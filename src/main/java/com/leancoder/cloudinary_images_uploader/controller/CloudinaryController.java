package com.leancoder.cloudinary_images_uploader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.leancoder.cloudinary_images_uploader.model.service.CloudinaryServiceImpl;

// Clase controller para el manejo de peticiones al servidor de cloudinary en nuestra api en spring
@RestController
public class CloudinaryController {

    // Inyeccion del bean para el manejo del service de cloudinary
    @Autowired
    CloudinaryServiceImpl cloudinaryService;

    // Endopoint de prueba
    @GetMapping("/home")
    public String Home() {
        System.out.println("Hola mundo");
        return "Hola mundo";
    }

    // Endpoint para la subida de archivos
    /* 
     * Recibe como parametros en el body de la peticion, una lista de archivos multipart (normalmente enviado desde un formData)
     */
    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam(value = "files", required = true) MultipartFile[] files) {
        // Accedemos al servicio y llamamos al metodo para subir los archivos
        // Retorna true en caso de haberse subido con exito
        if (cloudinaryService.uploadFiles(files)) {
            // Retornamos el siguiente Response entity
            return ResponseEntity.ok().body("Archivos subidos con exito");
            // o false en caso de error de servidor
        } else {
            // Retornamos este response entity
            return ResponseEntity.internalServerError().body("Error desconocido en el servidor");
        }

    }

}
