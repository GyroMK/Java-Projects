/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplos.de.ficheros;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Gon
 */
public class ExcepcionesPropias {
    public static void intervaloEdad(int edad) throws ExcepcionEdad{
        if(edad<16 || edad>65){
            throw new ExcepcionEdad("No puedes trabajar");
        }
    }
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int edad;
        String mensaje = "";
        
        try{
            System.out.print("Introduce la edad del trabajador: ");
            edad = teclado.nextInt();
            intervaloEdad(edad);
        }catch(InputMismatchException ime){
            mensaje = "No se permiten caracteres.";
        }catch(ExcepcionEdad ee){
            mensaje = ee.getMessage();
        }
        System.out.println(mensaje);
    }
}

