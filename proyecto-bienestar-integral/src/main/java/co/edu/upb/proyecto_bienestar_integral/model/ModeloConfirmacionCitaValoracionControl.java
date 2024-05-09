package co.edu.upb.proyecto_bienestar_integral.model;

import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.Cita;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.GestorBaseDeDatos;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.SistemaDeSalud;

public class ModeloConfirmacionCitaValoracionControl {
	
	public void agregarCita(Cita cita) {
		SistemaDeSalud.conseguirCitas().agregarAlFinal(cita);
		GestorBaseDeDatos.agregarCitaBD(cita);
	} // public void agregarCita(Cita cita)
	
} // public class ModeloConfirmacionCitaValoracionControl 
