import java.io.File;
import java.io.IOException;

public class CreadorDeProcesos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// Ruta absoluta del archivo C compilado
			ProcessBuilder pb = new 
					ProcessBuilder("E:\\2024-25\\PSP\\Primer trimestre\\Ejemplos UT1\\Ejemplo05\\proceso.exe");
			
			// Ruta absoluta con la carpeta donde queremos ejecutar el proceso en C
			// Esta carpeta tiene que haber sido creada previamente
			pb.directory(new File("E://Carpeta_de_salida"));
			
			Process proceso;
			proceso = pb.start();
			int valorDeRetorno = proceso.waitFor();
			
			if(valorDeRetorno == 0){
				System.out.println("El proceso se ha completado con éxito.");
			}else{
				System.out.println("Se ha producido un error con código: " + valorDeRetorno);
			}
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
