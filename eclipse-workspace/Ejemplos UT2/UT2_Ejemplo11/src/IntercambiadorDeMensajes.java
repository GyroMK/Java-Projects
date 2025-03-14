import java.util.concurrent.Exchanger;

public class IntercambiadorDeMensajes {

	public static void main(String[] args) {
		Exchanger<String> intercambiador = new Exchanger<String>();
		new Thread(new TareaA(intercambiador)).start();
		new Thread(new TareaB(intercambiador)).start();
	}

}
