/* Ejemplo multihilo */

public class Galgo extends Thread{

	private String nombre;
	private int tiempoDemora;
	
	public Galgo(String nombre, int tiempoDemora){
		super();
		this.nombre = nombre;
		this.tiempoDemora = tiempoDemora;
	}
	
	public void correr(){
		try{
			System.out.println("El galgo " + nombre + " comienza la carrera.");
			
			Thread.sleep(tiempoDemora * 1000); // Tiempo en milisegundos. *1000 para pasar a segundos
			
			System.out.println("El galgo " + nombre + " llega a la meta.");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void run(){
		this.correr();
	}
	
	public static void main(String[] args) {
		Galgo xavi = new Galgo("Xavineta", 6);
		Galgo cholo = new Galgo("Cholismo", 4);
		Galgo carlo = new Galgo("Carletto", 3);
		Galgo sampa = new Galgo("Sampaoli", 5);
		xavi.start();
		cholo.start();
		carlo.start();
		sampa.start();
	}

}
