package co.edu.upb.proyecto_bienestar_integral.model;

public class Paciente extends Persona {

	private String idHistoriaClinica;
	
	public Paciente(String nombres, String apellidos, String nombreCompleto, int edad, String telefono,String identificacion, String idHistoriaClinica) {
		super(nombres, apellidos, nombreCompleto, edad, telefono, identificacion);
		this.idHistoriaClinica = idHistoriaClinica;
	}
	
	public Paciente(String nombres, String apellidos, String nombreCompleto, int edad, String telefono, String identificacion) {
	   super(nombres, apellidos, nombreCompleto, edad, telefono, identificacion);
	}
	
	public String getIdHistoriaClinica() {
		return idHistoriaClinica;
	}

} // public class Paciente extends Persona
