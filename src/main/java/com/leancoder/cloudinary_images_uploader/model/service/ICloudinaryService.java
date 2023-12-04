package com.leancoder.cloudinary_images_uploader.model.service;

import org.springframework.web.multipart.MultipartFile;

public interface ICloudinaryService {
    
    public Boolean uploadFiles(MultipartFile[] files);

}
