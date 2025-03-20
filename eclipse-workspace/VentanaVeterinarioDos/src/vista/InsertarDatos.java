package vista;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

import controlador.Bbdd_Control;
import modelo.Waifus;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertarDatos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField txtNombre;
	private JTextField txtTipoanimal;
	private JTextField txtSintomas;
	private JTextField txtVacunas;

	/**
	 * Create the panel.
	 */
	public InsertarDatos() {
		
		Bbdd_Control mibbdd = new Bbdd_Control();
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(88, 54, 89, 20);
		add(textField);
		textField.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(126, 111, 252, 23);
		add(txtNombre);
		
		txtTipoanimal = new JTextField();
		txtTipoanimal.setColumns(10);
		txtTipoanimal.setBounds(222, 175, 384, 25);
		add(txtTipoanimal);
		
		JSpinner spinnerEdad = new JSpinner();
		spinnerEdad.setBounds(110, 224, 52, 23);
		add(spinnerEdad);
		
		txtSintomas = new JTextField();
		txtSintomas.setColumns(10);
		txtSintomas.setBounds(156, 277, 653, 25);
		add(txtSintomas);
		
		txtVacunas = new JTextField();
		txtVacunas.setColumns(10);
		txtVacunas.setBounds(171, 343, 638, 25);
		add(txtVacunas);
		
		JTextArea txtrId = new JTextArea();
		txtrId.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrId.setBackground(new Color(255, 255, 255));
		txtrId.setText("Id:");
		txtrId.setBounds(39, 49, 39, 25);
		add(txtrId);
		
		JTextArea txtrNombre = new JTextArea();
		txtrNombre.setText("Nombre: ");
		txtrNombre.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrNombre.setBackground(new Color(255, 255, 255));
		txtrNombre.setBounds(39, 111, 77, 25);
		add(txtrNombre);
		
		JTextArea txtrTipoDeAnimal = new JTextArea();
		txtrTipoDeAnimal.setText("Tipo de animal:");
		txtrTipoDeAnimal.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrTipoDeAnimal.setBackground(new Color(255, 255, 255));
		txtrTipoDeAnimal.setBounds(39, 170, 173, 25);
		add(txtrTipoDeAnimal);
		
		JTextArea txtrEdad = new JTextArea();
		txtrEdad.setText("Edad:");
		txtrEdad.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrEdad.setBackground(new Color(255, 255, 255));
		txtrEdad.setBounds(39, 222, 61, 25);
		add(txtrEdad);
		
		JTextArea txtrSntomas = new JTextArea();
		txtrSntomas.setText("Síntomas:");
		txtrSntomas.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrSntomas.setBackground(new Color(255, 255, 255));
		txtrSntomas.setBounds(39, 277, 105, 25);
		add(txtrSntomas);
		
		JTextArea txtrVacunas = new JTextArea();
		txtrVacunas.setText("Vacunas:");
		txtrVacunas.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrVacunas.setBackground(new Color(255, 255, 255));
		txtrVacunas.setBounds(39, 343, 105, 25);
		add(txtrVacunas);
		
		JButton btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Waifus m = new Waifus();
				m.setNombre(txtNombre.getText());
				m.setTipoAnimal(txtTipoanimal.getText());
				m.setEdad(Integer.parseInt(spinnerEdad.getValue().toString()));
				m.setDescripcionSintomas(txtSintomas.getText());
				m.setVacunas(txtVacunas.getText());
				
				mibbdd.insertaDatos(m);
				JOptionPane.showMessageDialog(null, "Mascota creada correctamente");
				
			}
		});
		btnInsertar.setBackground(new Color(105, 105, 105));
		btnInsertar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnInsertar.setBounds(355, 418, 154, 49);
		add(btnInsertar);
		
		JTextArea txtrInsertarMascota = new JTextArea();
		txtrInsertarMascota.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 26));
		txtrInsertarMascota.setForeground(new Color(0, 0, 0));
		txtrInsertarMascota.setText("Insertar Mascota");
		txtrInsertarMascota.setBounds(535, 24, 277, 51);
		add(txtrInsertarMascota);

	}
}
