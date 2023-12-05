package com.leancoder.cloudinary_images_uploader.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/home").allowedOrigins("http://localhost:9000");
        registry.addMapping("/upload").allowedOrigins("http://localhost:9000", "http://192.168.1.44:9000");
    }
    
}
