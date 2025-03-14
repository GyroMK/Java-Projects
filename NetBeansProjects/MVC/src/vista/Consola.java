package vista;

import java.util.Scanner;
import modelo.Persona;

/**
 *
 * @author gonzalo.detomas
 */
public class Consola {
    public Persona pideDatos(){
        Scanner teclado = new Scanner(System.in);
        Persona p = new Persona();
        
        // Pedir datos
        System.out.print("Introduzca nombre: ");
        p.setNombre(teclado.nextLine());
        System.out.print("Introduzca apellido: ");
        p.setApellido(teclado.nextLine());
        System.out.print("Introduzca nacionalidad: ");
        p.setNacionalidad(teclado.nextLine());
        System.out.print("Introduzca edad: ");
        p.setEdad(teclado.nextInt());
        System.out.print("Introduzca altura: ");
        p.setAltura(teclado.nextFloat());
        System.out.print("Introduzca (1) si está casado, (2) si no lo está: ");
        int casado = teclado.nextInt();
        if(casado == 1){
            p.setCasado(true);
        }else{
            p.setCasado(false);
        }    
        
        return p;
    }
    
    public void muestraDatos(Persona p){
        System.out.println("\n\tLos datos son: ");
        System.out.println("Nombre: " + p.getNombre());
        System.out.println("Apellido: " + p.getApellido());
        System.out.println("Nacionalidad: " + p.getNacionalidad());
        System.out.println("Edad: " + p.getEdad() + " años.");
        System.out.println("Altura: " + p.getAltura() + " m.");
        
        if(p.isCasado()){   // Si es verdadero (true)
            System.out.println("Casado");
        }else{
            System.out.println("Está receptiv@");
        }
    }
}
