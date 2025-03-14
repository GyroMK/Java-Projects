package vista;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Consulta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox cmbId;
	private JComboBox cmbNombre;
	private JComboBox cmbTipoAnimal;
	private JTable tablaMascotas;
	DefaultTableModel modeloTabla= new DefaultTableModel();
	
	public Consulta() {
		setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 954, 24);
		add(toolBar);
		
		cmbId = new JComboBox();
		cmbId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaTablaId();
			}
		});
		cmbId.setBounds(110, 49, 166, 21);
		add(cmbId);
		
		JRadioButton radioId = new JRadioButton("Id");
		radioId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaComboId();
			}
		});
		radioId.setBounds(58, 49, 46, 21);
		add(radioId);
		
		JRadioButton radioNombre = new JRadioButton("Nombre");
		radioNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaComboNombre();
			}
		});
		radioNombre.setBounds(296, 49, 76, 21);
		add(radioNombre);
		
		cmbNombre = new JComboBox();
		cmbNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaTablaNombre();
			}
		});
		cmbNombre.setBounds(378, 49, 166, 21);
		add(cmbNombre);
		
		
		JRadioButton rdbtnEspecie = new JRadioButton("Especie");
		rdbtnEspecie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaComboEspecie();
			}
		});
		rdbtnEspecie.setBounds(561, 49, 76, 21);
		add(rdbtnEspecie);
		
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
		modeloTabla.setColumnIdentifiers(new Object[] {"Id","Nombre","Especie","Edad","Síntomas","Vacunas"});
		tablaMascotas.setModel(modeloTabla);
		
		modeloTabla.setRowCount(0);

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
		public void cargaTablaId() {
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
				Statement consulta = conexion.createStatement();
				if (cmbId.getSelectedItem().toString().equals("Selecciona una Id")) {
					System.out.println("No bien ID");
					modeloTabla.setRowCount(0);
				}else {
					ResultSet registro = consulta.executeQuery("select idMascota, nombre, tipoAnimal, edad, descripcionSintomas, vacunas "
							+ "from mascotas "
							+ "where idMascota = " + cmbId.getSelectedItem());

					modeloTabla.setRowCount(0);

					while (registro.next()) {
						modeloTabla.addRow(new Object[] {
							
							registro.getInt("idMascota"),
							registro.getString("nombre"),
							registro.getString("tipoAnimal"),
							registro.getInt("edad"),
							registro.getString("descripcionSintomas"),
							registro.getString("vacunas"),
						});
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
					System.out.println("No bien NOMBRE");
					modeloTabla.setRowCount(0);
				}else {

					ResultSet registro = consulta.executeQuery("select idMascota, nombre, tipoAnimal, edad, descripcionSintomas, vacunas "
							+ "from mascotas "
							+ "where nombre = '" + cmbNombre.getSelectedItem() + "'");
					
					modeloTabla.setRowCount(0);
					
					while (registro.next()) {
						modeloTabla.addRow(new Object[] {
								
								registro.getInt("idMascota"),
								registro.getString("nombre"),
								registro.getString("tipoAnimal"),
								registro.getInt("edad"),
								registro.getString("descripcionSintomas"),
								registro.getString("vacunas"),
						});
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
					System.out.println("No bien TIPO ANIMAL");
					modeloTabla.setRowCount(0);
				} else {
					ResultSet registro = consulta.executeQuery("select idMascota, nombre, tipoAnimal, edad, descripcionSintomas, vacunas "
							+ "from mascotas "
							+ "where tipoAnimal = '" + cmbTipoAnimal.getSelectedItem()+"'");
					
					modeloTabla.setRowCount(0);
					
					while (registro.next()) {
						modeloTabla.addRow(new Object[] {
								
								registro.getInt("idMascota"),
								registro.getString("nombre"),
								registro.getString("tipoAnimal"),
								registro.getInt("edad"),
								registro.getString("descripcionSintomas"),
								registro.getString("vacunas"),
						});
					}

				}
				
				
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
}
