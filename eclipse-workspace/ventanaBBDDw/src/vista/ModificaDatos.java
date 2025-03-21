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
	private JTextField txtFecha;
	private JTextField txtNom;
	private JTextField txtEspecie;
	private JTextField txtlAnime;
	private JTextField txtlFecha;
	private JComboBox cmbId;
	private JSpinner spinnerEdad;
	private JTextField txtlApellido;
	private JLabel lblNewLabel;
	private JLabel lblAnime;
	private JLabel lblEdad;
	private JLabel lblTipo;
	private JLabel lblApellido;
	private JLabel lblNombre;
	private JLabel lblId;
	private JLabel lblNewLabel_7;

	/**
	 * Create the panel.
	 */
	public ModificaDatos() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
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
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(49, 297, 46, 14);
		add(lblNewLabel);
		
		lblAnime = new JLabel("Anime");
		lblAnime.setBounds(143, 274, 46, 14);
		add(lblAnime);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(138, 204, 46, 14);
		add(lblEdad);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(138, 172, 46, 14);
		add(lblTipo);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(138, 120, 46, 14);
		add(lblApellido);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(138, 91, 46, 14);
		add(lblNombre);
		
		lblId = new JLabel("Id de la mascota a modificar:");
		lblId.setBounds(143, 50, 147, 14);
		add(lblId);
		
		lblNewLabel_7 = new JLabel("Modificar Datos");
		lblNewLabel_7.setBounds(200, 16, 80, 14);
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
