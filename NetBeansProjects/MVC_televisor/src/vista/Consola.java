package vista;

import java.util.Scanner;
import modelo.Televisor;
import modelo.Televisor.Nombre;

/**
 *
 * @author sergi.carmona
 */
public class Consola {

    public Televisor nuevaTele() {
        Scanner teclado = new Scanner(System.in);
        Televisor t = new Televisor();

        System.out.print("Escribe la marca: ");
        t.setNombre(PideMarca());
        System.out.print("Escribe el modelo: ");
        t.setModelo(teclado.nextLine());
        System.out.print("Escribe las pulgadas: ");
        t.setPulgadas(teclado.nextInt());
        System.out.print("Escribe el pais: ");
        t.setPais(teclado.nextLine());

        return t;
    }

    public Nombre PideMarca() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Marcas\n1.SAMSUNG\n2.LG\n3.PHILIPS\n4.SONY");
        System.out.println("Introduzca la opcion: ");
        int opcion = teclado.nextInt();
        do {

            switch (opcion) {
                case 1:
                    return Nombre.SAMSUNG;
                case 2:
                    return Nombre.LG;
                case 3:
                    return Nombre.PHILIPS;
                case 4:
                    return Nombre.SONY;

                default:
                    System.out.println("Introduze una opcion correcta");
            }
        } while (opcion > 4 || opcion < 1);
        return Nombre.SAMSUNG;
    }

    public void muestraTele(Televisor t) {
        System.out.println("\n\tLos datos son: ");
        System.out.println("Su marca es: " + t.getNombre());
        System.out.println("Su modelo es: " + t.getModelo());
        System.out.println("Sus pulgadas es: " + t.getPulgadas());
        System.out.println("Su pais es: " + t.getPais());
    }

    public String pideCadena(String pregunta) {
        Scanner teclado = new Scanner(System.in);
        String cadenaPedida;
        System.out.print(pregunta);
        cadenaPedida = teclado.nextLine();

        return cadenaPedida;
    }

    public int pideNumero(String pregunta) {
        Scanner teclado = new Scanner(System.in);
        int numeroPedido;
        System.out.print(pregunta);
        numeroPedido = teclado.nextInt();

        return numeroPedido;
    }
}
