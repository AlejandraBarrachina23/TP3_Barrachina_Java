package ejercicioUno;
import javax.swing.JList;
import javax.swing.JTextField;

public class Validar {

	public static void IntervalosNumericos(JTextField TextBox, int ValorUno, int ValorDos) throws Exception {
		
				TextBoxVacio(TextBox);
				int Numero = Integer.parseInt(TextBox.getText().trim());
				if(Numero<ValorUno || Numero >ValorDos) throw new Exception("Solo se aceptan valores numéricos del " + ValorUno +  " al "+ ValorDos);
	       
		}
	
	public static void TextBoxVacio(JTextField TextBox) throws Exception {
		
		if(TextBox.getText().trim().isEmpty()) throw new Exception("Complete el campo");
		
		
	}
	
	public static void ListaVacia(JList Listado) throws Exception {
		
		if(Listado.getSelectedIndex()==-1) throw new Exception("La lista esta vacia");
		
	}
}
