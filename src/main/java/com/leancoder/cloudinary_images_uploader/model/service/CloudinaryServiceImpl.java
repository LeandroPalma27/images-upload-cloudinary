package com.leancoder.cloudinary_images_uploader.model.service;

import java.util.Arrays;
import java.util.List;

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
    public Boolean uploadFiles(MultipartFile[] files) {
        // Convertimos la matriz a un list de java
        List<MultipartFile> listMultipartFiles = Arrays.asList(files);
        // Accedemos al provider y con el metodo guardarArchivos, enviamos el list de MultipartFiles y este nos devolvera un valor booleano
        var res = cloudinaryProvider.guardarArchivos(listMultipartFiles);
        // Devuelve false en caso de retornar un list lleno de informacion entregada por el servidor, o un true en caso de enviar un list vacio (EN CASO DE ALGUN ERROR DE SERVIDOR 500)
        return !res.isEmpty();
    }

}
