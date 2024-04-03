package co.edu.upb.proyecto_bienestar_integral.model;

public class Persona {
	
	private String nombres;
	private String apellidos;
	private String nombreCompleto;
	private int edad; // en años 
	private String telefono;
	private String identificacion;
	
	public Persona(String nombres, String apellidos, String nombreCompleto, int edad, String telefono, String identificacion) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.nombreCompleto = nombreCompleto;
		this.edad = edad;
		this.telefono = telefono;
		this.identificacion = identificacion;
	}
	
	// Getters:
	public String getNombres() {
		return nombres;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public String getIdentificacion() {
		return identificacion;
	}
		
} // public class Persona
