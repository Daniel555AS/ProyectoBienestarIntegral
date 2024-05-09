package co.edu.upb.proyecto_bienestar_integral.model;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.GestorBaseDeDatos;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.Orden;

public class ModeloAutorizarExamen {

	public Pila<Orden> obtenerOrdenesPorAutorizar(String idHistoriaClinica) {
		return GestorBaseDeDatos.obtenerPilaOrdenesPorAutorizar(idHistoriaClinica);
	}
	
	public void eliminarOrdenCima(String idHistoriaClinica) {
		GestorBaseDeDatos.obtenerPilaOrdenesPorAutorizar(idHistoriaClinica).pop();
	}
	
	
	
} // public class ModeloAutorizarExamen 
