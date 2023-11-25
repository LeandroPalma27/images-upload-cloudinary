package com.leancoder.cloudinary_images_uploader.generics;

import java.util.ArrayList;
import java.util.Arrays;

// Clase generica para probar un metodo generico
public class Test2 {
    
    public <E> ArrayList<E> createArrayListWithGenerics(E ...e) {
        return new ArrayList<>(Arrays.asList(e));
    }
}
