package co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Persona {
	
	private String nombres;
	private String apellidos;
	private String nombreCompleto;
	private Date fechaNacimiento;
	private String telefono;
	private String tipoId;
	private String identificacion;
	
	public Persona(String nombres, String apellidos, String nombreCompleto, Date fechaNacimiento, String telefono, String tipoId, String identificacion) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.nombreCompleto = nombreCompleto;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.tipoId = tipoId;
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
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public String getTipoId() {
		return tipoId;
	}
	
	public String getIdentificacion() {
		return identificacion;
	}
	
    public String getCadenaEdadEnAniosYMeses() {
        Calendar calNacimiento = Calendar.getInstance();
        calNacimiento.setTime(fechaNacimiento);
        
        Calendar calActual = Calendar.getInstance();
        
        int anios = calActual.get(Calendar.YEAR) - calNacimiento.get(Calendar.YEAR);
        int meses = calActual.get(Calendar.MONTH) - calNacimiento.get(Calendar.MONTH);
        
        if (meses < 0) {
            anios--;
            meses += 12;
        }
        
        String edad = anios + " años";
        
        if (meses > 0) {
            edad += " y " + meses + " meses";
        }
        
        return edad;
    }
    
    public String getFechaNacimientoFormateada() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return sdf.format(fechaNacimiento);
    }
    
    public String getNombreJuntoId() {
    	return nombreCompleto + " - " + tipoId + " " + identificacion;
    }
		
} // public class Persona
