package com.leancoder.cloudinary_images_uploader.generics;

// Posibilidad de reutilizacion
/* 
 * Aquie observamos que implementamos una funcion encargada de hacer un bubble sort, que recibe una matriz de datos
 * Pero que pasaria que queremos reutilizar dicha funcion para diferentes tipos de datos para la matriz?
 * Para eso, implementamos los genericos en nuestra funcion
 */
public class Test3 {

    // Definimos la funcion, de tal manera que pueda recibir matrices de diferentes tipos de datos:
    public static <T extends Comparable<T>> void sort_generics(T[] a) {

        // As we are comparing the Non-primitive data types
        // we need to use Comparable class

        // Bubble Sort logic
        for (int i = 0; i < a.length - 1; i++) {

            for (int j = 0; j < a.length - i - 1; j++) {

                if (a[j].compareTo(a[j + 1]) > 0) {

                    swap(j, j + 1, a);
                }
            }
        }

        // Printing the elements after sorted

        for (T i : a) {
            System.out.print(i + ", ");
        }
        System.out.println();

    }

    public static <T> void swap(int i, int j, T[] a) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
