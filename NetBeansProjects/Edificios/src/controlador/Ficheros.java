package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import modelo.Edificios;

/**
 *
 * @author sergi.carmona
 */
public class Ficheros {

    public void escribir(ArrayList<Edificios> grupoEdificio) {
        File archivo = new File("edificios.txt");
        PrintWriter pw = null;

        try {
            pw = new PrintWriter(archivo);
            for (Edificios e : grupoEdificio) {
                pw.println(e.getCalle());
                pw.println(e.getNumPiso());
                pw.println(e.getNomPres());
                pw.println(e.getNumPuertas());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
        System.out.println("Guardado el archivo correctamente");
    }

    public void leer() {
        String cadena;
        FileReader f = null;

        try {
            f = new FileReader("edificios.txt");

            BufferedReader br = new BufferedReader(f);
            while ((cadena = br.readLine()) != null) {
                System.out.println("calle: " + cadena);
                System.out.println("numero de piso: " + br.readLine());
                System.out.println("nombre del presidente: " + br.readLine());
                System.out.println("numero de puertas: " + br.readLine());
            }
            br.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
