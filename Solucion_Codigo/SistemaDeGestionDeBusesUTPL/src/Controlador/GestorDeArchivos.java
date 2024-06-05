/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controlador;
import java.io.*;
import java.util.ArrayList;

public class GestorDeArchivos {
    // Guardar lista de objetos en archivo .dat
    public static void guardarEnArchivo(String nombreArchivo, ArrayList<?> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(lista);
            System.out.println("Datos guardados en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cargar lista de objetos desde archivo .dat
    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> cargarDesdeArchivo(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            return (ArrayList<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}