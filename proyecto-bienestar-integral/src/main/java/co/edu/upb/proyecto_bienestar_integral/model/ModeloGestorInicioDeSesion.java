package co.edu.upb.proyecto_bienestar_integral.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloGestorInicioDeSesion {
	
    public boolean validarInicioSesion(String identificacion, String contrasena) {
        try (Connection conexion = GestorBaseDeDatos.obtenerConexion()) {
            String consulta = "SELECT * FROM personal_administrativo WHERE identificacion = ? AND contrasena = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, identificacion);
            statement.setString(2, contrasena);
            ResultSet resultado = statement.executeQuery();
            return resultado.next(); // Si hay resultados, entonces, las credenciales son válidas
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } // public boolean validarInicioSesion

} // public class ModeloGestorInicioDeSesion 
