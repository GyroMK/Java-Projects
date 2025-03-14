/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Deportista;
import modelo.Equipo;

/**
 *
 * @author gonzalo.detomas
 */
public class Formulario {

    public Deportista pideDatos() {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Equipo> equiposDondeHaJugado = new ArrayList<>();
        Deportista deportistaActual = new Deportista();
        // Rellenamos el objeto deportistaActual
        System.out.print("Nombre: ");
        deportistaActual.setNombre(teclado.nextLine());
        System.out.print("Apellido: ");
        deportistaActual.setApellido(teclado.nextLine());
        System.out.print("Edad: ");
        deportistaActual.setEdad(teclado.nextInt());
        System.out.print("Número de equipos en los que ha jugado: ");
        deportistaActual.setNumEquipos(teclado.nextInt());
        teclado.nextLine();
        
        // Rellenamos los equipos en los que ha estado el deportista
        Equipo equipoActual = null;
        for (int x = 0; x < deportistaActual.getNumEquipos(); x++) {
            equipoActual = new Equipo();    // Reservamos un nuevo espacio de memoria
            System.out.print("Nombre: ");
            equipoActual.setNombre(teclado.nextLine());
            System.out.print("Localidad: ");
            equipoActual.setLocalidad(teclado.nextLine());
            System.out.print("Año de fundacion: ");
            equipoActual.setAnioFundacion(teclado.nextInt());
            teclado.nextLine();
            
            // Añadir el equipo a un ArrayList de equipos donde ha jugado
            equiposDondeHaJugado.add(equipoActual);
        }
        // Añadir el ArrayList al objeto deportistaActual
        deportistaActual.setArrLEquipos(equiposDondeHaJugado);
        
        return deportistaActual;
    }
    
    public void leeDeportista(Deportista deportistaActual){
        System.out.println("==============================");
        System.out.println("Nombre: " + deportistaActual.getNombre());
        System.out.println("Apellido: " + deportistaActual.getApellido());
        System.out.println("Edad: " + deportistaActual.getEdad());
        System.out.println("Equipos donde ha jugado: " + deportistaActual.getNumEquipos());
        // Mostramos todos los equipos donde ha jugado
        /*for(int i=0; i<deportistaActual.getNumEquipos(); i++){
            System.out.println("\tNombre del equipo: " + deportistaActual.getArrLEquipos().get(i).getNombre());
        }*/
        for(Equipo e : deportistaActual.getArrLEquipos()){
            System.out.println("\tNombre del equipo: " + e.getNombre());
            System.out.println("\tLocalidad del equipo: " + e.getLocalidad());
            System.out.println("\tAño de fundación: " + e.getAnioFundacion());
        }
    }
}
