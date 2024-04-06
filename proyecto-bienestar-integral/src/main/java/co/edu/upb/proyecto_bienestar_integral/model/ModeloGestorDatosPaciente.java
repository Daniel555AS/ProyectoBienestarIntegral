package co.edu.upb.proyecto_bienestar_integral.model;

import java.math.BigInteger;

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

}
