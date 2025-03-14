/*
 * Guardamos en un fichero de texto el contenido de un String
 */

package ejemplos.de.ficheros;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Gon
 */
public class FileInput_y_OutputStream {

    public static void main(String[] args) {
        // Declaración de variables
        FileOutputStream fichero = null;
        String texto = "Nuestro primer ejemplo en ficheros! ;)\nY esta es la segunda línea!!!";
        char c = 0;

        try{
            // Creamos el objeto fichero, en que guardaremos el texto dentro del archivo info.txt
            fichero = new FileOutputStream("info.txt");

            // Recorremos texto, carácter a carácter, y lo guardamos en info.txt
            for(int i=0; i<texto.length(); i++){
                c = texto.charAt(i);
                fichero.write((byte)c);
            }
            System.out.println("Texto almacenado correctamente en el fichero");
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                fichero.close(); //Cerramos el fichero
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
