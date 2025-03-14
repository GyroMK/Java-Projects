
public class WaitNotifySimple implements Runnable{
	/* Haciendo nuestras variable volátiles obligamos a los hilos a leerlas 
	 * de la memoria principal, y no del cach�, garantizando que el valor 
	 * leído siempre es el último valor escrito en ellas. Estamos diciendo 
	 * al compilador que el valor contenido en esa direcci�n de memoria puede 
	 * modificarse en cualquier momento, y queremos que dicha modificaci�n 
	 * sea visible inmediatamente para todos los hilos que est�n accediendo a ella*/
	private volatile boolean ejecutandoMetodo = false;
	
	public synchronized void metodoUno(){
		for(int i=0; i<10; i++){
			System.out.println("Ejecución (métodoUno) -> " + i);
			if(i==5){
				try{
					this.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	public synchronized void metodoDos(){
		for(int i=0; i<20; i++){
			System.out.println("Ejecución (métodoDos) -> " + i);
		}
		this.notifyAll();
	}

	@Override
	public void run() {
		if(!ejecutandoMetodo){
			ejecutandoMetodo=true;
			metodoUno();
		}else{
			metodoDos();
		}
	}

	public static void main(String[] args) {
		WaitNotifySimple wns = new WaitNotifySimple();
		new Thread(wns).start();
		new Thread(wns).start();
	}
}
