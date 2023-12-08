package com.leancoder.cloudinary_images_uploader.model.validation;

public class UsuarioValidator {
    private String username;
    private Integer edad;

    public UsuarioValidator() {}

    public UsuarioValidator(String username, Integer edad) {
        this.username = username;
        this.edad = edad;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
