package Filters;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;


public class BlackWhiteFilter implements iFilterable {

    public void makeFilter(Bitmap photo){

        int vertical = photo.getHeight();
        int horizontal = photo.getWidth();
        int rojo,pixel,verde,azul,suma,gris;

        for (int contadorY = 0; contadorY < vertical; contadorY++)
            for (int contadorX = 0; contadorX < horizontal; contadorX++) {

            //mi metodo
                /*pixel = photo.getPixel(contadorX, contadorY);
                Log.w("mitag", "obtner color");
                pixel = photo.getPixel(contadorX, contadorY);
                azul = pixel & 0x000000FF;
                verde = pixel & 0x0000FF00 >> 8;
                rojo = pixel & 0x00FF0000 >> 16;
                gris = (azul+verde+rojo)/3;
               // suma = ((pixel & 0xFF000000) | (rojo << 16) | (verde << 8)) | azul;
                photo.setPixel(contadorX, contadorY, gris);*/

                //metodo original
               /* Color color = Color.valueOf(photo.getPixel(contadorX, contadorY));
                float red = color.red();
                float blue = color.blue();
                float green = color.green();
                int gray = (int) ((red + blue + green) / 3);
                photo.setPixel(contadorX, contadorY, gray);*/
                Log.w("mitag", String.valueOf(contadorX));
            }
    }
}
