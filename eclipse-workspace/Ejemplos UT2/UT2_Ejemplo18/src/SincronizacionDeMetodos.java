/* Quitar la palabra reservada synchronized para ver la diferencia entre
 * una ejecuci�n sincronizada y otra que no lo es. Salida esperada:
 * 
Comienzo del m�todo 1
Fin del m�todo 1 
 - - - - - - - - - - - - - 
Comienzo del m�todo 2
Fin del m�todo 2 
 - - - - - - - - - - - - - 
Comienzo del m�todo 1
Fin del m�todo 1 
 - - - - - - - - - - - - - 
Comienzo del m�todo 2
Fin del m�todo 2 
 - - - - - - - - - - - - - */
public class SincronizacionDeMetodos implements Runnable {
	public synchronized void metodoUno(){
		System.out.println("Comienzo del método 1");
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			return;
		}
		System.out.println("Fin del método 1 \n - - - - - - - - - - - - - ");
	}

	public synchronized void metodoDos(){
		System.out.println("Comienzo del método 2");
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			return;
		}
		System.out.println("Fin del método 2 \n - - - - - - - - - - - - - ");
	}
	@Override
	public void run() {
		metodoUno();
		metodoDos();
	}

	public static void main(String[] args) {
		SincronizacionDeMetodos sdm = new SincronizacionDeMetodos();
		new Thread(sdm).start();
		new Thread(sdm).start();
		
		// Si utilizásemos objetos distintos sería como no utilizar synchronized
		// Para probar el siguiente código debemos cambiar:
		// implements Runnable por extends Thread y comentar el c�digo anterior del main
		// new SincronizacionDeMetodos().start();
		// new SincronizacionDeMetodos().start();
	}
}
