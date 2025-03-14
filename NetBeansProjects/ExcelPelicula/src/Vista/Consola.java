package Vista;

import Modelo.Pelicula;
import Modelo.Pelicula.Genero;
import Modelo.Premios;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sergi.carmona
 */
public class Consola {

    public Pelicula pideDatos() {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Premios> PremiosGanados = new ArrayList<>();
        Pelicula peliculaActual = new Pelicula();

        peliculaActual.setNombre(pideCadena("Nombre: "));
        peliculaActual.setDuracion(pideEntero("Duracion: "));
        System.out.print("Genero: ");
        peliculaActual.setGenero(PideGenero());
        peliculaActual.setPais(pideCadena("Pais: "));
        peliculaActual.setDirector(pideCadena("Director: "));
        peliculaActual.setValoracion(pideDecimal("Valoracion: "));
        System.out.println("Numero de premios: ");
        peliculaActual.setNumPremios(teclado.nextInt());
        teclado.nextLine();

        Premios premioActual = null;
        for (int x = 0; x < peliculaActual.getNumPremios(); x++) {
            premioActual = new Premios();    // Reservamos un nuevo espacio de memoria
            System.out.print("Nombre del premio: ");
            premioActual.setNombrePremio(teclado.nextLine());
            System.out.print("Ciudad: ");
            premioActual.setCiudad(teclado.nextLine());

            PremiosGanados.add(premioActual);

        }
        peliculaActual.setArrPremios(PremiosGanados);
        return peliculaActual;
    }

    public void muestraDatos(Pelicula peliculaActual) {
        System.out.println("==============================");
        System.out.println("Nombre: " + peliculaActual.getNombre());
        System.out.println("Duracion:  " + peliculaActual.getDuracion()+"h.");
        System.out.println("Pais: " + peliculaActual.getPais());
        System.out.println("Director: " + peliculaActual.getDirector());
        System.out.println("Valoracion: " + peliculaActual.getValoracion());
        if (peliculaActual.getNumPremios() == 0) {
            System.out.println("Esta pelicula no tiene premios");
        } else {
            System.out.println("Premios que ha ganado: " + peliculaActual.getNumPremios());
        }
        for (Premios p : peliculaActual.getArrPremios()) {
            System.out.println("\tNombre del premio: " + p.getNombrePremio());
            System.out.println("\tCiudad del premio: " + p.getCiudad());
        }
    }

    public String pideCadena(String pregunta) {
        Scanner teclado = new Scanner(System.in);
        String cadenaPedida;
        System.out.println(pregunta);
        cadenaPedida = teclado.nextLine();
        return cadenaPedida;
    }

    public int pideEntero(String pregunta) {
        Scanner teclado = new Scanner(System.in);
        int enteroPedido;
        System.out.println(pregunta);
        enteroPedido = teclado.nextInt();
        return enteroPedido;
    }

    public float pideDecimal(String pregunta) {
        Scanner teclado = new Scanner(System.in);
        float decimalPedido;
        System.out.println(pregunta);
        decimalPedido = teclado.nextFloat();
        return decimalPedido;
    }

    public Genero PideGenero() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Generos\n1.ACCIÓN\n2.COMEDIA\n3.ROMANCE\n4.TERROR\n5.CIENCIA FICCIÓN");
        System.out.println("Introduzca la opcion: ");
        int opcion = teclado.nextInt();
        do {

            switch (opcion) {
                case 1:
                    return Genero.ACCION;
                case 2:
                    return Genero.COMEDIA;
                case 3:
                    return Genero.ROMANCE;
                case 4:
                    return Genero.TERROR;
                case 5:
                    return Genero.CIENCIA_FICCION;

                default:
                    System.out.println("Introduze una opcion correcta");
            }
        } while (opcion > 4 || opcion < 1);
        return Genero.ACCION;
    }
    
    public int Menu(){
    Scanner teclado = new Scanner(System.in);
        System.out.println("1.Insertar pelicula");
        System.out.println("2.Mostrar todas las peliculas");
        System.out.println("3.Guardar lista de peliculas en documento de texto");
        System.out.println("4.Guardar en excel todas las peliculas");
        System.out.println("5.Leer del documento de texto las peliculas\n");
        int menu = teclado.nextInt();
        
        return menu;
}

}
