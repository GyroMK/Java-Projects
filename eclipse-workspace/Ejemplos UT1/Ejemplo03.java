import java.io.IOException;

public class Ejemplo03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// Apagar el equipo a los 30"
			//String []comando = {"shutdown", "-s", "-t", "30"}; 
			//Runtime.getRuntime().exec(comando);
			
			//Runtime.getRuntime().exec("calc.exe");
			
			//String[] listado = {"Notepad.exe", "notas.txt"};
			//Runtime.getRuntime().exec(listado);
			
			String[] listado = {"Notepad.exe", "notas.txt"};
			Process procesos = Runtime.getRuntime().exec(listado);
			
			// waitFor - Detiene la ejecución del programa que lanza el proceso a la espera de que este último termine
			int idProceso = procesos.waitFor();
			System.out.println("Fin de la ejecución: " + idProceso);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
