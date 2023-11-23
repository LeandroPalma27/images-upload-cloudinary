package com.leancoder.cloudinary_images_uploader.model;

import java.io.Serializable;

public class Perro implements Serializable{

    private static final long serialVersionUID = -1074395015286473387L;
    protected String nombre;
    private Integer edad;

    public Perro(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void saludar() {
        try {
            System.out.println("Hola mundo causitas");
        } catch (Exception e) {
        }
    }

}
