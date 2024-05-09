package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.view.componentes.*;
import co.edu.upb.proyecto_bienestar_integral.controller.*;

public class PanelMirarColaConsulta extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelFondo;
	private JPanel panelDecorativoSup;
	private JLabel lblColaEspera;
	private JLabel lblPaciente;
	private JLabel lblDatoPaciente;
	private JLabel lblIconoCola;
	private JLabel lblConsultorio;
	private JLabel lblDatoIdCita;
	private JLabel lblIdCita;
	private JLabel lblDatoConsultorio;
	private JLabel lblEspecialidad;
	private RoundedPanel panelPaciente;
	private RoundedPanel panelIdCita;
	private RoundedPanel panelConsultorio;
	private RoundedButton buttonSiguiente;
	private ModeloColaCitasConsulta modeloColaCitasConsulta;
	private ControladorColaCitasConsulta controladorColaCitasConsulta; 

	/**
	 * Create the panel.
	 */
	public PanelMirarColaConsulta() {
		this.modeloColaCitasConsulta = new ModeloColaCitasConsulta();
		this.controladorColaCitasConsulta = new ControladorColaCitasConsulta(modeloColaCitasConsulta, this);
		setLayout(null); // Establecimiento Absolute Layout

		// Creación de JPanel para fondo de PanelSeleccionCita:
		panelFondo = new JPanel();
		panelFondo.setBackground(new Color(255, 255, 255));
		panelFondo.setBounds(0, 0, 1203, 783);
		add(panelFondo);
		panelFondo.setLayout(null);

		lblConsultorio = new JLabel("Consultorio:");
		lblConsultorio.setHorizontalAlignment(SwingConstants.LEFT);
		lblConsultorio.setFont(new Font("Montserrat", Font.PLAIN, 26));
		lblConsultorio.setBounds(50, 578, 421, 45);
		panelFondo.add(lblConsultorio);

		// Creación de JPanel con propósito decorativo, ubicado en la parte superior del
		// panel:
		panelDecorativoSup = new JPanel();
		panelDecorativoSup.setBackground(new Color(2, 138, 102));
		panelDecorativoSup.setBounds(0, 47, 1203, 142);
		panelFondo.add(panelDecorativoSup);
		panelDecorativoSup.setLayout(null);

		// Creación de JLabel con el texto: "Cola de Espera":
		lblColaEspera = new JLabel("Cola de Espera: ");
		lblColaEspera.setForeground(new Color(240, 255, 240));
		lblColaEspera.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblColaEspera.setBounds(45, 43, 335, 57);
		panelDecorativoSup.add(lblColaEspera);

		lblEspecialidad = new JLabel("");
		lblEspecialidad.setForeground(new Color(240, 255, 240));
		lblEspecialidad.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblEspecialidad.setBounds(390, 43, 348, 57);
		panelDecorativoSup.add(lblEspecialidad);

		// Creación de JLabel con el texto: "Paciente:":
		lblPaciente = new JLabel("Paciente:");
		lblPaciente.setHorizontalAlignment(SwingConstants.LEFT);
		lblPaciente.setFont(new Font("Montserrat", Font.PLAIN, 26));
		lblPaciente.setBounds(50, 409, 421, 45);
		panelFondo.add(lblPaciente);

		// Creación de RoundedPanel decorativo para exponer el Paciente que se encuentra
		// en la cabeza de la Cola:
		panelPaciente = new RoundedPanel(50);
		panelPaciente.setLayout(null);
		panelPaciente.setBackground(new Color(241, 241, 241));
		panelPaciente.setBounds(50, 464, 633, 74);
		panelFondo.add(panelPaciente);

		// Creación de JLabel para exponer el Paciente que se encuentra en la cabeza de
		// la Cola:
		lblDatoPaciente = new JLabel("");
		lblDatoPaciente.setBounds(27, 0, 563, 74);
		panelPaciente.add(lblDatoPaciente);
		lblDatoPaciente.setFont(new Font("Montserrat", Font.PLAIN, 25));

		panelIdCita = new RoundedPanel(50);
		panelIdCita.setLayout(null);
		panelIdCita.setBackground(new Color(241, 241, 241));
		panelIdCita.setBounds(50, 292, 633, 74);
		panelFondo.add(panelIdCita);

		lblDatoIdCita = new JLabel("");
		lblDatoIdCita.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lblDatoIdCita.setBounds(27, 0, 563, 74);
		panelIdCita.add(lblDatoIdCita);

		lblIdCita = new JLabel("ID Cita:");
		lblIdCita.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdCita.setFont(new Font("Montserrat", Font.PLAIN, 26));
		lblIdCita.setBounds(50, 237, 421, 45);
		panelFondo.add(lblIdCita);

		panelConsultorio = new RoundedPanel(50);
		panelConsultorio.setLayout(null);
		panelConsultorio.setBackground(new Color(241, 241, 241));
		panelConsultorio.setBounds(50, 633, 633, 74);
		panelFondo.add(panelConsultorio);

		lblDatoConsultorio = new JLabel("");
		lblDatoConsultorio.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lblDatoConsultorio.setBounds(27, 0, 563, 74);
		panelConsultorio.add(lblDatoConsultorio);

		lblIconoCola = new JLabel("");
		lblIconoCola.setBounds(721, 270, 448, 335);
		panelFondo.add(lblIconoCola);
		setImageLabel(lblIconoCola, "Media\\IconoColaPacientes.png");

		// Creación de RoundedButton para el proceso pasar al siguiente Paciente en la
		// Cola:
		buttonSiguiente = new RoundedButton("Siguiente", new Color(23, 174, 191), new Color(0, 139, 139), 1000, 60);
		buttonSiguiente.setText("Siguiente");
		buttonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorColaCitasConsulta.siguientePaciente();
			}
		});
		buttonSiguiente.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonSiguiente.setForeground(new Color(255, 255, 255));
		buttonSiguiente.setBackground(new Color(23, 174, 191));
		buttonSiguiente.setBounds(800, 650, 320, 57);
		buttonSiguiente.setFocusable(false);
		panelFondo.add(buttonSiguiente);
	} // public PanelMirarColaConsulta()

	// Métodos Getters:
	public String getLblEspecialidad() {
		return lblEspecialidad.getText();
	}
	
	public String getLblDatoConsultorio() {
		return lblDatoConsultorio.getText();
	}
	
	public String getLblDatoIdCita() {
		return lblDatoIdCita.getText();
	}

	// Métodos Setters:
	public void setLblEspecialidad(String especialidad) {
		lblEspecialidad.setText(especialidad);
	}

	public void setPaciente(String paciente) {
		lblDatoPaciente.setText(paciente);
	}

	public void setIdCita(String id) {
		lblDatoIdCita.setText(id);
	}

	public void setConsultorio(String consultorio) {
		lblDatoConsultorio.setText(consultorio);
	}

	// Método private void que permite insertar una imagen con relación al tamaño
	// definido de un JLabel:
	private void setImageLabel(JLabel label, String root) {
		ImageIcon imageIcon = new ImageIcon(root);
		Image image = imageIcon.getImage();

		// Obtener el tamaño del JLabel
		int labelWidth = label.getWidth();
		int labelHeight = label.getHeight();

		// Escalar la imagen al tamaño del JLabel
		Image scaledImage = image.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);

		// Crear un nuevo ImageIcon con la imagen escalada
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		// Establecer el nuevo ImageIcon en el JLabel
		label.setIcon(scaledIcon);

		this.repaint();
	} // private void setImageLabel(JLabel label, String root)

} // public class PanelMirarColaConsulta extends JPanel
