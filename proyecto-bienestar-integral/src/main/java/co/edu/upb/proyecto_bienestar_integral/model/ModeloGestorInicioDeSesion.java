package co.edu.upb.proyecto_bienestar_integral.model;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.PersonaAdministrativa;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.SistemaDeSalud;

public class ModeloGestorInicioDeSesion {

	public boolean validarInicioSesion(String identificacion, String contrasena) {
		Lista<PersonaAdministrativa> personalAdministrativo = SistemaDeSalud.conseguirPersonalAdministrativo();
		int cantidadPersonalAdministrativo = personalAdministrativo.getTamano();

		for (int ii = 0; ii < cantidadPersonalAdministrativo; ii++) {
			if (personalAdministrativo.obtenerElemento(ii).getIdentificacion().equals(identificacion)
					&& personalAdministrativo.obtenerElemento(ii).getContrasena().equals(contrasena)) {
				return true;
			}
		}
		return false;
	} // public boolean validarInicioSesion

} // public class ModeloGestorInicioDeSesion
