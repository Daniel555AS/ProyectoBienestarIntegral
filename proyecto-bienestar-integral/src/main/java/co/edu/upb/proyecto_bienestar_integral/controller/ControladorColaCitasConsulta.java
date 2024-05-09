package co.edu.upb.proyecto_bienestar_integral.controller;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;
import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.model.logicadelsistema.Cita;
import co.edu.upb.proyecto_bienestar_integral.view.*;

public class ControladorColaCitasConsulta {

	private ModeloColaCitasConsulta modeloColaCitasConsulta;
	private PanelMirarColaConsulta panelMirarColaConsulta;

	public ControladorColaCitasConsulta(ModeloColaCitasConsulta modeloColaCitasConsulta,
			PanelMirarColaConsulta panelMirarColaConsulta) {
		this.modeloColaCitasConsulta = modeloColaCitasConsulta;
		this.panelMirarColaConsulta = panelMirarColaConsulta; 
	}

	public void accederCola(String consultorio, String especialidad, String motivo1, String motivo2) {
		Cola<Cita> colaCitas = modeloColaCitasConsulta.obtenerColaActual(especialidad);
		if (colaCitas.estaVacia()) {
			VistaMenuPrincipal.mostrarPanel(new PanelColaVacia(especialidad));
			return;
		}
		Cita citaActual = colaCitas.dequeue();
		panelMirarColaConsulta.setLblEspecialidad(citaActual.getEspecialidad());
		panelMirarColaConsulta.setPaciente(citaActual.getIdHistoriaClinicaPaciente());
		panelMirarColaConsulta.setIdCita(citaActual.getIdentificador());
		panelMirarColaConsulta.setConsultorio(consultorio);
		VistaMenuPrincipal.mostrarPanel(panelMirarColaConsulta);
	}
	
	public void siguientePaciente() {
		modeloColaCitasConsulta.quitarCitaDeLaCola(panelMirarColaConsulta.getLblDatoIdCita());
		String especialidad = panelMirarColaConsulta.getLblEspecialidad();
		Cola<Cita> colaCitas = modeloColaCitasConsulta.obtenerColaActual(especialidad);
		if (colaCitas.estaVacia()) {
			VistaMenuPrincipal.mostrarPanel(new PanelColaVacia(especialidad));
			return;
		}
		Cita citaActual = colaCitas.dequeue();
		panelMirarColaConsulta.setLblEspecialidad(citaActual.getEspecialidad());
		panelMirarColaConsulta.setPaciente(citaActual.getIdHistoriaClinicaPaciente());
		panelMirarColaConsulta.setIdCita(citaActual.getIdentificador());
		panelMirarColaConsulta.setConsultorio(panelMirarColaConsulta.getLblDatoConsultorio());
	}

} // public class ControladorColaCitasConsulta
