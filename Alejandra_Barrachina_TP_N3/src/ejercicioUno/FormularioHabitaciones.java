package ejercicioUno;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioHabitaciones extends JFrame {

	private JPanel pnlPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioHabitaciones frame = new FormularioHabitaciones();
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
	public FormularioHabitaciones() {
		setTitle("Habitaciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 300);
		
		
		JMenuBar menuHabitaciones = new JMenuBar();
		setJMenuBar(menuHabitaciones);
		JMenu mnHabitaciones = new JMenu("Habitaciones");
		menuHabitaciones.add(mnHabitaciones);
		JMenuItem mntmAgregarReserva = new JMenuItem("Agregar Reserva");
		
		mntmAgregarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AgregarReserva formularioAgregarReserva = new AgregarReserva();
				pnlPrincipal.add(formularioAgregarReserva);
				pnlPrincipal.repaint();
				pnlPrincipal.revalidate();
			}
		});
		mnHabitaciones.add(mntmAgregarReserva);
		JMenuItem mntmListarReservas = new JMenuItem("Listar Reservas");
		mnHabitaciones.add(mntmListarReservas);
		pnlPrincipal = new JPanel();
		pnlPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(pnlPrincipal);
		
	
	}

}
