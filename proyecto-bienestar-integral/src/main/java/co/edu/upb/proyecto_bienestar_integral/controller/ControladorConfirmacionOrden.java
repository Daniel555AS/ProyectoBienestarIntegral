package co.edu.upb.proyecto_bienestar_integral.controller;

import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.view.*;

public class ControladorConfirmacionOrden {

	private ModeloConfirmarOrden modeloConfirmarOrden;
	private PanelConfirmarOrden panelConfirmarOrden;

	public ControladorConfirmacionOrden(ModeloConfirmarOrden modeloConfirmarOrden,
			PanelConfirmarOrden panelConfirmarOrden) {
		this.modeloConfirmarOrden = modeloConfirmarOrden;
		this.panelConfirmarOrden = panelConfirmarOrden;
	}
	
	public void guardarOrden() {
		
	}
	
	public String obtenerNombreCompletoPaciente() {
		Orden ordenActual = panelConfirmarOrden.getOrdenActual();
		return modeloConfirmarOrden.obtenerNombreCompletoPaciente(ordenActual.getIdPaciente());
	}

} // public class ControladorConfirmacionOrden
