package co.edu.upb.proyecto_bienestar_integral.model;

import java.sql.Date;

public class Paciente extends Persona {

	private String idHistoriaClinica;
	
	public Paciente(String nombres, String apellidos, String nombreCompleto, Date fechaNacimiento, String telefono,String tipoId, String identificacion, String idHistoriaClinica) {
		super(nombres, apellidos, nombreCompleto, fechaNacimiento, telefono, tipoId, identificacion);
		this.idHistoriaClinica = idHistoriaClinica;
	}
	
	public Paciente(String nombres, String apellidos, String nombreCompleto, Date fechaNacimiento, String telefono, String tipoId, String identificacion) {
	   super(nombres, apellidos, nombreCompleto, fechaNacimiento, telefono, tipoId, identificacion);
	}
	
	public String getIdHistoriaClinica() {
		return idHistoriaClinica;
	}

} // public class Paciente extends Persona
