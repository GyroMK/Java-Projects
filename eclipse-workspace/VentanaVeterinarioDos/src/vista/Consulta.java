package vista;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import controlador.Bbdd_Control;
import modelo.Waifus;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Consulta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox cmbId;
	private JComboBox cmbNombre;
	private JComboBox cmbTipoAnimal;
	private JTable tablaMascotas;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	private JLabel lblEspecie;

	public Consulta() {
		setLayout(null);

		cmbId = new JComboBox();
		cmbId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaTablaId();
			}
		});
		cmbId.setBounds(110, 49, 166, 21);
		add(cmbId);

		cmbNombre = new JComboBox();
		cmbNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaTablaNombre();
			}
		});
		cmbNombre.setBounds(378, 49, 166, 21);
		add(cmbNombre);

		cmbTipoAnimal = new JComboBox();
		cmbTipoAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaTablaEspecie();
			}
		});
		cmbTipoAnimal.setBounds(643, 49, 166, 21);
		add(cmbTipoAnimal);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 116, 751, 296);
		add(scrollPane);

		tablaMascotas = new JTable();
		scrollPane.setViewportView(tablaMascotas);
		tablaMascotas.setBackground(new Color(255, 182, 193));
		tablaMascotas.setForeground(new Color(0, 0, 0));
		modeloTabla.setColumnIdentifiers(new Object[] { "Id", "Nombre", "Especie", "Edad", "Síntomas", "Vacunas" });
		tablaMascotas.setModel(modeloTabla);

		JLabel lblId = new JLabel("Id Mascota");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(10, 52, 79, 14);
		add(lblId);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(289, 52, 79, 14);
		add(lblNombre);

		lblEspecie = new JLabel("Especie");
		lblEspecie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEspecie.setBounds(554, 52, 79, 14);
		add(lblEspecie);

		modeloTabla.setRowCount(0);

	}

	public void cargaTablaId() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
			Statement consulta = conexion.createStatement();
			if (cmbId.getSelectedItem().toString().equals("Selecciona una Id")) {
				modeloTabla.setRowCount(0);
			} else {
				ResultSet registro = consulta
						.executeQuery("select idMascota, nombre, tipoAnimal, edad, descripcionSintomas, vacunas "
								+ "from mascotas " + "where idMascota = " + cmbId.getSelectedItem());

				modeloTabla.setRowCount(0);

				while (registro.next()) {
					modeloTabla.addRow(new Object[] {

							registro.getInt("idMascota"), registro.getString("nombre"),
							registro.getString("tipoAnimal"), registro.getInt("edad"),
							registro.getString("descripcionSintomas"), registro.getString("vacunas"), });
				}
			}

			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void cargaTablaNombre() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
			Statement consulta = conexion.createStatement();
			if (cmbNombre.getSelectedItem().toString().equals("Selecciona un nombre")) {
				modeloTabla.setRowCount(0);
			} else {

				ResultSet registro = consulta
						.executeQuery("select idMascota, nombre, tipoAnimal, edad, descripcionSintomas, vacunas "
								+ "from mascotas " + "where nombre = '" + cmbNombre.getSelectedItem() + "'");

				modeloTabla.setRowCount(0);

				while (registro.next()) {
					modeloTabla.addRow(new Object[] {

							registro.getInt("idMascota"), registro.getString("nombre"),
							registro.getString("tipoAnimal"), registro.getInt("edad"),
							registro.getString("descripcionSintomas"), registro.getString("vacunas"), });
				}
			}

			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void cargaTablaEspecie() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
			Statement consulta = conexion.createStatement();

			if (cmbTipoAnimal.getSelectedItem().toString().equals("Selecciona una especie")) {
				modeloTabla.setRowCount(0); // Vacía la tabla
			} else {
				Bbdd_Control bd = new Bbdd_Control();
				ArrayList<Waifus> arrLMascotas = new ArrayList<>();
				Waifus miMascota = new Waifus();

				modeloTabla.setRowCount(0);

				// Guardamos en el atributo tipoAnimal el contenido del JComboBox de TipoAnimal
				miMascota.setTipoAnimal(cmbTipoAnimal.getSelectedItem().toString());

				// Pasamos como parámetro el tipoAnimal y recogemos en arrLMascotas el resultado de la consulta
				arrLMascotas = bd.consultaMascotasConFiltro(miMascota);

				// Recorremos el arrLMascotas y lo mostramos en el JTable
				for (Waifus mascotaActual : arrLMascotas) {
					modeloTabla.addRow(new Object[] {
							mascotaActual.getIdMascota(), 
							mascotaActual.getNombre(),
							mascotaActual.getTipoAnimal(), 
							mascotaActual.getEdad(),
							mascotaActual.getDescripcionSintomas(), 
							mascotaActual.getVacunas() 
					});
				}

				/*
				 * ResultSet registro = consulta
				 * .executeQuery("select idMascota, nombre, tipoAnimal, edad, descripcionSintomas, vacunas "
				 * + "from mascotas " + "where tipoAnimal = '" + cmbTipoAnimal.getSelectedItem()
				 * + "'");
				 * 
				 * 
				 * while (registro.next()) { modeloTabla.addRow(new Object[] {
				 * 
				 * registro.getInt("idMascota"), registro.getString("nombre"),
				 * registro.getString("tipoAnimal"), registro.getInt("edad"),
				 * registro.getString("descripcionSintomas"), registro.getString("vacunas"), });
				 * }
				 */
			}

			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void cargaComboId() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select idMascota " + "from mascotas");
			cmbId.addItem("Selecciona una Id");

			while (registro.next()) {
				cmbId.addItem(registro.getInt("idMascota"));

			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void cargaComboNombre() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select nombre " + "from mascotas");
			cmbNombre.addItem("Selecciona un nombre");

			while (registro.next()) {
				cmbNombre.addItem(registro.getNString("nombre"));

			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void cargaComboEspecie() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select distinct (tipoAnimal) " + "from mascotas");
			cmbTipoAnimal.addItem("Selecciona una especie");

			while (registro.next()) {
				cmbTipoAnimal.addItem(registro.getString("tipoAnimal"));

			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
