/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package ejercicioRobotsFicheros;

import java.awt.Robot;

/**
 *
 * @author pablo
 */
public record RobotVico(int numSerie, int vida) implements Comparable<RobotVico> {

    

    @Override
    public int compareTo(RobotVico o) {
        return Integer.compare(this.numSerie, o.numSerie);
    }

}
