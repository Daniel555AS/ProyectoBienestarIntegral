package co.edu.upb.proyecto_bienestar_integral.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.edu.upb.proyecto_bienestar_integral.estructuras.Lista;
import co.edu.upb.proyecto_bienestar_integral.estructuras.ListaDoblementeEnlazada;

public class ModeloRegistroCitaValoracionControl {
	
	public String obtenerIdCita(String especialidadEntrada, String motivo) {
		String idCita = "";
		ListaDoblementeEnlazada<TipoEspecialidad> especialidades = TipoEspecialidad.obtenerEspecialiades();
		for (int ii = 0; ii < especialidades.getTamano(); ii++) {
			TipoEspecialidad especialidad = especialidades.obtenerElemento(ii);
			if (especialidad.getNombre().equals(especialidadEntrada)) {
				idCita = especialidad.getAbreviatura() + obtenerAbreviaturaMotivo(motivo) + obtenerNumeroAlFinal(especialidadEntrada, motivo);
			}
		}
		return idCita;
	}
	
	public int obtenerCostoConsulta(String motivo, String especialidadEntrada) {
		if(motivo.equals("Control")) {
			return 0;
		} else if(especialidadEntrada.equals("Medicina General")) {
			return 35000;
		}
		return 50000;
		
	}
	
	public ProfesionalSalud obtenerProfesionalSalud(String especialidad) {
		Lista<ProfesionalSalud> profesionalesSalud = SistemaDeSalud.conseguirProfesionalesSalud();
		ProfesionalSalud profesional;
		for(int ii = 0; ii < profesionalesSalud.getTamano(); ii++) {
			profesional = profesionalesSalud.obtenerElemento(ii);
			if(profesional.getEspecialidad().equals(especialidad) && profesional.getServicio().equals("Consulta")) {
				return profesional;
			}
		}
		return null;
	}

	private int obtenerNumeroAlFinal(String especialidad, String motivo) {
		Lista<Cita> citas = SistemaDeSalud.conseguirCitas();
		
		for(int ii = citas.getTamano() - 1; ii >= 0; ii--) {
			Cita cita = citas.obtenerElemento(ii);
			if(cita.getEspecialidad().equals(especialidad) && cita.getMotivo().equals(motivo)) {
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
	
	private String obtenerAbreviaturaMotivo(String motivo) {
		if(motivo.equals("Valoración")) {
			return "V";
		}
		return "C";
	}
	
}
