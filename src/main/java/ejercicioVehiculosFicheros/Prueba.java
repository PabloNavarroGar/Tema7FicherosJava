/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioVehiculosFicheros;

import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class Prueba {

    public static void main(String[] args) {

        ArrayList<Vehiculo> lista = crearCatalogoVehiculos();

        for (Vehiculo v : lista) {
            // Llamada método polimórfico toString()
            System.out.println(v);
            System.out.println("");
            v.metodoVehiculo();
            System.out.println("");
            
            // Conversiones explícitas
            if (v instanceof Deportivo){
                ((Deportivo) v).metodoDeportivo();
            } else if(v instanceof Furgoneta){
                ((Furgoneta) v).metodoFurgoneta();
            } else if (v instanceof Turismo){
                ((Turismo) v).metodoTurismo();
            }
            System.out.println("--------------------------------");
        }
        
    }

    public static ArrayList<Vehiculo> crearCatalogoVehiculos() {

        ArrayList<Vehiculo> lista = new ArrayList<>();

        lista.add(new Vehiculo());
        lista.add(new Vehiculo(2345334543L, "0944 TTF", "Seat", "León", "Rojo", 12.3, true));
        // Conversiones implícitas
        lista.add(new Turismo());
        lista.add(new Turismo(3, 1345334543L, "0955 TTF", "Peugeot", "308", "Verde", 2.3, true));
        lista.add(new Turismo(3, 1345334543L, "0955 TTF", "Peugeot", "308", "Verde", 2.3, true));
        lista.add(new Deportivo());
        lista.add(new Deportivo(3, 5545334543L, "2355 DRG", "Ford", "Mustang", "Negro", 1.3, true));
        lista.add(new Furgoneta());
        lista.add(new Furgoneta(1200, 12, 4444434543L, "1111 TTF", "Peugeot", "Partner", "Verde", 14.8, true));

        return lista;
    }

}
