package co.edu.upb.proyecto_bienestar_integral.controller;

import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.view.*;

public class ControladorRegistroPaciente {

	private ModeloGestorDatosPaciente modeloGestorDatosPaciente;
	private PanelRegistrarPaciente panelRegistrarPaciente;

	public ControladorRegistroPaciente(ModeloGestorDatosPaciente modeloGestorDatosPaciente,
			PanelRegistrarPaciente panelRegistrarPaciente) {
		this.modeloGestorDatosPaciente = modeloGestorDatosPaciente;
		this.panelRegistrarPaciente = panelRegistrarPaciente;
	}

	public void validarDatosPaciente() {
		String nombres = panelRegistrarPaciente.getNombres().trim();
		String apellidos = panelRegistrarPaciente.getApellidos().trim();
		String edad = panelRegistrarPaciente.getEdad();
		String telefono = panelRegistrarPaciente.getTelefono();
		String identificacion = panelRegistrarPaciente.getId();

		if (!(verificarNombres(nombres) && verificarApellidos(apellidos) && verificarEdad(edad)
				&& verificarTelefono(telefono))) {

		}

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
		if (!modeloGestorDatosPaciente.validarEdad(telefono)) {
			panelRegistrarPaciente.setCampoTelefono("");
			return false;
		}
		return true;
	} // private boolean verificarTelefono(String telefono)

} // public class ControladorRegistroPaciente
