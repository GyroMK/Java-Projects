package vista;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.Bbdd_Control;
import modelo.Mascotas;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class BorraDatos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<Mascotas> cmbId;
	private JTextField txtBorrarMascota;
	private JTextField txtNombre;
	private JTextField txtTipo;
	private JTextField txtEdad;
	private JTextField txtSintomas;
	private JTextField txtVacunas;
	private JComboBox cmbClase;
	private JTextField txtNombreClase;
	private JTextField txtTipoClase;
	private JTextField txtEdadClase;
	private JTextField txtSintomasClase;
	private JTextField txtVacunasClase;

	/**
	 * Create the panel.
	 */
	public BorraDatos() {
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		Bbdd_Control mibbdd = new Bbdd_Control();
		txtBorrarMascota = new JTextField();
		txtBorrarMascota.setForeground(new Color(0, 0, 0));
		txtBorrarMascota.setBackground(new Color(255, 255, 255));
		txtBorrarMascota.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		txtBorrarMascota.setText("Borrar Mascota");
		txtBorrarMascota.setBounds(350, 25, 169, 22);
		add(txtBorrarMascota);
		txtBorrarMascota.setColumns(10);

		cmbId = new JComboBox<>();
		cmbId.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Mascotas m = (Mascotas) cmbId.getSelectedItem();
				txtNombre.setText(m.getNombre());
				txtTipo.setText(m.getTipoAnimal());
				txtEdad.setText(m.getEdad() + "");
				txtSintomas.setText(m.getDescripcionSintomas());
				txtVacunas.setText(m.getVacunas());
			}
		});
		cmbId.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				String cadena = null;
				if (value instanceof Mascotas) {
					Mascotas m = (Mascotas) value;
					cadena = m.getIdMascota() + ", " + m.getTipoAnimal() + ", " + m.getNombre();
					setText(cadena);
				}
				return this;
			}
		});
		cmbId.setBounds(270, 95, 169, 21);
		add(cmbId);

		JLabel lblId = new JLabel("Id de la Mascota (Fran, cargando objeto)");
		lblId.setBounds(28, 95, 232, 14);
		add(lblId);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(184, 290, 89, 23);
		add(btnBorrar);

		txtNombre = new JTextField();
		txtNombre.setBounds(187, 141, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtTipo = new JTextField();
		txtTipo.setBounds(187, 166, 86, 20);
		add(txtTipo);
		txtTipo.setColumns(10);

		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(187, 192, 86, 20);
		add(txtEdad);

		txtSintomas = new JTextField();
		txtSintomas.setColumns(10);
		txtSintomas.setBounds(187, 220, 285, 20);
		add(txtSintomas);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(119, 144, 46, 14);
		add(lblNombre);

		JLabel lblTipoAnimal = new JLabel("Tipo de animal");
		lblTipoAnimal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoAnimal.setBounds(76, 169, 89, 14);
		add(lblTipoAnimal);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEdad.setBounds(97, 195, 68, 14);
		add(lblEdad);

		JLabel lblSintomas = new JLabel("Síntomas");
		lblSintomas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSintomas.setBounds(97, 223, 68, 14);
		add(lblSintomas);

		JLabel lblVacunas = new JLabel("Vacunas");
		lblVacunas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVacunas.setBounds(97, 250, 68, 14);
		add(lblVacunas);

		txtVacunas = new JTextField();
		txtVacunas.setColumns(10);
		txtVacunas.setBounds(187, 247, 285, 20);
		add(txtVacunas);

		cmbClase = new JComboBox();
		cmbClase.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// Controlamos que el combo tenga contenido
				if (cmbClase.getSelectedItem() != null) {
					String id = cmbClase.getSelectedItem().toString();
					// Queremos seleccionar el id (va desde el índice 0 hasta el índice de la
					// primera coma)
					id = id.substring(0, id.indexOf(","));
					// System.out.println("El id es: *" + id + "*");

					// Llamamos al método que rellena los JTextFields
					cargaDatosDesdeElComboAJTextFields(id);
				}
			}
		});
		cmbClase.setBounds(633, 95, 169, 21);
		add(cmbClase);

		JLabel lblIdDeLa = new JLabel("Id de la Mascota (clase)");
		lblIdDeLa.setBounds(475, 95, 148, 14);
		add(lblIdDeLa);

		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre_1.setBounds(512, 144, 46, 14);
		add(lblNombre_1);

		txtNombreClase = new JTextField();
		txtNombreClase.setColumns(10);
		txtNombreClase.setBounds(580, 141, 86, 20);
		add(txtNombreClase);

		txtTipoClase = new JTextField();
		txtTipoClase.setColumns(10);
		txtTipoClase.setBounds(580, 166, 86, 20);
		add(txtTipoClase);

		JLabel lblTipoAnimal_1 = new JLabel("Tipo de animal");
		lblTipoAnimal_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoAnimal_1.setBounds(469, 169, 89, 14);
		add(lblTipoAnimal_1);

		JLabel lblEdad_1 = new JLabel("Edad");
		lblEdad_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEdad_1.setBounds(490, 195, 68, 14);
		add(lblEdad_1);

		txtEdadClase = new JTextField();
		txtEdadClase.setColumns(10);
		txtEdadClase.setBounds(580, 192, 86, 20);
		add(txtEdadClase);

		JLabel lblSintomas_1 = new JLabel("Síntomas");
		lblSintomas_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSintomas_1.setBounds(490, 223, 68, 14);
		add(lblSintomas_1);

		txtSintomasClase = new JTextField();
		txtSintomasClase.setColumns(10);
		txtSintomasClase.setBounds(580, 220, 285, 20);
		add(txtSintomasClase);

		JLabel lblVacunas_1 = new JLabel("Vacunas");
		lblVacunas_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVacunas_1.setBounds(490, 250, 68, 14);
		add(lblVacunas_1);

		txtVacunasClase = new JTextField();
		txtVacunasClase.setColumns(10);
		txtVacunasClase.setBounds(580, 247, 285, 20);
		add(txtVacunasClase);

		JButton btnBorrarClase = new JButton("Borrar");
		btnBorrarClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Llamamos al método borrar de la clase Bbdd_Control con el id del JComboBox
				Bbdd_Control bdc = new Bbdd_Control();
				Mascotas m = new Mascotas();

				// Seleccionamos únicamente el id del combo
				String id = cmbClase.getSelectedItem().toString();
				id = id.substring(0, id.indexOf(","));

				m.setIdMascota(Integer.parseInt(id));
				int valor = JOptionPane.showConfirmDialog(null, "Borrar mascota");
				if (valor == JOptionPane.OK_OPTION) {
					bdc.borraDatos(m);

					// Una vez borrada la mascota vaciamos los JTextField
					txtNombreClase.setText("");
					txtTipoClase.setText("");
					txtEdadClase.setText("");
					txtSintomasClase.setText("");
					txtVacunasClase.setText("");

					// Volvemos a cargar el combo
					cmbClase.removeAllItems();
					cargaComboClase();
				}
			}
		});
		btnBorrarClase.setBounds(580, 290, 89, 23);
		add(btnBorrarClase);

	}

	public void cargaCombo() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select * from mascotas");
			Mascotas m = null;

			while (registro.next()) {
				m = new Mascotas();
				m.setIdMascota(registro.getInt("idMascota"));
				m.setTipoAnimal(registro.getString("tipoAnimal"));
				m.setNombre(registro.getString("nombre"));
				m.setDescripcionSintomas(registro.getString("descripcionSintomas"));
				m.setEdad(registro.getInt("edad"));
				m.setVacunas(registro.getString("vacunas"));

				cmbId.addItem(m);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Cargamos el id, tipo y nombre de la mascota
	public void cargaComboClase() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select idMascota, tipoAnimal, nombre from mascotas");
			String cadena = null;

			while (registro.next()) {
				cadena = registro.getString("idMascota").concat(", ")
						.concat(registro.getString("tipoAnimal").concat(", ").concat(registro.getString("nombre")));

				cmbClase.addItem(cadena);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void cargaDatosDesdeElComboAJTextFields(String id) {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select * from mascotas where idMascota=" + id);

			if (registro.next()) {
				txtNombreClase.setText(registro.getString("nombre"));
				txtTipoClase.setText(registro.getString("tipoAnimal"));
				txtEdadClase.setText(registro.getString("edad"));
				txtSintomasClase.setText(registro.getString("descripcionSintomas"));
				txtVacunasClase.setText(registro.getString("vacunas"));
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
