package ejercicioUno;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Utilidades {
	
	public static void CargarComboBox(String[] ListadoTipoHabitacion, JComboBox<String> ComboBox) {

		for (String item : ListadoTipoHabitacion) {
			
			ComboBox.addItem(item);
		}
	}
	
	public static void MostarLista(ArrayList<Habitacion>Listado) {
		
		for (Habitacion object : Listado) {
			
			System.out.println(object.toString());
		}
	}
	
	
	public static String CheckBoxSeleccionados(JPanel panelContenedor) {
		
		String CheckBoxSeleccionados = "";
		
		for (Component Componente : panelContenedor.getComponents()) {
			
			if(Componente instanceof JCheckBox) {
				if(((JCheckBox) Componente).isSelected()) CheckBoxSeleccionados+=((JCheckBox) Componente).getText()+" ";
	       }
		}
	
		return CheckBoxSeleccionados;
	}
		
	 public static int Confirmacion(String pregunta) {
		 
		 return JOptionPane.showConfirmDialog (null, pregunta ,"Advertencia", JOptionPane.YES_NO_OPTION);
		 
	 }
	 

	public static void LimpiarCheckBox(JPanel panelContenedor) {
					
			for (Component Componente : panelContenedor.getComponents()) {
				
				if(Componente instanceof JCheckBox) {
					((JCheckBox) Componente).setSelected(false);
		       }
			}
	}
	
	public static void LimpiarTextBox(JTextField TextBox) {
		
			TextBox.setText("");
	}
	
    public static void LimpiarFormulario(JPanel panelContenedor,JTextField TextBox) {
    	
    	LimpiarCheckBox(panelContenedor);
    	LimpiarTextBox(TextBox);
    }
	
}
	
