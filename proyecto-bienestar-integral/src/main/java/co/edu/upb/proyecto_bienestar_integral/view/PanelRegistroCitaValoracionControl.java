package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import co.edu.upb.proyecto_bienestar_integral.model.TipoEspecialidad;
import co.edu.upb.proyecto_bienestar_integral.view.componentes.*;
import co.edu.upb.proyecto_bienestar_integral.controller.*;
import co.edu.upb.proyecto_bienestar_integral.model.*;

public class PanelRegistroCitaValoracionControl extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelFondo;
	private JPanel panelDecorativoSup;
	private JLabel lblRegistrarCitaValoracionControl;
	private JLabel lblIdHistoriaClinica;
	private RoundedPanel panelIdHistoriaClinica;
	private JComboBox<TipoEspecialidad> comboBoxEspecialidades;
	private JComboBox<String> comboBoxMotivos;
	private JLabel lblEspecialidad;
	private JTextArea textAreaComentario;
	private JScrollPane innerScrollPaneComentario;
	private JLabel lblMotivo;
	private RoundedButton buttonContinuar;
	private JTextField campoIdHistoriaClinica;
	private ModeloRegistroCitaValoracionControl modeloRegistroCitaValoracionControl;
	private ControladorRegistroCitaValoracionControl controladorRegistroCitaValoracion;

	/**
	 * Create the panel.
	 */
	public PanelRegistroCitaValoracionControl() {
		modeloRegistroCitaValoracionControl = new ModeloRegistroCitaValoracionControl();
		controladorRegistroCitaValoracion = new ControladorRegistroCitaValoracionControl(
				modeloRegistroCitaValoracionControl, this);

		setLayout(null);
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

		// Creación de JLabel con el texto: "Registrar Orden Médica":
		lblRegistrarCitaValoracionControl = new JLabel("Registrar Cita de Valoración o Control");
		lblRegistrarCitaValoracionControl.setForeground(new Color(240, 255, 240));
		lblRegistrarCitaValoracionControl.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblRegistrarCitaValoracionControl.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblRegistrarCitaValoracionControl);

		// Creación de JLabel con el el texto: "ID Historia Clinica:"
		lblIdHistoriaClinica = new JLabel("ID Historia Clínica:");
		lblIdHistoriaClinica.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblIdHistoriaClinica.setBounds(41, 247, 248, 43);
		panelFondo.add(lblIdHistoriaClinica);

		// Creación de RoundedPanel decorativo para el ingreso del ID de Historia
		// Clínica del Paciente:
		panelIdHistoriaClinica = new RoundedPanel(50);
		panelIdHistoriaClinica.setBounds(310, 231, 789, 74);
		panelFondo.add(panelIdHistoriaClinica);
		panelIdHistoriaClinica.setBackground(new Color(241, 241, 241));
		panelIdHistoriaClinica.setLayout(null);

		// Creación de JTextField para ingresar ID de la Historia Clínica del Paciente;
		campoIdHistoriaClinica = new JTextField();
		campoIdHistoriaClinica.setBounds(26, 2, 739, 71);
		panelIdHistoriaClinica.add(campoIdHistoriaClinica);
		campoIdHistoriaClinica.setFont(new Font("Montserrat", Font.PLAIN, 25));
		campoIdHistoriaClinica.setBorder(null);
		campoIdHistoriaClinica.setBackground(null);
		campoIdHistoriaClinica.setColumns(10);

		// Creación de JComboBox para la selección de una Especialidad Médica:
		comboBoxEspecialidades = new JComboBox<TipoEspecialidad>();
		comboBoxEspecialidades.setFont(new Font("Montserrat", Font.PLAIN, 25));
		comboBoxEspecialidades.setBounds(310, 355, 612, 63);
		comboBoxEspecialidades.addItem(TipoEspecialidad.MEDICINA_GENERAL);
		comboBoxEspecialidades.addItem(TipoEspecialidad.CARDIOLOGIA);
		comboBoxEspecialidades.addItem(TipoEspecialidad.NEUROLOGIA);
		comboBoxEspecialidades.addItem(TipoEspecialidad.OFTALMOLOGIA);
		panelFondo.add(comboBoxEspecialidades);

		// Creación de JLabel con el texto: "Especialidad:":
		lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblEspecialidad.setBounds(41, 355, 248, 43);
		panelFondo.add(lblEspecialidad);

		// Creación de JLabel con el texto: "Especialidad:":
		lblMotivo = new JLabel("Motivo:");
		lblMotivo.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblMotivo.setBounds(45, 494, 248, 43);
		panelFondo.add(lblMotivo);

		// Creación de JComboBox para la selección de una Especialidad Médica:
		comboBoxMotivos = new JComboBox<String>();
		comboBoxMotivos.setFont(new Font("Montserrat", Font.PLAIN, 25));
		comboBoxMotivos.setBounds(311, 479, 612, 63);
		comboBoxMotivos.addItem("Valoración");
		comboBoxMotivos.addItem("Control");
		panelFondo.add(comboBoxMotivos);

		// Creación de JLabel con el texto: "Comentario:":
		lblEspecialidad = new JLabel("Comentario:");
		lblEspecialidad.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblEspecialidad.setBounds(45, 600, 248, 43);
		panelFondo.add(lblEspecialidad);

		// Creación de JTextArea dentro de JScrollPane
		textAreaComentario = new JTextArea();
		textAreaComentario.setFont(new Font("Montserrat", Font.PLAIN, 20));
		textAreaComentario.setBackground(new Color(241, 241, 241));
		// Configurar el JTextArea para que el texto se ajuste automáticamente al ancho
		// del área de visualización:
		textAreaComentario.setLineWrap(true);
		textAreaComentario.setWrapStyleWord(true);
		innerScrollPaneComentario = new JScrollPane(textAreaComentario);
		innerScrollPaneComentario.setBounds(310, 600, 789, 95);
		panelFondo.add(innerScrollPaneComentario);

		// Creación de RoundedButton para la continuación de procesos:
		buttonContinuar = new RoundedButton("Continuar", new Color(23, 174, 191), new Color(0, 139, 139), 1000, 60);
		buttonContinuar.setText("Continuar");
		buttonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorRegistroCitaValoracion.validarDatos();
			}
		});
		buttonContinuar.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonContinuar.setForeground(new Color(255, 255, 255));
		buttonContinuar.setBackground(new Color(23, 174, 191));
		buttonContinuar.setBounds(400, 750, 320, 57);
		buttonContinuar.setFocusable(false);
		panelFondo.add(buttonContinuar);

		panelFondo.setPreferredSize(new Dimension(0, 855));

	} // public PanelRegistroCitaValoracionControl()

	public String getIdHistoriaClinica() {
		return campoIdHistoriaClinica.getText();
	}

	public TipoEspecialidad getEspecialidad() {
		return (TipoEspecialidad) comboBoxEspecialidades.getSelectedItem();
	}

	public String getMotivo() {
		return (String) comboBoxMotivos.getSelectedItem();
	}

	public String getTextAreaComentario() {
		return textAreaComentario.getText();
	}

} // public class PanelRegistroCitaValoracionControl extends JPanel
