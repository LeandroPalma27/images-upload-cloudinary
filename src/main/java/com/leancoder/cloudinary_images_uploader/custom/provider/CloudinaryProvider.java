package com.leancoder.cloudinary_images_uploader.custom.provider;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cloudinary.Cloudinary;
import com.cloudinary.api.ApiResponse;

@Component
public class CloudinaryProvider {

    Logger logger = LoggerFactory.getLogger(CloudinaryProvider.class);

    @Autowired
    @Qualifier(value = "cloudinaryInit")
    Cloudinary cloudinaryAccess;

    // Obtendremos un id de foto random, si nos retorna un id valido quiere decir
    // que la conexion es exitosa
    public void isSuccessfulConnection () throws Exception {
        logger.info(cloudinaryAccess.randomPublicId());
        try {
            ApiResponse apiResponse = cloudinaryAccess.search().expression("dhiqvtimmw02t13y8oxw").sortBy("created_at", "desc").execute();
            System.out.println(apiResponse);
          } catch (IOException exception) {
            System.out.println(exception.getMessage());
          }
    }

}
