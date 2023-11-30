package com.leancoder.cloudinary_images_uploader.custom.provider;

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

  // Metodo desarrollado para probar si la conexion con cloudinary es exitosa
  /* 
   * Utilizamos los siguientes metodos de la instancia de cloudinary para poder encontrar algun archivo que tenga el id dentro de "expression()"
   * En este caso, pasamos un id de un archivo ya existente en mi servidor
   * Deberia retornar un ApiResponse con informacion del archivo en cuestion dentro
   * Y en caso de no encontrar al archivo, el response deberia mostrar que el key "total_count" 
   */
  public void buscarArchivo(String fileId) {
    try {
      ApiResponse apiResponse = cloudinaryAccess.search().expression(fileId).sortBy("created_at", "desc")
          .execute();
          logger.info((Integer) apiResponse.get("total_count") > 0 ? "Se encontro el archivo." : "No se encontro el archivo.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
