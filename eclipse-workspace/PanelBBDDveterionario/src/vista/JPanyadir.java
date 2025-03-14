package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JPanyadir extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField TextNombre;
	private JTextField TextTipo;
	private JTextField TextEdad;
	private JTextField TextSintomas;
	private JTextField TextVacunas;

	/**
	 * Create the panel.
	 */
	public JPanyadir() {
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(10, 29, 58, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo de Animal");
		lblNewLabel_2.setBounds(10, 54, 97, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Edad");
		lblNewLabel_3.setBounds(10, 79, 46, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sintomas");
		lblNewLabel_4.setBounds(10, 104, 58, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Vacunas");
		lblNewLabel_5.setBounds(10, 129, 58, 14);
		add(lblNewLabel_5);
		
		TextNombre = new JTextField();
		TextNombre.setBounds(66, 26, 86, 20);
		add(TextNombre);
		TextNombre.setColumns(10);
		
		TextTipo = new JTextField();
		TextTipo.setBounds(104, 51, 86, 20);
		add(TextTipo);
		TextTipo.setColumns(10);
		
		TextEdad = new JTextField();
		TextEdad.setBounds(42, 76, 86, 20);
		add(TextEdad);
		TextEdad.setColumns(10);
		
		TextSintomas = new JTextField();
		TextSintomas.setBounds(76, 101, 214, 20);
		add(TextSintomas);
		TextSintomas.setColumns(10);
		
		TextVacunas = new JTextField();
		TextVacunas.setBounds(66, 126, 214, 20);
		add(TextVacunas);
		TextVacunas.setColumns(10);
		
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/db_veterinario", "root", "");
		            Statement consulta = conexion.createStatement();
		            consulta.executeUpdate("insert into mascotas(nombre, tipoAnimal, edad, descripcionSintomas, vacunas) "
		                    + "values ('" + TextNombre.getText() + "', '"
		                    + TextTipo.getText() + "', "
		                    + Integer.parseInt(TextEdad.getText()) + ", '"
		                    + TextSintomas.getText() + "','"
		                    + TextVacunas.getText() + "')");
		            conexion.close();
		            System.out.println("Mascota guardada correctamente!!");

		        } catch (SQLException s) {
		            s.printStackTrace();
		        }
			}
		});
		btnNewButton.setBounds(285, 182, 89, 23);
		add(btnNewButton);

	}
}
