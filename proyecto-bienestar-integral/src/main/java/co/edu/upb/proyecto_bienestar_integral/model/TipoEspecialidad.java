package co.edu.upb.proyecto_bienestar_integral.model;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;

public enum TipoEspecialidad {
	CARDIOLOGIA("Cardilogía", new ListaEnlazada<>()),
	NEUROLOGIA("Neurología", new ListaEnlazada<>()),
	OFTALMOLOGIA("Oftalmología", new ListaEnlazada<>());
	
	private String nombre;
	private Lista<TipoExamen> examenes;
	
	private TipoEspecialidad(String nombre, Lista<TipoExamen> examenes) {
		this.nombre = nombre;
		this.examenes = examenes;
	}
	public Lista<TipoExamen> getExamenes() {
		return examenes;
	}
	
	public void agregarExamen(TipoExamen examen) {
		this.getExamenes().agregarAlFinal(examen);
	}
	
    @Override
    public String toString() {
        return nombre;
    }
}
