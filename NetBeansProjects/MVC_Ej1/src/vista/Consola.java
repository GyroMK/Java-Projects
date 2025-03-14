
package vista;

import java.util.Scanner;
import modelo.Mascota;

/**
 *
 * @author sergi.carmona
 */
public class Consola {
    public Mascota nuevaMascota() {
        Scanner teclado = new Scanner(System.in);
        Mascota m = new Mascota();
        
        System.out.print("Escribe el nombre: ");
        m.setNombre(teclado.nextLine());
        System.out.print("Escribe la fecha de nacimiento: ");
        m.setFechaNacimiento(teclado.nextLine());
        System.out.print("Escribe el animal: ");
        m.setAnimal(teclado.nextLine());
        System.out.print("Escribe la raza: ");
        m.setRaza(teclado.nextLine());
        System.out.print("Escribe su numero de chip: ");
        m.setNumeroChip(teclado.nextInt());
        
        return m;
    }
    
    public void muestraMascota(Mascota m) {
        System.out.println("\n\tLos datos son: ");
        System.out.println("Su nombre es: "+m.getNombre());
        System.out.println("Su fecha de nacimiento es: "+m.getFechaNacimiento());
        System.out.println("Su animal es: "+m.getAnimal());
        System.out.println("Su raza es: "+m.getRaza());
        System.out.println("Su numero de chip es: "+m.getNumeroChip());
    }
    
    public String pideCadena(String pregunta) {
        Scanner teclado = new Scanner(System.in);
        String cadenaPedida;
        System.out.print(pregunta);
        cadenaPedida = teclado.nextLine();
        
        return cadenaPedida;
    }
    public int pideNumero(String pregunta) {
        Scanner teclado = new Scanner(System.in);
        int numeroPedido;
        System.out.print(pregunta);
        numeroPedido = teclado.nextInt();
        
        return numeroPedido;
    }
}
