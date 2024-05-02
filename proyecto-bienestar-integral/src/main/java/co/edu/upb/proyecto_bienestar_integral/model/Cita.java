package co.edu.upb.proyecto_bienestar_integral.model;

public class Cita {
	
	private String identificador;
	private Paciente paciente;
	private String especialidad;
	private String servicio;
	private String motivo;
	private ProfesionalSalud profesionalAsignado;
	private int costo;
	private boolean estadoPago;
	
	
	
	// Métodos getters:
	public String getIdentificador() {
		return identificador;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

} // public class Cita 
