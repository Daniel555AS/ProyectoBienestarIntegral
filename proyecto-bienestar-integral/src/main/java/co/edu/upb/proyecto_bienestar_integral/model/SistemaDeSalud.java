package co.edu.upb.proyecto_bienestar_integral.model;

import java.util.Comparator;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;

public class SistemaDeSalud {
	
	private static Lista<PersonaAdministrativa> administrativos;
	private static Lista<Paciente> pacientes;
	
	public static void iniciarSistemaDeSalud() {
		administrativos = GestorBaseDeDatos.obtenerPersonasAdministrativas();
		pacientes = GestorBaseDeDatos.obtenerPacientes();
		ordenarPacientesPorId();
	}
	
	public static Lista<Paciente> conseguirPacientes() {
		return pacientes;
	}
	
	public static Lista<PersonaAdministrativa> conseguirPersonalAdministrativo() {
		return administrativos;
	}
	
	public static void ordenarPacientesPorId() {
		ComparadorIdentificacionPaciente comparador = new ComparadorIdentificacionPaciente();
		pacientes.ordenar(comparador);
	}
	
	public static void iniciarEspecialidades() {
		// Asignar examenes correspondientes a Cardiología:
		TipoEspecialidad.CARDIOLOGIA.agregarExamen(TipoExamen.ELECTROCARDIOGRAMA);
		TipoEspecialidad.CARDIOLOGIA.agregarExamen(TipoExamen.ECOCARDIOGRAFIA);
		TipoEspecialidad.CARDIOLOGIA.agregarExamen(TipoExamen.PRUEBA_DE_ESFUERZO);
		
		// Asignar exámenes correspondientes a Neurología:
		TipoEspecialidad.NEUROLOGIA.agregarExamen(TipoExamen.ELECTROENCEFALOGRAMA);
		
		// Asignar exámenes correspondientes a Oftalmología:
		TipoEspecialidad.OFTALMOLOGIA.agregarExamen(TipoExamen.TONOMETRIA);
	} // public static void iniciarEspecialidades() 
	
} // public class SistemaDeSalud 
