package ejercicioUno;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class ListadoHabitaciones extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tboxID;
	private JTextField tboxCantidadPersonas;
	private String[] ListadoTipoHabitacion = {"Simple","Triple","Doble","Cuadruple","Suite"};
	private DefaultListModel <Habitacion> ModeloHabitaciones;
	private JList <Habitacion> lstReservas;
	
	public ListModel<Habitacion> getModeloHabitaciones() {
		return ModeloHabitaciones;
	}
	
	public ListadoHabitaciones() {

		setLayout(null);
		ValidarSoloNumeros validaSoloNumero = new ValidarSoloNumeros();
		JLabel lblListadoDeHabitaciones = new JLabel("Listado de Habitaciones reservadas");
		lblListadoDeHabitaciones.setBounds(10, 11, 398, 14);
		add(lblListadoDeHabitaciones);
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 279, 24, 14);
		add(lblId);
		JLabel lblCantPersonas = new JLabel("CANT. PERSONAS");
		lblCantPersonas.setBounds(68, 279, 112, 14);
		add(lblCantPersonas);
		JLabel lblTipoDeHabitacion = new JLabel("TIPO DE HABITACI\u00D3N");
		lblTipoDeHabitacion.setBounds(172, 279, 135, 14);
		add(lblTipoDeHabitacion);
		tboxID = new JTextField();
		tboxID.setEnabled(false);
		tboxID.setBounds(10, 297, 47, 20);
		add(tboxID);
		tboxID.setColumns(10);
		tboxCantidadPersonas = new JTextField();
		tboxCantidadPersonas.setColumns(10);
		tboxCantidadPersonas.setBounds(68, 297, 91, 20);
		tboxCantidadPersonas.addKeyListener(validaSoloNumero);
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
		lstReservas = new JList<Habitacion>();		
		lstReservas.setBounds(10, 36, 482, 227);
		add(lstReservas);
		lstReservas.addListSelectionListener(new ListSelectionListener() {
			
		public void valueChanged(ListSelectionEvent e) {
				
				if(lstReservas.getSelectedValue()==null)return;
				tboxID.setText(Integer.toString(lstReservas.getSelectedValue().getID()));
				tboxCantidadPersonas.setText(Integer.toString(lstReservas.getSelectedValue().getCantidadPersonas()));
				cboxTipoHabitacion.setSelectedItem(lstReservas.getSelectedValue().getTipoHabitacion().toString());		
			
			}
		});
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					
					Validar.ListaVacia(lstReservas);
					if(Utilidades.Confirmacion("¿Esta seguro que desea modificar la reserva?")==0) {
						Validar.IntervalosNumericos(tboxCantidadPersonas, 1, 5);
						Habitacion habitacionAModificar = new Habitacion();
						habitacionAModificar = lstReservas.getSelectedValue();
						habitacionAModificar.setNuevaHabitacion(tboxCantidadPersonas.getText(), cboxTipoHabitacion.getSelectedItem().toString(), habitacionAModificar.getListadoServicios());
						ModeloHabitaciones.set(ModeloHabitaciones.indexOf(habitacionAModificar), habitacionAModificar);
						JOptionPane.showMessageDialog(null, "Reserva modificada con éxito");
						lstReservas.setSelectedIndex(0);
					}
				} catch (Exception excepcion) {
					
					JOptionPane.showMessageDialog(null, excepcion.getMessage());
				}
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			try {
				
				Validar.ListaVacia(lstReservas);
				if(Utilidades.Confirmacion("¿Esta seguro que desea eliminar la reserva?")==0) {
					ModeloHabitaciones.remove(lstReservas.getSelectedIndex());
					JOptionPane.showMessageDialog(null, "Reserva ha sido eliminada con éxito");
				
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
		lstReservas.setModel(this.ModeloHabitaciones);
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
}


