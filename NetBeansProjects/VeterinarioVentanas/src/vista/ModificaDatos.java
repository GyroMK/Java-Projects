package vista;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import modelo.Mascotas;

import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificaDatos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtTipoAnimal;
	private JTextField txtEdad;
	private JTextField txtSintomasNuevos;
	private JTextField txtVacunasNuevas;
	private JTextField txtNom;
	private JTextField txtEspecie;
	private JTextField txtSintos;
	private JTextField txtVacu;

	/**
	 * Create the panel.
	 */
	public ModificaDatos() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JTextArea txtrModificarDatos = new JTextArea();
		txtrModificarDatos.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 24));
		txtrModificarDatos.setText("Modificar Datos");
		txtrModificarDatos.setBounds(589, 34, 221, 31);
		add(txtrModificarDatos);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(300, 47, 74, 21);
		add(comboBox);
		
		JTextArea txtrIdDeLa = new JTextArea();
		txtrIdDeLa.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrIdDeLa.setText("Id de la mascota a modificar:");
		txtrIdDeLa.setBounds(39, 45, 231, 22);
		add(txtrIdDeLa);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNombre.setText("Nombre nuevo:");
		txtNombre.setBounds(39, 91, 114, 19);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTipoAnimal = new JTextField();
		txtTipoAnimal.setText("Especie nueva:");
		txtTipoAnimal.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTipoAnimal.setColumns(10);
		txtTipoAnimal.setBounds(39, 132, 114, 19);
		add(txtTipoAnimal);
		
		txtEdad = new JTextField();
		txtEdad.setToolTipText("Edad nueva:");
		txtEdad.setText("Edad nueva:");
		txtEdad.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEdad.setColumns(10);
		txtEdad.setBounds(39, 204, 114, 19);
		add(txtEdad);
		
		txtSintomasNuevos = new JTextField();
		txtSintomasNuevos.setText("Sintomas nuevos:");
		txtSintomasNuevos.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtSintomasNuevos.setColumns(10);
		txtSintomasNuevos.setBounds(39, 271, 131, 19);
		add(txtSintomasNuevos);
		
		txtVacunasNuevas = new JTextField();
		txtVacunasNuevas.setText("Vacunas nuevas:");
		txtVacunasNuevas.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtVacunasNuevas.setColumns(10);
		txtVacunasNuevas.setBounds(39, 322, 131, 19);
		add(txtVacunasNuevas);
		
		txtNom = new JTextField();
		txtNom.setBounds(194, 91, 199, 21);
		add(txtNom);
		txtNom.setColumns(10);
		
		txtEspecie = new JTextField();
		txtEspecie.setColumns(10);
		txtEspecie.setBounds(194, 132, 199, 21);
		add(txtEspecie);
		
		JSpinner spinnerEdad = new JSpinner();
		spinnerEdad.setBounds(194, 205, 35, 21);
		add(spinnerEdad);
		
		txtSintos = new JTextField();
		txtSintos.setColumns(10);
		txtSintos.setBounds(194, 271, 579, 21);
		add(txtSintos);
		
		txtVacu = new JTextField();
		txtVacu.setColumns(10);
		txtVacu.setBounds(194, 324, 579, 21);
		add(txtVacu);
		
		JButton btnNewButton = new JButton("MODIFICAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mascotas m = new Mascotas();
				m.setNombre(txtNom.getText());
				m.setTipoAnimal(txtEspecie.getText());
				m.setEdad(spinnerEdad.getComponentCount());
				m.setDescripcionSintomas(txtSintos.getText());
				m.setVacunas(txtVacu.getText());
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(546, 133, 151, 31);
		add(btnNewButton);

	}
}
