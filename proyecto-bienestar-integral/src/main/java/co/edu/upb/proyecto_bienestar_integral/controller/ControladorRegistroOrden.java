package co.edu.upb.proyecto_bienestar_integral.controller;

import java.sql.Date;

import javax.swing.JOptionPane;

import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.view.*;

public class ControladorRegistroOrden {

	private PanelRegistrarOrden panelRegistrarOrden;
	private ModeloRegistroOrden modeloRegistroOrden;

	public ControladorRegistroOrden(PanelRegistrarOrden panelRegistrarOrden, ModeloRegistroOrden modeloRegistroOrden) {
		this.panelRegistrarOrden = panelRegistrarOrden;
		this.modeloRegistroOrden = modeloRegistroOrden;
	}

	public void validarDatos() {
		String paciente = panelRegistrarOrden.getLblNombrePaciente();	
		if (!modeloRegistroOrden.verificarIdHistoriaClinica(paciente)) {
			panelRegistrarOrden.setCampoIdHistoriaClinica("");
			JOptionPane.showMessageDialog(null, "No se ha Encontrado Paciente Asociado al ID de Historia Clínica Ingresado.",
					"ERROR - REGISTRO DE ORDEN MÉDICA", JOptionPane.ERROR_MESSAGE);		
			return;
		}
		Orden orden = creacionDeOrden();
		PanelAgendaMedica panelAgendaMedica = new PanelAgendaMedica(orden);
		VistaMenuPrincipal.mostrarPanel(panelAgendaMedica);
	}
	
	private Orden creacionDeOrden() {
		String idHistoriaClinica = panelRegistrarOrden.getCampoIdHistoriaClinica();
		String especialidad = panelRegistrarOrden.getEspecialidad().getNombre();
		String tipoExamen = panelRegistrarOrden.getExamen().getNombre();
		String descripcionExamen = panelRegistrarOrden.getExamen().getDescripcion();
		Date fechaOrden = panelRegistrarOrden.getFechaOrden();
		int costoExamen = panelRegistrarOrden.getExamen().getCosto();
		ProfesionalSalud profesional = modeloRegistroOrden.obtenerProfesionalSalud(especialidad);
		String identificadorOrden = modeloRegistroOrden.generarIdentificarOrden(idHistoriaClinica, "examen", "especialidad");
		return new Orden(identificadorOrden, especialidad, tipoExamen, idHistoriaClinica, costoExamen, descripcionExamen, fechaOrden, profesional);
	}
	

	

} // public class ControladorRegistroOrden
