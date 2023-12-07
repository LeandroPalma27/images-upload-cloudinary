package com.leancoder.cloudinary_images_uploader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ModelController {

    @ModelAttribute(name = "nombre")
    public String miNombre() {
        return "Leandro";
    }

    @GetMapping("/home")
    public String Home(Model model) {
        model.addAttribute("title", "Home");
        return "home";
    }
    

}
