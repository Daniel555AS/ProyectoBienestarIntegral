package co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema;

import java.sql.Date;

public class PersonaAdministrativa extends Persona {
	
	private String contrasena;

	public PersonaAdministrativa(String nombres, String apellidos, String nombreCompleto, Date fechaNacimiento, String telefono, String tipoId, String identificacion, String contrasena) {
		super(nombres, apellidos, nombreCompleto, fechaNacimiento, telefono, tipoId, identificacion);
		this.contrasena = contrasena;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
} // public class PersonaAdministrativa extends Persona 
