package vista;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Bbdd_Control;
import modelo.Waifus;

import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;

public class ModificaDatos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtTipo;
	private JTextField txtEdad;
	private JTextField txtAnime;
	private JTextField txtFecha;
	private JTextField txtNom;
	private JTextField txtEspecie;
	private JTextField txtlAnime;
	private JTextField txtlFecha;
	private JComboBox cmbId;
	private JSpinner spinnerEdad;
	private JTextField txtlApellido;
	private JTextField txtApellido;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;

	/**
	 * Create the panel.
	 */
	public ModificaDatos() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JTextArea txtrModificarDatos = new JTextArea();
		txtrModificarDatos.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 24));
		txtrModificarDatos.setText("Modificar Datos");
		txtrModificarDatos.setBounds(239, 0, 221, 31);
		add(txtrModificarDatos);
		
		cmbId = new JComboBox();
		cmbId.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Bbdd_Control bd = new Bbdd_Control();
				Waifus m = bd.consultaPorId(cmbId.getSelectedItem().toString());
								
				txtNom.setText(m.getNombre());
				txtlApellido.setText(m.getApellido());
				txtEspecie.setText(m.getTipo());
				spinnerEdad.setValue(m.getEdad());
				txtlAnime.setText(m.getAnime());
				txtlFecha.setText(m.getFecha_nacimiento());
			}
		});
		cmbId.setBounds(300, 47, 74, 21);
		add(cmbId);
		
		JTextArea txtrIdDeLa = new JTextArea();
		txtrIdDeLa.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrIdDeLa.setText("Id de la mascota a modificar:");
		txtrIdDeLa.setBounds(39, 45, 231, 22);
		add(txtrIdDeLa);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNombre.setText("Nombre");
		txtNombre.setBounds(39, 91, 114, 19);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setEnabled(false);
		txtTipo.setText("Tipo");
		txtTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTipo.setColumns(10);
		txtTipo.setBounds(39, 172, 114, 19);
		add(txtTipo);
		
		txtEdad = new JTextField();
		txtEdad.setEnabled(false);
		txtEdad.setToolTipText("Edad nueva:");
		txtEdad.setText("Edad");
		txtEdad.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEdad.setColumns(10);
		txtEdad.setBounds(39, 204, 114, 19);
		add(txtEdad);
		
		txtAnime = new JTextField();
		txtAnime.setEnabled(false);
		txtAnime.setText("Anime");
		txtAnime.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtAnime.setColumns(10);
		txtAnime.setBounds(39, 271, 131, 19);
		add(txtAnime);
		
		txtFecha = new JTextField();
		txtFecha.setEnabled(false);
		txtFecha.setText("Fecha");
		txtFecha.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtFecha.setColumns(10);
		txtFecha.setBounds(39, 322, 131, 19);
		add(txtFecha);
		
		txtNom = new JTextField();
		txtNom.setBounds(194, 91, 199, 21);
		add(txtNom);
		txtNom.setColumns(10);
		
		txtEspecie = new JTextField();
		txtEspecie.setColumns(10);
		txtEspecie.setBounds(194, 172, 199, 21);
		add(txtEspecie);
		
		spinnerEdad = new JSpinner();
		spinnerEdad.setBounds(194, 205, 35, 21);
		add(spinnerEdad);
		
		txtlAnime = new JTextField();
		txtlAnime.setColumns(10);
		txtlAnime.setBounds(194, 271, 579, 21);
		add(txtlAnime);
		
		txtlFecha = new JTextField();
		txtlFecha.setColumns(10);
		txtlFecha.setBounds(194, 324, 579, 21);
		add(txtlFecha);
		
		JButton btnNewButton = new JButton("MODIFICAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bbdd_Control bd = new Bbdd_Control();
				
				Waifus m = new Waifus();
				m.setId(Integer.parseInt(cmbId.getSelectedItem().toString()));
				m.setNombre(txtNom.getText());
				m.setApellido(txtlApellido.getText());
				m.setTipo(txtEspecie.getText());
				m.setEdad(Integer.parseInt(spinnerEdad.getValue().toString()));
				m.setAnime(txtlAnime.getText());
				m.setFecha_nacimiento(txtlFecha.getText());
				
				int valor = JOptionPane.showConfirmDialog(null, "¿Desea modificar los datos de la Waifu?");
				if(valor == JOptionPane.OK_OPTION) {
					bd.modificaDatos(m);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(276, 405, 151, 31);
		add(btnNewButton);
		
		txtlApellido = new JTextField();
		txtlApellido.setColumns(10);
		txtlApellido.setBounds(194, 121, 199, 21);
		add(txtlApellido);
		
		txtApellido = new JTextField();
		txtApellido.setText("Apellido");
		txtApellido.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtApellido.setEnabled(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(39, 121, 114, 19);
		add(txtApellido);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(49, 297, 46, 14);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(49, 252, 46, 14);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(0, 208, 46, 14);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(0, 176, 46, 14);
		add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(0, 124, 46, 14);
		add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(0, 95, 46, 14);
		add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(0, 50, 46, 14);
		add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(194, 16, 46, 14);
		add(lblNewLabel_7);

	}
	public void cargaCombo() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/waifudb", "root", "");
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select id from waifus");

			while (registro.next()) {
				cmbId.addItem(registro.getInt("id"));
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
