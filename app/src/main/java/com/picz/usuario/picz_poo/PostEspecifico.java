package com.picz.usuario.picz_poo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import Posts.Room.PostDataBase;

public class PostEspecifico extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);
        // Set up the login form.

        Bundle parametros = this.getIntent().getExtras();
        if (parametros != null) {
            String comentario = parametros.getParcelable("comment");
            Bitmap imagen = parametros.getParcelable("image");
            String date = parametros.getParcelable("date");
            ImageView img = (ImageView)findViewById(R.id.imagen);
            TextView com = (TextView)findViewById(R.id.commentario);
            TextView fecha = (TextView)findViewById(R.id.fecha);
            img.setImageBitmap(imagen);
            com.setText(comentario);
            fecha.setText(date);
        }


    }
}
