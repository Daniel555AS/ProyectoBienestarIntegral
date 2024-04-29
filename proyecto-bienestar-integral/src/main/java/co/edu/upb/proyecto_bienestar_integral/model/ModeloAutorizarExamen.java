package co.edu.upb.proyecto_bienestar_integral.model;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;

public class ModeloAutorizarExamen {

	public Pila<Orden> obtenerOrdenesPorAutorizar(String idHistoriaClinica) {
		return GestorBaseDeDatos.obtenerPilaOrdenesPorAutorizar(idHistoriaClinica);
	}
	
} // public class ModeloAutorizarExamen 