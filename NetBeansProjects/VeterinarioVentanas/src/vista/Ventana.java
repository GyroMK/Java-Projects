package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.CardLayout;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 669);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu Opciones = new JMenu("Opciones");
		menuBar.add(Opciones);
		
		JMenuItem itemInsertar = new JMenuItem("Insertar");
		itemInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertarDatos insertaDatos = new InsertarDatos();
				cambiaPanel(insertaDatos);
			}
		});
		Opciones.add(itemInsertar);
		
		JMenuItem itemBorrar = new JMenuItem("Borrar");
		itemBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorraDatos borraDatos = new BorraDatos();
				borraDatos.cargaCombo();
				cambiaPanel(borraDatos);
			}
		});
		Opciones.add(itemBorrar);
		
		JMenuItem itemConsulta = new JMenuItem("Consultar");
		itemConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consulta consulta = new Consulta();
				consulta.cargaComboId();
				consulta.cargaComboNombre();
				consulta.cargaComboEspecie();
				
				cambiaPanel(consulta);
			}
		});
		Opciones.add(itemConsulta);
		
		JMenuItem itemModificar = new JMenuItem("Modificar");
		itemModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificaDatos modifica = new ModificaDatos();
				cambiaPanel(modifica);
			}
		});
		Opciones.add(itemModificar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
	}
	
	public void cambiaPanel(JPanel nuevoPanel) {
		contentPane.removeAll();
		contentPane.add(nuevoPanel);
		contentPane.repaint();
		contentPane.revalidate();
	}

}
