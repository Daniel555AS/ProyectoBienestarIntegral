package co.edu.upb.proyecto_bienestar_integral.model;

public class PersonaAdministrativa extends Persona {
	
	private String contrasena;

	public PersonaAdministrativa(String nombres, String apellidos, String nombreCompleto, int edad, String telefono, String identificacion, String contrasena) {
		super(nombres, apellidos, nombreCompleto, edad, telefono, identificacion);
		this.contrasena = contrasena;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
} // public class PersonaAdministrativa extends Persona 
