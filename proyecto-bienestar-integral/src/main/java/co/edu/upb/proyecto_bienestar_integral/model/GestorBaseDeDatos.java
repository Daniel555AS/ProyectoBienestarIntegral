package co.edu.upb.proyecto_bienestar_integral.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;
import co.edu.upb.proyecto_bienestar_integral.model.*;

public class GestorBaseDeDatos {
	private static final String URL = "jdbc:mysql://localhost:3307/bienestar_integral";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
    
    public static Lista<Paciente> obtenerPacientes() {
        Lista<Paciente> pacientes = new ListaDoblementeEnlazada<>();
        Connection conexion = null;
        PreparedStatement consulta = null;
        ResultSet resultados = null;

        try {
            conexion = obtenerConexion();
            consulta = conexion.prepareStatement("SELECT * FROM pacientes");
            resultados = consulta.executeQuery();

            while (resultados.next()) {
                String nombres = resultados.getString("nombres");
                String apellidos = resultados.getString("apellidos");
                String nombreCompleto = resultados.getString("nombre_completo");
                int edad = resultados.getInt("edad");
                String telefono = resultados.getString("telefono");
                String tipoId = resultados.getString("tipo_identificacion");
                String identificacion = resultados.getString("identificacion");
                String idHistoriaClinica = resultados.getString("id_historia_clinica");

                Paciente paciente = new Paciente(nombres, apellidos, nombreCompleto, edad, telefono, tipoId, identificacion, idHistoriaClinica);

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
    } // public static Lista<Paciente> obtenerPacientes() 
    
    // Método public static que obtiene a las Personas Administrativas de la Base de Datos, como una Lista:
    public static Lista<PersonaAdministrativa> obtenerPersonasAdministrativas() {
        Lista<PersonaAdministrativa> administrativos = new ListaDoblementeEnlazada<>();
        Connection conexion = null;
        PreparedStatement consulta = null;
        ResultSet resultados = null;

        try {
            conexion = obtenerConexion();
            consulta = conexion.prepareStatement("SELECT * FROM personal_administrativo");
            resultados = consulta.executeQuery();

            while (resultados.next()) {
                String nombres = resultados.getString("nombres");
                String apellidos = resultados.getString("apellidos");
                String nombreCompleto = resultados.getString("nombre_completo");
                int edad = resultados.getInt("edad");
                String telefono = resultados.getString("telefono");
                String tipoId = resultados.getString("tipo_identificacion");
                String identificacion = resultados.getString("identificacion");
                String contrasena = resultados.getString("contrasena");

                PersonaAdministrativa administrativo = new PersonaAdministrativa(nombres, apellidos, nombreCompleto, edad, telefono, tipoId, identificacion, contrasena);

                administrativos.agregarAlFinal(administrativo);
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

        return administrativos;
    }
    
    public static void agregarPacienteBD(Paciente paciente) {
        Connection conexion = null;
        PreparedStatement consulta = null;

        try {
            conexion = obtenerConexion();
            consulta = conexion.prepareStatement("INSERT INTO pacientes (id_historia_clinica, nombres, apellidos, nombre_completo, edad, telefono, tipo_identificacion, identificacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            consulta.setString(1, paciente.getIdHistoriaClinica());
            consulta.setString(2, paciente.getNombres());
            consulta.setString(3, paciente.getApellidos());
            consulta.setString(4, paciente.getNombreCompleto());
            consulta.setInt(5, paciente.getEdad());
            consulta.setString(6, paciente.getTelefono());
            consulta.setString(7, paciente.getTipoId());
            consulta.setString(8, paciente.getIdentificacion());

            consulta.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierre de recursos
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
    } // public static void agregarPacienteBD(Paciente paciente)
    
    
    
} // public class GestorBaseDeDatos 
