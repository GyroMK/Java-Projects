import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LectorEscritorSeguro extends Thread{
	private static List<String> contactos = new CopyOnWriteArrayList<String>();
	
	public static void main(String[] args) {
		for(int i=0; i<100; i++){
			new LectorEscritorSeguro().start();
		}
	}

	@Override
	public void run() {
		contactos.add(new String("Nuevo contacto"));
		for(String contacto : contactos){
			contactos.size();
		}
		System.out.println(contactos.size());
	}
}
