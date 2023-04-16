/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lecturaEscricutraFicheroPlano;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pablo
 */
public class MainEjercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Meter el archico e src/main/java y pega el archivo de localizaciones
        String fileName = "localizaciones.txt"; // Nombre del archivo de texto
        System.out.println("Leyendo el Fichero");
        List<String> lineas = leerFichero(fileName); // Leer el archivo de texto y almacenar cada línea en una lista
        List<String> localizaciones = extraerctLocalizaciones(lineas); // Extraer las localizaciones de cada línea y almacenarlas en una nueva lista
        System.out.println("Lista que ha conseguido con la Expresion regular las palabras clave");
        imprimirtLista(localizaciones); // Imprimir la lista de localizaciones por pantalla
        System.out.println("Lista Map que ha conseguido cada localizacion del archivo");
        Map<String, Integer> contador = contadortLocalizaciones(localizaciones); //Contar cuántas veces aparece cada localización en la lista

        imprimirMap(contador); // Imprimir el resultado del Map por pantalla
        System.out.println("Se va a imprimir ahora el Contador, mire en la carpeta Raiz");
        generarDocumentoContador(contador, "ContadorLocalizaciones", "txt");
    }

    public static void leerFichero(String nombreFichero, String formato) {

        // Se lee el fichero con los datos que tenga el ejemplo .txt(formato)
        String idFichero = nombreFichero + "." + formato;

        // Estos son variables para que guarden los datos que se van leyendo del fichero
        String[] tokens;
        String linea;

        System.out.println("Se esta  leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // try-with-resources. Permite cerrar los una vez hecho
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine va a devolver true siempre que haya una linea que tenga que leer
            while (datosFichero.hasNextLine()) {
                //Se guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String que se llama Tokens  
                tokens = linea.split("﻿Localizacion: [NSEO]");
                //Se generan los tokens en la lista con los tokens 
                System.out.println("Numero total de localizaciones : " + tokens[0]);

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para leer un archivo de texto y almacenar cada línea en una lista
    public static List<String> leerFichero(String nombreDelArchivo) {
        List<String> lineas = new ArrayList<>();
        try {
            lineas = Files.readAllLines(Paths.get("localizaciones.txt"),
                    StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println("Error leyendo el fichero");
        }
        for (String linea : lineas) {
            System.out.println(linea);
        }

        return lineas;
    }

    // Método para extraer las localizaciones de cada línea y almacenarlas en una nueva lista
    public static List<String> extraerctLocalizaciones(List<String> lista) {
        List<String> localizaciones = new ArrayList<>();
        //Pattern pattern = Pattern.compile("Localizacion: [N|S|O|E]");

        Pattern pattern = Pattern.compile(" [NSEO]");
        for (String line : lista) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                localizaciones.add(matcher.group());
            }
        }
        return localizaciones;
    }

    // Método para imprimir una lista por pantalla
    public static void imprimirtLista(List<String> lista) {
        for (String element : lista) {
            System.out.println(element);
        }
    }

    // Método para imprimir un Map por pantalla
    public static void imprimirMap(Map<String, Integer> map) {
        System.out.println("------------ Fichero contador deLocalizaciones ------------");
        for (Map.Entry<String, Integer> entrada : map.entrySet()) {
            System.out.println(entrada.getKey() + " - " + entrada.getValue());
        }
        System.out.println("--------------------------------------------------------");

    }

    // Método para contar cuántas veces aparece cada localización en una lista
    public static Map<String, Integer> contadortLocalizaciones(List<String> localizaciones) {
        Map<String, Integer> contadorLocalizaciones = new HashMap<>();
        for (String localizacion : localizaciones) {
            if (contadorLocalizaciones.containsKey(localizacion)) {
                contadorLocalizaciones.put(localizacion, contadorLocalizaciones.get(localizacion) + 1);
            } else {
                contadorLocalizaciones.put(localizacion, 1);
            }
        }
        return contadorLocalizaciones;

    }
        //Le meto en los parametro el Map, junto con el String del fichero y el formato
     public static void generarDocumentoContador(Map<String, Integer> map, String nomFichero, String formato) {
        String idFichero = nomFichero + "." + formato;
        String tmp;
        //---
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                int val = entry.getValue();
                tmp = key + " - " + val;
                flujo.write(tmp);
                flujo.newLine();
            }
            flujo.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
