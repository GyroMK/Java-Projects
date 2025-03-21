package vista;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.Bbdd_Control;
import modelo.Waifus;
import modelo.Waifus;

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
	private JComboBox<Waifus> cmbId;
	private JTextField txtBorrarMascota;
	private JTextField txtNombre;
	private JTextField txtTipo;
	private JTextField txtEdad;
	private JTextField txtAnime;
	private JTextField txtFecha;
	private JTextField txtApellido;
	private boolean isUpdatingCombo = false;

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
		txtBorrarMascota.setBounds(141, 31, 169, 22);
		add(txtBorrarMascota);
		txtBorrarMascota.setColumns(10);

		cmbId = new JComboBox<>();
        cmbId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (!isUpdatingCombo && e.getStateChange() == ItemEvent.SELECTED) {
                    Waifus m = (Waifus) cmbId.getSelectedItem();
                    if (m != null) {
                        txtNombre.setText(m.getNombre());
                        txtApellido.setText(m.getApellido());
                        txtTipo.setText(m.getTipo());
                        txtEdad.setText(m.getEdad() + "");
                        txtAnime.setText(m.getAnime());
                        txtFecha.setText(m.getFecha_nacimiento());
                    } else {
                        txtNombre.setText("");
                        txtApellido.setText("");
                        txtTipo.setText("");
                        txtEdad.setText("");
                        txtAnime.setText("");
                        txtFecha.setText("");
                    }
                }
            }
        });
		cmbId.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				String cadena = null;
				if (value instanceof Waifus) {
					Waifus m = (Waifus) value;
					cadena = m.getId() + ", " + m.getTipo() + ", " + m.getNombre();
					setText(cadena);
				}
				return this;
			}
		});
		cmbId.setBounds(270, 95, 169, 21);
		add(cmbId);

		JLabel lblId = new JLabel("Id de la Mascota ");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(28, 95, 232, 14);
		add(lblId);

		// In the constructor, modify the button ActionListener
		JButton btnBorrar = new JButton("Borrar");
        btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object selectedItem = cmbId.getSelectedItem();
                if (selectedItem instanceof Waifus) {
                    Waifus selectedWaifu = (Waifus) selectedItem;
                    int id = selectedWaifu.getId();
                    System.out.println("ID seleccionado: " + id);

                    int valor = JOptionPane.showConfirmDialog(null, "¿Borrar mascota?");
                    if (valor == JOptionPane.OK_OPTION) {
                        Bbdd_Control bdc = new Bbdd_Control();
                        bdc.borraDatos(selectedWaifu);

                        isUpdatingCombo = true;
                        cmbId.removeAllItems();
                        cargaCombo();
                        isUpdatingCombo = false;

                        txtNombre.setText("");
                        txtApellido.setText("");
                        txtTipo.setText("");
                        txtEdad.setText("");
                        txtAnime.setText("");
                        txtFecha.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione una mascota para borrar.");
                }
            }
        });

		// Modify the ItemListener to handle null cases
		cmbId.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            Object selected = cmbId.getSelectedItem();
		            if (selected instanceof Waifus) {
		                Waifus m = (Waifus) selected;
		                txtNombre.setText(m.getNombre() != null ? m.getNombre() : "");
		                txtApellido.setText(m.getApellido() != null ? m.getApellido() : "");
		                txtTipo.setText(m.getTipo() != null ? m.getTipo() : "");
		                txtEdad.setText(String.valueOf(m.getEdad()));
		                txtAnime.setText(m.getAnime() != null ? m.getAnime() : "");
		                txtFecha.setText(m.getFecha_nacimiento() != null ? m.getFecha_nacimiento() : "");
		            }
		        }
		    }
		});
		btnBorrar.setBounds(187, 317, 89, 23);
		add(btnBorrar);

		txtNombre = new JTextField();
		txtNombre.setBounds(187, 141, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtTipo = new JTextField();
		txtTipo.setBounds(195, 205, 86, 20);
		add(txtTipo);
		txtTipo.setColumns(10);

		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(195, 231, 86, 20);
		add(txtEdad);

		txtAnime = new JTextField();
		txtAnime.setColumns(10);
		txtAnime.setBounds(195, 259, 285, 20);
		add(txtAnime);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(119, 144, 46, 14);
		add(lblNombre);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(84, 208, 89, 14);
		add(lblTipo);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEdad.setBounds(105, 234, 68, 14);
		add(lblEdad);

		JLabel lblAnime = new JLabel("Anime");
		lblAnime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAnime.setBounds(105, 262, 68, 14);
		add(lblAnime);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setBounds(105, 289, 68, 14);
		add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(195, 286, 285, 20);
		add(txtFecha);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setBounds(119, 177, 49, 14);
		add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(190, 174, 86, 20);
		add(txtApellido);

	}

	public void cargaCombo() {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/waifudb", "root", "");
			Statement consulta = conexion.createStatement();
			ResultSet registro = consulta.executeQuery("select * from waifus");
			Waifus m = null;

			while (registro.next()) {
				m = new Waifus();
				m.setId(registro.getInt("id"));
				m.setTipo(registro.getString("tipo"));
				m.setNombre(registro.getString("nombre"));
				m.setApellido(registro.getString("apellido"));
				m.setAnime(registro.getString("anime"));
				m.setEdad(registro.getInt("edad"));
				m.setFecha_nacimiento(registro.getString("fecha_nacimiento"));

				cmbId.addItem(m);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}