package controlador;

import modelo.Persona;
import vista.Consola;

/**
 *
 * @author gonzalo.detomas
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Consola c = new Consola();
        Persona p;
        // Tenemos que guardar en una variable de tipo Persona lo que devuelve pideDatos
        p = c.pideDatos();
        c.muestraDatos(p);
    }
    
}
