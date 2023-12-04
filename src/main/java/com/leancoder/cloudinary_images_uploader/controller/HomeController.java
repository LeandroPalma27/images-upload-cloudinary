package com.leancoder.cloudinary_images_uploader.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.leancoder.cloudinary_images_uploader.custom.provider.CloudinaryProviderImpl;
import com.leancoder.cloudinary_images_uploader.model.service.CloudinaryServiceImpl;

@RestController
public class HomeController {

    @Autowired
    CloudinaryServiceImpl cloudinaryService;

    @GetMapping("/home")
    public String Home() {
        System.out.println("Hola mundo");
        return "Hola mundo";
    }

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam(value = "files", required = true) MultipartFile[] files) {
        // Investigar que es el modelAtributte
        if (cloudinaryService.uploadFiles(files)) {
            return ResponseEntity.ok().body("Archivos subidos con exito");
        } else {
            return ResponseEntity.internalServerError().body("Error desconocido en el servidor");
        }

    }

}
