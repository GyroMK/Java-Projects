package vista;

import controlador.Bbdd_Control;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.Mascotas;

/**
 *
 * @author gonzalo.detomas
 */
public class Consola {

    public int pideNum(String texto) {
        Scanner t = new Scanner(System.in);
        int num = -1;
        boolean numOK = false;

        do {
            muestraCadena(texto);

            try {
                num = t.nextInt();
                numOK = true;
            } catch (InputMismatchException ex) {
                System.out.println("Introduzca un número correcto!");
                t.nextLine();
            }
        } while (!numOK);
        return num;
    }

    public float pideFloat(String texto) {
        Scanner t = new Scanner(System.in);
        float num = -1;
        boolean numOK = false;

        do {
            System.out.print(texto);

            try {
                num = t.nextFloat();
                numOK = true;
            } catch (InputMismatchException ex) {
                System.out.println("Introduzca un número correcto!");
                t.nextLine();
            }
        } while (!numOK);
        return num;
    }

    public String pideCadena(String texto) {
        Scanner t = new Scanner(System.in);

        System.out.print(texto);

        return t.nextLine();
    }

    public int menuPrincipal() {
        System.out.println("MENÚ\n"
                + "1.Insertar mascota\n"
                + "2.Consultar mascota\n"
                + "3.Modificar mascota\n"
                + "4.Borrar mascota\n"
                + "0.Salir");
        return pideNum("Introduzca una opción: ");
    }

    public void muestraCadena(String texto) {
        System.out.println(texto);
    }

    public Mascotas pideDatos() {
        Mascotas nuevaMascota = new Mascotas();
        int edadOK = -1;

        nuevaMascota.setNombre(pideCadena("Introduzca el nombre de la mascota: "));
        nuevaMascota.setTipoAnimal(pideCadena("Introduzca el tipo de animal que es la mascota: "));

        do {
            edadOK = pideNum("Introduzca la edad de la mascota: ");
            if (edadOK >= 1000) {
                muestraCadena("Introduzca un número entre 0 y 999!");
            }
        } while (edadOK > 999);

        nuevaMascota.setEdad(edadOK);
        nuevaMascota.setDescripcionSintomas(pideCadena("Introduzca los sintomas: "));
        nuevaMascota.setVacunas(pideCadena("Introduzca las vacunas que tiene la mascota: "));

        return nuevaMascota;
    }

    public int subMenu() {
        System.out.println("\t1.Guardar en bloc de notas\n"
                + "\t2.Guardar en Word\n"
                + "\t3.Guardar en Excel\n"
                + "\t0.Salir");
        return pideNum("Introduzca una opción: ");
    }

    // Método que devuelve el valor por el que queremos filtrar
    public Mascotas consultaSubmenu() {
        Bbdd_Control bd = new Bbdd_Control();
        Mascotas miMascota = new Mascotas();
        int opcion = -1;

        do {
            System.out.println("1. Filtrar por idMascota");
            System.out.println("2. Filtrar por nombre de mascota");
            System.out.println("3. Filtrar por tipo de mascota");
            opcion = pideNum("Introduzca una opción: ");
        } while (opcion < 1 || opcion > 3);

        // Mostramos todos los datos
        bd.consultaGenerico();

        // Controlamos el dato por el que quiere filtrar
        switch (opcion) {
            case 1:
                miMascota.setIdMascotas(pideNum("Introduzca el id de la mascota a buscar: "));
                return miMascota;
            case 2:
                miMascota.setNombre(pideCadena("Introduzca el nombre de la mascota: "));
                return miMascota;
            case 3:
                miMascota.setTipoAnimal(pideCadena("Introduzca el tipo de mascota a buscar: "));
                return miMascota;
        }
        return null;
    }

    public int menuFicheros (){    
        int opcion = -1;
        do {
            System.out.println("1.Guardar en fichero texto");
            System.out.println("2.Guardar en fichero word");
            System.out.println("3.Guardar en excel");
            System.out.println("0.Salir");
            opcion = pideNum("Introduzca una opción: ");
        } while (opcion < 0 || opcion > 3);
        
        return opcion;
    }
}//class
