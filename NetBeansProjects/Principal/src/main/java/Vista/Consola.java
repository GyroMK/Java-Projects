
package Vista;

import Modelo.Persona;
import java.util.Scanner;

/**
 *
 * @author sergi.carmona
 */
public class Consola {
    public void pedirDatos() {
        Scanner teclado = new Scanner(System.in);
        Persona p = new Persona();
        System.out.print("Introduzca su nombre: ");
        teclado.nextLine();
    }
}
