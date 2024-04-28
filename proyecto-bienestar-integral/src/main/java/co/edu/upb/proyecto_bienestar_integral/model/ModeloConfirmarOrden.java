package co.edu.upb.proyecto_bienestar_integral.model;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;

public class ModeloConfirmarOrden {
	
	public String obtenerNombreCompletoPaciente(String idHistoriaClinica) {
		Lista<Paciente> pacientes = SistemaDeSalud.conseguirPacientes(); 
		for(int ii = 0; ii < pacientes.getTamano(); ii++) {
			if(pacientes.obtenerElemento(ii).getIdHistoriaClinica().equals(idHistoriaClinica)) {
				return pacientes.obtenerElemento(ii).getNombreCompleto();
			}
		}
		return "";
	}

} // public class ModeloConfirmarOrden 