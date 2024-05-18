package co.edu.upb.proyecto_bienestar_integral.controller;

import java.sql.Time;
import javax.swing.JOptionPane;
import co.edu.upb.proyecto_bienestar_integral.estructuras.Lista;
import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.Orden;
import co.edu.upb.proyecto_bienestar_integral.view.*;

public class ControladorAgendaMedica {
	
	// Atributos de la Clase ControladorAgendaMedica:
	private ModeloAgendaMedica modeloAgendaMedica;
	private PanelAgendaMedica panelAgendaMedica;

	// Constructor de la Clase ControladorAgendaMedica:
	public ControladorAgendaMedica(ModeloAgendaMedica modeloAgendaMedica, PanelAgendaMedica panelAgendaMedica) {
		this.modeloAgendaMedica = modeloAgendaMedica;
		this.panelAgendaMedica = panelAgendaMedica;
	} // public ControladorAgendaMedica(ModeloAgendaMedica modeloAgendaMedica,
		// PanelAgendaMedica panelAgendaMedica)

	/*
	 * Método public que retorna una Lista de objetos de tipo Orden. Los objetos se
	 * obtienen por medio de un filtrado según los criterios de Especialidad y
	 * Fecha:
	 */
	public Lista<Orden> obtenerOrdenesFiltradas() {
		Orden ordenActual = panelAgendaMedica.getOrdenActual();
		Lista<Orden> ordenesFiltradas = modeloAgendaMedica.filtrarOrdenesPorFecha(ordenActual.getEspecialidad(),
				ordenActual.getFecha());
		return ordenesFiltradas;
	} // public Lista<Orden> obtenerOrdenesFiltradas()

	// Método public void que permite la validación de la Hora Seleccionada dentro
	// de la Agenda Médica. Si la hora seleccionada no está disponible, se expone un
	// mensaje de error, de lo contrario, se continúa con el proceso de confirmación
	// de la Orden Médica:
	public void validarHoraSeleccionada() {
		Time horaSeleccionada = panelAgendaMedica.getHoraFilaSeleccionada();
		if (horaSeleccionada == null) {
			JOptionPane.showMessageDialog(null, "La Hora Seleccionada No se encuentra Disponible.",
					"ERROR - REGISTRO DE ORDEN MÉDICA", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Orden ordenActual = panelAgendaMedica.getOrdenActual();
		ordenActual.setHora(horaSeleccionada);
		PanelConfirmarOrden panelConfirmarOrden = new PanelConfirmarOrden(ordenActual);
		VistaMenuPrincipal.mostrarPanel(panelConfirmarOrden);
	} // public void validarHoraSeleccionada() 

} // public class ControladorAgendaMedica
