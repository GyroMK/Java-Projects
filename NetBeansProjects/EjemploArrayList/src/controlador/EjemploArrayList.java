/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Deportista;
import vista.Formulario;

/**
 *
 * @author gonzalo.detomas
 */
public class EjemploArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Formulario f = new Formulario();
        Deportista d = null;
        d = f.pideDatos();
        f.leeDeportista(d);
    }
    
}
