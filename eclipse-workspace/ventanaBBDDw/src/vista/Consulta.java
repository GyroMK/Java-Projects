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
	private JComboBox cmbAnime;
	private JComboBox cmbTipo;
	private JTable tablaWaifus;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	private JLabel lblTipo;

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

		cmbAnime = new JComboBox();
		cmbAnime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaTablaNombre();
			}
		});
		cmbAnime.setBounds(378, 49, 166, 21);
		add(cmbAnime);

		cmbTipo = new JComboBox();
		cmbTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaTablaEspecie();
			}
		});
		cmbTipo.setBounds(643, 49, 166, 21);
		add(cmbTipo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 116, 751, 296);
		add(scrollPane);

		tablaWaifus = new JTable();
		scrollPane.setViewportView(tablaWaifus);
		tablaWaifus.setBackground(new Color(255, 182, 193));
		tablaWaifus.setForeground(new Color(0, 0, 0));
		modeloTabla.setColumnIdentifiers(new Object[] { "Id", "Nombre", "Apellido", "Edad", "Tipo", "Anime", "Fecha" });
		tablaWaifus.setModel(modeloTabla);

		JLabel lblId = new JLabel("Id");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(10, 52, 79, 14);
		add(lblId);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(289, 52, 79, 14);
		add(lblNombre);

		lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(554, 52, 79, 14);
		add(lblTipo);

		modeloTabla.setRowCount(0);

	}

	public void cargaTablaId() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/waifudb", "root", "");
			Statement consulta = conexion.createStatement();
			if (cmbId.getSelectedItem().toString().equals("Selecciona una Id")) {
				modeloTabla.setRowCount(0);
			} else {
				ResultSet registro = consulta
						.executeQuery("select id, nombre, apellido, edad, tipo, anime, fecha_nacimiento "
								+ "from waifus " + "where id = " + cmbId.getSelectedItem());

				modeloTabla.setRowCount(0);

				while (registro.next()) {
					modeloTabla.addRow(new Object[] {

							registro.getInt("id"), 
							registro.getString("nombre"),
							registro.getString("apellido"), 
							registro.getInt("edad"),
							registro.getString("tipo"), 
							registro.getString("anime"),
							registro.getString("fecha_nacimiento"), });
				}
			}

			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void cargaTablaNombre() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/waifudb", "root", "");
			Statement consulta = conexion.createStatement();
			if (cmbAnime.getSelectedItem().toString().equals("Selecciona un anime")) {
				modeloTabla.setRowCount(0);
			} else {

				ResultSet registro = consulta
						.executeQuery("select id, nombre, apellido, edad, tipo, anime, fecha_nacimiento "
								+ "from waifus " + "where anime= '" + cmbAnime.getSelectedItem() + "'");

				modeloTabla.setRowCount(0);

				while (registro.next()) {
					modeloTabla.addRow(new Object[] {

							registro.getInt("id"), 
							registro.getString("nombre"),
							registro.getString("apellido"), 
							registro.getInt("edad"),
							registro.getString("tipo"), 
							registro.getString("anime"),
							registro.getString("fecha_nacimiento"), });
				}
			}

			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void cargaTablaEspecie() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/waifudb", "root", "");
			Statement consulta = conexion.createStatement();

			if (cmbTipo.getSelectedItem().toString().equals("Selecciona un Tipo")) {
				modeloTabla.setRowCount(0); // Vacía la tabla
			} else {
				Bbdd_Control bd = new Bbdd_Control();
				ArrayList<Waifus> arrLWaifus = new ArrayList<>();
				Waifus miWaifu = new Waifus();

				modeloTabla.setRowCount(0);

				// Guardamos en el atributo tipoAnimal el contenido del JComboBox de TipoAnimal
				miWaifu.setTipo(cmbTipo.getSelectedItem().toString());

				// Pasamos como parámetro el tipoAnimal y recogemos en arrLMascotas el resultado de la consulta
				arrLWaifus = bd.consultaMascotasConFiltro(miWaifu);

				// Recorremos el arrLMascotas y lo mostramos en el JTable
				for (Waifus mascotaActual : arrLWaifus) {
					modeloTabla.addRow(new Object[] {
							mascotaActual.getId(), 
							mascotaActual.getNombre(),
							mascotaActual.getApellido(),
							mascotaActual.getEdad(),
							mascotaActual.getTipo(), 
							mascotaActual.getAnime(), 
							mascotaActual.getFecha_nacimiento() 
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
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/waifudb", "root", "");
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select id " + "from waifus");
			cmbId.addItem("Selecciona una Id");

			while (registro.next()) {
				cmbId.addItem(registro.getInt("id"));

			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void cargaComboNombre() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/waifudb", "root", "");
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select distinct (anime) " + "from waifus");
			cmbAnime.addItem("Selecciona un anime");

			while (registro.next()) {
				cmbAnime.addItem(registro.getNString("anime"));

			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void cargaComboEspecie() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/waifudb", "root", "");
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select distinct (tipo) " + "from waifus");
			cmbTipo.addItem("Selecciona una especie");

			while (registro.next()) {
				cmbTipo.addItem(registro.getString("tipo"));

			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
