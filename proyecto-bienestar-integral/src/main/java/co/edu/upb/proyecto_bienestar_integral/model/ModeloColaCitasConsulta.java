package co.edu.upb.proyecto_bienestar_integral.model;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.Cita;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.GestorBaseDeDatos;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.SistemaDeSalud;

public class ModeloColaCitasConsulta {
	
	public Cola<Cita> obtenerColaActual(String especialidad) {
		Cola<Cita> citas = GestorBaseDeDatos.obtenerColaCitas(especialidad, "Valoración", "Control");
		return citas;
	}
	
	public void quitarCitaDeLaCola(String id) {
		GestorBaseDeDatos.eliminarCitaDeColaEspera(id);
		GestorBaseDeDatos.actualizarEstadoAtendidoCita(id);
		for(int ii = SistemaDeSalud.conseguirCitas().getTamano() - 1; ii >= 0; ii--) {
			if(SistemaDeSalud.conseguirCitas().obtenerElemento(ii).getIdentificador().equals(id)) {
				SistemaDeSalud.conseguirCitas().obtenerElemento(ii).setEstadoAtendido(true);
				return;
			}
		}
	} // public void quitarCitaDeLaCola(String id)
	
}
