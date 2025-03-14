/* Uso de Timer y TimerTask para controlar un sistema de regadío automático */

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SistemaDeRegadio implements Runnable{

	public static void main(String[] args) {
		SistemaDeRegadio miRegadio = new SistemaDeRegadio();
		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		ses.scheduleAtFixedRate(miRegadio, 2, 1, TimeUnit.SECONDS);
		System.out.println("Sistema de regadio configurado para comenzar en 2 segundos y regar cada segundo");
	}

	@Override
	public void run() {
		System.out.println("\\|/ \\|/ \\|/ \\|/ Regando \\|/ \\|/ \\|/ \\|/");
	}

}
