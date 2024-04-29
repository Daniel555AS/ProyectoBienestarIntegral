package co.edu.upb.proyecto_bienestar_integral.controller;

import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.view.*;
import co.edu.upb.proyecto_bienestar_integral.estructuras.*;

public class ControladorAutorizarExamen {

	// Atributos de la Clase ControladorAutorizarExamen:
	private ModeloAutorizarExamen modeloAutorizarExamen;
	private PanelAutorizarExamen panelAutorizarExamen;

	// Constructor de la Clase ControladorAutorizarExamen:
	public ControladorAutorizarExamen(ModeloAutorizarExamen modeloAutorizarExamen,
			PanelAutorizarExamen panelAutorizarExamen) {
		this.modeloAutorizarExamen = modeloAutorizarExamen;
		this.panelAutorizarExamen = panelAutorizarExamen;
	}
	
	public void verificacionOrdenes() {
		String idHistoriaClinica = panelAutorizarExamen.getCampoIdHistoriaClinica();
		Pila<Orden> ordenesEncontradas = modeloAutorizarExamen.obtenerOrdenesPorAutorizar(idHistoriaClinica);
		if(ordenesEncontradas.getTamano() == 0) { 
			PanelAutorizarExamen panel = new PanelAutorizarExamen("Media\\ImagenOrdenesNoEncontradas.png","No Se Han Encontrado Órdenes Pendientes por Autorizar");
			panel.setCampoIdHistoriaClinica(idHistoriaClinica);
			VistaMenuPrincipal.mostrarPanel(panel);
		}
	} // public void verificacionOrdenes()
	
} // public class ControladorAutorizarExamen
