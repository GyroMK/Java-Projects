package dam.unidad1;
import java.io.File;
import java.io.IOException;

public class Ejemplo04 {

	public static void main(String[] args) {
		try {
			Process proceso = new ProcessBuilder("Notepad.exe", "notas.txt").start();
			
			// waitFor - Detiene la ejecuci�n del programa que lanza el proceso a la espera de que este �ltimo termine
			int valor = proceso.waitFor();
			
			System.out.println("Fin de la ejecuci�n con un valor de retorno de: " + valor);
			
			// Con start podemos crear m�ltiples subprocesos a partir de un �nico ejemplar (instancia)
			/*ProcessBuilder procesoActual = new ProcessBuilder("Notepad.exe");
			for(int i=0; i<10; i++){
				procesoActual.start();
			}*/
			
			// Creaci�n del proceso indicando el directorio de trabajo
			/*ProcessBuilder procesoDos = new ProcessBuilder("Notepad.exe", "notas.txt");
			procesoDos.directory(new File("D:/dam/segundo/"));
			*/
			
			// Recoger informaci�n del entorno de ejecuci�n (Map)
			/*ProcessBuilder procesoTres = new ProcessBuilder("Notepad.exe", "notas.txt");
			java.util.Map<String, String> info = procesoTres.environment();
			System.out.println("N�mero de procesadores: " + info.get("NUMBER_OF_PROCESSORS"));
			*/
			
			/* Ejercicio: investiga qu� m�s informaci�n se puede obtener gracias al m�todo environment */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
