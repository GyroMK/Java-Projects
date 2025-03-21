package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import controlador.carrera_Control;

public class carrera extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	

	public carrera() {
		
		
		setLayout(null);
		
		JLabel Lbl1 = new JLabel("");
        Lbl1.setBounds(10, 11, 68, 100);
        add(Lbl1);

        JLabel Lbl2 = new JLabel("");
        Lbl2.setBounds(20, 122, 68, 100);
        add(Lbl2);

        JLabel Lbl3 = new JLabel("");
        Lbl3.setBounds(30, 233, 68, 100);
        add(Lbl3);

        JLabel Lbl4 = new JLabel("");
        Lbl4.setBounds(20, 344, 68, 100);
        add(Lbl4);

        JLabel Lbl5 = new JLabel("");
        Lbl5.setBounds(20, 478, 68, 100);
        add(Lbl5);
        
        JLabel Lbl6 = new JLabel("");
        Lbl6.setBounds(20, 578, 68, 100);
		add(Lbl6);

        JLabel Lblmeta = new JLabel("");
        Lblmeta.setBounds(583, 0, 83, 592);
        add(Lblmeta);

        // Redimensionar imágenes automáticamente
        setScaledImage(Lbl1, "/img/1.png", 68, 100);
        setScaledImage(Lbl2, "/img/2.png", 68, 100);
        setScaledImage(Lbl3, "/img/3.png", 68, 100);
        setScaledImage(Lbl4, "/img/4.png", 68, 100);
        setScaledImage(Lbl5, "/img/5.png", 68, 100); 
        setScaledImage(Lbl6, "/img/6.png", 68, 100); 
        setScaledImage(Lblmeta, "/img/meta.png", 83, 592);

       

		carrera_Control primero = new carrera_Control("1", Lbl1, Lblmeta);
		carrera_Control segundo = new carrera_Control("2", Lbl2, Lblmeta);
		carrera_Control tercero = new carrera_Control("3", Lbl3, Lblmeta);
		carrera_Control cuarto = new carrera_Control("4", Lbl4, Lblmeta);
		carrera_Control quinto = new carrera_Control("5", Lbl5, Lblmeta);
		carrera_Control sexto = new carrera_Control("6", Lbl6, Lblmeta);
		
				
		primero.start();
		segundo.start();
		tercero.start();
		cuarto.start();
		quinto.start();
		sexto.start();
	}
	
	private void setScaledImage(JLabel label, String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(carrera.class.getResource(imagePath));
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(img));
    }

}
