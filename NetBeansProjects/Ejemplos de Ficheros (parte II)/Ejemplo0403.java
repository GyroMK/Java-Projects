import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

// Escritura de bytes
public class Ejemplo0403 {

	public static void main(String[] args) throws IOException{
		// Escribimos una ruta existente
		String ruta = "C:\\adt";
		
		// Creamos el fichero
		File fichero = new File(ruta, "info.txt");
		
		// Creamos el flujo de salida hacia el fichero
		FileOutputStream flujo = new FileOutputStream(fichero);
		
		// Información a almacenar
		byte[] datos = new byte[100];
		
		// Escribe datos byte a byte
		System.out.println("Empezando a escribir...");
		for(int i=0; i<datos.length; i++){
			datos[i] = (byte)i;
			flujo.write(datos[i]);
		}
		
		// Cerramos el flujo
		flujo.close();
		System.out.println("Fichero escrito correctamente!");
	}
}
