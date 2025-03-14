package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import modelo.Pelicula;
import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.sl.usermodel.Sheet; CUIDADO CON LO QUE IMPORTAMOS SL NO SS ES LO QUE NECESITO
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author gonzalo.detomas
 */
public class FicheroControl {

    public void escribeFichero(ArrayList<Pelicula> arrListPelis) { //Le paso por parámetro el array que es lo que voy a escribir en el fichero

        File archivo = new File("cine.txt"); //Creo el archivo
        PrintWriter pw = null; //Declaro variable tipo PrintWriter
        try {
            pw = new PrintWriter(archivo);

            for (Pelicula peli : arrListPelis) {
                pw.println(peli.getNombrePeli());
                pw.println(peli.getDuracion());
                pw.println(peli.getPais());
                pw.println(peli.getDirector());
                // Controlamos el género de cada película
                if (peli.getGenero().equals(Pelicula.Genero.ACCION)) {
                    pw.println("Acción");
                } else if (peli.getGenero().equals(Pelicula.Genero.COMEDIA)) {
                    pw.println("Comedia");
                } else if (peli.getGenero().equals(Pelicula.Genero.CIENCIA_FICCION)) {
                    pw.println("Ciencia Ficción");
                } else if (peli.getGenero().equals(Pelicula.Genero.ROMANCE)) {
                    pw.println("Romance");
                } else if (peli.getGenero().equals(Pelicula.Genero.TERROR)) {
                    pw.println("Terror");
                }
                pw.println(peli.getNombrePremio());
                pw.println(peli.getCiudadPremio());
                pw.println(peli.getValoracion());
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    public void guardaExcel(ArrayList<Pelicula> arrayListPelis) {
        //Creo Libro
        Workbook libro = new XSSFWorkbook();
        //Creo Hoja
        Sheet hoja = libro.createSheet("Cine");
        //Creo fila
        Row filaCero = hoja.createRow(0);
        //Creo una celda
        Cell celda = filaCero.createCell(1);

        celda.setCellValue("CINE");
        filaCero.createCell(5).setCellValue("Premio");

        //Creo otra fila(filaUno) para añadir en las celdas los nombres de las variables
        Row filaUno = hoja.createRow(1);
        filaUno.createCell(0).setCellValue("Nombre Película");
        filaUno.createCell(1).setCellValue("Duración");
        filaUno.createCell(2).setCellValue("País");
        filaUno.createCell(3).setCellValue("Director");
        filaUno.createCell(4).setCellValue("Género");
        filaUno.createCell(5).setCellValue("Premio");
        filaUno.createCell(6).setCellValue("Ciudad Premio");
        filaUno.createCell(7).setCellValue("Valoración");

        //Vamos a añadir en el Excel los datos del ArrayList
        for (int i = 0; i < arrayListPelis.size(); i++) {
            Row filas = hoja.createRow(2 + i);

            filas.createCell(0).setCellValue(arrayListPelis.get(i).getNombrePeli());
            filas.createCell(1).setCellValue(arrayListPelis.get(i).getDuracion());
            filas.createCell(2).setCellValue(arrayListPelis.get(i).getPais());
            filas.createCell(3).setCellValue(arrayListPelis.get(i).getDirector());
            // Controlamos el género de cada película
            if (arrayListPelis.get(i).getGenero().equals(Pelicula.Genero.ACCION)) {
                filas.createCell(4).setCellValue("Acción");
            } else if (arrayListPelis.get(i).getGenero().equals(Pelicula.Genero.COMEDIA)) {
                filas.createCell(4).setCellValue("Comedia");
            } else if (arrayListPelis.get(i).getGenero().equals(Pelicula.Genero.CIENCIA_FICCION)) {
                filas.createCell(4).setCellValue("Ciencia Ficción");
            } else if (arrayListPelis.get(i).getGenero().equals(Pelicula.Genero.ROMANCE)) {
                filas.createCell(4).setCellValue("Romance");
            } else if (arrayListPelis.get(i).getGenero().equals(Pelicula.Genero.TERROR)) {
                filas.createCell(4).setCellValue("Terror");
            }
            filas.createCell(4).setCellValue(arrayListPelis.get(i).getGenero().toString());
            filas.createCell(5).setCellValue(arrayListPelis.get(i).getNombrePremio());
            filas.createCell(6).setCellValue(arrayListPelis.get(i).getCiudadPremio());
            filas.createCell(7).setCellValue(arrayListPelis.get(i).getValoracion());

        }
        // Ajusta el tamaño de columna
        
        for (int i = 0; i < hoja.getRow(arrayListPelis.size()).getPhysicalNumberOfCells(); i++) {
            hoja.autoSizeColumn(i);
        }
        
        //Guardar el archivo Excel en el disco
        try (FileOutputStream fileOut = new FileOutputStream("Cine.xlsx")) {
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

        System.out.println("Archivo Excel creado correctamente");
    }

    public void leeFichero() {
        String cadena;
        FileReader archivo = null;

        try {
            archivo = new FileReader("cine.txt");
            BufferedReader b = new BufferedReader(archivo);
            while ((cadena = b.readLine()) != null) {
                System.out.println("Nombre Película: " + cadena);
                System.out.println("Duración: " + b.readLine());
                System.out.println("País: " + b.readLine());
                System.out.println("Director: " + b.readLine());
                System.out.println("Género: " + b.readLine());
                System.out.println("Premio: " + b.readLine());
                System.out.println("Ciudad Premio: " + b.readLine());
                System.out.println("Valoración: " + b.readLine());
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
