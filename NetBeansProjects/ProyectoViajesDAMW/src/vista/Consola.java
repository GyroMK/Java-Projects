package vista;

import controlador.Ficheros;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import modelo.Viajero;
import modelo.Viajes;
import modelo.Viajes.Acompanyante;

/**
 *
 * @author sergi.carmona
 */
//
//                    System.out.println(propiedades.getProperty("nombre"));
//                    System.out.println(propiedades.getProperty("edad"));
//                    System.out.println(propiedades.getProperty("numViajes"));
//                    System.out.println(propiedades.getProperty("destino"));
//                    System.out.println(propiedades.getProperty("tiempo"));
//                    System.out.println(propiedades.getProperty("familia"));
//                    System.out.println(propiedades.getProperty("amigos"));
//                    System.out.println(propiedades.getProperty("solo"));
//                    System.out.println(propiedades.getProperty("valoracion"));
//                    System.out.println(propiedades.getProperty("insertar"));
//                    System.out.println(propiedades.getProperty("consultar"));
//                    System.out.println(propiedades.getProperty("generar"));
//                    System.out.println(propiedades.getProperty("salir"));
//                    System.out.println(propiedades.getProperty("mensajeOK"));
//                    System.out.println(propiedades.getProperty("mensajeMAL"));
//                    System.out.println(propiedades.getProperty("usuarioOK"));
//                    System.out.println(propiedades.getProperty("sqlOK"));
public class Consola {

    Properties propiedades = new Properties();
    InputStream entrada = null;
    Viajero viajeroActual = new Viajero();
    String ArchivoIdioma = Menu();
    

    public String Menu() {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        String idioma = "";
        try {
            do {
                System.out.println("1. Spanish");
                System.out.println("2. English");
                System.out.println("3. French");

                opcion = teclado.nextInt();

                if (opcion >= 1 && opcion <= 3) {
                    switch (opcion) {
                        case 1:
                            entrada = new FileInputStream("esp.properties");
                            idioma = "esp.properties";
                            MenuUsuario();
                            break;
                        case 2:
                            entrada = new FileInputStream("ing.properties");
                            idioma = "ing.properties";
                            MenuUsuario();
                            break;
                        case 3:
                            entrada = new FileInputStream("fra.properties");
                            idioma = "fra.properties";
                            MenuUsuario();
                            break;
                    }

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
        return idioma;
    }

    public void MenuUsuario() throws IOException {
        Ficheros f = new Ficheros();
        propiedades.load(entrada);
        Scanner teclado = new Scanner(System.in);
        int user;
        ArrayList<Viajero> grupoViajero = new ArrayList<>();
        Viajero viajeroActual = null;

        do {
            System.out.println("1. " + propiedades.getProperty("insertar"));
            System.out.println("2. " + propiedades.getProperty("consultar"));
            System.out.println("3. " + propiedades.getProperty("generar"));
            System.out.println("4. " + propiedades.getProperty("salir"));
            user = teclado.nextInt();
            switch (user) {
                case 1:
                    viajeroActual = pideDatos();
                    grupoViajero.add(viajeroActual);
                    String nombretxt=viajeroActual.getNombre().concat(".viajes");
                    f.escribir(grupoViajero,nombretxt);
                    break;
                case 2:
                    f.leer(ArchivoIdioma);
                    break;
                case 3:
                    
                    String txt=viajeroActual.getNombre().concat(".html");
                    f.EscribirHTML(viajeroActual, txt);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }

        } while (user < 4 || user > 1);

    }

    public Viajero pideDatos() throws IOException {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Viajes> ViajesRealizados = new ArrayList<>();
        Viajero viajeroActual = new Viajero();

        viajeroActual.setNombre(pideCadena(propiedades.getProperty("nombre")));
        viajeroActual.setEdad(pideEntero(propiedades.getProperty("edad")));
        viajeroActual.setNumViajes(pideEntero(propiedades.getProperty("numViajes")));

        Viajes viajeActual = null;
        for (int x = 0; x < viajeroActual.getNumViajes(); x++) {
            viajeActual = new Viajes();    // Reservamos un nuevo espacio de memoria
            viajeActual.setDestino(pideCadena(propiedades.getProperty("destino")));
            viajeActual.setTiempo(pideEntero(propiedades.getProperty("tiempo")));
            viajeActual.setAcompanyante(PideAcompanyante());
            viajeActual.setValoracion(pideEntero(propiedades.getProperty("valoracion")));

            ViajesRealizados.add(viajeActual);

        }
        viajeroActual.setArrViajes(ViajesRealizados);
        return viajeroActual;
        
    }

    public void muestraDatos(Viajero viajeroActual) {
        System.out.println("==============================");
        System.out.println((propiedades.getProperty("nombre") + ": " + viajeroActual.getNombre()));
        System.out.println((propiedades.getProperty("edad") + ": " + viajeroActual.getEdad()));
        if (viajeroActual.getNumViajes() == 0) {
                    System.out.println(propiedades.getProperty("noViajes"));
                } else {
                    System.out.println((propiedades.getProperty("numViajes") + ": " + viajeroActual.getNumViajes()));
                }
        for (Viajes v : viajeroActual.getArrViajes()) {
            System.out.println("\t" + (propiedades.getProperty("destino") + ": " + v.getDestino()));
            System.out.println("\t" + (propiedades.getProperty("tiempo") + ": " + v.getTiempo()));
            if (v.getAcompanyante() == Acompanyante.AMIGOS) {
                System.out.println("\t" + (propiedades.getProperty("amigos")));
            } else if (v.getAcompanyante() == Acompanyante.FAMILIA) {
                System.out.println("\t" + (propiedades.getProperty("familia")));
            } else {
                System.out.println("\t" + propiedades.getProperty("solo"));
            }
            System.out.println("\t" + (propiedades.getProperty("valoracion") + ": " + v.getValoracion()));
            System.out.println("------------------------");

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

    public Acompanyante PideAcompanyante() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("1." + propiedades.getProperty("familia") + "\n" + "2." + propiedades.getProperty("amigos") + "\n" + "3." + propiedades.getProperty("solo"));
        int opcion = teclado.nextInt();
        do {

            switch (opcion) {
                case 1:
                    return Acompanyante.FAMILIA;
                case 2:
                    return Acompanyante.AMIGOS;
                case 3:
                    return Acompanyante.SOLO;
                default:
                    System.out.println(propiedades.getProperty("inCorrect"));
            }
        } while (opcion > 3 || opcion < 1);
        return Acompanyante.SOLO;
    }

}
