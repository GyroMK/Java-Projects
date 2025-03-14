package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.Consola;

/**
 *
 * @author sergi.carmona
 */
public class Viajero implements Serializable {

    private String nombre;
    private int edad;
    private int numViajes;
    private ArrayList<Viajes> ArrViajes;

    public Viajero() {
        this.nombre = "";
        this.edad = 0;
        this.numViajes = 0;
    }

    public Viajero(String nombre, int edad, int numViajes) {
        this.nombre = nombre;
        this.edad = edad;
        this.numViajes = numViajes;
    }

    public void muestraViajero(String Properties) {
        Consola c = new Consola();
        InputStream entrada = null;
        Properties propiedades = new Properties();

            System.out.println("==============================");
            System.out.println((propiedades.getProperty("nombre") + ": " + nombre));
            System.out.println((propiedades.getProperty("edad") + ": " + edad));
            if (numViajes == 0) {
                System.out.println(propiedades.getProperty("noViajes"));
            } else {
                System.out.println((propiedades.getProperty("numViajes") + ": " + numViajes));
            }
            for (Viajes v : ArrViajes) {
                System.out.println("\t" + (propiedades.getProperty("destino") + ": " + v.getDestino()));
                System.out.println("\t" + (propiedades.getProperty("tiempo") + ": " + v.getTiempo()));
                if (v.getAcompanyante() == Viajes.Acompanyante.AMIGOS) {
                    System.out.println("\t" + (propiedades.getProperty("amigos")));
                } else if (v.getAcompanyante() == Viajes.Acompanyante.FAMILIA) {
                    System.out.println("\t" + (propiedades.getProperty("familia")));
                } else {
                    System.out.println("\t" + propiedades.getProperty("solo"));
                }
                System.out.println("\t" + (propiedades.getProperty("valoracion") + ": " + v.getValoracion()));
                System.out.println("------------------------");

            }
        }
    

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumViajes() {
        return numViajes;
    }

    public void setNumViajes(int numViajes) {
        this.numViajes = numViajes;
    }

    public ArrayList<Viajes> getArrViajes() {
        return ArrViajes;
    }

    public void setArrViajes(ArrayList<Viajes> ArrViajes) {
        this.ArrViajes = ArrViajes;
    }

}
