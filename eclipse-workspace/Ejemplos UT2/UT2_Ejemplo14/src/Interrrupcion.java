
public class Interrrupcion extends Thread {
	@Override
	public void run(){
		int contador=0;
		while(true){
			contador++;
			try{
				System.out.println(contador);
				if(contador==50){
					this.interrupt();
				}
				Thread.sleep(100);
			}catch(InterruptedException e){
				return;
			}
		}
	}
	public static void main(String[] args) {
		new Interrrupcion().start();
	}
}
