package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import modelo.Mascotas;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import vista.Consola;

/**
 *
 * @author gonzalo.detomas
 */
public class Ficheros {

    public void escribirFicheroTexto(ArrayList<Mascotas> arrLMascot) {
        File archivo = new File("mascotas.txt");
        PrintWriter pw = null;
        Consola c = new Consola();
        try {
            //A�adimos filewriter para poder a�adir informaci�n a los ficheros y no sobreescribirlos
            pw = new PrintWriter(new FileWriter(archivo, true));
            for (Mascotas mascotas : arrLMascot) {
                pw.println(mascotas.getIdMascotas());
                pw.println(mascotas.getNombre());
                pw.println(mascotas.getTipoAnimal());
                pw.println(mascotas.getEdad());
                pw.println(mascotas.getDescripcionSintomas());
                pw.println(mascotas.getVacunas());
            }
            c.muestraCadena("Fichero de texto guardado correctamente");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    public void escribirEnWord(ArrayList<Mascotas> arrLMascotas) {
        Consola c = new Consola();
        // Crear un documento
        XWPFDocument documento = new XWPFDocument();

        // Crear un p�rrafo
        XWPFParagraph parrafo = documento.createParagraph();

        // Crear un "run" para escribir texto en el p�rrafo
        XWPFRun ejecutador = parrafo.createRun();

        ejecutador.setText("Lista de mascotas");
        //ejecutador.setBold(true);
        ejecutador.setFontFamily("Comic Sans");
        // Guardamos el texto en un fichero
        try (FileOutputStream fichero = new FileOutputStream("mascotas.docx")) {
            // Escribimos en el documento
            documento.write(fichero);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //ejecutador.setBold(false);
        ejecutador.addBreak();
        for (Mascotas mascota : arrLMascotas) {
            ejecutador.setText("Id de la Mascota: " + mascota.getIdMascotas());
            ejecutador.addBreak();
            ejecutador.setText("Nombre de la Mascota: " + mascota.getNombre());
            ejecutador.addBreak();
            ejecutador.setText("La especie de la mascota es: " + mascota.getTipoAnimal());
            ejecutador.addBreak();
            ejecutador.setText("La edad de la mascota: " + mascota.getEdad());
            ejecutador.addBreak();
            ejecutador.setText("Los s�ntomas de la mascota: " + mascota.getDescripcionSintomas());
            ejecutador.addBreak();
            ejecutador.setText("La mascota tiene las siguientes vacunas: " + mascota.getVacunas());
            ejecutador.addBreak();

            ejecutador.setText("====================================");
            ejecutador.addBreak();
        }

        // Guardamos el texto en un fichero
        try (FileOutputStream fichero = new FileOutputStream("mascotas.docx")) {
            // Escribimos en el documento
            documento.write(fichero);
            // Mostramos un mensaje al usuario indicando que todo ha ido bien
            c.muestraCadena("Word creado correctamente ;)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escribirEnExcel(ArrayList<Mascotas> arrLMascotas) {
        Consola c = new Consola();

        // Necesitamos crear un Workbook .xlsx
        Workbook libro = new XSSFWorkbook();

        // Creamos una hoja (Sheet) en el en el libro anterior y ponemos un nombre a la hoja
        Sheet hoja = libro.createSheet("Mascotas");

        // Creamos una fila (Row) en la hoja y especif�camos la fila 
        Row fila = hoja.createRow(0);

        // Creamos las celdas (Cell) de la fila
        Cell celda = fila.createCell(1);
        // Escribimos contenido en la celda
        celda.setCellValue("Listado mascotas");

        // Creamos m�s filas
        Row segundaFila = hoja.createRow(1);
        segundaFila.createCell(0).setCellValue("IdMascota");
        segundaFila.createCell(1).setCellValue("Nombre");
        segundaFila.createCell(2).setCellValue("Tipo animal");
        segundaFila.createCell(3).setCellValue("Edad");
        segundaFila.createCell(4).setCellValue("Descripcion de s�ntomas");
        segundaFila.createCell(5).setCellValue("Vacunas");
//          Esta es una opci�n
//        for (int i = 0; i < arrLMascotas.size(); i++) {
//            segundaFila = hoja.createRow(i+2);
//            segundaFila.createCell(0).setCellValue(arrLMascotas.get(i).getIdMascotas());
//            segundaFila.createCell(1).setCellValue(arrLMascotas.get(i).getNombre());
//            segundaFila.createCell(2).setCellValue(arrLMascotas.get(i).getTipoAnimal());
//            segundaFila.createCell(3).setCellValue(arrLMascotas.get(i).getEdad());
//            segundaFila.createCell(4).setCellValue(arrLMascotas.get(i).getDescripcionSintomas());
//            segundaFila.createCell(5).setCellValue(arrLMascotas.get(i).getVacunas());
//            
//
//        }
        int cont = 2;
        for (Mascotas mascota : arrLMascotas) {
            segundaFila = hoja.createRow(cont);
            segundaFila.createCell(0).setCellValue(mascota.getIdMascotas());
            segundaFila.createCell(1).setCellValue(mascota.getNombre());
            segundaFila.createCell(2).setCellValue(mascota.getTipoAnimal());
            segundaFila.createCell(3).setCellValue(mascota.getEdad());
            segundaFila.createCell(4).setCellValue(mascota.getDescripcionSintomas());
            segundaFila.createCell(5).setCellValue(mascota.getVacunas());
            cont++;
        }

        // Guardar el archivo Excel en disco
        try (FileOutputStream fileOut = new FileOutputStream("notas_certificado.xlsx")) {
            libro.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Cerrar el libro para liberar recursos
                libro.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        c.muestraCadena("Archivo Excel creado correctamente");
    }
}//Cierre class

