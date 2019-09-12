package ejercicioUno;
import javax.swing.JComboBox;

public class Utilidades {
	
	public static void CargarComboBox(String[] ListadoTipoHabitacion, JComboBox<String> ComboBox) {

		for (String item : ListadoTipoHabitacion) {
			
			ComboBox.addItem(item);
		}
	}

}
