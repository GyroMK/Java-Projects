
package controlador;

import modelo.Teclado;
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
        // TODO code application logic here
        Consola c = new Consola();
        Teclado d = null;
        d = c.pideDatos();
        c.leeTeclado(d);
    }
    
}
