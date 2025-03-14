package controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Properties propiedades = new Properties();
        InputStream entrada = null;
        int opcion;

        try {
            do {
                System.out.println("\t.Elige el idioma.");
                System.out.println("    1: Español");
                System.out.println("    2: Frances");
                System.out.println("    3: Ingles");
                System.out.println("    4: Italiano");
                System.out.println("    5: Aleman");
                System.out.println("    0: SALIR\n");
                System.out.print("  Introduzca una opcion: ");
                opcion = teclado.nextInt();
                System.out.println("");

                if (opcion >= 1 && opcion <= 5) {
                    switch (opcion) {
                        case 1:
                            entrada = new FileInputStream("esp.properties");
                            break;
                        case 2:
                            entrada = new FileInputStream("fr.properties");
                            break;
                        case 3:
                            entrada = new FileInputStream("ing.properties");
                            break;
                        case 4:
                            entrada = new FileInputStream("ita.properties");
                            break;
                        case 5:
                            entrada = new FileInputStream("alem.properties");
                            break;

                    }

                    propiedades.load(entrada);
                    System.out.println(propiedades.getProperty("nombre"));
                    System.out.println(propiedades.getProperty("apellido"));
                    System.out.println(propiedades.getProperty("direccion"));
                    System.out.println(propiedades.getProperty("edad"));
                    System.out.println(propiedades.getProperty("telefono"));
                    System.out.println(propiedades.getProperty("fecha de nacimiento\n"));

                } else if (opcion == 0) {
                    System.out.println("Bai bai\n\n");
                } else {
                    System.out.println("Elija una opcion correcta\n");
                }

            } while (opcion != 0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
