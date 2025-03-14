package ejemploprintwriter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author sergi.carmona
 */
public class EjercicioFileReader {

    public static void main(String[] args) {
        String texto;
        FileReader fr = null;

        try {
            fr = new FileReader("prueba.txt");

            BufferedReader br = new BufferedReader(fr);
            while ((texto = br.readLine()) != null) {
                System.out.println(texto);
            }
            br.close();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }

    catch (IOException ioe) {
            ioe.printStackTrace();
    }
}
}