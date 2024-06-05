package Vista;

import Controlador.GestorDeArchivos;
import Controlador.OptimizacionDeRutas;
import Modelo.GestionDeRutas;
import Modelo.RegistroHorario;
import Modelo.RegistroParadas;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDeGestionDeBusesUTPL {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        ArrayList<RegistroParadas> todasLasParadas = new ArrayList<>();
        ArrayList<GestionDeRutas> todasLasRutas = new ArrayList<>();

        String agregarHorarios;
        int n = 0;
        int opcion = 0;

        do {
            System.out.println(""
                    + "-----------------------------------------------------------"
                    + "-------------------\n"
                    + "\t\t\tSistema De Gestion De Buses UTPL\n"
                    + "-----------------------------------------------------------"
                    + "-------------------");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar una nueva parada");
            System.out.println("2. Registrar una nueva ruta");
            System.out.println("3. Mostrar todas las paradas");
            System.out.println("4. Mostrar todas las rutas");
            System.out.println("5. Consultar horarios de una parada");
            System.out.println("6. Optimizar tiempo");
            System.out.println("7. Salir");
            opcion = entrada.nextInt();
            entrada.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    ArrayList<RegistroHorario> horariosParada = new ArrayList<>();
                    ArrayList<GestionDeRutas> rutasParada = new ArrayList<>();

                    System.out.println("Ingrese el nombre de la parada");
                    String paradaNombre = entrada.nextLine();
                    System.out.println("Ingrese la ubicacion de la parada");
                    String ubicacionParada = entrada.nextLine();

                    System.out.println("¿Desea agregar horarios a esta parada? (s/n)");
                    agregarHorarios = entrada.nextLine();
                    while (agregarHorarios.equalsIgnoreCase("s")) {
                        System.out.println("Ingrese la hora de salida (HH,MM)");
                        double horaSalida = entrada.nextDouble();
                        System.out.println("Ingrese la hora de llegada (HH,MM)");
                        double horaLlegada = entrada.nextDouble();
                        entrada.nextLine();
                        System.out.println("Ingrese el nombre de la ruta");
                        String nombreRuta = entrada.nextLine();

                        RegistroHorario horario = new RegistroHorario(horaSalida, horaLlegada);
                        horariosParada.add(horario);

                        GestionDeRutas rutaParada = new GestionDeRutas(nombreRuta);
                        rutasParada.add(rutaParada);

                        System.out.println("¿Desea agregar otro horario? (s/n)");
                        agregarHorarios = entrada.nextLine();
                    }
                    RegistroParadas parada = new RegistroParadas(paradaNombre, ubicacionParada, horariosParada, rutasParada);
                    todasLasParadas.add(parada);

                    GestorDeArchivos.guardarEnArchivo("paradas.dat", todasLasParadas);
                    break;
                case 2:
                    ArrayList<RegistroHorario> horariosRuta = new ArrayList<>();
                    ArrayList<RegistroParadas> paradasRuta = new ArrayList<>();
                    System.out.println("Ingrese el nombre de la ruta");
                    String nombreRuta = entrada.nextLine();

                    System.out.println("¿Desea agregar horarios a esta ruta? (s/n)");
                    agregarHorarios = entrada.nextLine();
                    while (agregarHorarios.equalsIgnoreCase("s")) {
                        System.out.println("Ingrese la hora de salida (HH,MM)");
                        double horaSalida = entrada.nextDouble();
                        System.out.println("Ingrese la hora de llegada (HH,MM)");
                        double horaLlegada = entrada.nextDouble();
                        entrada.nextLine();
                        System.out.println("Ingrese el nombre de la parada");
                        String nombre = entrada.nextLine();
                        System.out.println("Ingrese la ubicacion de la parada");
                        String ubicacion = entrada.nextLine();

                        RegistroHorario horario = new RegistroHorario(horaSalida, horaLlegada);
                        horariosRuta.add(horario);

                        RegistroParadas paradaRuta = new RegistroParadas(nombre, ubicacion);
                        paradasRuta.add(paradaRuta);

                        System.out.println("¿Desea agregar otro horario? (s/n)");
                        agregarHorarios = entrada.nextLine();
                    }
                    GestionDeRutas ruta = new GestionDeRutas(nombreRuta, paradasRuta, horariosRuta);
                    todasLasRutas.add(ruta);
                    GestorDeArchivos.guardarEnArchivo("rutas.dat", todasLasRutas);
                    break;
                case 3:
                    System.out.println("-----------------------------Paradas registradas------------------------------");
                    if (!todasLasParadas.isEmpty()) {
                        for (RegistroParadas r : todasLasParadas) {
                            System.out.println(r);
                        }
                    } else {
                        System.out.println("Base de datos vacía\n");
                    }

                    System.out.print("<< Presione una tecla para avanzar >> ");
                    entrada.nextLine();
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("-----------------------------Rutas registradas--------------------------------");
                    System.out.println("Rutas registradas:");
                    if (!todasLasRutas.isEmpty()) {
                        for (GestionDeRutas r : todasLasRutas) {
                            System.out.println(r);
                        }
                    } else {
                        System.out.println("Base de datos vacía\n");
                    }

                    System.out.print("<< Presione una tecla para avanzar >> ");
                    entrada.nextLine();
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("-----------------------------Horario de buses--------------------------------");
                    n = 1;
                    if ((!todasLasRutas.isEmpty()) || (!todasLasParadas.isEmpty())) {
                        for (int i = 0; i < todasLasParadas.size(); i++) {
                            for (int j = 0; j < todasLasParadas.get(i).obtenerHorarios().size(); j++) {
                                System.out.println(n + ". " + todasLasParadas.get(i).obtenerHorarios().get(j));
                                n += 1;
                            }
                        }
                        for (int i = 0; i < todasLasRutas.size(); i++) {
                            for (int j = 0; j < todasLasRutas.get(i).obtenerHorarios().size(); j++) {
                                System.out.println(n + ". " + todasLasRutas.get(i).obtenerHorarios().get(j));
                                n += 1;
                            }
                        }

                    } else {
                        System.out.println("Base de datos vacía\n");
                    }

                    System.out.print("<< Presione una tecla para avanzar >> ");
                    entrada.nextLine();
                    System.out.println("");
                    break;
                case 6:
                    int numArry = 0;
                    String rutaSeleccionada = "";

                    if ((!todasLasRutas.isEmpty()) || (!todasLasParadas.isEmpty())) {
                        System.out.println("Seleccione cual de las siguientes rutas registrada se desea optimizar");
                        n = 1;
                        for (int i = 0; i < todasLasParadas.size(); i++) {
                            for (int j = 0; j < todasLasParadas.get(i).obtenerRutas().size(); j++) {
                                System.out.println(n + ". " + todasLasParadas.get(i).obtenerRutas().get(j).getNombreRuta());
                                n += 1;
                                numArry = 1;
                            }
                        }
                        for (int i = 0; i < todasLasRutas.size(); i++) {
                            System.out.println(n + ". " + todasLasRutas.get(i).getNombreRuta());
                            n += 1;
                            numArry = 2;
                        }
                        int eleccion = entrada.nextInt();

                        if (numArry == 1) {
                                rutaSeleccionada = todasLasParadas.get(eleccion - 1).obtenerRutas().get(0).getNombreRuta();

                        } else {
                            rutaSeleccionada = todasLasRutas.get(eleccion - 1).getNombreRuta();
                        }

                        String mensaje = OptimizacionDeRutas.editarHorarios(rutaSeleccionada, todasLasRutas, todasLasParadas);
                        System.out.println(mensaje);
                        entrada.nextLine();
                    } else {
                        System.out.println("Base de datos vacía\n");
                    }

                    System.out.print("<< Presione una tecla para avanzar >> ");
                    entrada.nextLine();
                    System.out.println("");
                    break;
                case 7:
                    System.out.println("Usted ha salido del programa");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 7);
    }

}