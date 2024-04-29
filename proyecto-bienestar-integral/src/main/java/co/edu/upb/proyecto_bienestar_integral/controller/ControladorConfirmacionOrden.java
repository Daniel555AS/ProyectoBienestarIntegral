package co.edu.upb.proyecto_bienestar_integral.controller;

import javax.swing.JOptionPane;

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
		Orden orden = panelConfirmarOrden.getOrdenActual();
		modeloConfirmarOrden.agregarOrden(orden);
		JOptionPane.showMessageDialog(null, "La Orden Ha Sido Registrada Exitosamente", "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
		VistaMenuPrincipal.mostrarPanel(new PanelPrincipal());
	} // public void guardarOrden()
	
	public String obtenerNombreCompletoPaciente() {
		Orden ordenActual = panelConfirmarOrden.getOrdenActual();
		return modeloConfirmarOrden.obtenerNombreCompletoPaciente(ordenActual.getIdPaciente());
	}

} // public class ControladorConfirmacionOrden
