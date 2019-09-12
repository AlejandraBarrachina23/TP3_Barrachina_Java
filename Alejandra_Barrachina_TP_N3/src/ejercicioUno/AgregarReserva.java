package ejercicioUno;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class AgregarReserva extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tboxCantidad;
	private JButton btnAceptar;
	private String[] ListadoTipoHabitacion = {"Simple","Triple","Doble","Cuadruple","Suite"};	

	public AgregarReserva() {
		setBorder(new TitledBorder(null, "Agregar Habitaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblCantidad = new JLabel("Cantidad: ");
		lblCantidad.setBounds(21, 38, 119, 14);
		add(lblCantidad);
		
		JLabel lblTipoDeHabitacin = new JLabel("Tipo de Habitaci\u00F3n: ");
		lblTipoDeHabitacin.setBounds(21, 76, 119, 14);
		add(lblTipoDeHabitacin);
		
		JLabel lblServiciosAdicionales = new JLabel("Servicios Adicionales: ");
		lblServiciosAdicionales.setBounds(21, 121, 119, 14);
		add(lblServiciosAdicionales);
		
		JCheckBox chckbxWifi = new JCheckBox("Wifi");
		chckbxWifi.setBounds(146, 117, 50, 23);
		add(chckbxWifi);
		
		JCheckBox chckbxDesayuno = new JCheckBox("Desayuno");
		chckbxDesayuno.setBounds(198, 117, 86, 23);
		add(chckbxDesayuno);
		
		JCheckBox chckbxGimansio = new JCheckBox("Gimansio");
		chckbxGimansio.setBounds(295, 117, 89, 23);
		add(chckbxGimansio);
		
		JCheckBox chckbxSalaDeJuegos = new JCheckBox("Sala de juegos");
		chckbxSalaDeJuegos.setBounds(383, 117, 109, 23);
		add(chckbxSalaDeJuegos);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(204, 161, 89, 23);
		add(btnAceptar);
		
		JComboBox<String> cboxTipoHabitacion = new JComboBox<String>();
		cboxTipoHabitacion.setBounds(150, 73, 294, 20);
		Utilidades.CargarComboBox(ListadoTipoHabitacion, cboxTipoHabitacion);
		add(cboxTipoHabitacion);
		
		
		tboxCantidad = new JTextField();
		tboxCantidad.setBounds(150, 35, 294, 20);
		add(tboxCantidad);
		tboxCantidad.setColumns(10);

	}
}
