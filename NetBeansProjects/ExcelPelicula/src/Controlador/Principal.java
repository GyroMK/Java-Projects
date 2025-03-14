package Controlador;

import Modelo.Pelicula;
import Modelo.Premios;
import Vista.Consola;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sergi.carmona
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Consola c = new Consola();
        Ficheros f = new Ficheros();
        Scanner teclado = new Scanner(System.in);
        Pelicula p = null;
        int menu;
        ArrayList<Pelicula> grupoPeliculas = new ArrayList<>();

       
        do {
            switch (c.Menu()) {
                case 1:
                    grupoPeliculas.add(c.pideDatos());
                    break;
                case 2:
                    for (int i = 0; i < grupoPeliculas.size(); i++) {
                        c.muestraDatos(grupoPeliculas.get(i));
                    }
                    break;
                case 3:
                    f.escribir(grupoPeliculas);
                    break;
                case 4:
                    f.escribirExcel(grupoPeliculas);
                    break;
                case 5:
                    f.leer();
                    break;
            }

        } while (c.Menu() < 5 || c.Menu() > 1);

    }

}
