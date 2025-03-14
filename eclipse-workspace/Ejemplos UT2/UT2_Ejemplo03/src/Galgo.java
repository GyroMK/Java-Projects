/* Ejemplo multihilo */

public class Galgo extends Thread {

	private String nombre;

	public Galgo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public void correr() {
		System.out.println("El galgo " + nombre + " comienza la carrera de 100 m.");
		
		// La llamada a start() inicia el método run(). Es aquí donde se
		// capturarán los errores con try y catch
		for (int i = 0; i < 10; i++) {
			System.out.println("El galgo " + nombre + " pasa por los " + i*10 + "m.");
			
			try {
				// El método sleep necesita un long, por ese motivo hacemos un casting
				this.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// Código en caso de que se interrumpa la pausa, sleep, cosa que
				// es rarisima, por ello no hacemos nada
			}
		}
		// Con getName() obtendremos el nombre que le hemos dado al hilo
		System.out.println("--------------------------------------------------");
		System.out.println("El galgo " + nombre + " llega a la META. Hilo: " + this.getName());
		System.out.println("--------------------------------------------------");
	}

	@Override
	public void run() {
		this.correr();
	}

	public static void main(String[] args) {
		Galgo xavi = new Galgo("Xavineta");
		Galgo cholo = new Galgo("Cholismo");
		Galgo carlo = new Galgo("Carletto");
		Galgo sampa = new Galgo("Sampaoli");
		xavi.start();
		cholo.start();
		carlo.start();
		sampa.start();
	}

}