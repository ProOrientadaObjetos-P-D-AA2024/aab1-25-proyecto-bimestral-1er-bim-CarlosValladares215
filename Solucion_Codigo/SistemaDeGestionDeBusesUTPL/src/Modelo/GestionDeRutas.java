package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class GestionDeRutas implements Serializable{

    private String nombreRuta;
    private ArrayList<RegistroParadas> paradas;
    private ArrayList<RegistroHorario> horarios;

    public GestionDeRutas(String nombreRuta, ArrayList<RegistroParadas> paradas, ArrayList<RegistroHorario> horarios) {
        this.nombreRuta = nombreRuta;
        this.paradas = paradas;
        this.horarios = horarios;
    }

    public GestionDeRutas(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }
    
    public ArrayList<RegistroParadas> obtenerParadas() {
        return paradas;
    }

    public ArrayList<RegistroHorario> obtenerHorarios() {
        return horarios;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    @Override
    public String toString() {
        String acumulador = "+ " + nombreRuta;

        if (paradas == null) {
            return nombreRuta;
        }

        for (int i = 0; i < paradas.size(); i++) {
            acumulador = String.format("%s\n   - Parada: %s\n   - Horario: %s\n",
                    acumulador,
                    paradas.get(i),
                    horarios.get(i));
        }
        return acumulador;
    }
}
