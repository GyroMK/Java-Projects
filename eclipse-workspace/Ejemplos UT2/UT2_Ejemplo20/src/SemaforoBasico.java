import java.util.concurrent.Semaphore;
/* Sem�foro con capacidad para 3 permisos. Al mismo tiempo, 5 hilos construidos
 * a partir de la misma instancia de Runnable acceden a la secci�n cr�tica, 
 * solicitan permiso, realizan los pasos de la actividad sincronizada y liberan
 * el bloqueo.
 * acquire -> adquiere uno o m�s permisos del sem�foro si hay alguno disponible.
 * release -> libera uno o m�s permisos concedidos previamente. */

public class SemaforoBasico implements Runnable {
	Semaphore semaforo = new Semaphore(3);
	@Override
	public void run() {
		try{
			semaforo.acquire();
			System.out.println("Paso 1");
			Thread.sleep(1000);
			System.out.println("Paso 2");
			Thread.sleep(1000);
			System.out.println("Paso 3");
			Thread.sleep(1000);
			semaforo.release();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SemaforoBasico sb = new SemaforoBasico();
		for(int i=0; i<50; i++){
			new Thread(sb).start();
		}
	}
}
