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
			
			String[] listado = {"\"C:\\Users\\fri11\\AppData\\Local\\Programs\\Opera GX\\opera.exe\"", "https://www.skidrowreloaded.com"};
			Process procesos = Runtime.getRuntime().exec(listado);
			
			// waitFor - Detiene la ejecuci�n del programa que lanza el proceso a la espera de que este �ltimo termine
			int idProceso = procesos.waitFor();
			System.out.println("Fin de la ejecuci�n: " + idProceso);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
