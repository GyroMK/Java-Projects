package ejemploprintwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author sergi.carmona
 */
public class PrintWritter {

    public static void main(String[] args) {
        File archivo = new File("prueba.txt");

        PrintWriter pw = null;
        String nombre = "Sergi";
        String apellido = "Carmona";
        int edad = 16;
        
        try {
        pw = new PrintWriter(archivo);
        pw.println(nombre);
        pw.println(apellido);
        pw.println(edad);
        }catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }finally{
            if (pw != null){
                pw.close();
            }
        }
        

    }
}
