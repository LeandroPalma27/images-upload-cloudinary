package com.leancoder.cloudinary_images_uploader.model.service;

import org.springframework.web.multipart.MultipartFile;

// Interfaz para las metodos de la capa service del manejo con cloudinary
public interface ICloudinaryService {
    
    public Boolean uploadFiles(MultipartFile[] files);

}
