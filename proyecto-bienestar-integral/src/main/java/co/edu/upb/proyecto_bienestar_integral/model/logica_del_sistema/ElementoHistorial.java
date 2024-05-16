package co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class ElementoHistorial {
	// Atributos de la Clase ElmentoHistorial:
	private int id;
	private Date fecha;
	private Time hora;
	private String accion;
	private PersonaAdministrativa admin;
	
	// Primer Constructor de la Clase ElementoHistorial:
	public ElementoHistorial(int id, Date fecha, Time hora, String accion, PersonaAdministrativa admin) {
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.accion = accion;
		this.admin = admin;
	}
	
	// Segundo Constructor de la Clase ElementoHistorial:
	public ElementoHistorial(String accion, PersonaAdministrativa admin) {
		this.accion = accion;
		this.admin = admin;
	}
	
	// Getters:
	public int getId() {
		return id;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public Time getHora() {
		return hora;
	}
	
	public String getAccion() {
		return accion;
	}
	
	public PersonaAdministrativa getAdmin() {
		return admin;
	}
	
    public String getFechaFormateada() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(fecha);
    }
    
	public String getHoraFormateada() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(hora);
	}
	
} // public class ElementoHistorial
