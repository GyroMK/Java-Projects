package Controlador;

import Modelo.Pelicula;
import Modelo.Premios;
import Vista.Consola;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author sergi.carmona
 */
public class Ficheros {

    Consola c = new Consola();

    public void escribir(ArrayList<Pelicula> grupoPelicula) throws IOException {
        File archivo = new File("peliculas.txt");
        PrintWriter pw = null;

        try {
            pw = new PrintWriter(new FileWriter(archivo), true);
            for (Pelicula p : grupoPelicula) {
                pw.println(p.getNombre());
                pw.println(p.getDuracion());
                pw.println(p.getPais());
                pw.println(p.getDirector());
                pw.println(p.getGenero());
                if (p.getNumPremios() == 0) {
                    pw.println("Esta pelicula no tiene premios");
                } else {
                    pw.println(p.getNumPremios());
                }
                for (Premios pr : p.getArrPremios()) {
                    pw.println(pr.getNombrePremio());
                    pw.println(pr.getCiudad());
                }
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
            f = new FileReader("peliculas.txt");

            BufferedReader br = new BufferedReader(f);
            while ((cadena = br.readLine()) != null) {
                System.out.println("nombre: " + cadena);
                System.out.println("duracion: " + br.readLine());
                System.out.println("pais: " + br.readLine());
                System.out.println("director: " + br.readLine());
                System.out.println("genero: " + br.readLine());
                System.out.println("========================================");
                System.out.println("\tnumero de premios: " + br.readLine());
                System.out.println("\tNombre del premio: " + br.readLine());
                System.out.println("\t3Ciudad del premio: " + br.readLine());
            }
            br.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void escribirExcel(ArrayList<Pelicula> grupoPelicula) {
        for (Pelicula p : grupoPelicula) {
            Workbook libro = new XSSFWorkbook();

            Sheet hoja = libro.createSheet("Lista Peliculas");

            Row fila = hoja.createRow(0);

            Cell celda = fila.createCell(1);
            celda.setCellValue("Lista de peliculas");

            Row segundaFila = hoja.createRow(1);
            segundaFila.createCell(0).setCellValue("nombre");
            segundaFila.createCell(1).setCellValue("duracion");
            segundaFila.createCell(2).setCellValue("pais");
            segundaFila.createCell(3).setCellValue("director");
            segundaFila.createCell(4).setCellValue("genero");
            segundaFila.createCell(5).setCellValue("numero de premios");
            segundaFila.createCell(6).setCellValue("nombre del premio");
            segundaFila.createCell(7).setCellValue("ciudad del premio");

            for (int i = 0; i < grupoPelicula.size(); i++) {

                Row terceraFila = hoja.createRow(2 + i);
                terceraFila.createCell(0).setCellValue(grupoPelicula.get(i).getNombre());
                terceraFila.createCell(1).setCellValue(grupoPelicula.get(i).getDuracion());
                terceraFila.createCell(2).setCellValue(grupoPelicula.get(i).getPais());
                terceraFila.createCell(3).setCellValue(grupoPelicula.get(i).getDirector());
                if (grupoPelicula.get(i).getGenero() == Pelicula.Genero.ACCION) {
                    terceraFila.createCell(4).setCellValue("Accion");
                } else if (p.getGenero() == Pelicula.Genero.CIENCIA_FICCION) {
                    terceraFila.createCell(4).setCellValue("Ciencia Ficcion");
                } else if (p.getGenero() == Pelicula.Genero.COMEDIA) {
                    terceraFila.createCell(4).setCellValue("Comedia");
                } else if (p.getGenero() == Pelicula.Genero.ROMANCE) {
                    terceraFila.createCell(4).setCellValue("Romance");
                } else if (p.getGenero() == Pelicula.Genero.TERROR) {
                    terceraFila.createCell(4).setCellValue("Terror");
                }
                if (grupoPelicula.get(i).getNumPremios() == 0) {
                    terceraFila.createCell(5).setCellValue("No tiene");
                } else {
                    terceraFila.createCell(5).setCellValue(grupoPelicula.get(i).getNumPremios());
                }
                for (Premios pr : grupoPelicula.get(i).getArrPremios()) {
                    terceraFila.createCell(6).setCellValue(pr.getNombrePremio());
                    terceraFila.createCell(7).setCellValue(pr.getCiudad());
                }
            }
            for (int x = 0; x < hoja.getRow(grupoPelicula.size()).getPhysicalNumberOfCells(); x++) {
                hoja.autoSizeColumn(x);
            }
            

            try (FileOutputStream fileOut = new FileOutputStream("Lista_Peliculas.xlsx")) {
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
    }

}
