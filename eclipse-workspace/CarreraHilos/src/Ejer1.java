import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Ejer1 extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	

	public Ejer1() {
		
		
		setLayout(null);
		
		JLabel Lblichi = new JLabel("");
        Lblichi.setBounds(10, 11, 68, 100);
        add(Lblichi);

        JLabel Lblnino = new JLabel("");
        Lblnino.setBounds(20, 122, 68, 100);
        add(Lblnino);

        JLabel LblMiku = new JLabel("");
        LblMiku.setBounds(30, 233, 68, 100);
        add(LblMiku);

        JLabel LblYotsu = new JLabel("");
        LblYotsu.setBounds(20, 344, 68, 100);
        add(LblYotsu);

        JLabel LblItsu = new JLabel("");
        LblItsu.setBounds(20, 478, 68, 100);
        add(LblItsu);

        JLabel Lblmeta = new JLabel("");
        Lblmeta.setBounds(583, 0, 83, 592);
        add(Lblmeta);

        // Redimensionar imágenes automáticamente
        setScaledImage(Lblichi, "/img/ichika.png", 68, 100);
        setScaledImage(Lblnino, "/img/nino.png", 68, 100);
        setScaledImage(LblMiku, "/img/miku.png", 68, 100);
        setScaledImage(LblYotsu, "/img/yotsuba.png", 68, 100);
        setScaledImage(LblItsu, "/img/itsuki.png", 68, 100);
        setScaledImage(Lblmeta, "/img/meta.png", 83, 592);

       

		ej1 Ichika = new ej1("Ichika", Lblichi, Lblmeta);
		ej1 Nino = new ej1("Nino", Lblnino, Lblmeta);
		ej1 Miku = new ej1("Miku", LblMiku, Lblmeta);
		ej1 Yotsuba = new ej1("Yotsuba", LblYotsu, Lblmeta);
		ej1 Itsuki = new ej1("Itsuki", LblItsu, Lblmeta);
		
				
		Ichika.start();
		Nino.start();
		Miku.start();
		Yotsuba.start();
		Itsuki.start();
	}
	
	private void setScaledImage(JLabel label, String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(Ejer1.class.getResource(imagePath));
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(img));
    }

}
