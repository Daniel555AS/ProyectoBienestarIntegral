package co.edu.upb.proyecto_bienestar_integral.model;

import co.edu.upb.proyecto_bienestar_integral.model.logicadelsistema.Cita;

public class ModeloConfirmacionCitaValoracionControl {
	
	public void agregarCita(Cita cita) {
		SistemaDeSalud.conseguirCitas().agregarAlFinal(cita);
		GestorBaseDeDatos.agregarCitaBD(cita);
	} // public void agregarCita(Cita cita)
	
} // public class ModeloConfirmacionCitaValoracionControl 
