
package controlador;

import modelo.Televisor;
import modelo.Televisor.Nombre;
import vista.Consola;

/**
 *
 * @author sergi.carmona
 */
public class Principal {
    
    public static void main(String[] args) {
        Consola c = new Consola();
        Televisor TeleSalon = new Televisor(Nombre.SAMSUNG, "Paradise", 50, "Alemania");
        c.muestraTele(TeleSalon);
        
    
        
        Nombre nombre = c.PideMarca();
        String modelo = c.pideCadena("Escribe el modelo: ");
        Integer pulgadas = c.pideNumero("Escribe las pulgadas: ");
        String pais = c.pideCadena("Escribe el pais: ");
        
        Televisor TeleCocina = new Televisor(nombre, modelo, pulgadas, pais);
        c.muestraTele(TeleCocina);
    }
}
 