package controlador;

import modelo.Ropa;
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
        BaseDeDatos bd = new BaseDeDatos();
        Ropa miRopa;
        int opcion;

        do {
            opcion = c.menu();
            switch (opcion) {
                case 1:
                    miRopa = c.pideDatos();
                    bd.insertaRopa(miRopa);
                    break;
                case 2:
                    miRopa = new Ropa(); // entra al constructor por defecto  
                    miRopa = c.consultaSubmenu();
                    bd.consultaPrenda(miRopa);
                    break;
                case 3:
                    bd.consultaGenerico();
                    c.muestraFrase("\tIntroduzca los datos a modificar");
                    miRopa = c.pedirTodosLosDatos();
                    bd.modificarRopa(miRopa);
                    break;
                case 4:
                    bd.consultaGenerico();
                    bd.borrarRopa();
                    break;
            }
        } while (opcion != 5);

    }

}
