package co.edu.upb.proyecto_bienestar_integral.controller;

import co.edu.upb.proyecto_bienestar_integral.view.*;

import javax.swing.JOptionPane;

import co.edu.upb.proyecto_bienestar_integral.model.*;

public class ControladorRegistrarCitaExamen {

	private PanelRegistroCitaExamen panelRegistroCitaExamen;
	private ModeloRegistroCitaExamen modeloRegistroCitaExamen;

	public ControladorRegistrarCitaExamen(ModeloRegistroCitaExamen modeloRegistroCitaExamen,
			PanelRegistroCitaExamen panelRegistroCitaExamen) {
		this.modeloRegistroCitaExamen = modeloRegistroCitaExamen;
		this.panelRegistroCitaExamen = panelRegistroCitaExamen; 
	}
	
	public void Registrar() {
		String nombrePaciente = panelRegistroCitaExamen.getPaciente();
		String estadoOrden;
		if(!nombrePaciente.equals("ID No Encontrado")) {
			
		}
		JOptionPane.showMessageDialog(null, "No Se Ha Encontrado Orden Médica Asociada a la ID Ingresado.",
				"ERROR - REGISTRO DE CITA EXAMEN", JOptionPane.ERROR_MESSAGE);	
	}

}
