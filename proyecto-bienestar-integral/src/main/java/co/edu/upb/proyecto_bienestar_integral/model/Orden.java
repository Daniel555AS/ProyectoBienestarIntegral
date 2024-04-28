package co.edu.upb.proyecto_bienestar_integral.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public class Orden {
	// Atributos de la Clase Orden:
	private String identificador;
	private String especialidad;
	private String tipoExamen;
	private String idPaciente;
	private int costo;
	private String descripcion;
	private Date fecha;
	private Time hora;
	private boolean estado;
	private ProfesionalSalud profesionalAsignado;

	// Constructor de la Clase Orden:
	public Orden(String identificador, String especialidad, String tipoExamen, String idPaciente, int costo,
			String descripcion, Date fecha, ProfesionalSalud profesionalAsignado) {
		this.identificador = identificador;
		this.especialidad = especialidad;
		this.tipoExamen = tipoExamen;
		this.idPaciente = idPaciente;
		this.costo = costo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.profesionalAsignado = profesionalAsignado;
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

	public Date getFecha() {
		return fecha;
	}

	public Time getHora() {
		return hora;
	}
	
	public ProfesionalSalud getProfesionalAsignado() {
		return profesionalAsignado;
	}
	
	// Métodos Setters:
	public void setHora(Time hora) {
		this.hora = hora;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

} // public class Orden
