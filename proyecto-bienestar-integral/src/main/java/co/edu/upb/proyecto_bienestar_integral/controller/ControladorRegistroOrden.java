package co.edu.upb.proyecto_bienestar_integral.controller;

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
		String idHistoriaClinica = panelRegistrarOrden.getCampoIdHistoriaClinica();
		if (!modeloRegistroOrden.verificarIdHistoriaClinica(idHistoriaClinica)) {
			panelRegistrarOrden.setCampoIdHistoriaClinica("");
			JOptionPane.showMessageDialog(null, "No se ha Encontrado Paciente Asociado al ID de Historia Clínica",
					"ERROR - REGISTRO DE ORDEN MÉDICA", JOptionPane.ERROR_MESSAGE);		
			return;
		}
	}

} // public class ControladorRegistroOrden
