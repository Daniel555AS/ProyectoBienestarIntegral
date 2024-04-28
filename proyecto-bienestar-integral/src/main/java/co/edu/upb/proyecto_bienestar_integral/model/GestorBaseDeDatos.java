package co.edu.upb.proyecto_bienestar_integral.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.sql.Date;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;
import co.edu.upb.proyecto_bienestar_integral.model.*;

public class GestorBaseDeDatos {
	private static final String URL = "";
	private static final String USUARIO = "";
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
				Date fechaNacimiento = resultados.getDate("fecha_nacimiento");
				String telefono = resultados.getString("telefono");
				String tipoId = resultados.getString("tipo_identificacion");
				String identificacion = resultados.getString("identificacion");
				String idHistoriaClinica = resultados.getString("id_historia_clinica");

				Paciente paciente = new Paciente(nombres, apellidos, nombreCompleto, fechaNacimiento, telefono, tipoId,
						identificacion, idHistoriaClinica);

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

	// Método public static que obtiene a las Personas Administrativas de la Base de
	// Datos, como una Lista:
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
				Date fechaNacimiento = resultados.getDate("fecha_nacimiento");
				String telefono = resultados.getString("telefono");
				String tipoId = resultados.getString("tipo_identificacion");
				String identificacion = resultados.getString("identificacion");
				String contrasena = resultados.getString("contrasena");

				PersonaAdministrativa administrativo = new PersonaAdministrativa(nombres, apellidos, nombreCompleto,
						fechaNacimiento, telefono, tipoId, identificacion, contrasena);

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

	public static Lista<ProfesionalSalud> obtenerProfesionalesSalud() {
		Lista<ProfesionalSalud> profesionalesSalud = new ListaDoblementeEnlazada<>();
		Connection conexion = null;
		PreparedStatement consulta = null;
		ResultSet resultados = null;

		try {
			conexion = obtenerConexion();
			consulta = conexion.prepareStatement("SELECT * FROM profesionales_salud");
			resultados = consulta.executeQuery();

			while (resultados.next()) {
				String nombres = resultados.getString("nombres");
				String apellidos = resultados.getString("apellidos");
				String nombreCompleto = resultados.getString("nombre_completo");
				Date fechaNacimiento = resultados.getDate("fecha_nacimiento");
				String telefono = resultados.getString("telefono");
				String tipoId = resultados.getString("tipo_identificacion");
				String identificacion = resultados.getString("identificacion");
				String especialidad = resultados.getString("especialidad");
				String servicio = resultados.getString("servicio");

				ProfesionalSalud profesionalSalud = new ProfesionalSalud(nombres, apellidos, nombreCompleto,
						fechaNacimiento, telefono, tipoId, identificacion, especialidad, servicio);

				profesionalesSalud.agregarAlFinal(profesionalSalud);
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

		return profesionalesSalud;
	}
	
	
	public static Lista<Orden> obtenerOrdenes() {
		Lista<Orden> ordenes = new ListaDoblementeEnlazada<>();
		Connection conexion = null;
		PreparedStatement consulta = null;
		ResultSet resultados = null;

		try {
			conexion = obtenerConexion();
			consulta = conexion.prepareStatement("SELECT * FROM ordenes");
			resultados = consulta.executeQuery();

			while (resultados.next()) {			
				String identificador = resultados.getString("id_orden");
				String especialidad = resultados.getString("especialidad");
				String tipoExamen = resultados.getString("examen");
				String idPaciente = resultados.getString("id_historia_clinica_paciente");
				int costo = resultados.getInt("costo");
				String descripcion = resultados.getString("descripcion");
				boolean estado = resultados.getBoolean("estado");
				Date fecha = resultados.getDate("fecha");
				Time hora = resultados.getTime("hora");
				String idProfesionalAsignado = resultados.getString("id_profesional_asignado");
				ProfesionalSalud profesionalAsigando = obtenerProfesionalSaludAsignado(idProfesionalAsignado);
				
				Orden orden = new Orden(identificador, especialidad, tipoExamen, idPaciente, costo, descripcion, fecha,profesionalAsigando);
				orden.setHora(hora);
				orden.setEstado(estado);
			
				ordenes.agregarAlFinal(orden);
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

		return ordenes;
	} // public static Lista<Paciente> obtenerPacientes()
	
	public static void agregarPacienteBD(Paciente paciente) {
		Connection conexion = null;
		PreparedStatement consulta = null;

		try {
			conexion = obtenerConexion();
			consulta = conexion.prepareStatement(
					"INSERT INTO pacientes (id_historia_clinica, nombres, apellidos, nombre_completo, telefono, tipo_identificacion, identificacion, fecha_nacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			consulta.setString(1, paciente.getIdHistoriaClinica());
			consulta.setString(2, paciente.getNombres());
			consulta.setString(3, paciente.getApellidos());
			consulta.setString(4, paciente.getNombreCompleto());
			consulta.setString(5, paciente.getTelefono());
			consulta.setString(6, paciente.getTipoId());
			consulta.setString(7, paciente.getIdentificacion());
			consulta.setDate(8, paciente.getFechaNacimiento());

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
	
	private static ProfesionalSalud obtenerProfesionalSaludAsignado(String id) {
		Lista<ProfesionalSalud> profesionales = SistemaDeSalud.conseguirProfesionalesSalud();
		for(int ii = 0; ii < profesionales.getTamano(); ii++) {
			if(profesionales.obtenerElemento(ii).equals(id)) {
				return profesionales.obtenerElemento(ii);
			}
		}
		return null;
	}

} // public class GestorBaseDeDatos
