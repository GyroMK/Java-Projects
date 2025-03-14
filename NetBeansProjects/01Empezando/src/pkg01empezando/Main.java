package pkg01empezando;

/**
 *
 * @author sergi.carmona
 */
public class Main {

    public static void main(String[] args) {
        /**
         * @param args the command line arguments
         */

        System.out.println("Vamos Chavales!!!");
        //sentencias if
        int numero = 14;
        if (numero > 0) {
            System.out.println("El nuemero es positivo");
        }
        int edad = 18;

        if (edad >= 0 && edad < 4) {
            System.out.println("no pagas el transporte publico");
        } else if (edad >= 4 && edad < 26) {
            System.out.println("tienes el abono joven");
        } else if (edad >= 26 && edad < 66) {
            System.out.println("tu abono es nromal");
        } else {
            System.out.println("tiene el abono de pensionista");
        }

        if (edad >= 18) {
            System.out.println("Puedes votar");
        } else {
            System.out.println("No puedes votar");
        }
        //sentencias switch
        int opcion = 2;
        switch (opcion) {
            case 1:
                System.out.println("Opcion 1");
                break;
            case 2:
                System.out.println("Opcion 2");
                break;
            case 3:
                System.out.println("Opcion 3");
                break;
            default:
                System.out.println("has elegido un numero diferente a 1,2 y 3");
                break;
        }

        for (int i = 0; i < 1000; i++) {
            System.out.print(i + ", ");
            if (i % 20 == 0) {
                System.out.println("");
            }
        }

        for (int i = 10; i > 0; i--) {
            System.out.println("");
            System.out.print(i + " ");
        }
        System.out.println("");

        int i = 1;
        while (i <= 10) {
            System.out.print(i + ", ");
            i++;
        }
        System.out.println("");

        int j = 1;
        do {
            System.out.print(j + ", ");
            j++;
        } while (j <= 10);

        /*
        atajos de teclado
        - copiar: ctrl + C
        - pegar: ctrl + V
        - cortar: ctrl + X
        - para seleccionar textos: shift + flechas direccionales
        - shift + incio
        - shift + fin
        - seleccionar todo: ctrl A
        - deshacer: ctrl + Z
        - rehacer: ctrl + Y
        - duplicar lineas: ctrl + shift + flecha para abajo
        - mover la lineas: alt + shift + flecha arriba/abajo
        - navegar por las palabras que coinciden con la palabra en la que estamos: alt + bloq. mayus + flechas
        - cambiar `las variables de nombre: ctrl + R
        - cambiar de aplicacion: Alt + Tab
        - navegar entre pestañas: ctrl + Tab
        - para ir al escritorio: win + D
        - abrir explorador de windows: win + E
        - abrir administrador de tareas: ctrl + shift + esc
        
         */
    }

}
