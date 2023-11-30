package com.leancoder.cloudinary_images_uploader.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class BeansConfig {
    // Bean para el iniciador del servicio de cloudinary:
    @Bean(name = "cloudinaryInit")
    Cloudinary getCloudinary() {
        return new Cloudinary(ObjectUtils.asMap("cloud_name", "leandropalma27p", "api_key", "777658485899521",
                "api_secret", "hoOzbFZ_tZ3omPQuqQ0s7h5hJiU"));
    }
}
