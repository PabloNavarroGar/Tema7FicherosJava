/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioRobotsFicheros;

/**
 *
 * @author samue
 */
public class Robots implements Comparable<Robots>{
    //Atributos de clase
    private int numeroSerie;
    private int porcentajeVida;

    public Robots(int parseInt, int parseInt1) {
        this.numeroSerie = UtilidadesMetodos.numeroEnteroRandom(1,1000 );
        this.porcentajeVida = UtilidadesMetodos.numeroEnteroRandom(1, 100);
    }

  
    
    
    public int getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getPorcentajeVida() {
        return porcentajeVida;
    }

    public void setPorcentajeVida(int porcentajeVida) {
        this.porcentajeVida = porcentajeVida;
    }

    @Override
    public String toString() {
        return "Robots{" + "numeroSerie=" + numeroSerie + ", porcentajeVida=" + porcentajeVida + '}';
    }

    @Override
    public int compareTo(Robots o) {
        return Integer.compare(numeroSerie, numeroSerie);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.numeroSerie;
        return hash;
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
        final Robots other = (Robots) obj;
        return this.numeroSerie == other.numeroSerie;
    }
    
    
     
    
}
