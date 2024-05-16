package co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {

	private String identificador;
	private String idHistoriaClinicaPaciente;
	private String especialidad;
	private String servicio;
	private String motivo;
	private ProfesionalSalud profesionalAsignado;
	private int costo;
	private boolean estadoPago;
	private boolean estadoAtendido;
	private String comentario;
	private Date fecha;
	private Time hora;

	public Cita(String identificador, String idHistoriaClinicaPaciente, String especialidad, String servicio,
			String motivo, ProfesionalSalud profesionalAsignado, int costo, String comentario) {
		this.identificador = identificador;
		this.idHistoriaClinicaPaciente = idHistoriaClinicaPaciente;
		this.especialidad = especialidad;
		this.servicio = servicio;
		this.motivo = motivo;
		this.profesionalAsignado = profesionalAsignado;
		this.costo = costo;
		this.comentario = comentario;
		this.estadoPago = false;
		this.estadoAtendido = false;
	}
	
	public Cita(String identificador, String idHistoriaClinicaPaciente, String especialidad, String servicio,
			String motivo, ProfesionalSalud profesionalAsignado, int costo, boolean estadoPago, boolean estadoAtendido, String comentario, Date fecha, Time hora) {
		this.identificador = identificador;
		this.idHistoriaClinicaPaciente = idHistoriaClinicaPaciente;
		this.especialidad = especialidad;
		this.servicio = servicio;
		this.motivo = motivo;
		this.profesionalAsignado = profesionalAsignado;
		this.costo = costo;
		this.comentario = comentario;
		this.estadoPago = estadoPago;
		this.estadoAtendido = estadoAtendido;
		this.fecha = fecha;
		this.hora = hora;
	}

	// Métodos getters:
	public String getIdentificador() {
		return identificador;
	}

	public String getIdHistoriaClinicaPaciente() {
		return idHistoriaClinicaPaciente;
	}
	
	public String getEspecialidad() {
		return especialidad;
	}
	
	public String getServicio() {
		return servicio;
	}
	
	public String getMotivo() {
		return motivo;
	}
	
	public ProfesionalSalud getProfesionalAsignado() {
		return profesionalAsignado;
	}
	
	public int getCosto() {
		return costo;
	}
	
	public boolean getEstadoPago() {
		return estadoPago;
	}
	
	public boolean getEstadoAtendido() {
		return estadoAtendido;
	}
	
	public String getComentario( ) {
		return comentario;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public Time getHora() {
		return hora;
	}
	
    public String getFechaFormateada() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(fecha);
    }
    
	public String getHoraFormateada() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(hora);
	}
	
	// Métos Setters: 
	public void setHora(Time hora) {
		this.hora = hora;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public void setEstadoPago(boolean estadoPago) {
		this.estadoPago = estadoPago;
	}
	
	public void setEstadoAtendido(boolean estadoAtendido) {
		this.estadoAtendido = estadoAtendido;
	}
	
	// Método para establecer la hora actual del sistema
	public void setHoraActual() {
		LocalTime now = LocalTime.now();
		this.hora = Time.valueOf(now);
	}
	
	// Método para establecer la Fecha Actual del Sistema:
	public void setFechaActual() {
	    this.fecha = Date.valueOf(LocalDate.now());
	}
	

} // public class Cita
