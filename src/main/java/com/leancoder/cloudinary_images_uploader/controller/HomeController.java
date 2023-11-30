package com.leancoder.cloudinary_images_uploader.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
        return "Hola mundo";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam Map<String, MultipartFile> files) {
        // TODO: Enviar datos de archivos desde el frontend a este metodo, e imprmir datos de esos archivos en este controlador
        // Investigar que es el modelAtributte
        return files.toString();
    }

}
