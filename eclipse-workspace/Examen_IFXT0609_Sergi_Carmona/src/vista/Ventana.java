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
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

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
		setTitle("Examen de Sergi Carmona");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 669);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu Opciones = new JMenu("Opciones");
		Opciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuBar.add(Opciones);
		
		JMenuItem itemInsertar = new JMenuItem("Insertar");
		itemInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertarDatos insertaDatos = new InsertarDatos();
				cambiaPanel(insertaDatos);
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Abrir Calculadora");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String[] listado = {"calc.exe", ""};
				Process procesos = Runtime.getRuntime().exec(listado);
				
				// waitFor - Detiene la ejecuci�n del programa que lanza el proceso a la espera de que este �ltimo termine
				int idProceso = procesos.waitFor();
				System.out.println("Fin de la ejecuci�n: " + idProceso);
			} catch (IOException r) {
				// TODO Auto-generated catch block
				r.printStackTrace();
			} catch (InterruptedException r) {
				// TODO Auto-generated catch block
				r.printStackTrace();
			
			}
			}
		});
		Opciones.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Abrir Bloc de notas");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String[] listado = {"notepad.exe", ""};
					Process procesos = Runtime.getRuntime().exec(listado);
					
					// waitFor - Detiene la ejecuci�n del programa que lanza el proceso a la espera de que este ultimo termine
					int idProceso = procesos.waitFor();
					System.out.println("Fin de la ejecuci�n: " + idProceso);
				} catch (IOException r) {
					// TODO Auto-generated catch block
					r.printStackTrace();
				} catch (InterruptedException r) {
					// TODO Auto-generated catch block
					r.printStackTrace();
				
				}
				
			}
		});
		Opciones.add(mntmNewMenuItem_1);
		
		JSeparator separator_1 = new JSeparator();
		Opciones.add(separator_1);
		Opciones.add(itemInsertar);
		
		JMenuItem itemConsulta = new JMenuItem("Consultar");
		itemConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consulta consulta = new Consulta();
				consulta.cargaComboId();
				
				cambiaPanel(consulta);
			}
		});
		Opciones.add(itemConsulta);
		
		JSeparator separator = new JSeparator();
		Opciones.add(separator);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Carrera Aleatoria");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carrera carrera = new carrera();
				
				cambiaPanel(carrera);
			}
		});
		Opciones.add(mntmNewMenuItem_2);
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
