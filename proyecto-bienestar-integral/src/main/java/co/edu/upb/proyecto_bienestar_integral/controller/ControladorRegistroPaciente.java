package co.edu.upb.proyecto_bienestar_integral.controller;

import java.sql.Date;
import javax.swing.JOptionPane;
import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.view.*;

public class ControladorRegistroPaciente {

	private ModeloGestorDatosPaciente modeloGestorDatosPaciente;
	private PanelRegistrarPaciente panelRegistrarPaciente;

	public ControladorRegistroPaciente(PanelRegistrarPaciente panelRegistrarPaciente, ModeloGestorDatosPaciente modeloGestorDatosPaciente) {
		this.panelRegistrarPaciente = panelRegistrarPaciente;
		this.modeloGestorDatosPaciente = modeloGestorDatosPaciente;
	}

	public void validarDatosPaciente() {
		String nombres = panelRegistrarPaciente.getNombres().trim();
		String apellidos = panelRegistrarPaciente.getApellidos().trim();
		Date fechaNacimiento = panelRegistrarPaciente.getFechaNacimiento();
		String telefono = panelRegistrarPaciente.getTelefono();
		String tipoId = panelRegistrarPaciente.getTipoId();
		String identificacion = panelRegistrarPaciente.getId();
		String nombreCompleto = nombres + " " + apellidos;
		String idHistoriaClinica = "HC" + identificacion + "CBI";

		boolean vNombres = verificarNombres(nombres);
		boolean vApellidos = verificarApellidos(apellidos);
		boolean vFechaNacimiento = verificarFechaNacimiento(fechaNacimiento);
		boolean vTel = verificarTelefono(telefono);
		boolean vId = verificarId(identificacion);
		boolean vIdUnico = verificarIdUnico(identificacion);

		if (!(vNombres && vApellidos && vTel && vId && vFechaNacimiento)) {
			JOptionPane.showMessageDialog(null, "Dato(s) Ingresado(s) No Válido(s)", "ERROR - REGISTRO DE PACIENTE",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (!vIdUnico) {
			JOptionPane.showMessageDialog(null,
					"La Identificación Ingresada Ya Se Encuentra Asociada a un Paciente Existente.",
					"ERROR - REGISTRO DE PACIENTE", JOptionPane.ERROR_MESSAGE);
			return;
		}

		PanelConfirmarPaciente panelConfirmarPaciente = new PanelConfirmarPaciente(new Paciente(nombres, apellidos,
				nombreCompleto, fechaNacimiento, telefono, tipoId, identificacion, idHistoriaClinica));
		VistaMenuPrincipal.mostrarPanel(panelConfirmarPaciente);
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
	
	private boolean verificarFechaNacimiento(Date fechaNacimiento) {
		if(modeloGestorDatosPaciente.validarFechaNacimiento(fechaNacimiento)) {
			panelRegistrarPaciente.setFechaNacimiento(fechaNacimiento);
			return true;
		}
		panelRegistrarPaciente.setFechaNacimiento(null);
		return false;
	}

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

	private boolean verificarIdUnico(String id) {
		if (!modeloGestorDatosPaciente.validarIdUnico(id)) {
			panelRegistrarPaciente.setCampoId("");
			return false;
		}
		return true;
	}

} // public class ControladorRegistroPaciente
