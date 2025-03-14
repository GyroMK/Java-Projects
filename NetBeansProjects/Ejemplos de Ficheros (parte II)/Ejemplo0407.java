import java.io.IOException;
import java.io.RandomAccessFile;


public class Ejemplo0407 {

	public static void main(String[] args) throws IOException {
		// Escribimos una ruta existente
		String ruta = "C:\\adt\\info3.txt";
		
		// Declaramos el fichero de acceso aleatorio
		RandomAccessFile fichero = new RandomAccessFile(ruta, "rw");
		
		// Escribimos los bytes en el fichero
		for(int i=0; i<100; i++){
			fichero.write((byte)i);
		}
		
		// Movemos el puntero
		fichero.seek(20);
		
		// Leemos los bytes pares
		for(int i=0; i<30; i++){
			int miCaracter = fichero.read();
			System.out.print(miCaracter + ", ");
			fichero.skipBytes(1);
		}
		
		// Cerramos el fichero
		fichero.close();
	}
}
