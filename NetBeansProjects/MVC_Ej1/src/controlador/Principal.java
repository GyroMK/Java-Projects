/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

import java.util.Scanner;
import modelo.Mascota;
import vista.Consola;

/**
 *
 * @author sergi.carmona
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Consola c = new Consola();
        Mascota perro = new Mascota("Alan", "19/04/2018", "Perro", "Dálmata", 78934);
        Mascota gato = new Mascota("Yeremy", "08/10/2019", "Gato", "Esfinge", 11264);
        
        c.muestraMascota(perro);
        c.muestraMascota(gato);
        System.out.println("");
        
        String nombre = c.pideCadena("Escribe el nombre: ");
        String fechaNacimiento = c.pideCadena("Escribe la fecha de nacimiento: ");
        String animal = c.pideCadena("Escribe el animal: ");
        String raza = c.pideCadena("Escribe la raza: ");
        int numeroChip = c.pideNumero("Escribe su numero de chip: ");
        Mascota loro = new Mascota(nombre, fechaNacimiento, animal, raza, numeroChip);
        Mascota m;
        // Tenemos que guardar en una variable de tipo Persona lo que devuelve pideDatos
        m = c.nuevaMascota();
        c.muestraMascota(m);
        
        c.muestraMascota(loro);
    }
    
}
