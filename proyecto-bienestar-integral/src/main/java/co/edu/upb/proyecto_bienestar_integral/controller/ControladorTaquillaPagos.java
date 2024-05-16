package co.edu.upb.proyecto_bienestar_integral.controller;

import javax.swing.JOptionPane;
import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.ElementoHistorial;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.GestorBaseDeDatos;
import co.edu.upb.proyecto_bienestar_integral.view.*;

public class ControladorTaquillaPagos {

	private ModeloTaquillaPagos modeloTaquillaPagos;
	private PanelTaquillaPagos panelTaquillaPagos;

	// Constructor de la Clase ControladorTaquillaPagos:
	public ControladorTaquillaPagos(ModeloTaquillaPagos modeloTaquillaPagos, PanelTaquillaPagos panelTaquillaPagos) {
		this.modeloTaquillaPagos = modeloTaquillaPagos;
		this.panelTaquillaPagos = panelTaquillaPagos;
	}

	public void confirmarPago() {
		if (panelTaquillaPagos.getCostoCita().equals("ID Cita No Encontrado")) {
			JOptionPane.showMessageDialog(null, "El ID de Cita No Ha Sido Encontrado.", "ERROR - CONFIRMACIÓN PAGO",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		modeloTaquillaPagos.pagarCita(panelTaquillaPagos.getCitaIdentificada());
		GestorBaseDeDatos.agregarElementoHistorial(
				new ElementoHistorial("Pago Realizado en Taquilla", VistaMenuPrincipal.getAdminActual()));
		JOptionPane.showMessageDialog(null, "Pago Confirmado con Éxtio", "OPERACIÓN EXITOSA",
				JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null,
				"Se ha Agregado la Cita a la Cola de Espera: "
						+ panelTaquillaPagos.getCitaIdentificada().getEspecialidad() + " - "
						+ panelTaquillaPagos.getCitaIdentificada().getMotivo(),
				"OPERACIÓN EXITOSA", JOptionPane.INFORMATION_MESSAGE);
		panelTaquillaPagos.setCampoIdCitaNull();
	}

} // public class ControladorTaquillaPagos
