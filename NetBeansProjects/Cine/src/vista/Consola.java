package vista;

import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.Pelicula;
import modelo.Pelicula.Genero;

/**
 *
 * @author gonzalo.detomas
 */
public class Consola {

    public int pideNum(String texto) { //Método que pide un número
        Scanner teclado = new Scanner(System.in);
        int devuelveNum = -1;//Integer.MIN_VALUE; Da igual el nº al que inicialices la variable
        boolean numOK = false;

        do {
            System.out.print(texto);

            try { //Intenta esto
                devuelveNum = teclado.nextInt();
                numOK = true;

            } catch (InputMismatchException ex) {
                System.out.println("Introduzca un número!!");
                teclado.nextLine(); //Limpio buffer
            }
        } while (!numOK);
        return devuelveNum;
    }

    public float pideFloat(String texto) { //Aqui otra forma de controlar para que vuelva a pedir sin utilizar boolean
        Scanner teclado = new Scanner(System.in);
        float devuelveNum = -1;//Integer.MIN_VALUE; Da igual el nº al que inicialices la variable
        boolean numOK = false;

        do {
            System.out.print(texto);

            try { //Intenta esto
                devuelveNum = teclado.nextFloat();
                numOK = true;

            } catch (InputMismatchException ex) {
                System.out.println("Introduzca un número!!");
                teclado.nextLine(); //Limpio buffer
            }
        } while (!numOK);
        /*
        Scanner teclado = new Scanner(System.in);
        float devuelveNum = -1.0f;
        System.out.println("Dentro del pideFloat");
        while (devuelveNum != -1.0f) {
            System.out.print(texto);
            try { //Intenta esto
                devuelveNum = teclado.nextFloat();

            } catch (InputMismatchException ex) {
                System.out.println("Introduzca un número!!");
            } finally {
                teclado.nextLine();//Limpio buffer
            }

        }*/

        return devuelveNum;
    }

    public String pideCadena(String texto) { //Aqui no hace falta controlar con un do-while ya que un String acepta un nº
        Scanner teclado = new Scanner(System.in);
        String devuelveCadena = null;

        System.out.print(texto);

        try { //Intenta esto
            devuelveCadena = teclado.nextLine();

        } catch (InputMismatchException ex) {
            System.out.println("Introduzca un número!!");
        }
        return devuelveCadena;
    }

    public int menu() {
        int opcion;
        do {
            System.out.println("Menú:\n1.Insertar película\n"
                    + "2.Mostrar Películas\n"
                    + "3.Guardar en fichero\n"
                    + "4.Guardar en Excel\n"
                    + "5.Leer fichero en consola\n"
                    + "0.Salir");

            opcion = pideNum(" Introduzca una opción: ");
        } while (opcion < 0 || opcion > 5);
        return opcion;
    }

    public Genero pideGenero() {
        int opcion;
        do {
            System.out.println("Géneros:\n1.ACCIÓN\n"
                    + "2.COMEDIA\n"
                    + "3.ROMANCE\n"
                    + "4.TERROR\n"
                    + "5.CIENCIA FICCIÓN");
            opcion = pideNum("Introduzca una opción: ");
            switch (opcion) {
                case 1:
                    return Genero.ACCION; //Cuando utilizas return en un case no hace falta usar un break
                case 2:
                    return Genero.COMEDIA;
                case 3:
                    return Genero.ROMANCE;
                case 4:
                    return Genero.TERROR;
                case 5:
                    return Genero.CIENCIA_FICCION;
            }

        } while (opcion < 1 || opcion > 5);

        return Genero.CIENCIA_FICCION;
    }

    public Pelicula pideDatosPeli() {
        Pelicula nuevaPeli = new Pelicula(); //Objeto de tipo Pelicula

        nuevaPeli.setNombrePeli(pideCadena("Introduzca el nombre de la película: "));
        nuevaPeli.setDuracion(pideNum("Introduzca la duración de la película: "));
        nuevaPeli.setPais(pideCadena("Introduzca el pais de la película: "));
        nuevaPeli.setDirector(pideCadena("Introduzca el director de la película: "));
        nuevaPeli.setGenero(pideGenero());
        nuevaPeli.setNombrePremio(pideCadena("Introduzca el nombre del premio: "));
        nuevaPeli.setCiudadPremio(pideCadena("Introduzca la ciudad del premio: "));
        nuevaPeli.setValoracion(pideFloat("Introduzca la valoración de la película: "));

        return nuevaPeli;
    }

    public void muestraPeli(Pelicula nuevaPeli) { //Con void no utilizas return porque no vas a devolver nada
        System.out.println("Nombre: " + nuevaPeli.getNombrePeli());
        System.out.println("Duración: " + nuevaPeli.getDuracion());
        System.out.println("Pais: " + nuevaPeli.getPais());
        System.out.println("Director: " + nuevaPeli.getDirector());
        System.out.println("Género: " + nuevaPeli.getGenero());
        System.out.println("Nombre Premio: " + nuevaPeli.getNombrePremio());
        System.out.println("Ciudad Premio: " + nuevaPeli.getCiudadPremio());
        System.out.println("Valoración: " + nuevaPeli.getValoracion());
    }

}//Cierre consola
