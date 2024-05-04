package co.edu.upb.proyecto_bienestar_integral.controller;

import co.edu.upb.proyecto_bienestar_integral.view.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import co.edu.upb.proyecto_bienestar_integral.estructuras.Lista;
import co.edu.upb.proyecto_bienestar_integral.estructuras.ListaDoblementeEnlazada;
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
		String estadoOrden = panelRegistroCitaExamen.getlblEstadoEncontrado();
		if (!nombrePaciente.equals("ID No Encontrado")) {
			if (estadoOrden.equals("Orden No Autorizada")) {
				JOptionPane.showMessageDialog(null, "La Orden Ingresada No Se Encuentra Autorizada.",
						"ERROR - REGISTRO DE CITA EXAMEN", JOptionPane.ERROR_MESSAGE);
				return;
			}
			Orden ordenR = buscarOrdenPorId(panelRegistroCitaExamen.getCampoIdOrden());
			String idCita = obtenerIdCita(ordenR);
			Cita citaRegistrar = new Cita(idCita, ordenR.getIdPaciente(), ordenR.getEspecialidad(), ordenR.getTipoExamen(),
					"Examen", ordenR.getProfesionalAsignado(), ordenR.getCosto(), ordenR.getComentario());
			citaRegistrar.setFecha(ordenR.getFecha());
			citaRegistrar.setHora(ordenR.getHora());
			modeloRegistroCitaExamen.agregaCita(citaRegistrar);
			JOptionPane.showMessageDialog(null, "la Cita Examen Ha Sido Registrada Exitosamente", "OPERACiÓN EXITOSA", JOptionPane.INFORMATION_MESSAGE);
			VistaMenuPrincipal.mostrarPanel(new PanelPrincipal());
			return;
		}
		JOptionPane.showMessageDialog(null, "No Se Ha Encontrado Orden Médica Asociada a la ID Ingresado.",
				"ERROR - REGISTRO DE CITA EXAMEN", JOptionPane.ERROR_MESSAGE);
	} // public void Registrar()

	private Orden buscarOrdenPorId(String idOrden) {
		Lista<Orden> ordenes = SistemaDeSalud.conseguirOrdenes();
		for (int ii = ordenes.getTamano() - 1; ii >= 0; ii--) {
			Orden orden = ordenes.obtenerElemento(ii);
			if (orden.getIdentificador().equals(idOrden)) {
				return orden;
			}
		}
		return null;
	}

	private String obtenerIdCita(Orden orden) {
		String idCita = "";
		ListaDoblementeEnlazada<TipoEspecialidad> especialidades = TipoEspecialidad.obtenerEspecialiades();
		for (int ii = 0; ii < especialidades.getTamano(); ii++) {
			TipoEspecialidad especialidad = especialidades.obtenerElemento(ii);
			if (especialidad.getNombre().equals(orden.getEspecialidad())) {
				idCita = especialidad.getAbreviatura() + "E" + obtenerNumeroAlFinal(orden);
			}
		}
		return idCita;
	}

	private int obtenerNumeroAlFinal(Orden orden) {
		Lista<Cita> citas = SistemaDeSalud.conseguirCitas();
		
		for(int ii = citas.getTamano() - 1; ii >= 0; ii--) {
			Cita cita = citas.obtenerElemento(ii);
			if(cita.getEspecialidad().equals(orden.getEspecialidad()) && cita.getMotivo().equals("Examen")) {
				Pattern patron = Pattern.compile("\\d+$");
				Matcher matcher = patron.matcher(cita.getIdentificador());

				if (matcher.find()) {
					return Integer.parseInt(matcher.group()) + 1;
				} else {
					return -1; // Si no se encuentra ningún número al final
				}
			}
		}
		return 0;
	}

}
