/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lecturaEscricutraFicheroPlano;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

        String fileName = "localizaciones.txt"; // Nombre del archivo de texto
        List<String> lines = leerFichero(fileName); // Leer el archivo de texto y almacenar cada línea en una lista
        List<String> localizaciones = extraerctLocalizaciones(lines); // Extraer las localizaciones de cada línea y almacenarlas en una nueva lista
        imprimirtLista(localizaciones); // Imprimir la lista de localizaciones por pantalla
        Map<String, Integer> contadorLocalizaciones = contarLocalizaciones((File) localizaciones); // Contar cuántas veces aparece cada localización en la lista
        imprimirMap( contadorLocalizaciones); // Imprimir el resultado del Map por pantalla
        //writeMapToFile(contadorLocalizaciones, "contadorLocalizaciones.txt"); // Escribir el resultado del Map en un archivo de texto
    }

    public static void leerFichero(String nombreFichero, String formato) {

        // Se lee el fichero con los datos que tenga el ejemplo .txt(formato)
        String idFichero = nombreFichero + "." + formato;

        // Estos son variables para que guarden los datos que se van leyendo del fichero
        String[] tokens;
        String linea;

        System.out.println("Se esta  leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine va a devolver true siempre que haya una linea que tenga que leer
            while (datosFichero.hasNextLine()) {
                //Se guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String que se llama Tokens  
                tokens = linea.split("﻿Localizacion: [N|S|E|O]");
                //Se generan los tokens en la lista con los tokens 
                System.out.println("Norte: " + tokens[0] + " - Sur: " + tokens[1]);

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para leer un archivo de texto y almacenar cada línea en una lista
    public static List<String> leerFichero(String nombreDelArchivo) {
           List<String> lineas=new ArrayList<>();
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
        Pattern pattern = Pattern.compile("Localizacion: \\[([NSOE])\\]");
        for (String line : lista) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                localizaciones.add(matcher.group(1));
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

    public static Map<String, Integer> contarLocalizaciones(File archivo) {
        Map<String, Integer> map = new HashMap<>();

        try ( BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Pattern pattern = Pattern.compile("Localizacion: \\[(N|S|E|O)\\]");
                Matcher matcher = pattern.matcher(linea);

                while (matcher.find()) {
                    String localizacion = matcher.group(1);
                    map.put(localizacion, map.getOrDefault(localizacion, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    // Método para imprimir un Map por pantalla
    public static void imprimirMap(Map<String, Integer> map) {
        System.out.println("------------ Fichero contadorLocalizaciones ------------");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("--------------------------------------------------------");
    }
}
