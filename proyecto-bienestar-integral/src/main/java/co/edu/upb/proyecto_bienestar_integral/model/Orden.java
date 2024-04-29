package co.edu.upb.proyecto_bienestar_integral.model;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

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
	private String comentario;

	// Constructor de la Clase Orden:
	public Orden(String identificador, String especialidad, String tipoExamen, String idPaciente, int costo,
			String descripcion, Date fecha, ProfesionalSalud profesionalAsignado, String comentario) {
		this.identificador = identificador;
		this.especialidad = especialidad;
		this.tipoExamen = tipoExamen;
		this.idPaciente = idPaciente;
		this.costo = costo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.profesionalAsignado = profesionalAsignado;
		this.comentario = comentario;
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
	
	public String getComentario() {
		return comentario;
	}
	
	public ProfesionalSalud getProfesionalAsignado() {
		return profesionalAsignado;
	}
	
    public String getFechaFormateada() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(fecha);
    }
    
    public String getHoraFormateada() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(hora);
    }
	
	// Métodos Setters:
	public void setHora(Time hora) {
		this.hora = hora;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

} // public class Orden
