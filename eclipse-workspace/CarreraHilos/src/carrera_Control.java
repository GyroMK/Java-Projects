import java.util.Iterator;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class carrera_Control extends Thread {
	private String nombre;
	private JLabel lbl;
	private JLabel lblmeta;

	public carrera_Control(String nombre, JLabel lbl, JLabel meta) {
		super();
		this.lbl = lbl;
		this.nombre = nombre;
		this.lblmeta = meta;
	}

	public void correr() {
		System.out.println(nombre + " comienza la carrera de 100 m.");
		while (lbl.getX() < lblmeta.getX()) {
			System.out.println(nombre + " pasa por los " + lbl.getX() + 10 + "m.");
			lbl.setLocation(lbl.getX() + 10, lbl.getY());
			try {
				this.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
			}
			
		}
		System.out.println("--------------------------------------------------");
		System.out.println(nombre + " llega a la META. Hilo: " + this.getName());
		System.out.println("--------------------------------------------------");

		//JOptionPane.showMessageDialog(null, nombre + " llegó a la meta");

	}

	@Override
	public void run() {
		this.correr();
	}
}
