package co.edu.upb.proyecto_bienestar_integral.model;

import java.sql.Date;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.Orden;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.SistemaDeSalud;

public class ModeloAgendaMedica {

	public Lista<Orden> filtrarOrdenesPorFecha(String especialidad, Date fecha) {
		Lista<Orden> ordenes = SistemaDeSalud.conseguirOrdenes();
		Lista<Orden> ordenesFiltradas = new ListaDoblementeEnlazada<>();
		for (int ii = ordenes.getTamano() - 1; ii >= 0; ii--) {
			if (ordenes.obtenerElemento(ii).getEspecialidad().equals(especialidad)
					&& fecha.toLocalDate().isEqual(ordenes.obtenerElemento(ii).getFecha().toLocalDate())) {
				ordenesFiltradas.agregarAlFinal(ordenes.obtenerElemento(ii));
			} 
		}
		return ordenesFiltradas;
	} //

} // public class ModeloAgendaMedica
