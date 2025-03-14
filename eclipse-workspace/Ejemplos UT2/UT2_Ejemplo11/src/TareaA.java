import java.util.concurrent.Exchanger;

public class TareaA implements Runnable{
	private Exchanger<String> intercambiador;
	
	public TareaA(Exchanger<String> intercambiador) {
		super();
		this.intercambiador = intercambiador;
	}

	@Override
	public void run() {
		try{
			String mensajeRecibido = intercambiador.exchange("Mensaje enviado por TareaA");
			
			System.out.println("Mensaje recibido en TareaA: " + mensajeRecibido);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
