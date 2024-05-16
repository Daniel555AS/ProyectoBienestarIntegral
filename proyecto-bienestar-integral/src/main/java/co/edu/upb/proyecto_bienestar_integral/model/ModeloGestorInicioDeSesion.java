package co.edu.upb.proyecto_bienestar_integral.model;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.PersonaAdministrativa;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.SistemaDeSalud;

public class ModeloGestorInicioDeSesion {

	public PersonaAdministrativa validarInicioSesion(String identificacion, String contrasena) {
		Lista<PersonaAdministrativa> personalAdministrativo = SistemaDeSalud.conseguirPersonalAdministrativo();
		int cantidadPersonalAdministrativo = personalAdministrativo.getTamano();
		PersonaAdministrativa admin;
		for (int ii = 0; ii < cantidadPersonalAdministrativo; ii++) {
			admin = personalAdministrativo.obtenerElemento(ii);
			if (admin.getIdentificacion().equals(identificacion) && admin.getContrasena().equals(contrasena)) {
				return admin;
			}
		}
		return null;
	} // public PersonaAdministrativa validarInicioSesion(String identificacion, String contrasena)

} // public class ModeloGestorInicioDeSesion
