package co.edu.upb.proyecto_bienestar_integral.model;

import co.edu.upb.proyecto_bienestar_integral.estructuras.Lista;
import co.edu.upb.proyecto_bienestar_integral.model.logicadelsistema.Cita;

public class ModeloTaquillaPagos {

	public void pagarCita(Cita cita) {
		Lista<Cita> citas = SistemaDeSalud.conseguirCitas();
		for(int ii = citas.getTamano() - 1; ii >= 0; ii--) {
			if(citas.obtenerElemento(ii).getIdentificador().equals(cita.getIdentificador())) {
				SistemaDeSalud.conseguirCitas().obtenerElemento(ii).setEstadoPago(true);
				GestorBaseDeDatos.agregarCitaColasEsperaBD(citas.obtenerElemento(ii));
				break;
			}
		}
		GestorBaseDeDatos.actualizarEstadoOrden(cita.getIdentificador());	
	}
		
} // public class ModeloTaquillaPagos 
