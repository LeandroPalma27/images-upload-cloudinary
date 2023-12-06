package com.leancoder.cloudinary_images_uploader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HolaController {
    
    @GetMapping("/hola")
    // Se crea una sesion si en la aplicacion requerimos algo relacionado con la session HTTP
    // Tambien pueden depender de la configuración en eln filterChain de la aplicacion
    public String Hola(Model model/* , HttpSession session */){
        model.addAttribute("hola", "Hola mundo");
        return "hola";
    }

}
