package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Ejecutador;
import modelo.Jugador;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTable tablaJugadores;
	DefaultTableModel modeloTabla = new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */
	public static void cargaVentana(Ventana frame) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		setTitle("Deportistas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 26, 368, 90);
		contentPane.add(scrollPane);
		
		tablaJugadores = new JTable();
		scrollPane.setViewportView(tablaJugadores);
		
		modeloTabla.setColumnIdentifiers(new Object[]{"Nombre", "Deporte", "Tiempo"});
		tablaJugadores.setModel(modeloTabla);
		
		Ejecutador e = new Ejecutador();
		modeloTabla.setRowCount(0);
		
		for(Jugador j : e.cargandoJugadores()){
			modeloTabla.addRow(new Object[]{
					j.getNombre(),
					j.getDeporte(),
					j.getTiempo()
			});
		}
	}

}
