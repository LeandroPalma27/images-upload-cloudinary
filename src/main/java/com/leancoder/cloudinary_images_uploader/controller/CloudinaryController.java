package com.leancoder.cloudinary_images_uploader.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
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
     * Recibe como parametros en el body de la peticion, una lista de archivos
     * multipart (normalmente enviado desde un formData)
     */
    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> upload(
            @RequestParam(value = "files", required = true) MultipartFile[] files) {
        // Accedemos al servicio y llamamos al metodo para subir los archivos
        // En caso de haberse registrado URLs en el map, el map retornado tendra datos
        // Con lo cual isEmpty() nos dara un false, y para retornar el ResponseEntity
        // con status 20X debemos pasarlo a true
        var res = cloudinaryService.uploadFiles(files);
        if (!res.isEmpty()) {
            // Retornamos el siguiente Response entity
            Map<String, String> response = res;
            return ResponseEntity.ok().body(response);
        }
        // Si no llegamos a retornar lo de arriba, quiere decir que el response del
        // service estara vacio, con lo cual podemos interpretar que ocurrio un error de
        // servidor
        // Retornamos este response entity
        Map<String, String> response = new HashMap<String, String>();
        response.put("error", "Ocurrio un error de servidor inesperado.");
        System.out.println(response.get("error"));
        return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body(response);
    }

}
