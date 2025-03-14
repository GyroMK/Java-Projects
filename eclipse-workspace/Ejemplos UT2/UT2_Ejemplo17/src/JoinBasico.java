/* El m�todo join permite indicar a un hilo que debe suspender sus ejecuci�n
 * hasta que termina otro hilo de referencia. Debe de ejecutarse dentro del
 * m�todo as�ncrono o no tendr� efecto. Muy importante que el jb2 tenga una 
 * referencia al jb1 para invocar al m�todo join */
public class JoinBasico extends Thread {
	private int id;
	private boolean suspender = false;
	private Thread hilo;
	
	public JoinBasico (int id){
		this.id = id;
	}
	public void suspenderHilo(Thread hilo){
		this.suspender=true;
		this.hilo=hilo;
	}
	@Override
	public void run() {
		try{
			for(int i=0; i<3; i++){
				if(suspender){
					hilo.join();
				}
				System.out.println("Hilo: " + id + ". Iteración nº: " + i);
				Thread.sleep(1000);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		JoinBasico jb1 = new JoinBasico(1);
		JoinBasico jb2 = new JoinBasico(2);
		jb1.start();
		jb2.start();
		// Comentar la siguiente l�nea para entender el efecto del m�todo join
		jb1.suspenderHilo(jb2);
	}
}











