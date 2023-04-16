/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioVehiculosFicheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author samue
 */
public class ejercicioVehFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    //Para generar una lisa crando los 10 vehiculos, voy a crear una lista, con los atributos de los vehiculos
    //A continuacion le usando el RSU, con un for que marque 10 en el iterador creo , me cree los 10 vehiculo, junto con el randim,
    // Y con un Switch que me mrque la opcion 
    public static List<Vehiculo> generarLista() {

        List<Vehiculo> lista = new ArrayList<>();
        String numeroBastidor;
        String numeroMatricula;
        String marca;
        String color;
        int opcion;
        numeroBastidor = RandomStringUtils.randomNumeric(8);
        numeroMatricula = RandomStringUtils.randomNumeric(4) + "--" + RandomStringUtils.randomAlphabetic(3);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {

            numeroBastidor = RandomStringUtils.randomNumeric(8);
            numeroMatricula = RandomStringUtils.randomNumeric(4) + "--" + RandomStringUtils.randomAlphabetic(3);
            opcion = random.nextInt(5);
            switch (opcion) {
                case 0 -> {
                    marca = "Kia";
                    color = "Blanco";
                }
                case 1 -> {
                    marca = "Ford";
                    color = "Azul";
                }
                case 2 -> {
                    marca = "Honda";
                    color = "Negro";
                }
                case 3 -> {
                    marca = "Mitsubishi";
                    color = "Verde";
                }
                case 4 -> {
                    marca = "Audi";
                    color = "Rojo";
                }
                default -> {
                    marca = "Toyota";
                    color = "Amarillo";
                }
            }

            Vehiculo v = new Turismo(4, Long.valueOf(numeroBastidor), numeroMatricula, marca, RandomStringUtils.random(3), color, i, true);
            lista.add(v);
        }
        //Furgonetas

        for (int i = 0; i < 10; i++) {

            numeroBastidor = RandomStringUtils.randomNumeric(8);
            numeroMatricula = RandomStringUtils.randomNumeric(4) + "--" + RandomStringUtils.randomAlphabetic(3);
            opcion = random.nextInt(5);
            switch (opcion) {
                case 0 -> {
                    marca = "Kia";
                    color = "Blanco";
                }
                case 1 -> {
                    marca = "Ford";
                    color = "Azul";
                }
                case 2 -> {
                    marca = "Honda";
                    color = "Negro";
                }
                case 3 -> {
                    marca = "Mitsubishi";
                    color = "Verde";
                }
                case 4 -> {
                    marca = "Audi";
                    color = "Rojo";
                }
                default -> {
                    marca = "Toyota";
                    color = "Amarillo";
                }
            }

            Vehiculo v = new Furgoneta(random.nextInt(500), random.nextInt(500), Long.valueOf(numeroBastidor), numeroMatricula, marca, "Mod" + opcion, color, i, true);
            lista.add(v);
        }

        for (int i = 0; i < 10; i++) {

            numeroBastidor = RandomStringUtils.randomNumeric(8);
            numeroMatricula = RandomStringUtils.randomNumeric(4) + "--" + RandomStringUtils.randomAlphabetic(3);
            opcion = random.nextInt(5);
            switch (opcion) {
                case 0 -> {
                    marca = "Kia";
                    color = "Blanco";
                }
                case 1 -> {
                    marca = "Ford";
                    color = "Azul";
                }
                case 2 -> {
                    marca = "Honda";
                    color = "Negro";
                }
                case 3 -> {
                    marca = "Mitsubishi";
                    color = "Verde";
                }
                case 4 -> {
                    marca = "Audi";
                    color = "Rojo";
                }
                default -> {
                    marca = "Toyota";
                    color = "Amarillo";
                }
            }

            Vehiculo v = new Deportivo(random.nextInt(200), Long.valueOf(numeroBastidor), numeroMatricula, marca, RandomStringUtils.random(3), color, i, true);
            lista.add(v);
        }

        return lista;
    }

    public static void generarFicheroVehiculos(String nomFichero, String formato, List<Vehiculo> lista) {

        String idFichero = nomFichero + "." + formato;
        String tmp;
        String tipoVehi = "";
        //---
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            //Cada línea del fichero estará compuesta por un número, un espacio, un guión, un
            //espacio y los datos del vehículo en cuestión. El número de cada línea será 0, 1 o 2
            //si el objeto es un Turismo, un Deportivo o una Furgoneta, respectivamente. 
            //Explicita
            for (Vehiculo v : lista) {
                if (v instanceof Furgoneta) {
                    tipoVehi = "0 - ";
                }
                if (v instanceof Deportivo) {
                    tipoVehi = "1 - ";
                }
                if (v instanceof Turismo) {
                    tipoVehi = "2 - ";
                }

                tmp = tipoVehi + v.toString();

                flujo.write(tmp);
                flujo.newLine();
            }

            flujo.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

   //Falta el metodo d e

    //Le meto en los parametro de la lista, junto con el String del fichero y el formato
    public static void generarDocumentIndividual(String nomFichero, String formato, List<Vehiculo> lista) {
        String idFichero = nomFichero + "." + formato;
        String tmp;
        //Buffered, que el paso el vehiculo, la lista y en el tmp, el to string del vehiculo
        try ( BufferedWriter bufo = new BufferedWriter(new FileWriter(idFichero))) {

            for (Vehiculo v : lista) {

                tmp = v.toString();
                bufo.write(tmp);
                bufo.newLine();
            }
            bufo.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void generarFicherosTipoVehiculo(List<Vehiculo> lista) {
        //Creamos 3 listas con cada tipño vehiculo
        List<Vehiculo> turismos = new ArrayList<>();
        List<Vehiculo> deportivos = new ArrayList<>();
        List<Vehiculo> furgonetas = new ArrayList<>();
        //Por cada tipo de vehiculo le podemos una conversion explicita en el for each
        for (Vehiculo v : lista) {
            if (v instanceof Turismo) {
                turismos.add(v);
            }
            if (v instanceof Deportivo) {
                deportivos.add(v);
            }
            if (v instanceof Furgoneta) {
                furgonetas.add(v);
            }
            //Se genera cada documento de cada vehiculo
            generarDocumentIndividual("Turismos", "txt", turismos);
            generarDocumentIndividual("Deportivos", "txt", deportivos);
            generarDocumentIndividual("Furgonetas", "txt", furgonetas);
        }
    }

}