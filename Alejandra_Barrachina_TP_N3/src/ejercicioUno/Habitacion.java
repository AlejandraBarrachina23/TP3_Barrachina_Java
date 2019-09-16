package ejercicioUno;
public class Habitacion {

	private int ID;
	private int CantidadPersonas;
	private String TipoHabitacion;
	private String ListadoServicios;
	private static int CuentaId=0;

	Habitacion(){		
		
		CuentaId++;
		ID= CuentaId; 
	}

	public String toString() {
		
		return "ID: " + ID + " Cantidad de Personas: " + CantidadPersonas + " Tipo: " + TipoHabitacion + " Servicios: " + ListadoServicios;
	}
	
	public void setNuevaHabitacion(String CantidadPersonas, String TipoHabitacion, String ListadoServicios) {
		
		this.CantidadPersonas = Integer.parseInt(CantidadPersonas);
		this.TipoHabitacion = TipoHabitacion;
		this.ListadoServicios = ListadoServicios;
	}
	
	public String setListadoServicios(String listadoServicios) {
		return ListadoServicios = listadoServicios;
	}

	public int getID() {
		return ID;
	}

	public int getCantidadPersonas() {
		return CantidadPersonas;
	}

	public String getTipoHabitacion() {
		return TipoHabitacion;
	}

	public String getListadoServicios() {
		return ListadoServicios;
	}

	public static int getCuentaId() {
		return CuentaId;
	}
	
	public void IDRepetido(int idCargado) throws Exception {
		
		if(this.ID == idCargado) {
			 throw new Exception("El ID esta repetido");			
		}	
	}
}

