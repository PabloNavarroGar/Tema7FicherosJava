/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioVehiculosFicheros;

/**
 *
 * @author jcarlosvico@maralboran.es
 */

// Clase Turismo es clase hija o subclase (Vehiculo). Especialización
public class Turismo extends Vehiculo{
    
    // Atributo propio de Turismo, que no existe en vehiculo
    private int numeroPuertas;
    
    // Constructor con parámetros. Recibe todos los parámetros de clase hija y padre
    public Turismo(int numeroPuertas, Long bastidor, String matricula, 
            String marca, String modelo, String color, double tarifa, boolean disponible) {
        // Primera línea de código de un constructor clase hija es llamar al constructor padre
        super(bastidor, matricula, marca, modelo, color, tarifa, disponible);
        // Inicialización de atributos propios de la subclase
        this.numeroPuertas = numeroPuertas;
        
    }
    
    // Sobrescribir el método toString

    @Override
    public String toString() {
        return super.toString() + "\n\tTurismo{" + "numeroPuertas=" + numeroPuertas + '}';
    }
    
   
    public Turismo(){
        // Llama al constructor por defecto de Vehiculo
        super();
        this.numeroPuertas = 5;
    }

    // Métodos propios de turismo
    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }
    
    public void metodoTurismo(){
        System.out.println("Este es el método propio de turismo");
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        // Compara ambos vehiculos antes de comparar
        // los atributos propios de turismo
        if (!super.equals(obj)){
            return false;
        }
        
        final Turismo other = (Turismo) obj;
        if (this.numeroPuertas != other.numeroPuertas) {
            return false;
        }
        
        return true;
    }
    
}
