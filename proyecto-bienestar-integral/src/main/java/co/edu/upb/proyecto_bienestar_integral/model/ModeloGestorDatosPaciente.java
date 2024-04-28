package co.edu.upb.proyecto_bienestar_integral.model;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Calendar;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;

public class ModeloGestorDatosPaciente {
	
	private boolean validarDatoNumBig(String dato, BigInteger minimo) {
		try {
			BigInteger num = new BigInteger(dato);
			return num.compareTo(minimo) >= 0;
		} catch (NumberFormatException e) {
			return false;
		}
	} // public boolean validarId(String dato, BigInteger minimo)

	private boolean validarDatoNum(String dato, int minimo, int maximo) {
		try {
			int num = Integer.parseInt(dato);
			return num >= minimo && num <= maximo;
		} catch (NumberFormatException e) {
			return false;
		}
	} // private boolean validarDatoNum(String dato, int minimo, int maximo) 

	public boolean validarId(String id) {
		return validarDatoNumBig(id, new BigInteger("10000"));
	} // public boolean validarId(String id)

	public boolean validarTelefono(String telefono) {      
		return validarDatoNumBig(telefono, new BigInteger("3000000000"));
	} // public boolean validarTelefono(String telefono)

	public boolean validarEdad(String edad) {
		return validarDatoNum(edad, 0, 160);
	} // public boolean validarEdad(String edad)

	public boolean validarNombres(String nombres) {
		return !nombres.isBlank();
	} // public boolean validarNombres(String nombres)

	public boolean validarApellidos(String apellidos) {
		return !apellidos.isBlank();
	} // public boolean validarApellidos(String apellidos)
	
	public boolean validarIdUnico(String id) {
		BigInteger numId = new BigInteger(id);
		int cantidadPacientes = SistemaDeSalud.conseguirPacientes().getTamano();
		Lista<Paciente> pacientes = SistemaDeSalud.conseguirPacientes();
		if(numId.compareTo(new BigInteger("500000000")) >= 0) {
			for(int ii = cantidadPacientes - 1; ii >= 0; ii-- ) {
				if(pacientes.obtenerElemento(ii).getIdentificacion().equals(id)) {
					return false;
				}
			}
		} else {
			for(int jj = 0; jj < cantidadPacientes; jj++) {
				if(pacientes.obtenerElemento(jj).getIdentificacion().equals(id)) {
					return false;
				}
			}
		} 
		return true;
	} // public boolean validarIdUnico(String id) 
	
	public boolean validarFechaNacimiento(Date fechaNacimiento) {
	    if (fechaNacimiento != null) {
	        Date fechaActual = new Date(System.currentTimeMillis()); // Obtener la fecha actual del sistema
	        // Creación de un Calendar para la manipulación de fechas:
	        Calendar calFechaSeleccionada = Calendar.getInstance();
	        Calendar calFechaActual = Calendar.getInstance();
	        calFechaSeleccionada.setTime(fechaNacimiento);
	        calFechaActual.setTime(fechaActual);

	        // Asegurarse de que la fecha seleccionada no sea mayor que la fecha actual
	        calFechaActual.add(Calendar.DAY_OF_MONTH, 0); 
	        if (!calFechaSeleccionada.after(calFechaActual)) {
	            // La fecha seleccionada es válida
	            return true;
	        }
	    }
	    return false;
	}

} // public class ModeloGestorDatosPaciente
