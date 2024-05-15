package co.edu.upb.proyecto_bienestar_integral.controller;

import co.edu.upb.proyecto_bienestar_integral.view.*;
import javax.swing.JOptionPane;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.Paciente;
import co.edu.upb.proyecto_bienestar_integral.model.logica_gestion_pacientes.ModeloConfirmacionPaciente;

public class ControladorConfirmacionPaciente {
	// A
	private ModeloConfirmacionPaciente modeloConfirmacionPaciente;
	private PanelConfirmarPaciente panelConfirmarPaciente;

	public ControladorConfirmacionPaciente(PanelConfirmarPaciente panelConfirmarPaciente,
			ModeloConfirmacionPaciente modeloConfirmacionPaciente) {
		this.panelConfirmarPaciente = panelConfirmarPaciente;
		this.modeloConfirmacionPaciente = modeloConfirmacionPaciente;
	}
	
	public void guardarPaciente() {
		Paciente pacienteActual = panelConfirmarPaciente.getPacienteActual();
		modeloConfirmacionPaciente.agregarPaciente(pacienteActual);
		JOptionPane.showMessageDialog(null, "El Paciente Ha Sido Agregado Exitosamente", "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
		VistaMenuPrincipal.mostrarPanel(new PanelPrincipal());
	} // public void almacenarPaciente()
	
	public void regresarRegistro() {
		Paciente paciente = panelConfirmarPaciente.getPacienteActual();
		PanelRegistrarPaciente panelRegistrarPaciente = new PanelRegistrarPaciente();
		
		panelRegistrarPaciente.setCampoNombres(paciente.getNombres());
		panelRegistrarPaciente.setCampoApellidos(paciente.getApellidos());
		panelRegistrarPaciente.setCampoTelefono(paciente.getTelefono());
		panelRegistrarPaciente.setFechaNacimiento(paciente.getFechaNacimiento());
		panelRegistrarPaciente.setcomboBoxTipoId(paciente.getTipoId());
		panelRegistrarPaciente.setCampoId(paciente.getIdentificacion());
		
		VistaMenuPrincipal.mostrarPanel(panelRegistrarPaciente);
	} // public void regresarRegistro()
}
