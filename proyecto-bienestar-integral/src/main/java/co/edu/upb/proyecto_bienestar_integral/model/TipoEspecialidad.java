package co.edu.upb.proyecto_bienestar_integral.model;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;

public enum TipoEspecialidad {
	CARDIOLOGIA("Cardiología", "CAR" ,new ListaEnlazada<>()),
	NEUROLOGIA("Neurología", "NEU", new ListaEnlazada<>()),
	OFTALMOLOGIA("Oftalmología", "OFT" ,new ListaEnlazada<>());
	
	private String nombre;
	private String abreviatura;
	private Lista<TipoExamen> examenes;
	
	private TipoEspecialidad(String nombre, String abreviatura, Lista<TipoExamen> examenes) {
		this.nombre = nombre;
		this.abreviatura = abreviatura;
		this.examenes = examenes;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getAbreviatura() {
		return abreviatura;
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
