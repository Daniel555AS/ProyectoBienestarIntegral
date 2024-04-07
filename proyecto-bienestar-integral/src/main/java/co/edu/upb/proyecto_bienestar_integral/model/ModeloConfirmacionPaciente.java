package co.edu.upb.proyecto_bienestar_integral.model;

public class ModeloConfirmacionPaciente {

	public void agregarPaciente(Paciente paciente) {
		SistemaDeSalud.conseguirPacientes().agregarAlFinal(paciente);
		SistemaDeSalud.ordenarPacientesPorId();
		GestorBaseDeDatos.agregarPacienteBD(paciente);
	} // public void agregarPaciente(Paciente paciente)

} // public class ModeloConfirmacionPaciente 
