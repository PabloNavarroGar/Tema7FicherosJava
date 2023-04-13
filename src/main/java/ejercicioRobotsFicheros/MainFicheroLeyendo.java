/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioRobotsFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class MainFicheroLeyendo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         List<Robots> listaRobots = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            listaRobots.add();
        }
        
         generarFicheroRobots("ListaDeRobots", listaRobots);
        }
        
    
    
    
    
      public static void generarFicheroRobots(String nombreFichero, List<Robots> listaRob) {
       
        // Se crea ael fichero con una ruta a la carpeta.
        String idFichero = nombreFichero + ".txt";
        //Tipo de archivo texto
        String tmp;//Variable String que mas adelante voy a usar
        //Uso del BiffederWiter.
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            //For Echar que le paso la lista, y el tmp, le ponemos que tenga el 
            // numero de seria al empezar y luego el porcdntaje de vida
            for (Robots r : listaRob) {
                tmp = r.getNumeroSerie()+ ";" + r.getPorcentajeVida()+ ";";
                flujo.write(tmp);
                flujo.newLine();
            }
            flujo.flush();
            System.out.println("Fichero " + nombreFichero + " se ha creado sin problemas.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

      
      
        public static void leerFicheroRobots(String nombreFichero, String formato) {

        
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
                tokens = linea.split(";");
                //Se generan los tokens en la lista con los tokens 
                System.out.println("Robot: " + tokens[0] + " - Vida: " + tokens[1]);

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
        
        
           public static List<Robots> sacarListaDeArchivo(String nombreFichero, String formato) {
        List<Robots> lista = new ArrayList<>();

        // Fichero a leer con datos de ejemplo
        String idFichero = nombreFichero + "." + formato;

        // Variables para guardar los datos, misma estructura que el metodo anteror
        String[] tokens;
        String linea;

        System.out.println("Se esta leyendo el fichero: " + idFichero);

      
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
           
            while (datosFichero.hasNextLine()) {
              
                linea = datosFichero.nextLine();
            
                tokens = linea.split(";");
                //
                Robots r = new Robots(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
               
                lista.add(r);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }
   


    
}
