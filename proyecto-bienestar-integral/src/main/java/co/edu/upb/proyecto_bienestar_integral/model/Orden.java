package co.edu.upb.proyecto_bienestar_integral.model;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import com.jgoodies.common.base.Objects;

import co.edu.upb.proyecto_bienestar_integral.estructuras.Lista;

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
    
    public String getFechaYHoraFormateada() {
    	return getFechaFormateada() + " - " + getHoraFormateada();
    }
    
    public String getNombreYIdPaciente() {
    	Lista<Paciente> pacientes = SistemaDeSalud.conseguirPacientes();
    	for(int ii = 0; ii < pacientes.getTamano(); ii++) {
    		if(pacientes.obtenerElemento(ii).getIdHistoriaClinica().equals(idPaciente)) {
    			return pacientes.obtenerElemento(ii).getNombreCompleto();
    		}
    	}
    	return "";
    }
    
    public String getMensajeEstado() {
    	if(estado) {
    		return "Orden Autorizada";
    	}
    	return "Orden No Autorizada";
    }
	
	// Métodos Setters:
	public void setHora(Time hora) {
		this.hora = hora;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	// Método public void para establecer un comentario para una Orden:
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	// Modificación del método .equals() correspondiente a la Clase Orden:
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orden orden = (Orden) o;
        return costo == orden.costo &&
                estado == orden.estado &&
                Objects.equals(identificador, orden.identificador) &&
                Objects.equals(especialidad, orden.especialidad) &&
                Objects.equals(tipoExamen, orden.tipoExamen) &&
                Objects.equals(idPaciente, orden.idPaciente) &&
                Objects.equals(descripcion, orden.descripcion) &&
                Objects.equals(fecha, orden.fecha) &&
                Objects.equals(hora, orden.hora) &&
                Objects.equals(profesionalAsignado, orden.profesionalAsignado) &&
                Objects.equals(comentario, orden.comentario);
    } // public boolean equals(Object o) 

} // public class Orden
