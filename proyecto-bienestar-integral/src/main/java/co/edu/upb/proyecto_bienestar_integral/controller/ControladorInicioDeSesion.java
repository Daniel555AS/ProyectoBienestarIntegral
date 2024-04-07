package co.edu.upb.proyecto_bienestar_integral.controller;

import co.edu.upb.proyecto_bienestar_integral.view.*;

import javax.swing.JOptionPane;

import co.edu.upb.proyecto_bienestar_integral.model.*;

public class ControladorInicioDeSesion {

	private VistaInicioDeSesion vistaInicioDeSesion;
	private ModeloGestorInicioDeSesion modeloGestorInicioDeSesion;

	public ControladorInicioDeSesion(VistaInicioDeSesion vistaInicioDeSesion,
			ModeloGestorInicioDeSesion modeloGestorInicioDeSesion) {
		this.vistaInicioDeSesion = vistaInicioDeSesion;
		this.modeloGestorInicioDeSesion = modeloGestorInicioDeSesion;
	}

	public void iniciarSesion(String identificacion, String contrasena) {
		if (modeloGestorInicioDeSesion.validarInicioSesion(identificacion, contrasena)) {
			// Si las credenciales son válidas, abrir VistaMenuPrincipal:
			VistaMenuPrincipal vistaMenuPrincipal = new VistaMenuPrincipal();
			vistaMenuPrincipal.setVisible(true);
			vistaInicioDeSesion.setVisible(false);
		} else {
			// Si las credenciales son inválidas, mostrar mensaje de error con JOptionPane
			JOptionPane.showMessageDialog(null, "Los datos ingresados no son válidos. Vuelva a intentarlo.",
					"ERROR - INICIO DE SESIÓN", JOptionPane.ERROR_MESSAGE);
		}
	} // public void iniciarSesion(String identificacion, String contrasena)

} // public class ControladorInicioDeSesion
