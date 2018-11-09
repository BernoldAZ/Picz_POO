package com.picz.usuario.picz_poo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.util.Log;

import Filters.BlackWhiteFilter;
import Filters.GaussianFilter;
import Filters.SharpFilter;
import Filters.iFilterable;


public class CameraActivity extends AppCompatActivity {

    ImageView imageView;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        Button btnCamera = (Button)findViewById(R.id.btnCamera);
        imageView = (ImageView)findViewById(R.id.imageView);

        Bundle parametros = this.getIntent().getExtras();

        if(parametros !=null){
            //Toast toast1 = Toast.makeText(getApplicationContext(),"aplicando filtro", Toast.LENGTH_SHORT);
            //toast1.show();
            Bitmap photo = parametros.getParcelable("Photo");
            iFilterable filtro = new BlackWhiteFilter();
            Bitmap Aplicado = filtro.makeFilter(photo);
            imageView.setImageBitmap(Aplicado);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    public void aplicarFiltro(View  view){

        spinner = findViewById(R.id.myspinner);
        int pos = spinner.getSelectedItemPosition();
    }


}
