package controlador;

import java.util.ArrayList;

import modelo.Jugador;
import vista.Ventana;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;

public class Ejecutador {
	private static JTextField txtValor;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ventana miVentana = new Ventana();
		miVentana.cargaVentana(miVentana);
		
		JSlider slider = new JSlider();
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20000);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {				
				int valor = slider.getValue();
				if(valor>1000)
					txtValor.setText(String.valueOf(valor));
			}
		});
		slider.setValue(0);
		slider.setMaximum(2000000);
		slider.setBounds(10, 152, 414, 26);
		miVentana.getContentPane().add(slider);
		
		txtValor = new JTextField();
		txtValor.setBounds(52, 189, 133, 20);
		miVentana.getContentPane().add(txtValor);
		txtValor.setColumns(10);
	}

	public ArrayList<Jugador> cargandoJugadores(){
		ArrayList<Jugador> arrLJugadores = new ArrayList<>();
		Jugador uno = new Jugador("Carlos Alcaraz", "Tenis", 7);
		Jugador dos = new Jugador("Fernando Alonso", "Piloto F1", 24);
		Jugador tres = new Jugador("María Vicente", "Atletismo", 7);
		Jugador cuatro = new Jugador("Jon Rahm", "Golf", 9);
		Jugador cinco = new Jugador("Sergio Llull", "Baloncesto", 20);
		
		arrLJugadores.add(uno);
		arrLJugadores.add(dos);
		arrLJugadores.add(tres);
		arrLJugadores.add(cuatro);
		arrLJugadores.add(cinco);
		
		return arrLJugadores;
	}
}
