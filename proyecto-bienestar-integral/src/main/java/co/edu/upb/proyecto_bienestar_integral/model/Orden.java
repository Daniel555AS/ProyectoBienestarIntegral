package co.edu.upb.proyecto_bienestar_integral.model;

public class Orden {
	
	private String identificador;
	private String especialidad;
	private String tipoExamen;
	private String idPaciente;
	private int costo;
	private String descripcion;
	private boolean estado;
	
	public Orden(String identificador, String especialidad, String tipoExamen, String idPaciente, int costo, String descripcion) {
		this.identificador = identificador;
		this.especialidad = especialidad;
		this.tipoExamen = tipoExamen;
		this.idPaciente = idPaciente;
		this.costo = costo;
		this.descripcion = descripcion;
		this.estado = false;
	}
	
	// Getters:
	public String getIdentificador() {
		return identificador;
	}
	
	public String getEspecialidad() {
		return especialidad;
	}
	
	public String getTipoExamen() {
		return tipoExamen;
	}
	
	public String getIdPaciente() {
		return idPaciente;
	}
	
	public int getCosto() {
		return costo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public boolean getEstado() {
		return estado;
	}
	
	
} // public class Orden
