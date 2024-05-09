package co.edu.upb.proyecto_bienestar_integral.model.logica_gestion_pacientes;

import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.GestorBaseDeDatos;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.Paciente;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.SistemaDeSalud;

public class ModeloConfirmacionPaciente {

	public void agregarPaciente(Paciente paciente) {
		SistemaDeSalud.conseguirPacientes().agregarAlFinal(paciente);
		SistemaDeSalud.ordenarPacientesPorId();
		GestorBaseDeDatos.agregarPacienteBD(paciente);
	} // public void agregarPaciente(Paciente paciente)

} // public class ModeloConfirmacionPaciente 
