package com.leancoder.cloudinary_images_uploader.model.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.leancoder.cloudinary_images_uploader.custom.provider.CloudinaryProviderImpl;

// Clase service para el manejo la informacion recibida desde el controller de cloudinary
@Service
public class CloudinaryServiceImpl implements ICloudinaryService {

    // Inyectamos el bean que carga el provider de cloudinary
    @Autowired
    CloudinaryProviderImpl cloudinaryProvider;

    // Implementamos el metodo uploadFiles, que recibe una matriz de multipartFiles
    @Override
    public Map<String, String> uploadFiles(MultipartFile[] files) {
        // Convertimos la matriz a un list de java
        List<MultipartFile> listMultipartFiles = Arrays.asList(files);
        // Accedemos al provider y con el metodo guardarArchivos, enviamos el list de MultipartFiles y este nos devolvera un array list con la informacion obtenida como respuesta del provider
        Map <String, String> urlFiles = new HashMap<>();
        var res = cloudinaryProvider.guardarArchivos(listMultipartFiles);
        if (!res.isEmpty()) {
            for (int i = 0; i < res.size(); i++) {
                urlFiles.put("url_".concat(Integer.toString(i + 1)), res.get(i).get("secure_url").toString());
            }
            return urlFiles;
        }
        // Devuelve false en caso de retornar un list lleno de informacion entregada por el servidor, o un true en caso de enviar un list vacio (EN CASO DE ALGUN ERROR DE SERVIDOR 500)
        return urlFiles;
    }

}
