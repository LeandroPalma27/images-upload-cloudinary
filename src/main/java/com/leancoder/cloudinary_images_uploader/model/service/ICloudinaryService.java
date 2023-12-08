package com.leancoder.cloudinary_images_uploader.model.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

// Interfaz para las metodos de la capa service del manejo con cloudinary
public interface ICloudinaryService {
    
    public Map<String, String> uploadFiles(MultipartFile[] files);

}
