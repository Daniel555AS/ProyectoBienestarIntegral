package co.edu.upb.proyecto_bienestar_integral.model;

import co.edu.upb.proyecto_bienestar_integral.model.logicadelsistema.Cita;

public class ModeloRegistroCitaExamen {
	
	public void agregaCita(Cita cita) {
		SistemaDeSalud.conseguirCitas().agregarAlFinal(cita);
		GestorBaseDeDatos.agregarCitaBD(cita);
	} // public void agregarPaciente(Paciente paciente)
	
} // public class ModeloRegistroCitaExamen 
