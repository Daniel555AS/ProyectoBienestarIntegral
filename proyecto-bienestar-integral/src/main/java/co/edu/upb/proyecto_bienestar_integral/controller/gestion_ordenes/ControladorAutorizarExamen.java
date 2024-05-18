package co.edu.upb.proyecto_bienestar_integral.controller.gestion_ordenes;

import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.*;
import co.edu.upb.proyecto_bienestar_integral.view.*;
import javax.swing.JOptionPane;
import co.edu.upb.proyecto_bienestar_integral.estructuras.*;

public class ControladorAutorizarExamen {

	// Atributos de la Clase ControladorAutorizarExamen:
	private ModeloAutorizarExamen modeloAutorizarExamen;
	private PanelAutorizarExamen panelAutorizarExamen;
	private PanelCambiarEstadoOrden panelCambiarEstadoOrden;
	private Pila<Orden> pilaOrdenesPaciente;

	// Primer Constructor de la Clase ControladorAutorizarExamen:
	public ControladorAutorizarExamen(ModeloAutorizarExamen modeloAutorizarExamen,
			PanelAutorizarExamen panelAutorizarExamen) {
		this.modeloAutorizarExamen = modeloAutorizarExamen;
		this.panelAutorizarExamen = panelAutorizarExamen;
		this.pilaOrdenesPaciente = new Pila<>();
	} // public ControladorAutorizarExamen(ModeloAutorizarExamen
		// modeloAutorizarExamen, PanelAutorizarExamen panelAutorizarExamen)

	// Segundo Constructor de la Clase ControladorAutorizarExamen:
	public ControladorAutorizarExamen(ModeloAutorizarExamen modeloAutorizarExamen,
			PanelCambiarEstadoOrden panelCambiarEstadoOrden) {
		this.modeloAutorizarExamen = modeloAutorizarExamen;
		this.panelCambiarEstadoOrden = panelCambiarEstadoOrden;
		this.pilaOrdenesPaciente = modeloAutorizarExamen
				.obtenerOrdenesPorAutorizar(panelCambiarEstadoOrden.getOrdenActual().getIdPaciente());
	} // public ControladorAutorizarExamen(ModeloAutorizarExamen
		// modeloAutorizarExamen, PanelCambiarEstadoOrden panelCambiarEstadoOrden)

	// Método public void para procesos de verificación de existencia de órdenes
	// médicas con respecto a un Paciente:
	public void verificacionOrdenes(String idHistoriaClinica) {
		this.pilaOrdenesPaciente = modeloAutorizarExamen.obtenerOrdenesPorAutorizar(idHistoriaClinica);
		if (pilaOrdenesPaciente.getTamano() == 0) {
			PanelAutorizarExamen panel = new PanelAutorizarExamen("Media\\ImagenOrdenesNoEncontradas.png",
					"No Se Han Encontrado Órdenes Pendientes por Autorizar");
			panel.setCampoIdHistoriaClinica(idHistoriaClinica);
			VistaMenuPrincipal.mostrarPanel(panel);
		} else {
			PanelCambiarEstadoOrden panelCambiarEstadoOrden = new PanelCambiarEstadoOrden(pilaOrdenesPaciente.peek());
			panelCambiarEstadoOrden.setCampoIdHistoriaClinica(idHistoriaClinica);
			VistaMenuPrincipal.mostrarPanel(panelCambiarEstadoOrden);
		}
	} // public void verificacionOrdenes(String idHistoriaClinica)

	// Método public void para procesos de autorización de una orden médica:
	public void autorizacionOrden(Orden ordenActual) {
		Orden ordenCima = panelCambiarEstadoOrden.getOrdenActual();
		int opcion = JOptionPane.showOptionDialog(null, "¿Desea Confirmar la Autorización de la Orden Médica?",
				"Autorización Orden Médica", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				new String[] { "Confirmar", "Rechazar" }, null);
		if (opcion == JOptionPane.YES_OPTION) {
			GestorBaseDeDatos.agregarElementoHistorial(
					new ElementoHistorial("Autorización de Orden Médica", VistaMenuPrincipal.getAdminActual()));
			// Verificar si hay órdenes pendientes en la pila
			if (!pilaOrdenesPaciente.estaVacia()) {
				int index = buscarIndice(ordenCima.getIdentificador());
				if (index != -1) {
					SistemaDeSalud.conseguirOrdenes().obtenerElemento(index).setEstado(true);
					GestorBaseDeDatos.actualizarEstadoOrden(ordenCima.getIdentificador());
					pilaOrdenesPaciente.pop();
					if (!pilaOrdenesPaciente.estaVacia()) {
						PanelCambiarEstadoOrden panelCambiarEstadoOrden = new PanelCambiarEstadoOrden(
								pilaOrdenesPaciente.peek());
						VistaMenuPrincipal.mostrarPanel(panelCambiarEstadoOrden);
					} else {
						PanelAutorizarExamen panel = new PanelAutorizarExamen("Media\\ImagenOrdenesNoEncontradas.png",
								"No Se Han Encontrado Órdenes Pendientes por Autorizar");
						panel.setCampoIdHistoriaClinica(ordenCima.getIdPaciente());
						VistaMenuPrincipal.mostrarPanel(panel);
					}
				}
			}
		}
	} // public void autorizacionOrden(Orden ordenActual)

	/*
	 * Método que retorna un String correspondiente al Nombre Completo de un
	 * Paciente. El parametro de entrada es un objeto de tipo Orden, del cual, se
	 * obtiene el ID correspondiente a la Historia Clínica del Paciente, con base a
	 * este dato, es que se realiza el proceso de búsqueda:F
	 */
	public String obtenerNombreCompletoPaciente(Orden ordenActual) {
		ListaDoblementeEnlazada<Paciente> pacientes = (ListaDoblementeEnlazada<Paciente>) SistemaDeSalud
				.conseguirPacientes();
		for (int ii = 0; ii < pacientes.getTamano(); ii++) {
			if (pacientes.obtenerElemento(ii).getIdHistoriaClinica().equals(ordenActual.getIdPaciente())) {
				return pacientes.obtenerElemento(ii).getNombreCompleto();
			}
		}
		return "";
	} // public String obtenerNombreCompletoPaciente(Orden OrdenActual)

	/*
	 * Método private que retorna un número entero, correspondiente al índice en que
	 * se encuentra un objeto de tipo Orden en la Lista de ordenes del
	 * SistemaDeSalud. El proceo de búsqueda se realiza con base al ID de la Orden
	 * Médica (Parámetro de Entrada). Si no se encuentra la orden, se retorna -1:
	 */
	private int buscarIndice(String idOrden) {
		for (int ii = SistemaDeSalud.conseguirOrdenes().getTamano() - 1; ii >= 0; ii--) {
			Orden orden = SistemaDeSalud.conseguirOrdenes().obtenerElemento(ii);
			if (orden.getIdentificador().equals(idOrden)) {
				return ii;
			}
		}
		return -1;
	} // private int buscarIndice(String idOrden)

} // public class ControladorAutorizarExamen
