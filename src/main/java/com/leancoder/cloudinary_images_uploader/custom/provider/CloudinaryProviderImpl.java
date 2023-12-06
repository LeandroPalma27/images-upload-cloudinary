package com.leancoder.cloudinary_images_uploader.custom.provider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.api.ApiResponse;
import com.cloudinary.utils.ObjectUtils;

// Clase provedora de cloudinary, para el accesoa nuestro servidor en cloudinary y el intercambio de informacion con este
@Component
public class CloudinaryProviderImpl implements ICloudinaryProvider {

  // Loger para el manejo de informacion en consola
  Logger logger = LoggerFactory.getLogger(CloudinaryProviderImpl.class);

  // Bean de la conexion a cloudinary
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

  // Metodo provider para guardar una lista de MultipartFiles
  @Override
  // Retorna una lista de maps un clave Object y un map de valor
  public List<Map<Object, Map>> guardarArchivos(List<MultipartFile> files) {
    // Obtenemos la instancia de cloudinary access
    var instance = cloudinaryAccess.uploader();
    // Creamos una lista para recibir los maps al hacer la peticion al cloudinaryInit
    List<Map<Object, Map>> results = new ArrayList<>();
    // Recorremos la lista de MultiparFiles (YA QUE ENVIAREMOS ARCHIVO POR ARCHIVO)
    for (MultipartFile file : files) {
      // Definimos un map para los parametros enviamos en cada subida de archivo
      var params = ObjectUtils.asMap(
          "public_id", file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf(".")).trim(),
          "overwrite", true,
          "faces", true,
          "folder", "drag-and-drop_files");
      try {
        // Hacemos un try catch para ejecutar la funcion upload del cloudinaryInit
        // Pasmos como parametro un file.getBytes() y el map con los parametros definidos para la subida del archivo
        Map res = instance.upload(file.getBytes(), params);
        logger.info(res.get("secure_url").toString());
        // Guardamos lo resultante en la lista que retornaremos al final del metodo.
        results.add(res);
      } catch (IOException e) {
        // En caso de fallar, retornamos un list vacio
        return new ArrayList<>();
      }
    }
    return results;
  }

  @Override
  public void guardarArchivo(File file) {
    throw new UnsupportedOperationException("Unimplemented method 'guardarArchivo'");
  }

}
