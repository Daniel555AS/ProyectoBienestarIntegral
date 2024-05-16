package co.edu.upb.proyecto_bienestar_integral.controller;

import co.edu.upb.proyecto_bienestar_integral.view.*;
import javax.swing.JOptionPane;
import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.*;

public class ControladorInicioDeSesion {

	private VistaInicioDeSesion vistaInicioDeSesion;
	private ModeloGestorInicioDeSesion modeloGestorInicioDeSesion;

	public ControladorInicioDeSesion(VistaInicioDeSesion vistaInicioDeSesion,
			ModeloGestorInicioDeSesion modeloGestorInicioDeSesion) {
		this.vistaInicioDeSesion = vistaInicioDeSesion;
		this.modeloGestorInicioDeSesion = modeloGestorInicioDeSesion;
	}

	public void iniciarSesion(String identificacion, String contrasena) {
		PersonaAdministrativa admin = modeloGestorInicioDeSesion.validarInicioSesion(identificacion, contrasena);
		if (admin != null) {
			// Si las credenciales son válidas, abrir VistaMenuPrincipal:
			VistaMenuPrincipal vistaMenuPrincipal = new VistaMenuPrincipal();
			VistaMenuPrincipal.setAdminActual(admin);
			PanelPrincipal.setAdminActual(admin);
			GestorBaseDeDatos.agregarElementoHistorial(new ElementoHistorial("Inicio de Sesión", admin));
			vistaMenuPrincipal.setVisible(true);
			vistaInicioDeSesion.setVisible(false);
		} else {
			// Si las credenciales son inválidas, mostrar mensaje de error con JOptionPane
			JOptionPane.showMessageDialog(null, "Los datos ingresados no son válidos. Vuelva a intentarlo.",
					"ERROR - INICIO DE SESIÓN", JOptionPane.ERROR_MESSAGE);
		}
	} // public void iniciarSesion(String identificacion, String contrasena)

} // public class ControladorInicioDeSesion
