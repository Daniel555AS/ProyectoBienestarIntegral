package co.edu.upb.proyecto_bienestar_integral.controller;

import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.Cita;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.ProfesionalSalud;
import co.edu.upb.proyecto_bienestar_integral.view.*;

public class ControladorRegistroCitaValoracionControl {

	private ModeloRegistroCitaValoracionControl modeloRegistroCitaValoracionControl;
	private PanelRegistroCitaValoracionControl panelRegistroCitaValoracionControl;

	public ControladorRegistroCitaValoracionControl(
			ModeloRegistroCitaValoracionControl modeloRegistroCitaValoracionControl,
			PanelRegistroCitaValoracionControl panelRegistroCitaValoracionControl) {
		this.modeloRegistroCitaValoracionControl = modeloRegistroCitaValoracionControl;
		this.panelRegistroCitaValoracionControl = panelRegistroCitaValoracionControl;
	}
	
	public void validarDatos() {
		String idHistoriaClinica = panelRegistroCitaValoracionControl.getIdHistoriaClinica();
		String especialidad = panelRegistroCitaValoracionControl.getEspecialidad().getNombre();
		String motivo = panelRegistroCitaValoracionControl.getMotivo();
		String comentario = panelRegistroCitaValoracionControl.getTextAreaComentario();
		String idCita = modeloRegistroCitaValoracionControl.obtenerIdCita(especialidad, motivo);
		ProfesionalSalud profesional = modeloRegistroCitaValoracionControl.obtenerProfesionalSalud(especialidad);
		int costo = modeloRegistroCitaValoracionControl.obtenerCostoConsulta(motivo, especialidad);		
		Cita cita = new Cita(idCita, idHistoriaClinica, especialidad, motivo, motivo, profesional, costo, comentario); 
		VistaMenuPrincipal.mostrarPanel(new PanelConfirmacionCitaValoracionControl(cita));
	}

} // public class ControladorRegistroCitaValoracionControl
