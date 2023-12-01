package com.leancoder.cloudinary_images_uploader.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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
        System.out.println("Hola mundo");
        return "Hola mundo";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam(value = "files", required = true) MultipartFile[] files) {
        // Investigar que es el modelAtributte
        // TODO: Implementar subida de archivos cargados a cloudinary, y retornar un response HTTP correspondiente en caso de exito y fallo
        List<MultipartFile> myFiles = Arrays.asList(files);
        var res = listToStream(myFiles).map((e) -> {
            return e.getOriginalFilename();
        });
        res.forEach(System.out::println);
        return "Hola mundo";
    }

    public <T> Stream<T> listToStream(List<T> list){
        return list.stream();
    }

}
