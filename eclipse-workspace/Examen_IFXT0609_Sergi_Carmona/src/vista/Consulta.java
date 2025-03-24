package vista;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import controlador.Bbdd_Control;
import modelo.Personajes;

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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Consulta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox cmbPeli;
	private JTable tablaPersonajes;
	DefaultTableModel modeloTabla = new DefaultTableModel();

	public Consulta() {
		setLayout(null);

		cmbPeli = new JComboBox();
		cmbPeli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargaTablaEspecie();
			}
		});
		cmbPeli.setBounds(444, 52, 166, 21);
		add(cmbPeli);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 116, 751, 296);
		add(scrollPane);

		tablaPersonajes = new JTable();
		scrollPane.setViewportView(tablaPersonajes);
		tablaPersonajes.setBackground(new Color(255, 182, 193));
		tablaPersonajes.setForeground(new Color(0, 0, 0));
		modeloTabla.setColumnIdentifiers(new Object[] { "Id", "Nombre", "Pelicula", "Primera vez", "Pareja" });
		tablaPersonajes.setModel(modeloTabla);

		JLabel lblPeli = new JLabel("Pelicula");
		lblPeli.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeli.setBounds(344, 55, 79, 14);
		add(lblPeli);

		JButton btnNewButton = new JButton("Guardar en fichero");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor = JOptionPane.showConfirmDialog(null, "¿quieres guaradar el personaje?");
				if (valor == JOptionPane.OK_OPTION) {
					File archivo = new File("personajes.txt");
					PrintWriter pw = null;

					try {
						pw = new PrintWriter(archivo);

						// Recorre la tabla y guarda cada fila en el archivo
						for (int i = 0; i < modeloTabla.getRowCount(); i++) {
							pw.println(modeloTabla.getValueAt(i, 0));
							pw.println(modeloTabla.getValueAt(i, 1));
							pw.println(modeloTabla.getValueAt(i, 2));
							pw.println(modeloTabla.getValueAt(i, 3));
							pw.println(modeloTabla.getValueAt(i, 4));
						}

						System.out.println("Guardado el archivo correctamente");

					} catch (FileNotFoundException r) {
						r.printStackTrace();
					} finally {
						if (pw != null) {
							pw.close();
						}
					}
				}
			}
		});

		btnNewButton.setBounds(386, 491, 184, 23);
		add(btnNewButton);

		modeloTabla.setRowCount(0);

	}

	public void cargaTablaEspecie() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/waifudb", "root", "");
			Statement consulta = conexion.createStatement();

			if (cmbPeli.getSelectedItem().toString().equals("Selecciona una Pelicula")) {
				modeloTabla.setRowCount(0); // Vacía la tabla
			} else {
				Bbdd_Control bd = new Bbdd_Control();
				ArrayList<Personajes> arrLPersonajes = new ArrayList<>();
				Personajes miPersonaje = new Personajes();

				modeloTabla.setRowCount(0);

				miPersonaje.setPelicula(cmbPeli.getSelectedItem().toString());

				arrLPersonajes = bd.consultaPersonajeConFiltro(miPersonaje);

				for (Personajes personajeActual : arrLPersonajes) {
					modeloTabla.addRow(new Object[] { personajeActual.getId(), personajeActual.getNombre(),
							personajeActual.getPelicula(), personajeActual.getPrimeraVez(),
							personajeActual.getPareja(), });
				}

			}

			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void cargaComboId() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/personajesDisney", "root", "");
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select distinct (pelicula) " + "from personajes");
			cmbPeli.addItem("Selecciona una Pelicula");

			while (registro.next()) {
				cmbPeli.addItem(registro.getString("pelicula"));

			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
