package co.edu.upb.proyecto_bienestar_integral.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import co.edu.upb.proyecto_bienestar_integral.estructuras.*;
import co.edu.upb.proyecto_bienestar_integral.model.logicadelsistema.Cita;

public class GestorBaseDeDatos {
	private static final String URL = ""; // Url de Base de Datos
	private static final String USUARIO = ""; // Usuario de Base de Datos
	private static final String CONTRASENA = ""; // Contraseña de Base de Datos

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
				String comentario = resultados.getString("comentario");
				ProfesionalSalud profesionalAsigando = obtenerProfesionalSaludAsignado(idProfesionalAsignado);

				Orden orden = new Orden(identificador, especialidad, tipoExamen, idPaciente, costo, descripcion, fecha,
						profesionalAsigando, comentario);
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
	} // public static Lista<Orden> obtenerOrdenes()

	public static Lista<Cita> obtenerCitas() {
		Lista<Cita> citas = new ListaDoblementeEnlazada<>();
		Connection conexion = null;
		PreparedStatement consulta = null;
		ResultSet resultados = null;

		try {
			conexion = obtenerConexion();
			consulta = conexion.prepareStatement("SELECT * FROM citas ORDER BY id_cita ASC");
			resultados = consulta.executeQuery();

			while (resultados.next()) {
				String id = resultados.getString("id_cita");
				String idHistoriaClinicaPaciente = resultados.getString("id_historia_clinica_paciente");
				String especialidad = resultados.getString("especialidad");
				String servicio = resultados.getString("servicio");
				String motivo = resultados.getString("motivo");
				String profesional = resultados.getString("id_profesional_asignado");
				int costo = resultados.getInt("costo");
				boolean estadoPago = resultados.getBoolean("estado_pago");
				boolean estadoAtendido = resultados.getBoolean("estado_atendido");
				String comentario = resultados.getString("comentario");
				Date fecha = resultados.getDate("fecha");
				Time hora = resultados.getTime("hora");
				ProfesionalSalud profesionalAsignado = obtenerProfesionalSaludAsignado(profesional);

				Cita cita = new Cita(id, idHistoriaClinicaPaciente, especialidad, servicio, motivo, profesionalAsignado,
						costo, estadoPago, estadoAtendido, comentario, fecha, hora);

				citas.agregarAlFinal(cita);
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

		return citas;
	} // public static Lista<Cita> obtenerCitas()

	public static void actualizarEstadoPagoCita(String idCita) {
		Connection conexion = null;
		PreparedStatement consulta = null;

		try {
			conexion = obtenerConexion();
			consulta = conexion.prepareStatement("UPDATE citas SET estado_pago = true WHERE id_cita = ?");
			consulta.setString(1, idCita);
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
	}

	public static Lista<Cita> obtenerCitasPendientesPorPagar() {
		Lista<Cita> citas = new ListaDoblementeEnlazada<>();
		Connection conexion = null;
		PreparedStatement consulta = null;
		ResultSet resultados = null;

		try {
			conexion = obtenerConexion();
			consulta = conexion.prepareStatement("SELECT * FROM citas WHERE estado_pago = false ORDER BY id_cita ASC");
			resultados = consulta.executeQuery();

			while (resultados.next()) {
				String id = resultados.getString("id_cita");
				String idHistoriaClinicaPaciente = resultados.getString("id_historia_clinica_paciente");
				String especialidad = resultados.getString("especialidad");
				String servicio = resultados.getString("servicio");
				String motivo = resultados.getString("motivo");
				String profesional = resultados.getString("id_profesional_asignado");
				int costo = resultados.getInt("costo");
				boolean estadoPago = resultados.getBoolean("estado_pago");
				boolean estadoAtendido = resultados.getBoolean("estado_atendido");
				String comentario = resultados.getString("comentario");
				Date fecha = resultados.getDate("fecha");
				Time hora = resultados.getTime("hora");
				ProfesionalSalud profesionalAsignado = obtenerProfesionalSaludAsignado(profesional);

				Cita cita = new Cita(id, idHistoriaClinicaPaciente, especialidad, servicio, motivo, profesionalAsignado,
						costo, estadoPago, estadoAtendido, comentario, fecha, hora);

				citas.agregarAlFinal(cita);
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

		return citas;
	}

	public static Pila<Orden> obtenerPilaOrdenesPorAutorizar(String idHistoriaClinica) {
		Pila<Orden> ordenes = new Pila<>();
		Connection conexion = null;
		PreparedStatement consulta = null;
		ResultSet resultados = null;

		try {
			conexion = obtenerConexion();
			String sql = "SELECT * FROM ordenes WHERE id_historia_clinica_paciente = ? AND estado = false ORDER BY fecha ASC";
			consulta = conexion.prepareStatement(sql);
			consulta.setString(1, idHistoriaClinica);
			resultados = consulta.executeQuery();

			while (resultados.next()) {
				String identificador = resultados.getString("id_orden");
				String especialidad = resultados.getString("especialidad");
				String tipoExamen = resultados.getString("examen");
				int costo = resultados.getInt("costo");
				String descripcion = resultados.getString("descripcion");
				Date fecha = resultados.getDate("fecha");
				Time hora = resultados.getTime("hora");
				String idProfesionalAsignado = resultados.getString("id_profesional_asignado");
				String comentario = resultados.getString("comentario");
				ProfesionalSalud profesionalAsignado = obtenerProfesionalSaludAsignado(idProfesionalAsignado);

				Orden orden = new Orden(identificador, especialidad, tipoExamen, idHistoriaClinica, costo, descripcion,
						fecha, profesionalAsignado, comentario);
				orden.setHora(hora);
				ordenes.push(orden);
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
	}

	public static Cola<Cita> obtenerColaCitas(String especialidad, String motivo1, String motivo2) {
		Cola<Cita> colaCitas = new Cola<>();
		Connection conexion = null;
		PreparedStatement consulta = null;
		ResultSet resultados = null;

		try {
			conexion = obtenerConexion();
			consulta = conexion.prepareStatement(
					"SELECT * FROM colas_espera WHERE especialidad = ? AND (motivo = ? OR motivo = ?)");
			consulta.setString(1, especialidad);
			consulta.setString(2, motivo1);
			consulta.setString(3, motivo2);
			resultados = consulta.executeQuery();

			while (resultados.next()) {
				String idCita = resultados.getString("id_cita_en_cola");
				Cita cita = obtenerCitaSegunId(idCita);
				if (cita != null) {
					colaCitas.enqueue(cita);
				}
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

		return colaCitas;
	}

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

	public static void agregarCitaBD(Cita cita) {
		Connection conexion = null;
		PreparedStatement consulta = null;

		try {
			conexion = obtenerConexion();
			consulta = conexion.prepareStatement(
					"INSERT INTO citas (id_cita, id_historia_clinica_paciente, especialidad, servicio, motivo, id_profesional_asignado, costo, estado_pago, estado_atendido, comentario, fecha, hora) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			consulta.setString(1, cita.getIdentificador());
			consulta.setString(2, cita.getIdHistoriaClinicaPaciente());
			consulta.setString(3, cita.getEspecialidad());
			consulta.setString(4, cita.getServicio());
			consulta.setString(5, cita.getMotivo());
			consulta.setString(6, cita.getProfesionalAsignado().getIdentificacion());
			consulta.setInt(7, cita.getCosto());
			consulta.setBoolean(8, cita.getEstadoPago());
			consulta.setBoolean(9, cita.getEstadoAtendido());
			consulta.setString(10, cita.getComentario());
			consulta.setDate(11, cita.getFecha());
			consulta.setTime(12, cita.getHora());

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

	public static void agregarOrdenBD(Orden orden) {
		Connection conexion = null;
		PreparedStatement consulta = null;

		try {
			conexion = obtenerConexion();
			consulta = conexion.prepareStatement(
					"INSERT INTO ordenes (id_orden, especialidad, examen, id_historia_clinica_paciente, costo, descripcion, comentario, estado, fecha, hora, id_profesional_asignado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			consulta.setString(1, orden.getIdentificador());
			consulta.setString(2, orden.getEspecialidad());
			consulta.setString(3, orden.getTipoExamen());
			consulta.setString(4, orden.getIdPaciente());
			consulta.setInt(5, orden.getCosto());
			consulta.setString(6, orden.getDescripcion());
			consulta.setString(7, orden.getComentario());
			consulta.setBoolean(8, orden.getEstado());
			consulta.setDate(9, orden.getFecha());
			consulta.setTime(10, orden.getHora());
			consulta.setString(11, orden.getProfesionalAsignado().getIdentificacion());

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
	} // public static void agregarOrdenBD(Orden orden)

	public static void agregarCitaColasEsperaBD(Cita cita) {
		Connection conexion = null;
		PreparedStatement consulta = null;

		try {
			conexion = obtenerConexion();
			consulta = conexion.prepareStatement(
					"INSERT INTO colas_espera (id_cita_en_cola, id_historia_clinica_paciente, especialidad, motivo) VALUES (?, ?, ?, ?)");
			consulta.setString(1, cita.getIdentificador());
			consulta.setString(2, cita.getIdHistoriaClinicaPaciente());
			consulta.setString(3, cita.getEspecialidad());
			consulta.setString(4, cita.getMotivo());

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
	} // public void agregarCitaColasEsperaBD(Cita cita)

	public static void actualizarEstadoOrden(String idOrden) {
		Connection conexion = null;
		PreparedStatement consulta = null;

		try {
			conexion = obtenerConexion();
			String sql = "UPDATE ordenes SET estado = true WHERE id_orden = ?";
			consulta = conexion.prepareStatement(sql);
			consulta.setString(1, idOrden);
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
	}
	
	public static void actualizarEstadoAtendidoCita(String idCita) {
	    Connection conexion = null;
	    PreparedStatement consulta = null;

	    try {
	        conexion = obtenerConexion();
	        consulta = conexion.prepareStatement("UPDATE citas SET estado_atendido = true WHERE id_cita = ?");
	        consulta.setString(1, idCita);
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
	}
	

	public static void eliminarCitaDeColaEspera(String idCitaEnCola) {
		Connection conexion = null;
		PreparedStatement consulta = null;

		try {
			conexion = obtenerConexion();
			consulta = conexion.prepareStatement("DELETE FROM colas_espera WHERE id_cita_en_cola = ?");
			consulta.setString(1, idCitaEnCola);
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
	}

	private static ProfesionalSalud obtenerProfesionalSaludAsignado(String id) {
		Lista<ProfesionalSalud> profesionales = SistemaDeSalud.conseguirProfesionalesSalud();
		for (int ii = 0; ii < profesionales.getTamano(); ii++) {
			if (profesionales.obtenerElemento(ii).getIdentificacion().equals(id)) {
				return profesionales.obtenerElemento(ii);
			}
		}
		return null;
	}

	private static Cita obtenerCitaSegunId(String id) {
		Cita cita = null;
		Lista<Cita> citas = SistemaDeSalud.conseguirCitas();
		for (int ii = citas.getTamano() - 1; ii >= 0; ii--) {
			cita = citas.obtenerElemento(ii);
			if (cita.getIdentificador().equals(id)) {
				return cita;
			}
		}
		return cita;
	}

	private static Paciente obtenerPacienteSegunId(String id) {
		Paciente paciente = null;
		Lista<Paciente> pacientes = SistemaDeSalud.conseguirPacientes();
		for (int ii = 0; ii < pacientes.getTamano(); ii++) {
			paciente = pacientes.obtenerElemento(ii);
			if (paciente.getIdentificacion().equals(id)) {
				return paciente;
			}
		}
		return paciente;
	}

} // public class GestorBaseDeDatos
