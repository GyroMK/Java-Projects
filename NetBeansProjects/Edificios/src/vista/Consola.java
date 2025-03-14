package vista;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Edificios;

/**
 *
 * @author sergi.carmona
 */
public class Consola {

    Scanner teclado = new Scanner(System.in);

    public void Menu() {
        int menu = teclado.nextInt();

        do {
            switch (menu) {
                case 1:
            }

            }
            while (menu > 4); 
                
    }
    
    public String PideCadena(String texto){
        Scanner teclado = new Scanner(System.in);
        String devuelveCadena;
        
        System.out.println(texto);
        devuelveCadena = teclado.nextLine();
        
        return devuelveCadena;
    }
    
    public int PideNum(String texto){
        Scanner teclado = new Scanner(System.in);
        int devuelveNum;
        
        System.out.print(texto);
        devuelveNum = teclado.nextInt();
        
        return devuelveNum;
    }
    
    public Edificios pideDatos() {
        Edificios nuevoEdificio = new Edificios();
        
        System.out.println("Escribe los datos: ");
        nuevoEdificio.setCalle(PideCadena("introduze la calle: "));
        nuevoEdificio.setNumPiso(PideNum("introduze el numero de piso: "));
        nuevoEdificio.setNomPres(PideCadena("introduze el nombre del presidente: "));
        nuevoEdificio.setNumPuertas(PideNum("introduze el numeo de puertas: "));
        
        return nuevoEdificio;
    }

    public void MuestraDatos(Edificios nuevoEdificio) {
        System.out.println("==============================");
            System.out.println("\tNombre de la calle: " + nuevoEdificio.getCalle());
            System.out.println("\tNumero de pisos: " + nuevoEdificio.getNumPiso());
            System.out.println("\tNombre del presidente: " + nuevoEdificio.getNomPres());
            System.out.println("\tNumero de puertas: " + nuevoEdificio.getNumPuertas());
    }
    
    public int menu(){
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("1.Inserta edificio");
        System.out.println("2.Mostrar todos los datos");
        System.out.println("3.Guardar en fichero todos los edificios");
        System.out.println("4.leer de fichero todos los edificios");
        System.out.println("Introduzca una opcion: ");
        int opcion=teclado.nextInt();
        //int opcion = pideNum("Intrizca una opcion: ")
        
        return opcion;
    }

}
