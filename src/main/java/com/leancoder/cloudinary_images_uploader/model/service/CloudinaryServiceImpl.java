package com.leancoder.cloudinary_images_uploader.model.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.leancoder.cloudinary_images_uploader.custom.provider.CloudinaryProviderImpl;

@Service
public class CloudinaryServiceImpl implements ICloudinaryService {

    @Autowired
    CloudinaryProviderImpl cloudinaryProvider;

    @Override
    public Boolean uploadFiles(MultipartFile[] files) {
        List<MultipartFile> listMultipartFiles = Arrays.asList(files);
        var res = cloudinaryProvider.guardarArchivos(listMultipartFiles);
        return !res.isEmpty();
    }

}
