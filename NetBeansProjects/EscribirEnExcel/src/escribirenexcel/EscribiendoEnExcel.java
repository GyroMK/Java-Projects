package escribirenexcel;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Gon
 */
public class EscribiendoEnExcel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // Necesitamos crear un Workbook .xlsx
        Workbook libro = new XSSFWorkbook();  

        // Creamos una hoja (Sheet) en el en el libro anterior y ponemos un nombre a la hoja
        Sheet hoja = libro.createSheet("Notas certificado java");

        // Creamos una fila (Row) en la hoja y especifícamos la fila 
        Row fila = hoja.createRow(0);

        // Creamos las celdas (Cell) de la fila
        Cell celda = fila.createCell(1);
        // Escribimos contenido en la celda
        celda.setCellValue("Notas de clase");

        // Creamos más filas
        Row segundaFila = hoja.createRow(1);
        segundaFila.createCell(0).setCellValue("Nombre");
        segundaFila.createCell(1).setCellValue("Apellido");
        segundaFila.createCell(2).setCellValue("Localidad");
        segundaFila.createCell(3).setCellValue("Nota");

        Row terceraFila = hoja.createRow(2);
        terceraFila.createCell(0).setCellValue("Fernando");
        terceraFila.createCell(1).setCellValue("Romay");
        terceraFila.createCell(2).setCellValue("Alcorcón");

        Row cuartaFila = hoja.createRow(3);
        cuartaFila.createCell(0).setCellValue("Rocío");
        cuartaFila.createCell(1).setCellValue("Carrasco");
        cuartaFila.createCell(2).setCellValue("Valdemoro");

        // Guardar el archivo Excel en disco
        try (FileOutputStream fileOut = new FileOutputStream("notas_certificado.xlsx")) {
            libro.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                // Cerrar el libro para liberar recursos
                libro.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Archivo Excel creado correctamente");    
    }    
}
