package com.leancoder.cloudinary_images_uploader.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leancoder.cloudinary_images_uploader.model.Perro;

@RestController
public class HomeController {

    String filename = "perro.ser";

    @GetMapping("/home")
    public String Home() throws IOException, ClassNotFoundException {

        Perro perrito = new Perro("Tati", 2);

        // Serializacion
        FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        // Method for serialization of object
        out.writeObject(perrito);

        out.close();
        fileOut.close();

        System.out.println("Object has been serialized");

        // Deserializacion
        Perro perritoDeserializado = null;

        // Reading the object from a file
        FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileIn);

        // Method for deserialization of object
        perritoDeserializado = (Perro) in.readObject();

        in.close();
        fileIn.close();

        System.out.println("Object has been deserialized ");
        System.out.println("nombre = " + perritoDeserializado.getNombre());
        System.out.println("b = " + perritoDeserializado.getEdad());

        return "Hola mundo";
    }

}
