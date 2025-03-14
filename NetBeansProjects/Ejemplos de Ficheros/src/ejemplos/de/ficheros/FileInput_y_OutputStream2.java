/*
 * Leemos de un fichero de texto y mostramos el contenido por consola
 */

package ejemplos.de.ficheros;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Gon
 */
public class FileInput_y_OutputStream2 {

    public static void main(String[] args) {
        // Declaración de variables
        FileInputStream fichero = null;
        String texto = "";
        char c = 0;

        try{
            // Creamos el objeto fichero, del cual leeremos su contenido
            fichero = new FileInputStream("info.txt");

            int tamaño = fichero.available();

            // Recorremos fichero, carácter a carácter, y lo mostramos por consola
            for(int i=0; i<tamaño; i++){
                c = (char)fichero.read();
                texto += c;
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            // Escribimos el texo por consola
            System.out.print(texto);
            try{
                fichero.close(); //Cerramos el fichero
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
