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
import modelo.Personajes;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class InsertarDatos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField txtNombre;
	private JTextField txtTipo;
	private JTextField txtAnime;
	private JTextField txtApellido;

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
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(104, 214, 384, 25);
		add(txtTipo);
		
		txtAnime = new JTextField();
		txtAnime.setColumns(10);
		txtAnime.setBounds(88, 250, 653, 25);
		add(txtAnime);
		
		JButton btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Personajes m = new Personajes();
				m.setNombre(txtNombre.getText());
				m.setPelicula(txtApellido.getText());
				m.setPrimeraVez(txtTipo.getText());
				m.setPareja(txtAnime.getText());
				
				mibbdd.insertaDatos(m);
				JOptionPane.showMessageDialog(null, "Personaje creado correctamente");
				
			}
		});
		btnInsertar.setBackground(new Color(105, 105, 105));
		btnInsertar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnInsertar.setBounds(355, 418, 154, 49);
		add(btnInsertar);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(155, 164, 252, 23);
		add(txtApellido);
		
		JLabel lblPareja = new JLabel("Pareja");
		lblPareja.setBounds(46, 259, 46, 14);
		add(lblPareja);
		
		JLabel lblPrimeraVez = new JLabel("Primera Vez");
		lblPrimeraVez.setBounds(37, 219, 84, 14);
		add(lblPrimeraVez);
		
		JLabel lblPelicula = new JLabel("Pelicula");
		lblPelicula.setBounds(99, 168, 46, 14);
		add(lblPelicula);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(88, 115, 46, 14);
		add(lblNombre);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(59, 57, 46, 14);
		add(lblId);
		
		JLabel lblInsertar = new JLabel("Insertar personaje");
		lblInsertar.setBounds(262, 11, 90, 14);
		add(lblInsertar);

	}
}
