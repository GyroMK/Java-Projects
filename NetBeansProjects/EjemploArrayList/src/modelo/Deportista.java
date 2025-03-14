/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author gonzalo.detomas
 */
public class Deportista {
    private String nombre;
    private String apellido;
    private int edad;
    private int numEquipos;
    private ArrayList<Equipo> arrLEquipos;
    
    public Deportista(){
        this.nombre = "";
        this.apellido = "";
        this.edad = 0;
    }
    
    public Deportista(String nombre, String apellido, int edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Equipo> getArrLEquipos() {
        return arrLEquipos;
    }

    public void setArrLEquipos(ArrayList<Equipo> arrLEquipos) {
        this.arrLEquipos = arrLEquipos;
    }

    public int getNumEquipos() {
        return numEquipos;
    }

    public void setNumEquipos(int numEquipos) {
        this.numEquipos = numEquipos;
    }    
}
