import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

// Lectura de Tipos Primitivos
public class Ejemplo0406 {

	public static void main(String[] args) throws IOException{
		// Escribimos una ruta existente
		String ruta = "C:\\adt";
		
		// Creamos el fichero
		File fichero = new File(ruta, "info2.txt");
		
		// Creamos el flujo de entrada desde el fichero
		FileInputStream flujo = new FileInputStream(fichero);
		
		// Creamos un objeto para conectar los flujos (el de bytes y el datos)
		DataInputStream datos = new DataInputStream(flujo);
		
		// Leemos los datos primitivos del fichero
		System.out.println("Empezando a leer el fichero...");
		System.out.println(datos.readBoolean());
		System.out.println(datos.readChar());
		System.out.println(datos.readDouble());
		System.out.println(datos.readInt());
		System.out.println(datos.readFloat());
		System.out.println(datos.readLong());
		System.out.println(datos.readUTF());
		
		datos.close();
		System.out.println("\n\nFichero leído correctamente!");
	}
}
