package leerescribirenexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author gonzalo.detomas
 */
public class LeerDesdeExcel {

    public static void main(String[] args) {
        File fichero = new File("notas_certificado.xlsx");
        InputStream lectura = null;
        int numFila = 0;
        Workbook libro = null;

        try {
            lectura = new FileInputStream(fichero);
        } catch (FileNotFoundException ex) {
        }
        try {
            libro = WorkbookFactory.create(lectura);
        } catch (IOException ex) {
        } catch (EncryptedDocumentException ex) {
        }
        Sheet hoja = libro.getSheetAt(0);

        Row fila = hoja.getRow(numFila);
        Cell celda = null;
        String contenidoCelda = null;
        System.out.println("El contenido del Excel es: ");
        while (fila != null) {
            for (int col = 0; col < 4; col++) {
                celda = fila.getCell(col);
                if (celda != null) {
                    contenidoCelda = celda.getStringCellValue();
                    System.out.print(contenidoCelda + "\t");
                }
            }
            System.out.println("");
            numFila++;
            fila = hoja.getRow(numFila);
        }
    }
}
