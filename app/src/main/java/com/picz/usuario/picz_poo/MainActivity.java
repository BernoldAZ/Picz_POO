package com.picz.usuario.picz_poo;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import Posts.Room.PostDataBase;
import Posts.Room.PostRoom;

public class MainActivity extends AppCompatActivity {
    PostDataBase db = Room.databaseBuilder(getApplicationContext(),PostDataBase.class, "database-name").build();

    private static final int PICK_IMAGE = 100;

    private static PostRoom addDatabase(final PostDataBase db, PostRoom post) {
        db.PostDAO().insert(post);
        return post;
    }/*
    public Bitmap getReportPicture(long reportId) {
        String picturePath = getReportPicturePath(reportId);
        if (picturePath == null || picturePath.length() == 0)
            return (null);

        Bitmap reportPicture = BitmapFactory.decodeFile(picturePath);

        return (reportPicture);
    }*/
    private static void agregar(PostDataBase db) {

        PostRoom post = new PostRoom();
        //post.insertar(imagen);
        post.insertarComentario("Omae wa moe shindeiru");
        addDatabase(db, post);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        List<PostRoom> posts = db.PostDAO().getPosts();
        for(PostRoom post: posts){
            //Log.w("mitag","1");
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });

        FloatingActionButton gallery = (FloatingActionButton) findViewById(R.id.gallery);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");




        Intent cameraActivity = new Intent(getApplicationContext(), CameraActivity.class);
        cameraActivity.putExtra("Photo", bitmap);
        startActivity(cameraActivity);
    }

    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }


}
