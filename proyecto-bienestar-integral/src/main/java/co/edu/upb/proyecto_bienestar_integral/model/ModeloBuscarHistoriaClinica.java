package co.edu.upb.proyecto_bienestar_integral.model;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.*;

public class ModeloBuscarHistoriaClinica {
	
	public Paciente verificarExistenciaPaciente(String idHistoriaClinica) {
		Lista<Paciente> pacientes = SistemaDeSalud.conseguirPacientes();
		for(int ii = 0; ii < pacientes.getTamano(); ii++) {
			if(pacientes.obtenerElemento(ii).getIdHistoriaClinica().equals(idHistoriaClinica)) {
				return pacientes.obtenerElemento(ii);
			}
		}
		return null;
	}
	
	public Lista<Cita> obtenerHistorialMedico(String idHistoriaClinica) {
		Lista<Cita> citas = SistemaDeSalud.conseguirCitas();
		Lista<Cita> historialMedico = new ListaDoblementeEnlazada<>();
		Cita cita;
		for(int ii = citas.getTamano() - 1; ii >= 0; ii--) {
			cita = citas.obtenerElemento(ii);
			if(cita.getEstadoAtendido() == true && cita.getIdHistoriaClinicaPaciente().equals(idHistoriaClinica)) {
				historialMedico.agregarAlFinal(cita);
			}
		}
		historialMedico.ordenar(new ComparadorFechaHoraCitas());
		return historialMedico;
	}
	
	
} // public class ModeloBuscarHistoriaClinica 
