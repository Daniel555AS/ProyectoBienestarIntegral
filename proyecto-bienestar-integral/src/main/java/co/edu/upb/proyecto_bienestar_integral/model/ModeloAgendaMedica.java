package co.edu.upb.proyecto_bienestar_integral.model;

import java.sql.Date;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;

public class ModeloAgendaMedica {

	public Lista<Orden> filtrarOrdenesPorFecha(String especialidad, Date fecha) {
		SistemaDeSalud.ordenarOrdenesPorFecha();
		Lista<Orden> ordenes = SistemaDeSalud.conseguirOrdenes();
		Lista<Orden> ordenesFiltradas = new ListaDoblementeEnlazada<>();
		for (int ii = ordenes.getTamano() - 1; ii >= 0; ii--) {
			if (ordenes.obtenerElemento(ii).getEspecialidad().equals(especialidad)
					&& ordenes.obtenerElemento(ii).getFecha().equals(fecha)) {
				ordenesFiltradas.agregarAlFinal(ordenes.obtenerElemento(ii));
			} else if (ordenes.obtenerElemento(ii).getFecha().after(fecha)) {
				return ordenesFiltradas;
			} 
		}
		return ordenesFiltradas;
	} //

} // public class ModeloAgendaMedica
