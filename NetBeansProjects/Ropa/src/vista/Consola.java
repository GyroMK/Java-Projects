package vista;

import controlador.BaseDeDatos;
import java.util.Scanner;
import modelo.Ropa;

/**
 *
 * @author gonzalo.detomas
 */
public class Consola {

    public String pideCadena(String pregunta) {
        Scanner teclado = new Scanner(System.in);
        System.out.print(pregunta);

        return teclado.nextLine();
    }

    public int pideEntero(String pregunta) {
        Scanner teclado = new Scanner(System.in);
        System.out.print(pregunta);

        return teclado.nextInt();
    }

    public float pideDecimal(String pregunta) {
        Scanner teclado = new Scanner(System.in);
        System.out.print(pregunta);

        return teclado.nextFloat();
    }

    public Ropa pideDatos() {
        Ropa prendaActual = new Ropa();
        String tallaActual = null;
        prendaActual.setTipoPrenda(pideCadena("Introduzca el tipo de prenda: "));
        prendaActual.setTipoMaterial(pideCadena("Introduzca el tipo de material: "));
        prendaActual.setDescripcion(pideCadena("Introduzca la descripción de la prenda: "));
        // Pedimos la talla mientras que pongan más de 3 caracteres (XL, XXL, 3XL, 4XL, 5XL...)
        do {
            tallaActual = pideCadena("Introduzca la talla: ");
        } while (tallaActual.length() > 3);
        prendaActual.setTalla(tallaActual);
        prendaActual.setPrecio(pideDecimal("Introduzca precio de la prenda: "));

        return prendaActual;
    }

    public void muestraDatos(Ropa prendaActual) {
        System.out.println("===============================");
        System.out.println("Identificador: " + prendaActual.getIdArticulo());
        System.out.println("Tipo de prenda: " + prendaActual.getTipoPrenda());
        System.out.println("Tipo de material: " + prendaActual.getTipoMaterial());
        System.out.println("Descripción: " + prendaActual.getDescripcion());
        System.out.println("Talla: " + prendaActual.getTalla());
        System.out.println("Precio: " + prendaActual.getPrecio() + " euros.");
        System.out.println("===============================");
    }

    // Método que devuelve el valor por el que queremos filtrar
    public Ropa consultaSubmenu() {
        BaseDeDatos bd = new BaseDeDatos();
        Ropa r = new Ropa();
        int opcion = -1;

        do {
            System.out.println("1. Filtrar por idArticulo");
            System.out.println("2. Filtrar por tipo de prenda");
            System.out.println("3. Filtrar por precio");
            opcion = pideEntero("Introduzca una opción: ");
        } while (opcion < 1 || opcion > 3);

        // Mostramos todos los datos
        bd.consultaGenerico();

        // Controlamos el dato por el que quiere filtrar
        switch (opcion) {
            case 1:
                r.setIdArticulo(pideEntero("Introduzca el idArticulo: "));
                return r;
            case 2:
                r.setTipoPrenda(pideCadena("Introduzca el tipo de prenda: "));
                return r;
            case 3:
                r.setPrecio(pideDecimal("Introduzca un precio: "));
                return r;
        }
        return null;
    }

    public int menu() {
        System.out.println("1. Inserta artículo");
        System.out.println("2. Consulta artículo");
        System.out.println("3. Modificar artículo");
        System.out.println("4. Borrar artículo");
        System.out.println("5. Salir");

        return pideEntero("Introduzca una opción: ");
    }

    public void muestraFrase(String texto) {
        System.out.println(texto);
    }

    public Ropa pedirTodosLosDatos() {
        Ropa prendaActual = new Ropa();
        prendaActual.setIdArticulo(pideEntero("Introduzca el Id a modificar: "));
        
        String tallaActual = null;
        prendaActual.setTipoPrenda(pideCadena("Introduzca el tipo de prenda: "));
        prendaActual.setTipoMaterial(pideCadena("Introduzca el tipo de material: "));
        prendaActual.setDescripcion(pideCadena("Introduzca la descripción de la prenda: "));
        // Pedimos la talla mientras que pongan más de 3 caracteres (XL, XXL, 3XL, 4XL, 5XL...)
        do {
            tallaActual = pideCadena("Introduzca la talla: ");
        } while (tallaActual.length() > 3);
        prendaActual.setTalla(tallaActual);
        prendaActual.setPrecio(pideDecimal("Introduzca precio de la prenda: "));

        return prendaActual;
    }
}
