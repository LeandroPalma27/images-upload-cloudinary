package com.leancoder.cloudinary_images_uploader.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @GetMapping("/home")
    public String Home() {
        return "Hola mundo";
    }

}
