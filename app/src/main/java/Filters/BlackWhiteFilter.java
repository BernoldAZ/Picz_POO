package Filters;

import android.graphics.Bitmap;
import android.graphics.Color;


public class BlackWhiteFilter implements iFilterable {

    public void makeFilter(Bitmap photo){
        int vertical = photo.getHeight();
        int horizontal = photo.getWidth();

        for (int contadorY = 0; contadorY < vertical; contadorY++){
            for (int contadorX = 0; contadorX < horizontal; contadorX++){
               Color color = Color.valueOf(photo.getPixel(contadorX,contadorY));

               float red = color.red();
               float blue = color.red();
               float green = color.red();
               int gray = (int) ((red + blue + green) /3);


               photo.setPixel(contadorX,contadorY, gray );
            }
        }
    }
}
