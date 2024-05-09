package co.edu.upb.proyecto_bienestar_integral.model;

import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.Cita;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.GestorBaseDeDatos;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.SistemaDeSalud;

public class ModeloRegistroCitaExamen {
	
	public void agregaCita(Cita cita) {
		SistemaDeSalud.conseguirCitas().agregarAlFinal(cita);
		GestorBaseDeDatos.agregarCitaBD(cita);
	} // public void agregarPaciente(Paciente paciente)
	
} // public class ModeloRegistroCitaExamen 
