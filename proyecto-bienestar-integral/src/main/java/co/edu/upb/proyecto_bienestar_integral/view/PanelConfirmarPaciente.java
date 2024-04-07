package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.upb.proyecto_bienestar_integral.view.componentes.*;
import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.controller.*;

public class PanelConfirmarPaciente extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Paciente pacienteActual;

	private JLabel lblConfirmarPaciente;
	private RoundedButton buttonConfirmar;
	private RoundedButton buttonRegresar;
	private JPanel panelFondo;
	private JPanel panelDecorativoSup;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblIdentificacion;
	private JLabel lblTelefono;
	private JLabel lblEdad;
	private JLabel lblIdHistoriaClinica;
	private JLabel lblNombresPaciente;
	private JLabel lblApellidosPaciente;
	private JLabel lblIdPaciente;
	private JLabel lblIdHistoriaClinicaPaciente;
	private JLabel lblTelefonoPaciente;
	private JLabel lblEdadPaciente;
	
	private ModeloConfirmacionPaciente modeloConfirmacionPaciente;
	private ControladorConfirmacionPaciente controladorConfirmacionPaciente;
	/**
	 * Create the panel.
	 */
	public PanelConfirmarPaciente(Paciente pacienteActual) {
		this.pacienteActual = pacienteActual;
		modeloConfirmacionPaciente = new ModeloConfirmacionPaciente();
		controladorConfirmacionPaciente = new ControladorConfirmacionPaciente(this, modeloConfirmacionPaciente);

		setLayout(null);

		// Creación de JPanel como fondo para PanelRegistraPaciente:
		panelFondo = new JPanel();
		panelFondo.setBounds(0, 0, 1203, 783);
		panelFondo.setBackground(new Color(255, 255, 255));
		add(panelFondo);
		panelFondo.setLayout(null);

		// Creación de RoundedButton para regresar a PanelRegistrarPaciente y modificar
		// datos del Paciente:
		buttonRegresar = new RoundedButton("Regresar", new Color(203, 53, 53), new Color(234, 68, 68), 1000, 60);
		buttonRegresar.setText("Regresar");
		buttonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorConfirmacionPaciente.regresarRegistro();
			}
		});
		buttonRegresar.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonRegresar.setForeground(new Color(255, 255, 255));
		buttonRegresar.setBackground(new Color(203, 53, 53));
		buttonRegresar.setBounds(610, 716, 259, 57);
		buttonRegresar.setFocusable(false);
		panelFondo.add(buttonRegresar);

		// Creación de JPanel con propósito decorativo, ubicado en la parte superior del
		// panel:
		panelDecorativoSup = new JPanel();
		panelDecorativoSup.setBounds(0, 48, 1203, 142);
		panelDecorativoSup.setBackground(new Color(2, 138, 102));
		panelFondo.add(panelDecorativoSup);
		panelDecorativoSup.setLayout(null);

		// Creación de JLabel con el texto: "Gestión de Pacientes":
		lblConfirmarPaciente = new JLabel("Confirmar Paciente");
		lblConfirmarPaciente.setForeground(new Color(240, 255, 240));
		lblConfirmarPaciente.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblConfirmarPaciente.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblConfirmarPaciente);

		// Creación de JLabel con el texto: "Nombres:":
		lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Montserrat", Font.BOLD, 30));
		lblNombres.setBounds(60, 222, 170, 49);
		panelFondo.add(lblNombres);

		// Creación de JLabel con el texto: "Apellidos:":
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Montserrat", Font.BOLD, 30));
		lblApellidos.setBounds(60, 310, 164, 49);
		panelFondo.add(lblApellidos);

		// Creación de JLabel con el texto: "Identificación:":
		lblIdentificacion = new JLabel("Identificación:");
		lblIdentificacion.setFont(new Font("Montserrat", Font.BOLD, 30));
		lblIdentificacion.setBounds(60, 398, 237, 49);
		panelFondo.add(lblIdentificacion);

		lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("Montserrat", Font.BOLD, 30));
		lblTelefono.setBounds(60, 486, 155, 49);
		panelFondo.add(lblTelefono);

		lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Montserrat", Font.BOLD, 30));
		lblEdad.setBounds(60, 574, 100, 49);
		panelFondo.add(lblEdad);

		lblIdHistoriaClinica = new JLabel("ID Historía Clínica:");
		lblIdHistoriaClinica.setFont(new Font("Montserrat", Font.BOLD, 30));
		lblIdHistoriaClinica.setBounds(60, 662, 301, 49);
		panelFondo.add(lblIdHistoriaClinica);

		// Creación de RoundedButton para la confirmación de datos del Paciente:
		buttonConfirmar = new RoundedButton("Confirmar", new Color(23, 174, 191), new Color(0, 139, 139), 1000, 60);
		buttonConfirmar.setText("Confirmar");
		buttonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorConfirmacionPaciente.guardarPaciente();
			}
		});
		buttonConfirmar.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonConfirmar.setForeground(new Color(255, 255, 255));
		buttonConfirmar.setBackground(new Color(23, 174, 191));
		buttonConfirmar.setBounds(920, 716, 259, 57);
		buttonConfirmar.setFocusable(false);
		panelFondo.add(buttonConfirmar);

		// Creación de JLabel con los Nombres del Paciente Actual a confirmar:
		lblNombresPaciente = new JLabel(pacienteActual.getNombres());
		lblNombresPaciente.setFont(new Font("Montserrat", Font.PLAIN, 30));
		lblNombresPaciente.setBounds(382, 222, 797, 49);
		panelFondo.add(lblNombresPaciente);

		// Creación de JLabel con los Apellidos del Paciente Actual a confirmar:
		lblApellidosPaciente = new JLabel(pacienteActual.getApellidos());
		lblApellidosPaciente.setFont(new Font("Montserrat", Font.PLAIN, 30));
		lblApellidosPaciente.setBounds(387, 310, 789, 49);
		panelFondo.add(lblApellidosPaciente);

		// Creación de JLabel con la el ID de Historia Clínica del Paciente Actual a
		// Confirmar:
		lblIdHistoriaClinicaPaciente = new JLabel(pacienteActual.getIdHistoriaClinica());
		lblIdHistoriaClinicaPaciente.setFont(new Font("Montserrat", Font.PLAIN, 30));
		lblIdHistoriaClinicaPaciente.setBounds(387, 657, 789, 49);
		panelFondo.add(lblIdHistoriaClinicaPaciente);

		// Creación de JLabel con la Identificación del Paciente Actual a Confirmar:
		lblIdPaciente = new JLabel(pacienteActual.getTipoId() + "  " + pacienteActual.getIdentificacion());
		lblIdPaciente.setFont(new Font("Montserrat", Font.PLAIN, 30));
		lblIdPaciente.setBounds(382, 398, 789, 49);
		panelFondo.add(lblIdPaciente);
		
		// Creación de JLabel con el Teléfono del Paciente Actual a Confirmar:
		lblTelefonoPaciente = new JLabel(pacienteActual.getTelefono());
		lblTelefonoPaciente.setFont(new Font("Montserrat", Font.PLAIN, 30));
		lblTelefonoPaciente.setBounds(382, 486, 789, 49);
		panelFondo.add(lblTelefonoPaciente);
	    
		// Creación de JLabel con la Edad del Paciente Actual a Confirmar:
		lblEdadPaciente = new JLabel(pacienteActual.getEdad() + "  Años");
		lblEdadPaciente.setFont(new Font("Montserrat", Font.PLAIN, 30));
		lblEdadPaciente.setBounds(382, 574, 789, 49);
		panelFondo.add(lblEdadPaciente);

	} // public PanelConfirmarPaciente()
	
	// Método get para el atributo pacienteActual:
	public Paciente getPacienteActual() {
		return pacienteActual;
	}
	
} 
