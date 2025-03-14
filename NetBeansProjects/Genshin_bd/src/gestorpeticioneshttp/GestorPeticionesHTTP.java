package gestorpeticioneshttp;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GestorPeticionesHTTP {
    private Map<String, String> personajes = new TreeMap<>(); // Orden alfabético automático

    public void cargarPersonajesDesdeArchivo(String rutaArchivo) throws IOException {
        String html = new String(Files.readAllBytes(Paths.get(rutaArchivo)));
        Document doc = Jsoup.parse(html);
        Elements filas = doc.select("tr");

        for (Element fila : filas) {
            Element enlace = fila.selectFirst("td a[href]");
            Element nombre = fila.select("td:nth-child(2)").first();

            if (enlace != null && nombre != null) {
                String url = "https://gensh.honeyhunterworld.com" + enlace.attr("href");
                String nombrePersonaje = nombre.text().toLowerCase();
                personajes.put(nombrePersonaje, url);
            }
        }
    }

    public List<List<String>> extraerTablaStats(String url, String personaje) {
        List<List<String>> stats = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
                .timeout(10000)
                .get();
            Element tabla = doc.selectFirst("table.genshin_table.stat_table");

            if (tabla == null) throw new Exception("No se encontró la tabla de estadísticas.");

            Elements filas = tabla.select("tr");
            boolean esPrimeraFila = true;
            for (Element fila : filas) {
                Elements celdas = fila.select("td");
                if (esPrimeraFila) { esPrimeraFila = false; continue; }
                if (celdas.size() > 1) {
                    List<String> filaStats = new ArrayList<>();
                    filaStats.add(celdas.get(0).text()); // LVL
                    filaStats.add(personaje);
                    
                    int columnasDisponibles = celdas.size();
                    for (int i = 1; i < columnasDisponibles; i++) {
                        String valor = celdas.get(i).text().isEmpty() ? "0%" : celdas.get(i).text();
                        filaStats.add(valor);
                    }
                    stats.add(filaStats);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al obtener datos de " + personaje + ": " + e.getMessage());
        }
        return stats;
    }

    public void actualizarExcel(String rutaExcel, List<List<String>> datos) throws IOException {
        File file = new File(rutaExcel);
        Workbook workbook;
        Sheet sheet;

        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            fis.close();
        } else {
            workbook = new XSSFWorkbook();
        }

        sheet = workbook.getSheet("Hoja4");
        if (sheet == null) {
            throw new IOException("La hoja 'Hoja4' no existe en el archivo Excel.");
        }

        int filaActual = 3;
        while (sheet.getRow(filaActual) != null && sheet.getRow(filaActual).getCell(0) != null) {
            filaActual++;
        }

        for (List<String> filaDatos : datos) {
            Row row = sheet.createRow(filaActual++);
            for (int i = 0; i < filaDatos.size(); i++) {
                row.createCell(i).setCellValue(filaDatos.get(i));
            }
        }

        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();
        workbook.close();
    }

    public static void main(String[] args) {
        try {
            GestorPeticionesHTTP gestor = new GestorPeticionesHTTP();
            gestor.cargarPersonajesDesdeArchivo("html_char.txt");
            String rutaExcel = "calculadora genshin.xlsx";
            
            for (Map.Entry<String, String> entry : gestor.personajes.entrySet()) {
                String personaje = entry.getKey();
                String url = entry.getValue();
                System.out.println("Obteniendo datos de: " + personaje);
                List<List<String>> tablaStats = gestor.extraerTablaStats(url, personaje);
                gestor.actualizarExcel(rutaExcel, tablaStats);
                Thread.sleep(2000); // Evita bloqueos
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
