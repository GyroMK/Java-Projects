import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* Lanza una tarea que se realiza de manera asíncrona y deja en espera el tratamiento de la respuesta.
 * Construye un objeto que implementa Callable y lo entrega a ExecutorService. El resultado se almacena
 * en un objeto Future mediante el método get, pudiendo evaluar si el proceso ha terminado correctamente
 * o ha sido cancelado. Finalmente, se apaga ExecutorService. Si no se apagase, queda a la espera de
 * nuevas tareas. */
public class Lector implements Callable<String>{

	public static void main(String[] args) {
		Lector lector = new Lector();
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<String> resultado = es.submit(lector);
		try {
			String texto = resultado.get();
			
			if(resultado.isDone()){
				System.out.println(texto);
				System.out.println("Proceso finalizado");
			}else if(resultado.isCancelled()){
				System.out.println("Proceso cancelado");
			}
			es.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String call() throws Exception {
		String textoLeido = "Soy de Madrid";
		Thread.sleep(1000);
		return textoLeido;
	}

}
