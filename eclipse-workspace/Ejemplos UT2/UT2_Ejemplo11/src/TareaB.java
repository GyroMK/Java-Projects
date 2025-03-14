import java.util.concurrent.Exchanger;

public class TareaB implements Runnable{
	private Exchanger<String> intercambiador;
	
	public TareaB(Exchanger<String> intercambiador) {
		super();
		this.intercambiador = intercambiador;
	}

	@Override
	public void run() {
		try{
			String mensajeRecibido = intercambiador.exchange("Mensaje enviado por TareaB");
			
			System.out.println("Mensaje recibido en TareaB: " + mensajeRecibido);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
