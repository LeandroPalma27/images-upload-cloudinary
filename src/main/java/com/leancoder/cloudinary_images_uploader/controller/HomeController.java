package com.leancoder.cloudinary_images_uploader.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    public void mostrarNumero(Integer numero) {
        System.out.println(numero);
    }
    
    @GetMapping("/home")
    public String Home() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        /* var res = new ArrayList<String>(20);
        res.add("hola");
        int cont = 0;
        while (cont < 21) {
            res.add("xd");
            cont++;
        }
        System.out.println(res.size()); */
        /* numeros.forEach((new HomeController())::mostrarNumero); */
        return "Hola mundo";
    }

}
