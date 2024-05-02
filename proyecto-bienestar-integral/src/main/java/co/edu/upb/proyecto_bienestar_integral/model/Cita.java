package co.edu.upb.proyecto_bienestar_integral.model;

public class Cita {

	private String identificador;
	private String idHistoriaClinicaPaciente;
	private String especialidad;
	private String servicio;
	private String motivo;
	private ProfesionalSalud profesionalAsignado;
	private int costo;
	private boolean estadoPago;
	private String comentario;

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
	}

	// Métodos getters:
	public String getIdentificador() {
		return identificador;
	}

	public String idHistoriaClinicaPaciente() {
		return idHistoriaClinicaPaciente;
	}

} // public class Cita
