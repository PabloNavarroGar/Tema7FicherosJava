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
         //--- Generamos la lista gracias a nuestro método
        List<Vehiculo> lista = generarLista();
        //---
        System.out.println("IMPRIMIMOS NUESTRA LISTA DE VEHÍCULOS");
        lista.forEach(System.out::println);
        //--- Generamos el fichero que contendrá la información de nuestros vehículos
        generarFicheroVehiculos("vehículos", "txt", lista);
        //--- Guardamos nuestra lista ordenada que hemos obtenido desde el archivo
        List<Vehiculo> listaOrdenada = generarListaVehiculosDesdeArchivo("vehículos", "txt", ":");
        //---
        System.out.println("\nLista OrdenadaA\n");
        listaOrdenada.forEach(System.out::println);
        //---Generamos cada uno de nuestros ficheros de cada uno de los tipos de vehículos
        generarFicherosTipoVehiculo(listaOrdenada);
        
        
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
            //si el objeto es un Turismo, un Deportivo o una Furgoneta.
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

   //Falta el metodo del documento de los tokenssssss
    
    
    
    // para calcular cuantos coches rojos hay
    /*
    El predicate es una expesion lamba que devuleve un boolean
    Predicate<Vehiculo> predicadoColor = (v)->v.getColor().equalsIgnoreCase(rojo);
    long contador = 0;
    contador=listaVehiculos.stream().filter(predicadoColor).count();
    
    
    Como imprimiria por pantalla todas las marcas diferentes o utra cosa
    stream con mao que recibe funtions
    distinct para no repita,hago el mapeo, y se imprime por for each
    listaVehiculos.stream()
            .map(v->v.getMarca())
            .distict()
            .forEach(System.out::printl);    
    
    
    */
    
    public static List<Vehiculo> generarListaVehiculosDesdeArchivo(String nomFichero, String formato, String separador) {
        List<Vehiculo> lista = new ArrayList<>();
        Comparator<Vehiculo> criterioMarca = (v1, v2) -> v1.getMarca().compareToIgnoreCase(v2.getMarca());
        //---
        String idFichero = nomFichero + "." + formato;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        //---

        //---
        Vehiculo v = null;
        //---
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(separador);
                // Convierte en String tokens
                //--- Dependiendo de como empiece la línea sabremos que tipo de objeto es
                //--- Usamos los tokens[] para guardar cada atributo según el constructor
                if (linea.contains("0 - ")) {//--- Si es un turismo
                    tokens[0] = tokens[0].replaceAll("0 - ", "");
                    //v = new Turismo(Integer.valueOf(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4], Double.parseDouble(tokens[5]), Integer.parseInt(tokens[7]), Boolean.parseBoolean(tokens[8]));
                    v = new Turismo(Integer.parseInt(tokens[0]), Long.valueOf(tokens[1]), String.valueOf(tokens[2]), tokens[3], tokens[4], tokens[5], Integer.parseInt(tokens[7]), Boolean.parseBoolean(tokens[8]));
                } else if (linea.contains("1 - ")) {
                    //--- Si es un deportivo                   
                    tokens[0] = tokens[0].replaceAll("1 - ", "");
                    //v = new Deportivo(Long.valueOf(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4], Double.parseDouble(tokens[5]), Integer.parseInt(tokens[7]));
                    v= new Deportivo(0, Long.MAX_VALUE, linea, linea, linea, linea, 0, true);
                } else {
                    //--- Si es una furgoneta
                    tokens[0] = tokens[0].replaceAll("2 - ", "");
                    //v = new Furgoneta(Long.valueOf(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4], Double.parseDouble(tokens[5]), Integer.parseInt(tokens[7]), Integer.parseInt(tokens[8]));
                    v = new Furgoneta(0, 0, Long.MAX_VALUE, linea, linea, linea, linea, 0, true);
                }
                //--- Añadimos el Vehículo a la lista
                lista.add(v);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        //---
        Collections.sort(lista, criterioMarca);
        return lista;

    }
    
    
    

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
