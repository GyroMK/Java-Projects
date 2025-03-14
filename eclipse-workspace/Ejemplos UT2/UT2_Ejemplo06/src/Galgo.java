import java.util.ArrayList;

/* Ejemplo multihilo. Creaci�n de m�ltiples hilos a partir de un �nico objeto */
/* Posibles errores de concurrencia */

public class Galgo implements Runnable{

	private String nombre;
	private int tiempoDemora;
	private int caloriasConsumidas=0;
	
	public Galgo(String nombre, int tiempoDemora){
		super();
		this.nombre = nombre;
		this.tiempoDemora = tiempoDemora;
	}
	
	public void correr(){
		try{
			System.out.println("El galgo " + nombre + " comienza la carrera.");
			
			Thread.sleep(tiempoDemora * 1000); // Tiempo en milisegundos. *1000 para pasar a segundos
			caloriasConsumidas++;
			
			System.out.println("El galgo " + nombre + " llega a la meta con " + caloriasConsumidas + " calor�as consumidas.");
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
		// ArrayList que guardar� los estados de un hilo <Thread.State> 
		ArrayList<Thread.State> estado = new ArrayList<>();
		Thread hilo = new Thread(carlo);
		estado.add(hilo.getState());
		hilo.start();
		// Recorremos los estados del hilo hasta terminar
		while(hilo.getState()!=Thread.State.TERMINATED){
			if(!estado.contains(hilo.getState())){
				estado.add(hilo.getState());
			}
		}
		/* Para a�adir el estado TERMINATED */
		if(!estado.contains(hilo.getState())){
			estado.add(hilo.getState());
		}
		// Mostramos todos los estados que contiene el ArrayList
		for(Thread.State estadoActual : estado){
			System.out.println(estadoActual);
		}
	}

}













