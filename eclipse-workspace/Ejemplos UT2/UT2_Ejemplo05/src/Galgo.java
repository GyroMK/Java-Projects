import java.util.concurrent.atomic.AtomicInteger;

/* Ejemplo multihilo. Creación de múltiples hilos a partir de un único objeto */
/* Posibles errores de concurrencia */

public class Galgo implements Runnable{

	private String nombre;
	private int tiempoDemora;
	//private int caloriasConsumidas=0;
	private static AtomicInteger caloriasConsumidas = new AtomicInteger();
	
	public Galgo(String nombre, int tiempoDemora){
		super();
		this.nombre = nombre;
		this.tiempoDemora = tiempoDemora;
	}
	
	public void correr(){
		try{
			System.out.println("El galgo " + nombre + " comienza la carrera.");
			
			Thread.sleep(tiempoDemora * 1000); // Tiempo en milisegundos. *1000 para pasar a segundos
			//caloriasConsumidas++;
			caloriasConsumidas.getAndIncrement();
			
			System.out.println("El galgo " + nombre + " llega a la meta con " + caloriasConsumidas + " calorías consumidas.");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void run(){
		this.correr();
	}
	
	public static void main(String[] args) {
		Galgo carlo = new Galgo("Carletto", 3);
		/*new Thread(carlo).start();
		new Thread(carlo).start();
		new Thread(carlo).start();
		new Thread(carlo).start();*/
		
		for (int i = 0; i < 200; i++) {
			new Thread(carlo).start();
		}
	}

}
