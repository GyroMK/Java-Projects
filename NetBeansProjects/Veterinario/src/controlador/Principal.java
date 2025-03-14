package controlador;

import java.util.ArrayList;
import modelo.Mascotas;
import vista.Consola;

/**
 *
 * @author gonzalo.detomas
 */
public class Principal {

    public static void main(String[] args) {
        Consola c = new Consola();
        Bbdd_Control mibbdd = new Bbdd_Control();
        int opcion;
        Mascotas mascota;
        ArrayList<Mascotas> arrLMasc = new ArrayList<>();
        int numMenu = 0;
        Ficheros f = new Ficheros();

        do {
            opcion = c.menuPrincipal();

            switch (opcion) {
                case 1:
                    mascota = c.pideDatos();
                    mibbdd.insertaDartos(mascota);
                    break;
                case 2:
                    // Creamos un nuevo objeto para tener los valores del constructor por defecto
                    mascota = new Mascotas();
                    mascota = c.consultaSubmenu();
                    arrLMasc = mibbdd.consultaMascota(mascota);
                    do {
                        numMenu = c.menuFicheros();
                        switch (numMenu) {
                            case 1:
                                f.escribirFicheroTexto(arrLMasc);
                                break;
                            case 2:
                                f.escribirEnWord(arrLMasc);
                                break;
                            case 3:
                                f.escribirEnExcel(arrLMasc);
                                break;
                        }
                    } while (numMenu != 0);
                    break;
                case 3:
                    mibbdd.modificarDatosConPrepareStatement();
                    break;
                case 4:
                    mibbdd.borraDatos();
                    break;
                case 0:
                    c.muestraCadena("Saliendo de la app");
                    break;
                default:
                    c.muestraCadena("Opción incorrecta!");
            }
        } while (opcion != 0);
    }//main

}//class
