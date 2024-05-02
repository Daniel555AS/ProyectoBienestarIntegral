package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import co.edu.upb.proyecto_bienestar_integral.estructuras.Lista;
import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.view.componentes.*;

public class PanelRegistroCitaExamen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelFondo;
	private JPanel panelDecorativoSup;
	private JLabel lblRegistrarCitaExamen;
	private JLabel lblIdOrden;
	private JLabel lblNombrePacienteEncontrado;
	private JLabel lblIdHistoriaClinicaEncontrado;
	private RoundedPanel panelIdOrden;
	private JTextField campoIdOrden;
	private JLabel lblPaciente;
	private RoundedPanel panelPaciente;
	private JLabel lblIdHistoriaClinica;
	private RoundedPanel panelIdHistoriaClinica;
	private RoundedPanel panelEspecialidad;
	private JLabel lblEspecialidadEncontrada;
	private JLabel lblEspecialidad;
	private JLabel lblServicio;
	private JLabel lblServicioEncontrado;
	private JLabel lblMotivoExamen;
	private RoundedPanel panelServicio;
	private JLabel lblMotivo;
	private RoundedPanel panelMotivo;
	private JLabel lblProfesionalEncontrado;
	private JLabel lblProfesionalAsignado;
	private RoundedPanel panelProfesional;
	private JLabel lblCosto;
	private RoundedPanel panelCosto;
	private JLabel lblCostoEncontrado;
	private RoundedPanel panelEstado;
	private JLabel lblEstado;
	private JLabel lblEstadoEncontrado;

	/**
	 * Create the panel.
	 */
	public PanelRegistroCitaExamen() {
		setLayout(null); // Establecimiento Absolute Layout
		// Creación de JPanel para el fondo de PanelRegistroCitaExamen:
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1192, 783);
		add(scrollPane);

		panelFondo = new JPanel();
		panelFondo.setBackground(new Color(255, 255, 255));
		panelFondo.setBounds(0, 0, 1192, 999);
		panelFondo.setLayout(null);
		scrollPane.setViewportView(panelFondo);

		// Creación de JPanel con propósito decorativo, ubicado en la parte superior del
		// panel:
		panelDecorativoSup = new JPanel();
		panelDecorativoSup.setBackground(new Color(2, 138, 102));
		panelDecorativoSup.setBounds(0, 47, 1203, 142);
		panelFondo.add(panelDecorativoSup);
		panelDecorativoSup.setLayout(null);

		// Creación de JLabel con el texto: "Registrar Cita: Examen":
		lblRegistrarCitaExamen = new JLabel("Registrar Cita: Examen");
		lblRegistrarCitaExamen.setForeground(new Color(240, 255, 240));
		lblRegistrarCitaExamen.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblRegistrarCitaExamen.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblRegistrarCitaExamen);

		// Creación de JLabel con el el texto: "ID Orden:"
		lblIdOrden = new JLabel("ID Orden:");
		lblIdOrden.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblIdOrden.setBounds(41, 247, 248, 43);
		panelFondo.add(lblIdOrden);

		// Creación de JLabel con el el texto: "Pacientre:"
		lblPaciente = new JLabel("Paciente:");
		lblPaciente.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblPaciente.setBounds(41, 353, 248, 43);
		panelFondo.add(lblPaciente);

		// Creación de JLabel con el el texto: "ID Historia Clínica:"
		lblIdHistoriaClinica = new JLabel("ID Historia Clínica:");
		lblIdHistoriaClinica.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblIdHistoriaClinica.setBounds(41, 461, 248, 43);
		panelFondo.add(lblIdHistoriaClinica);

		// Creación de RoundedPanel decorativo para el ingreso del Identificador de la
		// Orden Médica:
		panelIdOrden = new RoundedPanel(50);
		panelIdOrden.setLayout(null);
		panelIdOrden.setBackground(new Color(241, 241, 241));
		panelIdOrden.setBounds(299, 228, 827, 74);
		panelFondo.add(panelIdOrden);

		// Creación de RoundedPanel decorativo para el Nombre del Paciente:
		panelPaciente = new RoundedPanel(50);
		panelPaciente.setLayout(null);
		panelPaciente.setBackground(new Color(241, 241, 241));
		panelPaciente.setBounds(299, 337, 679, 74);
		panelFondo.add(panelPaciente);

		// Creación de RoundedPanel decorativo para el ID de Historia Clínica del
		// Paciente:
		panelIdHistoriaClinica = new RoundedPanel(50);
		panelIdHistoriaClinica.setLayout(null);
		panelIdHistoriaClinica.setBackground(new Color(241, 241, 241));
		panelIdHistoriaClinica.setBounds(299, 446, 679, 74);
		panelFondo.add(panelIdHistoriaClinica);

		lblNombrePacienteEncontrado = new JLabel("ID No Encontrado");
		lblNombrePacienteEncontrado.setBounds(26, 0, 612, 74);
		lblNombrePacienteEncontrado.setFont(new Font("Montserrat", Font.PLAIN, 25));
		panelPaciente.add(lblNombrePacienteEncontrado);

		lblIdHistoriaClinicaEncontrado = new JLabel("ID No Encontrado");
		lblIdHistoriaClinicaEncontrado.setBounds(26, 0, 612, 74);
		lblIdHistoriaClinicaEncontrado.setFont(new Font("Montserrat", Font.PLAIN, 25));
		panelIdHistoriaClinica.add(lblIdHistoriaClinicaEncontrado);

		// Creación de JTextField como campo para ingresar ID de Orden Médica:
		campoIdOrden = new JTextField();
		campoIdOrden.setBackground(null);
		campoIdOrden.setBorder(null);
		campoIdOrden.setFont(new Font("Montserrat", Font.PLAIN, 25));
		campoIdOrden.setBounds(20, 0, 786, 74);
		panelIdOrden.add(campoIdOrden);
		campoIdOrden.setColumns(10);

		// Creación de JLabel con el texto: "Especialidad:":
		lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblEspecialidad.setBounds(41, 587, 248, 43);
		panelFondo.add(lblEspecialidad);

		// Creación de RoundedPanel decorativo para la Especialidad asociada a la Orden
		// Médica:
		panelEspecialidad = new RoundedPanel(50);
		panelEspecialidad.setLayout(null);
		panelEspecialidad.setBackground(new Color(241, 241, 241));
		panelEspecialidad.setBounds(299, 568, 675, 74);
		panelFondo.add(panelEspecialidad);

		// Creación de JLabel, para que contenga el Dato Encontrado correspodiente a
		// Especialidad:
		lblEspecialidadEncontrada = new JLabel("ID No Encontrado");
		lblEspecialidadEncontrada.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lblEspecialidadEncontrada.setBounds(26, 0, 626, 74);
		panelEspecialidad.add(lblEspecialidadEncontrada);

		// Creación de JLabel con el texto: "Servicio:":
		lblServicio = new JLabel("Servicio:");
		lblServicio.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblServicio.setBounds(41, 693, 248, 43);
		panelFondo.add(lblServicio);

		// Creación de RoundedPanel decorativo para la Especialidad asociada a la Orden
		// Médica:
		panelServicio = new RoundedPanel(50);
		panelServicio.setLayout(null);
		panelServicio.setBackground(new Color(241, 241, 241));
		panelServicio.setBounds(299, 677, 675, 74);
		panelFondo.add(panelServicio);

		// Creación de JLabel, para que contenga el Dato Encontrado correspodiente a
		// Especialidad:
		lblServicioEncontrado = new JLabel("ID No Encontrado");
		lblServicioEncontrado.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lblServicioEncontrado.setBounds(26, 0, 596, 74);
		panelServicio.add(lblServicioEncontrado);

		// Creación de JLabel con el texto: "Motivo:":
		lblMotivo = new JLabel("Motivo:");
		lblMotivo.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblMotivo.setBounds(41, 799, 248, 43);
		panelFondo.add(lblMotivo);

		// Creación de RoundedPanel decorativo para el Motivo de la Cita Médica:
		panelMotivo = new RoundedPanel(50);
		panelMotivo.setLayout(null);
		panelMotivo.setBackground(new Color(241, 241, 241));
		panelMotivo.setBounds(299, 786, 676, 74);
		panelFondo.add(panelMotivo);

		// Creación de JLabel con el Texto: "Examen":
		lblMotivoExamen = new JLabel("Examen");
		lblMotivoExamen.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lblMotivoExamen.setBounds(26, 0, 600, 74);
		panelMotivo.add(lblMotivoExamen);

		///////////////

		// Creación de JLabel con el texto: "Profesional Asignado:":
		lblProfesionalAsignado = new JLabel("Profesional:");
		lblProfesionalAsignado.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblProfesionalAsignado.setBounds(41, 905, 248, 43);
		panelFondo.add(lblProfesionalAsignado);

		// Creación de RoundedPanel decorativo para el Profesional Asignado:
		panelProfesional = new RoundedPanel(50);
		panelProfesional.setLayout(null);
		panelProfesional.setBackground(new Color(241, 241, 241));
		panelProfesional.setBounds(299, 895, 676, 74);
		panelFondo.add(panelProfesional);

		// Creación de JLabel, para que contenga el Dato Encontrado correspodiente a
		// Profesional Asignado:
		lblProfesionalEncontrado = new JLabel("ID No Encontrado");
		lblProfesionalEncontrado.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lblProfesionalEncontrado.setBounds(26, 0, 600, 74);
		panelProfesional.add(lblProfesionalEncontrado);

		///////////////

		// Creación de JLabel con el texto: "Costo:":
		lblCosto = new JLabel("Costo:");
		lblCosto.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblCosto.setBounds(41, 1011, 248, 43);
		panelFondo.add(lblCosto);

		// Creación de RoundedPanel decorativo para el Costo:
		panelCosto = new RoundedPanel(50);
		panelCosto.setLayout(null);
		panelCosto.setBackground(new Color(241, 241, 241));
		panelCosto.setBounds(299, 1004, 676, 74);
		panelFondo.add(panelCosto);

		// Creación de JLabel, para que contenga el Dato Encontrado correspodiente a
		// Costo:
		lblCostoEncontrado = new JLabel("ID No Encontrado");
		lblCostoEncontrado.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lblCostoEncontrado.setBounds(26, 0, 600, 74);
		panelCosto.add(lblCostoEncontrado);

		///////////////

		// Creación de JLabel con el texto: "Estado:":
		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblEstado.setBounds(41, 1117, 248, 43);
		panelFondo.add(lblEstado);

		// Creación de RoundedPanel decorativo para el Estado de Autorización de la
		// Orden Médica:
		panelEstado = new RoundedPanel(50);
		panelEstado.setLayout(null);
		panelEstado.setBackground(new Color(241, 241, 241));
		panelEstado.setBounds(299, 1113, 676, 74);
		panelFondo.add(panelEstado);

		// Creación de JLabel, para que contenga el Dato Encontrado correspodiente al
		// Estado de Autorización de la Orden Médica:
		lblEstadoEncontrado = new JLabel("ID No Encontrado");
		lblEstadoEncontrado.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lblEstadoEncontrado.setBounds(26, 0, 600, 74);
		panelEstado.add(lblEstadoEncontrado);

		campoIdOrden.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateName();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				updateName();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateName();
			}

			private void updateName() {
				Lista<Orden> ordenes = SistemaDeSalud.conseguirOrdenes();
				String idOrden = getCampoIdOrden();
				boolean ordenEncontrada = false; // Variable para controlar si se encuentra la Orden Médica
				for (int ii = 0; ii < ordenes.getTamano(); ii++) {
					if (idOrden.equals(ordenes.obtenerElemento(ii).getIdentificador())) {
						Orden orden = ordenes.obtenerElemento(ii);
						lblNombrePacienteEncontrado.setText(orden.getNombreYIdPaciente());
						lblIdHistoriaClinicaEncontrado.setText(orden.getIdPaciente());
						lblEspecialidadEncontrada.setText(orden.getEspecialidad());
						lblProfesionalEncontrado.setText(orden.getProfesionalAsignado().getNombreEId());
						lblCostoEncontrado.setText("$ " + orden.getCosto());
						lblEstadoEncontrado.setText(orden.getMensajeEstado());
						ordenEncontrada = true; // Se encontró la Orden Médica
						break; // Salir del bucle ya que se encontró la Orden Médica
					}
				}
				// Si no se encuentra la Orden, mostrar el mensaje "ID No Encontrado"
				if (!ordenEncontrada) {
					lblNombrePacienteEncontrado.setText("ID No Encontrado");
					lblIdHistoriaClinicaEncontrado.setText("ID No Encontrado");
					lblEspecialidadEncontrada.setText("ID No Encontrado");
					lblProfesionalEncontrado.setText("ID No Encontrado");
					lblCostoEncontrado.setText("ID No Encontrado");
					lblEstadoEncontrado.setText("ID No Encontrado");
				}
			}
		});

		panelFondo.setPreferredSize(new Dimension(0, 1250));
	} // public PanelRegistroCitaExamen()

	public String getCampoIdOrden() {
		return campoIdOrden.getText();
	}
} // public class PanelRegistroCitaExamen extends JPanel
