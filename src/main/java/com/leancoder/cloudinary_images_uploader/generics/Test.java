package com.leancoder.cloudinary_images_uploader.generics;

/* 
 * Genericos
 * T: Se usa para tipos de clases
 * K: Se usa para el uso de claves (COMO EN UN MAP POR EJEMPLO)
 * N: Se usa exclusivamente para valores numericos
 * E: Se usa para elementos
 * V: Se usa para valores
 * S, U, V: 2do, 3ero y 4to para tipos de clases
 */
public class Test <T, U>{
    
    private U u;
    private T t;

    public Test(T t, U u) {
        this.t = t;
        this.u = u;
    }

    public void printTypes() {
        System.out.println(this.t.getClass().getName() + " = " + this.t);
        System.out.println(this.u.getClass().getName() + " = " + this.u);
    }

    public U getU() {
        return u;
    }

    public void setU(U u) {
        this.u = u;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

}
