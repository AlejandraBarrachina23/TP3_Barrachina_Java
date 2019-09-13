package ejercicioUno;
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
}
