package controlador;

import java.util.ArrayList;
import modelo.Pelicula;
import vista.Consola;

/**
 *
 * @author gonzalo.detomas
 */
public class Principal {

    public static void main(String[] args) {
        Pelicula nuevaPeli; //= new Pelicula();
        Consola c = new Consola();
        int opcion;
        ArrayList <Pelicula> arrLPelis = new ArrayList<>();
        FicheroControl fichero = new FicheroControl();
        
        do{
            opcion = c.menu();
            
            switch (opcion) {
                case 1:
                    nuevaPeli = c.pideDatosPeli();
                    arrLPelis.add(nuevaPeli);
                    //arrLPelis.add(c.pideDatosPeli()); Otra forma de hacerlo en una línea de código
                    break;
                case 2:
                    for (int i = 0; i < arrLPelis.size(); i++) {
                        c.muestraPeli(arrLPelis.get(i));
                    }
                    break;
                case 3:
                    fichero.escribeFichero(arrLPelis);
                    break;
                case 4:
                    fichero.guardaExcel(arrLPelis);
                    break;
                case 5:
                    fichero.leeFichero();
                    break;
                default:
                    System.out.println("Introduzca una opción correcta");
            }
                    
        }while(opcion!=0);
        
    }//Cierre main
   
}//Cierre clase
