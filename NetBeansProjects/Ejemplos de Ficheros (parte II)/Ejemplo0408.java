import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Ejemplo0408 {
	public static void main(String[] args) {
		// Declaramos las variables
		Properties propiedades = new Properties();
		InputStream entrada = null;

		try {
			// Creamos el objeto InputStream con el nombre del archivo .properties
			entrada = new FileInputStream("datos.properties");

			// Cargamos el archivo .properties
			propiedades.load(entrada);

			// Obtenemos las propiedades y las mostramos por consola
			System.out.println(propiedades.getProperty("nombre"));
			System.out.println(propiedades.getProperty("apellido"));
			System.out.println(propiedades.getProperty("localidad"));
			System.out.println(propiedades.getProperty("telefono"));
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

