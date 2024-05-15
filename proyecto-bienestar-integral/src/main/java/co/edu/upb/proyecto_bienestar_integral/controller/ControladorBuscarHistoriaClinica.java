package co.edu.upb.proyecto_bienestar_integral.controller;

import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.Paciente;
import co.edu.upb.proyecto_bienestar_integral.view.*;

public class ControladorBuscarHistoriaClinica {

	private ModeloBuscarHistoriaClinica modeloBuscarHistoriaClinica;
	private PanelBuscarHistoriaClinica panelBuscarHistoriaClinica;
	private PanelHistoriaClinicaPaciente panelHistoriaClinicaPaciente;

	// Primer Constructor de la Clase ControladorBuscarHistoriaClinica
	public ControladorBuscarHistoriaClinica(ModeloBuscarHistoriaClinica modeloBuscarHistoriaClinica,
			PanelBuscarHistoriaClinica panelBuscarHistoriaClinica) {
		this.modeloBuscarHistoriaClinica = modeloBuscarHistoriaClinica;
		this.panelBuscarHistoriaClinica = panelBuscarHistoriaClinica;
	}

	// Segundo Constructor de la Clase ControladorBuscarHistoriaClinica
	public ControladorBuscarHistoriaClinica(ModeloBuscarHistoriaClinica modeloBuscarHistoriaClinica,
			PanelHistoriaClinicaPaciente panelHistoriaClinicaPaciente) {
		this.modeloBuscarHistoriaClinica = modeloBuscarHistoriaClinica;
		this.panelHistoriaClinicaPaciente = panelHistoriaClinicaPaciente;
	}

	public void verificarExistenciaHistoriaClinica(String idHistoriaClinica) {
		Paciente paciente = modeloBuscarHistoriaClinica.verificarExistenciaPaciente(idHistoriaClinica);
		if (paciente != null) {
			PanelHistoriaClinicaPaciente panelPaciente = new PanelHistoriaClinicaPaciente();
			panelPaciente.setLblDatoNombres(paciente.getNombres());
			panelPaciente.setLblDatoApellidos(paciente.getApellidos());
			panelPaciente.setLblDatoIdPaciente(paciente.getTipoId(), paciente.getIdentificacion());
			panelPaciente.setLblDatoFechaNacimiento(paciente.getFechaNacimientoFormateada());
			panelPaciente.setLblDatoHistoriaClinica(paciente.getIdHistoriaClinica());
			panelPaciente.setCampoIdHistoriaClinica(idHistoriaClinica);
			VistaMenuPrincipal.mostrarPanel(panelPaciente);
		} else {
			PanelBuscarHistoriaClinica panel = new PanelBuscarHistoriaClinica("Media\\\\ImagenOrdenesNoEncontradas.png",
					"No Se Ha Encontrado Ningún Paciente con el ID de Historia Clínica Ingresado");
			panel.setCampoIdHistoriaClinica(idHistoriaClinica);
			VistaMenuPrincipal.mostrarPanel(panel);
		}
	}

} // public class ControladorBuscarHistoriaClinica
