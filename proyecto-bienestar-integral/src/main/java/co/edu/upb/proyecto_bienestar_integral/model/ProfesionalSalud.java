package co.edu.upb.proyecto_bienestar_integral.model;

import java.sql.Date;

public class ProfesionalSalud extends Persona {
	// Atributos de la Clase ProfesionalSalud:
	private String especialidad;
	private String servicio;
	
	// Constructor de la Clase ProfesionalSalud:
	public ProfesionalSalud(String nombres, String apellidos, String nombreCompleto, Date fechaNacimiento,
			String telefono, String tipoId, String identificacion, String especialidad, String servicio) {
		super(nombres, apellidos, nombreCompleto, fechaNacimiento, telefono, tipoId, identificacion);
		this.especialidad = especialidad;
		this.servicio = servicio;
	}
	
	// Métodos getters:
	public String getEspecialidad() {
		return especialidad;
	}
	
	public String getServicio() {
		return servicio;
	}
} // public class ProfesionalSalud extends Persona
