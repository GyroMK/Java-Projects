/*
 * Llamada a la clase abstracta
 */

package net.juanxxiii.ejemplos;

import java.util.Scanner;

/**
 *
 * @author Gon
 */
public class EjemploAbstracta {

    public static void main(String[] args) {
        // Creamos un objeto de la clase Circulo
        String palabra = null;
        Scanner teclado = new Scanner(System.in);
       
        
        Circulo c = new Circulo(5, 4, 7);
        System.out.println("El área del círculo es: " + c.area());
        c.mostrar();
        // Creamos un objeto de la clase Cuadrado
        Cuadrado cuadrado = new Cuadrado(25, 9, 8.3);
        System.out.println("El área del cuadrado es: " + cuadrado.area());
    }
}
