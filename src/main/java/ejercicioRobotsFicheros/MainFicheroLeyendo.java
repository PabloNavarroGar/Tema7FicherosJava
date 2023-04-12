/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioRobotsFicheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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
        
         ArrayList<RobotVico> listaRobots = new ArrayList<>();

        //Creacion de los 20 robots
        for (int i = 0; i < 20; i++) {
         
           
            listaRobots.add(new RobotVico(numeroEnteroRandom(100, 9999), numeroEnteroRandom(1, 100)));
        }
        
        
    }
    
    
    
    public static void leerFicheroRobot(String RobotString) throws FileNotFoundException, IOException {
	     
		String linea;
		
		// Se crea el objeto FileReader
		FileReader fr = new FileReader(RobotString);
		// Se instancia el objeto BufferedReader a partir de FileReader
		BufferedReader br = new BufferedReader(fr);

		// Mientras el método readLine() no devuelva null existen datos por leer
	while((linea = br.readLine())!=null) {
                    boolean cadena = false;
		System.out.println(cadena);
	}

}

   public static int numeroEnteroRandom(int minimo, int maximo) {

        Random random = new Random();
        int numero = random.nextInt(maximo - minimo + 1) + minimo;
        return numero;
    } 

    
}
