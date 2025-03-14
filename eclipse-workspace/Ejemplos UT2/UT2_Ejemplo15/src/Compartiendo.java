
public class Compartiendo extends Thread {
	private MiObjeto mo;
	
	public Compartiendo(MiObjeto mo) {
		this.mo = mo;
	}

	@Override
	public void run(){
		this.mo.variableComun++;
		System.out.println("Variable compartida con valor de: " + this.mo.variableComun);
	}
	
	public static void main(String[] args) throws InterruptedException{
		MiObjeto mo = new MiObjeto();
		Compartiendo compartiendo01 = new Compartiendo(mo);
		Compartiendo compartiendo02 = new Compartiendo(mo);
		Compartiendo compartiendo03 = new Compartiendo(mo);
		Compartiendo compartiendo04 = new Compartiendo(mo);
		compartiendo01.start();
		Thread.sleep(1000);
		compartiendo02.start();
		Thread.sleep(1000);
		compartiendo03.start();
		Thread.sleep(1000);
		compartiendo04.start();
	}
}
