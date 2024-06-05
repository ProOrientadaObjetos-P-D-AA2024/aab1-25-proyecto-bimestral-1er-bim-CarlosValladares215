package Controlador;

import Modelo.GestionDeRutas;
import Modelo.RegistroParadas;
import java.util.ArrayList;
import java.util.Scanner;

public class OptimizacionDeRutas {

    public static String editarHorarios(String nombreRuta, ArrayList<GestionDeRutas> todasLasRutas, ArrayList<RegistroParadas> todasLasParadas) {
        Scanner entrada = new Scanner(System.in);
        double nuevaHoraSalida;
        double nuevaHoraLlegada;
        int n;

        for (int i = 0; i < todasLasParadas.size(); i++) {
            for (int j = 0; j < todasLasParadas.get(i).obtenerHorarios().size(); j++) {
                if (todasLasParadas.get(i).obtenerRutas().get(j).getNombreRuta().equals(nombreRuta)) {
                    System.out.println("Ingrese la nueva hora de salida (HH,MM):");
                    nuevaHoraSalida = entrada.nextDouble();
                    System.out.println("Ingrese la nueva hora de llegada (HH,MM):");
                    nuevaHoraLlegada = entrada.nextDouble();

                    todasLasParadas.get(i).obtenerHorarios().get(j).setHoraSalida(nuevaHoraSalida);
                    todasLasParadas.get(i).obtenerHorarios().get(j).setHoraLlegada(nuevaHoraLlegada);
                }
            }
        }

        for (int i = 0; i < todasLasRutas.size(); i++) {
            for (int j = 0; j < todasLasRutas.get(i).obtenerHorarios().size(); j++) {
                if (todasLasRutas.get(i).getNombreRuta().equals(nombreRuta)) {
                    System.out.println("Ingrese la nueva hora de salida (HH,MM):");
                    nuevaHoraSalida = entrada.nextDouble();
                    System.out.println("Ingrese la nueva hora de llegada (HH,MM):");
                    nuevaHoraLlegada = entrada.nextDouble();

                    todasLasRutas.get(i).obtenerHorarios().get(j).setHoraSalida(nuevaHoraSalida);
                    todasLasRutas.get(i).obtenerHorarios().get(j).setHoraLlegada(nuevaHoraLlegada);
                }
            }

        }
        return "Horarios actualizados con éxito para la ruta: " + nombreRuta;
    }

}