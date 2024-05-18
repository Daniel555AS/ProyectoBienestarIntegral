package co.edu.upb.proyecto_bienestar_integral;

import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.SistemaDeSalud;
import co.edu.upb.proyecto_bienestar_integral.view.*;

public class App {

	public static void main(String[] args) {
		// Se Inicializa el Sistema de Salud, al ejecutar el Software:
		SistemaDeSalud.iniciarSistemaDeSalud();
		// Se Inicializan las características de Especialidades del Centro de Salud, al
		// ejecutar el Software:
		SistemaDeSalud.iniciarEspecialidades();
		// Se crea una nueva VistaInicioDeSesion:
		VistaInicioDeSesion vistaInicioDeSesion = new VistaInicioDeSesion();
		// Se permite la visibilización del objeto anteriormente creado:
		vistaInicioDeSesion.setVisible(true);
	} // main

} // public class App
