/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escribirobjetoenfichero;

import java.io.Serializable;

/**
 *
 * @author Gon
 */
public class Persona implements Serializable{
    private String nombre;
    private String lugar;
    private int edad;

    public Persona(String nombre, String lugar, int edad){
        this.nombre = nombre;
        this.lugar = lugar;
        this.edad = edad;
    }
    
    public void muestraPersona(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Lugar: " + lugar);
        System.out.println("Edad: " + edad);
    }
}
