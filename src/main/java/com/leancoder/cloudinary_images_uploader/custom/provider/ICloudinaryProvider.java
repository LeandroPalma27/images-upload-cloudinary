package com.leancoder.cloudinary_images_uploader.custom.provider;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface ICloudinaryProvider {
    public void buscarArchivo(String fileId);
    public List<Map<Object, Map>> guardarArchivos(List<MultipartFile> files);
    public void guardarArchivo(File file);
}