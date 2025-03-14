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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class BorraDatos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox cmbId;
	private JTextField txtBorrarMascota;

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
		txtBorrarMascota.setBounds(538, 32, 169, 22);
		add(txtBorrarMascota);
		txtBorrarMascota.setColumns(10);
		
		JTextArea txtrIdDeLa = new JTextArea();
		txtrIdDeLa.setFont(new Font("Monospaced", Font.BOLD, 15));
		txtrIdDeLa.setText("Id de la mascota a borrar");
		txtrIdDeLa.setBounds(27, 73, 247, 22);
		add(txtrIdDeLa);
		
		cmbId = new JComboBox();
		
		cmbId.setBounds(308, 77, 62, 21);
		add(cmbId);
		
		JButton btnNewButton = new JButton("Borrar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mascotas m = new Mascotas();
				
				m.setIdMascota(Integer.parseInt(cmbId.getSelectedItem().toString()));
				if (mibbdd.borraDatos(m)==1) {
					JOptionPane.showMessageDialog(null, "Mascota borrada correctamente");
				}else {
					JOptionPane.showMessageDialog(null, "Fallo al eliminar mascota");
				}
			}
		});
		btnNewButton.setBounds(564, 68, 129, 38);
		add(btnNewButton);

	}
	
	public void cargaCombo() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select idMascota " + "from mascotas");

			while (registro.next()) {
				cmbId.addItem(registro.getInt("idMascota"));

			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
