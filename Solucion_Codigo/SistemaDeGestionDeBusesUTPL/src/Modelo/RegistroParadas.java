package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class RegistroParadas implements Serializable{

    private String nombre;
    private String ubicacion;
    private ArrayList<RegistroHorario> horarios;
    private ArrayList<GestionDeRutas> rutas;

    public RegistroParadas(String nombre, String ubicacion,ArrayList<RegistroHorario> horarios, ArrayList<GestionDeRutas> rutas) {

        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.horarios = horarios;
        this.rutas = rutas;
    }
    public RegistroParadas(String nombre, String ubicacion){
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
    
    public ArrayList<RegistroHorario> obtenerHorarios() {
        return horarios;
    }

    public ArrayList<GestionDeRutas> obtenerRutas() {
        return rutas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public String toString() {
        String acumulador = "+ " + nombre + ", ubicado en " + ubicacion;
        if (rutas == null) {
            return nombre + ", ubicado en " + ubicacion;
        }
        for (int i = 0; i < rutas.size(); i++) {
            acumulador = String.format("%s\n   - Ruta: %s\n   - Horario: %s\n",
                    acumulador,
                    rutas.get(i),
                    horarios.get(i));
        }

        return acumulador;
    }
}
