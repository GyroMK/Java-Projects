package controlador;

import java.util.ArrayList;
import vista.Consola;
import modelo.Edificios;

/**
 *
 * @author sergi.carmona
 */
public class Principal {

    public static void main(String[] args) {
        Edificios nuevoEdificio = new Edificios();
        Ficheros f = new Ficheros();
        Consola c = new Consola();
        int opcion;
        ArrayList<Edificios> grupoEdificio = new ArrayList<>();

        do {
            opcion = c.menu();
            switch (opcion) {
                case 1:
                    grupoEdificio.add(c.pideDatos());
                    break;
                case 2:
                    for (int i = 0; i < grupoEdificio.size(); i++) {
                        c.MuestraDatos(grupoEdificio.get(i));
                    }
                    //grupoEdificio.forEach(System.out::println);
                case 3:
                    f.escribir(grupoEdificio);
                    break;
                case 4:
                    f.leer();
                    break;
                default:
                    System.out.println("Introduzca una opcion correcta");
            }
        } while (opcion < 5 || opcion > 1);
    }
}
