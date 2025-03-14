/* La sincronizaci�n se realiza a nivel de m�todo (cada uno de los m�todos solo
 * puede estar siendo ejecutado por un objeto simult�neamente, pero ambos m�todos
 * pueden estar ejecut�ndose por dos objetos distintos) */
public class SincronizacionDeSegmentos extends Thread {
	int id;
	static Object bloqueoUno = new Object();
	static Object bloqueoDos = new Object();
	
	public SincronizacionDeSegmentos (int id){
		this.id = id;
	}
	
	public void metodoUno(){
		synchronized(bloqueoUno){
			System.out.println("Comienzo del método 1");
		}
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			return;
		}
		System.out.println("Fin del método 1 del hilo " + id + "\n - - - - - - - - - - - - - ");
	}

	public synchronized void metodoDos(){
		synchronized(bloqueoDos){
			System.out.println("Comienzo del m�todo 2");
		}
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			return;
		}
		System.out.println("Fin del m�todo 2 del hilo " + id + "\n - - - - - - - - - - - - - ");
	}
	@Override
	public void run() {
		if(id==1){
			metodoUno();
			metodoDos();
		}else{
			metodoDos();
			metodoUno();
		}
	}

	public static void main(String[] args) {
		new SincronizacionDeSegmentos(1).start();
		new SincronizacionDeSegmentos(2).start();
	}
}
