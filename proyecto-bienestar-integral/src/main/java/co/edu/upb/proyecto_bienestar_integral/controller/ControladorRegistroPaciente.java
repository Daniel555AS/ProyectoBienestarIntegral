package co.edu.upb.proyecto_bienestar_integral.controller;

import javax.swing.JOptionPane;

import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.view.*;

public class ControladorRegistroPaciente {

	private ModeloGestorDatosPaciente modeloGestorDatosPaciente;
	private PanelRegistrarPaciente panelRegistrarPaciente;

	public ControladorRegistroPaciente(ModeloGestorDatosPaciente modeloGestorDatosPaciente,PanelRegistrarPaciente panelRegistrarPaciente) {
		this.modeloGestorDatosPaciente = modeloGestorDatosPaciente;
		this.panelRegistrarPaciente = panelRegistrarPaciente;
	}

	public Paciente validarDatosPaciente() {
		String nombres = panelRegistrarPaciente.getNombres().trim();
		String apellidos = panelRegistrarPaciente.getApellidos().trim();
		String edad = panelRegistrarPaciente.getEdad();
		String telefono = panelRegistrarPaciente.getTelefono();
		String identificacion = panelRegistrarPaciente.getId();
		String nombreCompleto = nombres + " " + apellidos;
		
		boolean vNombres = verificarNombres(nombres);
		boolean vApellidos = verificarApellidos(apellidos);
		boolean vEdad = verificarEdad(edad);
		boolean vTel = verificarTelefono(telefono);
		boolean vId = verificarId(identificacion);

		if (!(vNombres && vApellidos && vEdad && vTel && vId)) {
			JOptionPane.showMessageDialog(null, "Dato(s) Ingresado(s) No Válido(s)", "ERROR - REGISTRO DE PACIENTE", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return new Paciente(nombres, apellidos, nombreCompleto, Integer.parseInt(edad), telefono, identificacion);

	} // public void validarDatosPaciente()

	private boolean verificarNombres(String nombres) {
		if (modeloGestorDatosPaciente.validarNombres(nombres)) {
			panelRegistrarPaciente.setCampoNombres(nombres);
			return true;
		}
		panelRegistrarPaciente.setCampoNombres("");
		return false;
	} // private boolean verificarNombres(String nombres)

	private boolean verificarApellidos(String apellidos) {
		if (modeloGestorDatosPaciente.validarApellidos(apellidos)) {
			panelRegistrarPaciente.setCampoApellidos(apellidos);
			return true;
		}
		panelRegistrarPaciente.setCampoApellidos("");
		return false;
	} // private boolean verificarNombres(String apellidos)

	private boolean verificarEdad(String edad) {
		if (!modeloGestorDatosPaciente.validarEdad(edad)) {
			panelRegistrarPaciente.setCampoEdad("");
			return false;
		}
		return true;
	} // private boolean verificarEdad(String edad)

	private boolean verificarTelefono(String telefono) {
		if (!modeloGestorDatosPaciente.validarTelefono(telefono)) {
			panelRegistrarPaciente.setCampoTelefono("");
			return false;
		}
		return true;
	} // private boolean verificarTelefono(String telefono)

	private boolean verificarId(String id) {
		if (!modeloGestorDatosPaciente.validarId(id)) {
			panelRegistrarPaciente.setCampoId("");
			return false;
		}
		return true;
	} // private boolean verificarId(String id)

} // public class ControladorRegistroPaciente
