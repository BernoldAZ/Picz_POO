package Filters;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class GaussianFilter implements iFilterable{


    public Bitmap makeFilter(Bitmap photo) {
        photo = photo.copy( Bitmap.Config.ARGB_8888 , true);

        int vertical = photo.getHeight();
        int horizontal = photo.getWidth();
        int rojo, pixel, verde, azul, suma, gris;

        for (int contadorY = 1; contadorY < vertical-1; contadorY++){ //Se usa 1 para no utilizar los bordes
            for (int contadorX = 1; contadorX < horizontal-1; contadorX++) { 

                pixel = photo.getPixel(contadorX, contadorY);

            }

        }
        return photo;
    }

    public double[][] crearKernel(int sigma){ //Esto nos crea el kernel

        double[][] kernel = new double[3][3];

        double sumaKernel = 0;

        for (int fila = 0 ; fila < 3 ; fila++){ //Le asigna un resultado de aplicar la formula a cada posición de la matriz
            for (int columna = 0; columna < 3 ; columna++){
                double valorActual =  Math.exp( -  (Math.pow((fila-1),2) + Math.pow((columna-1),2)) /(2 * Math.pow(sigma,2) ) );
                kernel[fila][columna] = valorActual;
                sumaKernel = sumaKernel + valorActual;
            }
        }

        sumaKernel = 1/sumaKernel;

        for (int fila = 0 ; fila < 3 ; fila++) {//Hace que cada celda quede con valores de probabilidades
            for (int columna = 0; columna < 3; columna++) {
                kernel[fila][columna] = kernel[fila][columna] * sumaKernel;
            }
        }

        return kernel;
    }
}
