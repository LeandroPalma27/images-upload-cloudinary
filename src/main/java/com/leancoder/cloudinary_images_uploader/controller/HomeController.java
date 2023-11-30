package com.leancoder.cloudinary_images_uploader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leancoder.cloudinary_images_uploader.custom.provider.CloudinaryProvider;

@RestController
public class HomeController {

    @Autowired
    CloudinaryProvider cloudinaryProvider;

    public void mostrarNumero(Integer numero) {
        System.out.println(numero);
    }
    
    @GetMapping("/home")
    public String Home() {
        try {
            cloudinaryProvider.isSuccessfulConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Hola mundo";
    }

}
