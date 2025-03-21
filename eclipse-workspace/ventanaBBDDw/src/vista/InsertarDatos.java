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
import javax.swing.JLabel;

public class InsertarDatos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField txtNombre;
	private JTextField txtTipo;
	private JTextField txtAnime;
	private JTextField txtFecha;
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
		
		JSpinner spinnerEdad = new JSpinner();
		spinnerEdad.setBounds(113, 263, 52, 23);
		add(spinnerEdad);
		
		txtAnime = new JTextField();
		txtAnime.setColumns(10);
		txtAnime.setBounds(126, 321, 653, 25);
		add(txtAnime);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(245, 387, 638, 25);
		add(txtFecha);
		
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
		
		JTextArea txtrTipo = new JTextArea();
		txtrTipo.setText("Tipo:");
		txtrTipo.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrTipo.setBackground(new Color(255, 255, 255));
		txtrTipo.setBounds(39, 209, 55, 25);
		add(txtrTipo);
		
		JTextArea txtrEdad = new JTextArea();
		txtrEdad.setText("Edad:");
		txtrEdad.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrEdad.setBackground(new Color(255, 255, 255));
		txtrEdad.setBounds(42, 261, 61, 25);
		add(txtrEdad);
		
		JTextArea txtrAnime = new JTextArea();
		txtrAnime.setText("Anime:");
		txtrAnime.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrAnime.setBackground(new Color(255, 255, 255));
		txtrAnime.setBounds(42, 316, 77, 25);
		add(txtrAnime);
		
		JTextArea txtrFecha = new JTextArea();
		txtrFecha.setText("Fecha de Nacimiento:");
		txtrFecha.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrFecha.setBackground(new Color(255, 255, 255));
		txtrFecha.setBounds(10, 382, 218, 25);
		add(txtrFecha);
		
		JButton btnInsertar = new JButton("INSERTAR");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Waifus m = new Waifus();
				m.setNombre(txtNombre.getText());
				m.setApellido(txtApellido.getText());
				m.setTipo(txtTipo.getText());
				m.setEdad(Integer.parseInt(spinnerEdad.getValue().toString()));
				m.setAnime(txtAnime.getText());
				m.setFecha_nacimiento(txtFecha.getText());
				
				mibbdd.insertaDatos(m);
				JOptionPane.showMessageDialog(null, "Waifu creada correctamente");
				
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
		txtrInsertarMascota.setBounds(232, 0, 277, 51);
		add(txtrInsertarMascota);
		
		JTextArea txtrApellido = new JTextArea();
		txtrApellido.setText("Apellido:");
		txtrApellido.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrApellido.setBackground(Color.WHITE);
		txtrApellido.setBounds(39, 162, 106, 25);
		add(txtrApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(155, 164, 252, 23);
		add(txtApellido);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(59, 371, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(48, 297, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(49, 245, 46, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(39, 198, 46, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(49, 151, 46, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(48, 100, 46, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(28, 37, 46, 14);
		add(lblNewLabel_6);

	}
}
