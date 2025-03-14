package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import modelo.Viajero;
import modelo.Viajes;
import vista.Consola;

/**
 *
 * @author SERGI.CARMONA
 */
public class Ficheros {

    Consola c = new Consola();
    InputStream entrada = null;
    Properties propiedades = new Properties();

    public void escribir(ArrayList<Viajero> grupoViajero, String txt) throws IOException {

        FileOutputStream fichero = null;
        Viajero personaParaGuardar = new Viajero();

        try {
            fichero = new FileOutputStream(txt);
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(personaParaGuardar);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fichero.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println(propiedades.getProperty("mensajeOK"));
    }

    public void leer(String Propierties) {
        Scanner teclado = new Scanner(System.in);
        Viajero FicheroViajeroLectura;
        FileInputStream ficheroEntrada = null;
        
        try{
            System.out.println("Dime la persona que quieres consultar:\n");
            String nombre = teclado.nextLine();
            ficheroEntrada = new FileInputStream(nombre.concat(".viajes"));
            System.out.println(nombre.concat(".viajes"));
            ObjectInputStream tuberiaEntrada = new ObjectInputStream(ficheroEntrada);
            
            FicheroViajeroLectura = (Viajero)tuberiaEntrada.readObject();
            FicheroViajeroLectura.muestraViajero(Arx);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void EscribirHTML(Viajero viajero, String txt) throws IOException {
        Viajero v = viajero;
        File archivo = new File(txt);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(archivo), true);

            pw.println("<!DOCTYPE html>\n");
            pw.println("<html>\n");
            pw.println("\t<head>\n");
            pw.println("\t\t<title>" + v.getNombre() + "</title>\n");
            pw.println("\t</head>\n");
            pw.println("\t<body bgcolor=\"#000000\" text=\"white\">\n");
            pw.println("\t\t<table align=\"center\">\n");
            pw.println("\t\t\t\t<td align=\"center\"><b>" + v.getNombre() + "</b></td>\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
        System.out.println(propiedades.getProperty("mensajeOK"));

    }
}
