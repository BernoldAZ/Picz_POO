package Filters;

import android.graphics.Bitmap;

public class MyFilter implements iFilterable {


    public Bitmap makeFilter(Bitmap photo) {
        photo = photo.copy( Bitmap.Config.ARGB_8888 , true);

        int vertical = photo.getHeight();
        int horizontal = photo.getWidth();

        double[][] kernel = crearKernel(0.2); //Aqui se declara el valor del sigma

        for (int contadorY = 1; contadorY < vertical-1; contadorY++){ //Se usa 1 para no utilizar los bordes
            for (int contadorX = 1; contadorX < horizontal-1; contadorX++) {


                int pixel = photo.getPixel(contadorX,contadorY);
                int azul = pixel & 0x000000FF;
                int verde = pixel & 0x0000FF00 >> 8;
                int rojo = pixel & 0x00FF0000 >> 32;
                int alfa = pixel & 0xFF000000 >> 128;

                int cambiada = (alfa << 128 | (rojo << 32) | (verde << 8)) | azul;

                photo.setPixel(contadorX,contadorY,cambiada);
            }

        }
        return photo;
    }

    private double[][] crearKernel(double sigma){ //Esto nos crea el kernel

        double[][] kernel = new double[3][3];

        double sumaKernel = 0;

        for (int fila = 0 ; fila < 3 ; fila++){ //Le asigna un resultado de aplicar la formula a cada posición de la matriz
            for (int columna = 0; columna < 3 ; columna++){
                double valorActual =  sigma / (Math.exp(Math.pow((fila-1),2)) + Math.exp(Math.pow((columna-1),2))); //Esto seria lo que cambia
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

    private int convolution(int[][] photoSample, double[][] kernel){
        double result = 0;
        for (int fila = 0 ; fila < 3 ; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                result = result + ( photoSample[fila][columna] * kernel[fila][columna]);
            }
        }
        return (int) result;
    }
}
