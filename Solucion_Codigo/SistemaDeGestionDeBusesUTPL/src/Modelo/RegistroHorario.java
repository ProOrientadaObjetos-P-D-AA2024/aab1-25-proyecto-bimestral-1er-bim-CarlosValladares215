package Modelo;

import java.io.Serializable;

public class RegistroHorario implements Serializable{
    private double horaLlegada;
    private double horaSalida;

    public RegistroHorario(double horaSalida, double horaLlegada) {
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    public void setHoraLlegada(double horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public void setHoraSalida(double horaSalida) {
        this.horaSalida = horaSalida;
    }
    
    
    @Override
    public String toString() {
        return "[Salida: " + horaSalida + ", Llegada: " + horaLlegada + "]";
    }
}
