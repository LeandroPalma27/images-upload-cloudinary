package com.leancoder.cloudinary_images_uploader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.leancoder.cloudinary_images_uploader.model.validation.UsuarioValidator;


@Controller
@SessionAttributes({"userData"})
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

    @PostMapping("/home")
    public String HomeProccess(@RequestParam String username, @RequestParam Integer edad, Model model) {
        UsuarioValidator usuario = new UsuarioValidator(username, edad);
        model.addAttribute("userData", usuario);
        return "redirect:/ver";
    }

    @GetMapping("/ver")
    public String VerUser(@SessionAttribute("userData") UsuarioValidator userData, Model model, SessionStatus sessionStatus) {
        model.addAttribute("userData", userData);
        return "ver";
    }
    

    @GetMapping("/home2")
    public String Home2 () {
        return "home2";
    }

    @GetMapping("/saludar/{nombre}")
        public String Saludar (@PathVariable(name = "nombre") String nombre, Model model) {
            model.addAttribute("nombre", nombre);
            return "saludo";
        }
    

}
