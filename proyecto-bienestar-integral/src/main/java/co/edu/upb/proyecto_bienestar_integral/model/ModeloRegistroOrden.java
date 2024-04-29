package co.edu.upb.proyecto_bienestar_integral.model;

import java.sql.Date;
import java.util.Calendar;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;

public class ModeloRegistroOrden {

	public boolean verificarIdHistoriaClinica(String paciente) {
		if (paciente.equals("Paciente No Encontrado")) {
			return false;
		}
		return true;
	} // public boolean verificarIdHistoriaClinica(String paciente)

	public String generarIdentificarOrden(String idHistoriaClinicaPaciente, String examen, String especialidad) {
		return especialidad + examen + idHistoriaClinicaPaciente + GestorHorario.obtenerFechaYHoraActualJunta();
	} // public String generarIdentificarOrden(String idHistoriaClinicaPaciente, String examen, String especialidad)
	
	public ProfesionalSalud obtenerProfesionalSalud(String especialidad) {
		Lista<ProfesionalSalud> profesionalesSalud = SistemaDeSalud.conseguirProfesionalesSalud();
		ProfesionalSalud profesional;
		for(int ii = 0; ii < profesionalesSalud.getTamano(); ii++) {
			profesional = profesionalesSalud.obtenerElemento(ii);
			if(profesional.getEspecialidad().equals(especialidad) && profesional.getServicio().equals("Exámenes")) {
				return profesional;
			}
		}
		return null;
	}
	
	public boolean validarFecha(Date fecha) {
	    if (fecha != null) {
	        Date fechaActual = new Date(System.currentTimeMillis()); // Obtener la fecha actual del sistema
	        // Creación de un Calendar para la manipulación de fechas:
	        Calendar calFechaSeleccionada = Calendar.getInstance();
	        Calendar calFechaActual = Calendar.getInstance();
	        calFechaSeleccionada.setTime(fecha);
	        calFechaActual.setTime(fechaActual);

	        // Asegurarse de que la fecha seleccionada sea después de la fecha actual:
	        calFechaActual.add(Calendar.DAY_OF_MONTH, 0); 
	        if (calFechaSeleccionada.after(calFechaActual)) {
	            // La fecha seleccionada es válida
	            return true;
	        }
	    }
	    return false;
	} // public boolean validarFecha(Date fecha)
	

}
