package co.edu.upb.proyecto_bienestar_integral.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;
import co.edu.upb.proyecto_bienestar_integral.model.*;

public class GestorBaseDeDatos {
	private static final String URL = "***";
    private static final String USUARIO = "***";
    private static final String CONTRASENA = "**";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
    
    public Lista<Paciente> obtenerPacientes() {
        Lista<Paciente> pacientes = new ListaDoblementeEnlazada<>();
        Connection conexion = null;
        PreparedStatement consulta = null;
        ResultSet resultados = null;

        try {
            conexion = obtenerConexion();
            consulta = conexion.prepareStatement("SELECT * FROM paciente");
            resultados = consulta.executeQuery();

            while (resultados.next()) {
                String nombres = resultados.getString("nombres");
                String apellidos = resultados.getString("apellidos");
                String nombreCompleto = resultados.getString("nombre_completo");
                int edad = resultados.getInt("edad");
                String telefono = resultados.getString("telefono");
                String identificacion = resultados.getString("identificacion");
                String idHistoriaClinica = resultados.getString("id_historia_clinica");

                Paciente paciente = new Paciente(nombres, apellidos, nombreCompleto, edad, telefono, identificacion, idHistoriaClinica);

                pacientes.agregarAlFinal(paciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierre de recursos
            if (resultados != null) {
                try {
                    resultados.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (consulta != null) {
                try {
                    consulta.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return pacientes;
    } // public Lista<Paciente> obtenerPacientes() 
    
    
    
} // public class GestorBaseDeDatos 
