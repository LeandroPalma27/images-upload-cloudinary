package com.leancoder.cloudinary_images_uploader.custom.provider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.ProgressCallback;
import com.cloudinary.api.ApiResponse;
import com.cloudinary.utils.ObjectUtils;

@Component
public class CloudinaryProviderImpl implements ICloudinaryProvider {

  Logger logger = LoggerFactory.getLogger(CloudinaryProviderImpl.class);

  @Autowired
  @Qualifier(value = "cloudinaryInit")
  Cloudinary cloudinaryAccess;

  // Metodo desarrollado para probar si la conexion con cloudinary es exitosa
  /*
   * Utilizamos los siguientes metodos de la instancia de cloudinary para poder
   * encontrar algun archivo que tenga el id dentro de "expression()"
   * En este caso, pasamos un id de un archivo ya existente en mi servidor
   * Deberia retornar un ApiResponse con informacion del archivo en cuestion
   * dentro
   * Y en caso de no encontrar al archivo, el response deberia mostrar que el key
   * "total_count"
   */
  public void buscarArchivo(String fileId) {
    try {
      ApiResponse apiResponse = cloudinaryAccess.search().expression(fileId).sortBy("created_at", "desc")
          .execute();
      logger.info(
          (Integer) apiResponse.get("total_count") > 0 ? "Se encontro el archivo." : "No se encontro el archivo.");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Map<Object, Map>> guardarArchivos(List<MultipartFile> files) {
    // Implementar carga visual de archivos en el frontend.
    var instance = cloudinaryAccess.uploader();
    List<Map<Object, Map>> results = new ArrayList<>();
    for (MultipartFile file : files) {
      var params = ObjectUtils.asMap(
          "public_id", file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf(".")).trim(),
          "overwrite", true,
          "faces", true,
          "folder", "drag-and-drop_files");
      try {
        Map res = instance.upload(file.getBytes(), params);
        System.out.println(res.get("secure_url"));
        results.add(res);
      } catch (IOException e) {
        return new ArrayList<>();
      }
    }
    return results;
  }

  @Override
  public void guardarArchivo(File file) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'guardarArchivo'");
  }

}
