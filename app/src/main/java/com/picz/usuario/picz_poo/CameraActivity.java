package com.picz.usuario.picz_poo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.util.Log;

import Filters.BlackWhiteFilter;
import Filters.GaussianFilter;
import Filters.iFilterable;


public class CameraActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 100;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        Button btnCamera = (Button)findViewById(R.id.btnCamera);
        imageView = (ImageView)findViewById(R.id.imageView);

        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            Toast toast1 = Toast.makeText(getApplicationContext(),"aplicando filtro", Toast.LENGTH_SHORT);
            toast1.show();
            Bitmap photo = parametros.getParcelable("Photo");
            Log.w("mitag", "empiezo");
            iFilterable filtro = new GaussianFilter();
            Bitmap Aplicado = filtro.makeFilter(photo);
            Log.w("mitag", "termine");
            imageView.setImageBitmap(Aplicado);
        }


        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            Bitmap photo = (Bitmap)data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
        else finish();
    }

    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }
}
