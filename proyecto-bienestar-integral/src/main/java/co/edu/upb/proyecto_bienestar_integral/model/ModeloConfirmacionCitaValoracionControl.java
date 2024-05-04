package co.edu.upb.proyecto_bienestar_integral.model;

public class ModeloConfirmacionCitaValoracionControl {
	
	public void agregarCita(Cita cita) {
		SistemaDeSalud.conseguirCitas().agregarAlFinal(cita);
		GestorBaseDeDatos.agregarCitaBD(cita);
	} // public void agregarCita(Cita cita)
	
} // public class ModeloConfirmacionCitaValoracionControl 
