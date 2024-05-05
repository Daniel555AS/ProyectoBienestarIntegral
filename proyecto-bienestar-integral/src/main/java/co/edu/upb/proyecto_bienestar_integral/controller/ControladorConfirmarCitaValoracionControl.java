package co.edu.upb.proyecto_bienestar_integral.controller;

import javax.swing.JOptionPane;
import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.view.*;

public class ControladorConfirmarCitaValoracionControl {

	private ModeloConfirmacionCitaValoracionControl modeloConfirmacionCitaValoracionControl;
	private PanelConfirmacionCitaValoracionControl panelConfirmacionCitaValoracionControl;

	public ControladorConfirmarCitaValoracionControl(
			ModeloConfirmacionCitaValoracionControl modeloConfirmacionCitaValoracionControl,
			PanelConfirmacionCitaValoracionControl panelConfirmacionCitaValoracionControl) {
		this.modeloConfirmacionCitaValoracionControl = modeloConfirmacionCitaValoracionControl;
		this.panelConfirmacionCitaValoracionControl = panelConfirmacionCitaValoracionControl;
	}

	public void registrarCita() {
		modeloConfirmacionCitaValoracionControl.agregarCita(panelConfirmacionCitaValoracionControl.getCita());
		JOptionPane.showMessageDialog(null, "la Cita Ha Sido Registrada Exitosamente", "OPERACIÓN EXITOSA",
				JOptionPane.INFORMATION_MESSAGE);
		VistaMenuPrincipal.mostrarPanel(new PanelPrincipal());
	}

}
// public class ControladorConfirmarCitaValoracionControl
