/* Uso de Timer y TimerTask para controlar un sistema de regadío automático */

import java.util.Timer;
import java.util.TimerTask;

public class SistemaDeRegadio extends TimerTask{

	public static void main(String[] args) {
		Timer temporizador = new Timer();
		// Espera 2 segundos para empezar a regar y riega cada segundo
		temporizador.schedule(new SistemaDeRegadio(), 2000, 1000);
	}

	@Override
	public void run() {
		System.out.println("\\|/ \\|/ \\|/ \\|/ Regando \\|/ \\|/ \\|/ \\|/");
	}

}
