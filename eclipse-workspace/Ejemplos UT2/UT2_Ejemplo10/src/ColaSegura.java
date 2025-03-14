import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ColaSegura implements Runnable{
	// Hacemos concurrente la cola
	private static Queue<Integer> cola = new ConcurrentLinkedDeque<Integer>();
	
	public static void main(String[] args) {
		for(int i=0; i<10; i++){
			new Thread(new ColaSegura()).start();
		}
	}

	@Override
	public void run() {
		cola.add(10);
		for(Integer i : cola){
			System.out.print(i + ":");
		}
		System.out.println("Tamaño cola: " + cola.size());
	}

}
