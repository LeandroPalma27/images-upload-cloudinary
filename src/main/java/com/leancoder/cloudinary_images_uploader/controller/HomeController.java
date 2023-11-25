package com.leancoder.cloudinary_images_uploader.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leancoder.cloudinary_images_uploader.generics.Test;
import com.leancoder.cloudinary_images_uploader.generics.Test2;
import com.leancoder.cloudinary_images_uploader.generics.Test3;

@RestController
public class HomeController {

    public void mostrarNumero(Integer numero) {
        System.out.println(numero);
    }
    
    @GetMapping("/home")
    public String Home() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        /* GENERICS */
        Test<Integer, String> test = new Test<Integer, String>(15, "99.99");
        Test2 test2 = new Test2();
        var res = test2.createArrayListWithGenerics("Hola", 12, 123);
        System.out.println(res);
        test.printTypes();

        /* 
         * Seguridad en genericos:
         * Al implementar los genericos en nuestros metodos y clases de Java, obligamos al compilador a mostrarnos errores en compilacion
         * y no en tiempo de ejecucion. Esto se debe a que al no definir que tipo de dato recibiremos al emplear algun metodo que reciba un tipo de dato desconocido,
         * puede que al castearlo a lo que esperamos, no se cumpla con lo establecido, generando un error en tiempo de ejecucion y no uno mostrado por el compilador.
         * Un ejemplo de esto seria:
         */
        ArrayList array1 = new ArrayList();
        array1.add("Hola");
        array1.add("Hola2");
        array1.add(10);
        
        // Casteo:
        /* 
         * Esto indiscutiblemente retornara un dato de tipo entero, y al castearlo a un String generara un RuntimeException.
         */
        /* String casteo3 = (String) array1.get(2); */

        // Aplicando el uso de genericos para la seguridad de la integridad de la aplicacion (NO GENERAR ERRORES EN TIEMPO DE EJECUCION):
        ArrayList<String> array2 = new ArrayList<String>();
        array2.add("Hola");
        array2.add("Hola2");
        // Generando un error del compilador (The method add(int, String) in the type ArrayList<String> is not applicable for the arguments (int)):
        /* array2.add(10); */

        // Y tambien destacar que nos evita tener que hacer el tedioso proceso del casteo (siendo no buena practica debido a que no tenemos la certeza de que la llamada no retorne el tipo de dato esperado)

        // Reutilizacion de codigo:
        /*
         * Definimos matrices de varios tipos de datos:
         */
        String[] nombre = {"Leandro", "Martin", "Tati"};
        // Se llama "numbers" porque arriba tengo una lista llamada numeros(no puedo repetir el nombre de la varible en este scope)
        Integer[] numbers = {35, 99, 2, 1};

        // Llamamos la funcion que se encarga de hacer el bubble sort:
        Test3.sort_generics(nombre);
        Test3.sort_generics(numbers);
        // Y efectivamente, usamos la misma funcion para diferentes tipos de matrices
        return "Hola mundo";
    }

}
