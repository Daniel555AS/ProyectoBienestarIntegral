package co.edu.upb.proyecto_bienestar_integral.model;

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
		ProfesionalSalud profesional = null;
		for(int ii = 0; ii < profesionalesSalud.getTamano(); ii++) {
			profesional = profesionalesSalud.obtenerElemento(ii);
			if(profesional.getEspecialidad().equals(especialidad) && profesional.getServicio().equals("Exámenes")) {
				return profesional;
			}
		}
		return null;
	}
	

}
