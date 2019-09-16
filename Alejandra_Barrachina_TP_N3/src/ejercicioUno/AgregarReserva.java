package ejercicioUno;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class AgregarReserva extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel pnlServicios;
	private JTextField tboxCantidad;
	private JButton btnAceptar;
	private Habitacion unaNuevaHabitacion;
	private String[] ListadoTipoHabitacion = {"Simple","Triple","Doble","Cuadruple","Suite"};	
	//private static ArrayList<Habitacion> ListadoHabitaciones = new ArrayList<Habitacion>();
	private static DefaultListModel <Habitacion> ModeloHabitaciones;

	public AgregarReserva() {
		
		ValidarSoloNumeros validaSoloNumero = new ValidarSoloNumeros();
		setBorder(new TitledBorder(null, "Agregar Habitaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		JLabel lblCantidad = new JLabel("Cantidad: ");
		lblCantidad.setBounds(21, 38, 119, 14);
		add(lblCantidad);
		JLabel lblTipoDeHabitacin = new JLabel("Tipo de Habitaci\u00F3n: ");
		lblTipoDeHabitacin.setBounds(21, 76, 119, 14);
		add(lblTipoDeHabitacin);
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(204, 161, 89, 23);
		add(btnAceptar);
		JComboBox<String> cboxTipoHabitacion = new JComboBox<String>();
		cboxTipoHabitacion.setBounds(150, 73, 294, 20);
		Utilidades.CargarComboBox(ListadoTipoHabitacion, cboxTipoHabitacion);
		add(cboxTipoHabitacion);
		tboxCantidad = new JTextField();
		tboxCantidad.setBounds(150, 35, 294, 20);
		tboxCantidad.addKeyListener(validaSoloNumero);
		add(tboxCantidad);
		tboxCantidad.setColumns(10);
		pnlServicios = new JPanel();
		pnlServicios.setBounds(10, 114, 477, 23);
		add(pnlServicios);
		pnlServicios.setLayout(null);
		JLabel label = new JLabel("Servicios Adicionales: ");
		label.setBounds(0, 4, 119, 14);
		pnlServicios.add(label);
		JCheckBox checkBox = new JCheckBox("Wifi");
		checkBox.setBounds(125, 0, 50, 23);
		pnlServicios.add(checkBox);
		JCheckBox checkBox_1 = new JCheckBox("Desayuno");
		checkBox_1.setBounds(177, 0, 86, 23);
		pnlServicios.add(checkBox_1);
		JCheckBox checkBox_2 = new JCheckBox("Gimansio");
		checkBox_2.setBounds(274, 0, 89, 23);
		pnlServicios.add(checkBox_2);
		JCheckBox checkBox_3 = new JCheckBox("Sala de juegos");
		checkBox_3.setBounds(362, 0, 119, 23);
		pnlServicios.add(checkBox_3);
		btnAceptar.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
				
				try {
					
					Validar.IntervalosNumericos(tboxCantidad, 1, 5);
					if(Utilidades.Confirmacion("¿Esta seguro que desea agregar esta reserva?")==0) {
						unaNuevaHabitacion = new Habitacion();
						unaNuevaHabitacion.setNuevaHabitacion(tboxCantidad.getText(), cboxTipoHabitacion.getSelectedItem().toString(), Utilidades.CheckBoxSeleccionados(pnlServicios));
					    ModeloHabitaciones.addElement(unaNuevaHabitacion);
					    JOptionPane.showMessageDialog(null, "Reserva cargada con éxito");
					    Utilidades.LimpiarFormulario(pnlServicios, tboxCantidad);
					}
				} 
				
				catch (Exception excepcion) {
					
					JOptionPane.showMessageDialog(null, excepcion.getMessage());
				}
		
			}
		});

	}

	public void setModeloHabitaciones(DefaultListModel<Habitacion> modeloHabitaciones) {
		this.ModeloHabitaciones = modeloHabitaciones;
	}
}

class ValidarSoloNumeros extends KeyAdapter{
	  
	public void keyTyped(KeyEvent e) {
		
		char validar = e.getKeyChar();
		if(Character.isLetter(validar)) {
			e.consume();
			JOptionPane.showMessageDialog(null, "Solo se permiten numeros");
		} 
	}
}



