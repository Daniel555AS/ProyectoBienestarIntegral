package co.edu.upb.proyecto_bienestar_integral.model;

public class ModeloRegistroOrden {

	public boolean verificarIdHistoriaClinica(String paciente) {
		if (paciente.equals("Paciente No Encontrado")) {
			return false;
		}
		return true;
	} // public boolean verificarIdHistoriaClinica(String paciente)

	public String generarIdentificarOrden(String idHistoriaClinicaPaciente, String examen, String especialidad) {
		return especialidad + examen + idHistoriaClinicaPaciente + GestorHorario.obtenerFechaYHoraActualJunta();
	}
	

}
