package co.edu.upb.proyecto_bienestar_integral.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDeDatos {

	private static final String URL = "***";
    private static final String USUARIO = "***";
    private static final String CONTRASENA = "**";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
	
} // public class ConexionBaseDeDatos 
