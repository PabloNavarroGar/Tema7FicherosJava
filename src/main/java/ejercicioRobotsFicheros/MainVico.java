/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioRobotsFicheros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 *
 * @author pablo
 */
public class MainVico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<RobotVico> lista = (ArrayList<RobotVico>) getListaRobores(50);
        //Compraradores
        Collections.sort(lista, (r1, r2) -> Integer.compare(r1.vida(), r2.vida()));
        System.out.println("Ordenados por porct de vida de menor a mayor");
        lista.forEach(System.out::println);

        Comparator<RobotVico> menorMayor = (r1, r2) -> Integer.compare(r1.vida(), r2.vida());
        Collections.sort(lista, menorMayor.reversed());
        System.out.println("orenador por porcentaje de vida de mayor a menor");
        lista.forEach(System.out::println);

        System.out.println("Robots con mas de 50% de vida");

        for (RobotVico robot : lista) {
            if (robot.vida() >= 50) {
                System.out.println(robot);
            }

        }
        System.out.println("Usando API STREAM.Los que tienen mas de 50");
        //Todo el stream es exactamente igual a lo de arriba
        lista.stream()
                .filter(r -> r.vida() >= 50)
                .forEach(r -> System.out.println(r));

        System.out.println("Usando API STREAM.Los 3 con mahor porcentaje");
        //Todo el stream es exactamente igual a lo de arriba
        lista.stream()
                .limit(3)
                .forEach(r -> System.out.println(r.numSerie()));
        System.out.println("Usando API STREAM.Losmas vida");
        Stream<RobotVico> streamRobot = lista.stream();
        Stream<RobotVico> streamRobotFiltrados = streamRobot.filter(r -> r.vida() >= 50);
        streamRobotFiltrados.forEach(System.out::println);
        
        
        //Todo el stream es exactamente igual a lo de arriba
        lista.stream()
                .filter(r -> r.vida() >= 50)
                .forEach(r -> System.out.println(r));

    }

    public static List<RobotVico> getListaRobores(int num) {
        var listaRobots = new ArrayList<RobotVico>();
        Random random = new Random();
        if (num <= 0) {

            throw new IllegalArgumentException("El numero a crear no es valido");
        }

        for (int i = 0; i < num; i++) {

            listaRobots.add(new RobotVico(random.nextInt(0, 5000), random.nextInt(0, 100)));

        }

        return listaRobots;
    }

}
