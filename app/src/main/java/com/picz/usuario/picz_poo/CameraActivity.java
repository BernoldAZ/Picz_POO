package com.picz.usuario.picz_poo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import Filters.FilterFactory;
import Filters.iFilterable;

public class CameraActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        Button btnfilter1 = (Button)findViewById(R.id.btnFilter1);
        Button btnfilter2 = (Button)findViewById(R.id.btnFilter2);
        Button btnfilter3 = (Button)findViewById(R.id.btnFilter3);
        Button btnfilter4 = (Button)findViewById(R.id.btnFilter4);
        imageView = (ImageView)findViewById(R.id.imageView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToPost();
            }
        });

        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            Bitmap photo = parametros.getParcelable("Photo");
            imageView.setImageBitmap(photo);
        }


        btnfilter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeFilter(0);
            }
        });

        btnfilter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeFilter(1);
            }
        });

        btnfilter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeFilter(2);
            }
        });

        btnfilter4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeFilter(3);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


    }

    private void makeFilter(int posFilter){
        imageView = (ImageView)findViewById(R.id.imageView);

        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            Toast toast1 = Toast.makeText(getApplicationContext(),"aplicando filtro", Toast.LENGTH_SHORT);
            toast1.show();
            Bitmap photo = parametros.getParcelable("Photo");
            FilterFactory factory = new FilterFactory();
            iFilterable filtro = factory.getFilter(posFilter);
            Bitmap Aplicado = filtro.makeFilter(photo);
            imageView.setImageBitmap(Aplicado);
        }

    }

    private void goToPost(){
        Drawable drawable =  imageView.getDrawable();
        BitmapDrawable bitmapDrawable = ((BitmapDrawable) drawable);
        Bitmap bitmap = bitmapDrawable .getBitmap();

        Intent PostActivity = new Intent(getApplicationContext(), CreatePostActivity.class);
        PostActivity.putExtra("Photo", bitmap);
        startActivity(PostActivity);

    }


}
