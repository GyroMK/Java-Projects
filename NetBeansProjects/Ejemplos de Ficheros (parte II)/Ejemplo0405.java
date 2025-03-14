import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

// Escritura de Tipos Primitivos
public class Ejemplo0405 {

	public static void main(String[] args) throws IOException{
		// Escribimos una ruta existente
		String ruta = "C:\\adt";
		
		// Creamos el fichero
		File fichero = new File(ruta, "info2.txt");
		
		// Creamos el flujo de salida hacia el fichero
		FileOutputStream flujo = new FileOutputStream(fichero);
		
		// Creamos un objeto para conectar los flujos (el de bytes y el datos)
		DataOutputStream datos = new DataOutputStream(flujo);
		
		// Escribimos datos primitivos
		System.out.println("Empezando a escribir...");
		datos.writeBoolean(false);
		datos.writeChar('G');
		datos.writeDouble(149500000d);
		datos.writeInt(9845);
		datos.writeFloat(7650000f);
		datos.writeLong(87654321l);
		datos.writeUTF("Escribiendo texto");
		
		// Cerramos el stream
		datos.close();
		System.out.println("Fichero escrito correctamente!");
	}
}

