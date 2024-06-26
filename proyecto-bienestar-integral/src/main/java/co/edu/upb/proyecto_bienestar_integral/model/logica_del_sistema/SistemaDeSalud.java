package co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;
import co.edu.upb.proyecto_bienestar_integral.model.ComparadorFechaHoraOrdenes;
import co.edu.upb.proyecto_bienestar_integral.model.ComparadorIdentificacionPaciente;

public class SistemaDeSalud {
	
	private static Lista<PersonaAdministrativa> administrativos;
	private static Lista<Paciente> pacientes;
	private static Lista<Orden> ordenes;
	private static Lista<ProfesionalSalud> profesionalesSalud;
	private static Lista<Cita> citas;
	
	public static void iniciarSistemaDeSalud() {
		administrativos = GestorBaseDeDatos.obtenerPersonasAdministrativas();
		pacientes = GestorBaseDeDatos.obtenerPacientes();
		profesionalesSalud = GestorBaseDeDatos.obtenerProfesionalesSalud();
		ordenes = GestorBaseDeDatos.obtenerOrdenes();
		citas = GestorBaseDeDatos.obtenerCitas();
		ordenarPacientesPorId();
	}
	
	public static Lista<Paciente> conseguirPacientes() {
		return pacientes;
	}
	
	public static Lista<PersonaAdministrativa> conseguirPersonalAdministrativo() {
		return administrativos;
	}
	
	public static Lista<Orden> conseguirOrdenes() {
		return ordenes;
	}
	
	public static Lista<ProfesionalSalud> conseguirProfesionalesSalud() {
		return profesionalesSalud;
	}
	
	public static Lista<Cita> conseguirCitas() {
		return citas;
	}
	
	public static void ordenarPacientesPorId() {
		ComparadorIdentificacionPaciente comparador = new ComparadorIdentificacionPaciente();
		pacientes.ordenar(comparador);
	}
	
	public static void ordenarOrdenesPorFecha() {
		ComparadorFechaHoraOrdenes comparador = new ComparadorFechaHoraOrdenes();
		ordenes.ordenar(comparador);
	}
	
	public static void iniciarEspecialidades() {
		// Asignar examenes correspondientes a Cardiología:
		TipoEspecialidad.CARDIOLOGIA.agregarExamen(TipoExamen.ELECTROCARDIOGRAMA);
		TipoEspecialidad.CARDIOLOGIA.agregarExamen(TipoExamen.ECOCARDIOGRAFIA);
		TipoEspecialidad.CARDIOLOGIA.agregarExamen(TipoExamen.PRUEBA_DE_ESFUERZO);
		
		// Asignar exámenes correspondientes a Neurología:
		TipoEspecialidad.NEUROLOGIA.agregarExamen(TipoExamen.ELECTROENCEFALOGRAMA);
		TipoEspecialidad.NEUROLOGIA.agregarExamen(TipoExamen.TOMOGRAFIA_COMPUTARIZADA);
		TipoEspecialidad.NEUROLOGIA.agregarExamen(TipoExamen.ELECTROMIOGRAFIA);
		
		// Asignar exámenes correspondientes a Oftalmología:
		TipoEspecialidad.OFTALMOLOGIA.agregarExamen(TipoExamen.TONOMETRIA);
		TipoEspecialidad.OFTALMOLOGIA.agregarExamen(TipoExamen.QUERATOMETRIA);
		TipoEspecialidad.OFTALMOLOGIA.agregarExamen(TipoExamen.GONIOSCOPIA);
		
		// Asignar exámenes correspondinetes a Medicina Interna:
		TipoEspecialidad.MEDICINA_INTERNA.agregarExamen(TipoExamen.HEMOGRAMA);
		TipoEspecialidad.MEDICINA_INTERNA.agregarExamen(TipoExamen.PERFIL_LIPIDICO);
		TipoEspecialidad.MEDICINA_INTERNA.agregarExamen(TipoExamen.PERFIL_METABOLICO_BASICO);
		
		// Asignar exámenes correspondientes a Gastroenterología:
		TipoEspecialidad.GASTROENTEROLOGIA.agregarExamen(TipoExamen.COLONOSCOPIA);
		TipoEspecialidad.GASTROENTEROLOGIA.agregarExamen(TipoExamen.ENDOSCOPIA_DIGESTIVA_ALTA);
		TipoEspecialidad.GASTROENTEROLOGIA.agregarExamen(TipoExamen.MANOMETRIA_ESOFAGICA);
		
		
	} // public static void iniciarEspecialidades() 
	
} // public class SistemaDeSalud 
