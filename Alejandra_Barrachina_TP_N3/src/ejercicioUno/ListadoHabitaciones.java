package ejercicioUno;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class ListadoHabitaciones extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tboxID;
	private JTextField tboxCantidadPersonas;
	private String[] ListadoTipoHabitacion = {"Simple","Triple","Doble","Cuadruple","Suite"};	

	public ListadoHabitaciones() {
		setLayout(null);
		
		JLabel lblListadoDeHabitaciones = new JLabel("Listado de Habitaciones reservadas");
		lblListadoDeHabitaciones.setBounds(10, 11, 398, 14);
		add(lblListadoDeHabitaciones);
		
		JList lstReservas = new JList();
		lstReservas.setBounds(10, 36, 482, 227);
		add(lstReservas);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 279, 24, 14);
		add(lblId);
		
		JLabel lblCantPersonas = new JLabel("CANT. PERSONAS");
		lblCantPersonas.setBounds(68, 279, 112, 14);
		add(lblCantPersonas);
		
		JLabel lblTipoDeHabitacin = new JLabel("TIPO DE HABITACI\u00D3N");
		lblTipoDeHabitacin.setBounds(172, 279, 135, 14);
		add(lblTipoDeHabitacin);
		
		tboxID = new JTextField();
		tboxID.setBounds(10, 297, 47, 20);
		add(tboxID);
		tboxID.setColumns(10);
		
		tboxCantidadPersonas = new JTextField();
		tboxCantidadPersonas.setColumns(10);
		tboxCantidadPersonas.setBounds(68, 297, 91, 20);
		add(tboxCantidadPersonas);
		
		JComboBox <String> cboxTipoHabitacion = new JComboBox<String>();
		cboxTipoHabitacion.setBounds(169, 297, 130, 20);
		Utilidades.CargarComboBox(ListadoTipoHabitacion, cboxTipoHabitacion);
		
		add(cboxTipoHabitacion);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(309, 296, 89, 23);
		add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(403, 296, 89, 23);
		add(btnEliminar);

	}
}
