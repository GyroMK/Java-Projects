package escribiendoenword;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.*;


public class EscribiendoEnWord {

    public static void main(String[] args) throws Exception {
        // Crear un documento
        XWPFDocument documento = new XWPFDocument();
        
        // Crear un párrafo
        XWPFParagraph parrafo = documento.createParagraph();
        
        // Crear un "run" para escribir texto en el párrafo
        XWPFRun ejecutador = parrafo.createRun();
        ejecutador.setText("Vamos chavales!!!");
        
        // Guardamos el texto en un fichero
        try (FileOutputStream fichero = new FileOutputStream("word guapísimo.docx")) {
            // Escribimos en el documento
            documento.write(fichero);
            // Mostramos un mensaje al usuario indicando que todo ha ido bien
            System.out.println("Word creado correctamente ;)");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
