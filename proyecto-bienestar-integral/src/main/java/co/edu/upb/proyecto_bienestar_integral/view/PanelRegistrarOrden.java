package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.sql.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import co.edu.upb.proyecto_bienestar_integral.view.componentes.*;
import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.estructuras.*;
import co.edu.upb.proyecto_bienestar_integral.controller.*;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.toedter.calendar.JDateChooser;

import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class PanelRegistrarOrden extends JPanel {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	private JPanel panelFondo;
	private JPanel panelDecorativoSup;
	private JLabel lblRegistrarOrdenMedica;
	private JLabel lblIdHistoriaClinica;
	private RoundedPanel panelIdHistoriaClinica;
	private JComboBox<TipoExamen> comboBoxExamenes;
	private JComboBox<TipoEspecialidad> comboBoxEspecialidades;
	private JLabel lblEspecialidad;
	private JLabel lblExamen;
	private JLabel lblPaciente;
	private JTextField campoIdHistoriaClinica;
	private JLabel lblNombrePaciente;
	private RoundedPanel panelPacienteEncontrado;
	private JScrollBar scrollBar;
	private JLabel lblFecha;
	private JDateChooser calendarioFecha;

	private ControladorRegistroOrden controladorRegistroOrden;
	private ModeloRegistroOrden modeloRegistroOrden;

	/**
	 * Create the panel.
	 */
	public PanelRegistrarOrden() {
		modeloRegistroOrden = new ModeloRegistroOrden();
		controladorRegistroOrden = new ControladorRegistroOrden(this, modeloRegistroOrden);

		setLayout(null);
		// Creación de JPanel para fondo de PanelGestionPacientes:
		panelFondo = new JPanel();
		panelFondo.setBackground(new Color(255, 255, 255));
		// panelFondo.setBounds(0, 0, 1203, 783);
		panelFondo.setBounds(0, 0, 1203, 920);
		add(panelFondo);
		panelFondo.setLayout(null);

		// Creación de JPanel con propósito decorativo, ubicado en la parte superior del
		// panel:
		panelDecorativoSup = new JPanel();
		panelDecorativoSup.setBackground(new Color(2, 138, 102));
		panelDecorativoSup.setBounds(0, 47, 1203, 142);
		panelFondo.add(panelDecorativoSup);
		panelDecorativoSup.setLayout(null);

		// Creación de JLabel con el texto: "Registrar Orden Médica":
		lblRegistrarOrdenMedica = new JLabel("Registrar Orden Médica");
		lblRegistrarOrdenMedica.setForeground(new Color(240, 255, 240));
		lblRegistrarOrdenMedica.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblRegistrarOrdenMedica.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblRegistrarOrdenMedica);

		// Creación de JLabel con el el texto: "ID Historia Clinica:"
		lblIdHistoriaClinica = new JLabel("ID Historia Clínica:");
		lblIdHistoriaClinica.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lblIdHistoriaClinica.setBounds(41, 247, 248, 43);
		panelFondo.add(lblIdHistoriaClinica);

		// Creación de RoundedPanel decorativo para el ingreso del ID de Historia
		// Clínica del Paciente:
		panelIdHistoriaClinica = new RoundedPanel(50);
		panelIdHistoriaClinica.setBounds(310, 231, 789, 74);
		panelFondo.add(panelIdHistoriaClinica);
		panelIdHistoriaClinica.setBackground(new Color(241, 241, 241));
		panelIdHistoriaClinica.setLayout(null);

		// Creación de RoundedPanel decorativo para la exposición del paciente asociado
		// a la Historia Clínica ingresada:
		panelPacienteEncontrado = new RoundedPanel(50);
		panelPacienteEncontrado.setLayout(null);
		panelPacienteEncontrado.setBackground(new Color(241, 241, 241));
		panelPacienteEncontrado.setBounds(310, 342, 789, 74);
		panelFondo.add(panelPacienteEncontrado);

		lblNombrePaciente = new JLabel("");
		lblNombrePaciente.setBounds(26, 0, 753, 74);
		panelPacienteEncontrado.add(lblNombrePaciente);
		lblNombrePaciente.setFont(new Font("Montserrat", Font.PLAIN, 25));

		// Creación de JTextField para ingresar ID de la Historia Clínica del Paciente;
		campoIdHistoriaClinica = new JTextField();
		campoIdHistoriaClinica.setBounds(26, 2, 739, 71);
		panelIdHistoriaClinica.add(campoIdHistoriaClinica);
		campoIdHistoriaClinica.setFont(new Font("Montserrat", Font.PLAIN, 25));
		campoIdHistoriaClinica.setBorder(null);
		campoIdHistoriaClinica.setBackground(null);
		campoIdHistoriaClinica.setColumns(10);
		campoIdHistoriaClinica.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
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
				Lista<Paciente> pacientes = SistemaDeSalud.conseguirPacientes();
				String idHc = getCampoIdHistoriaClinica();
				boolean pacienteEncontrado = false; // Variable para controlar si se encuentra el paciente
				for (int ii = 0; ii < pacientes.getTamano(); ii++) {
					if (idHc.equals(pacientes.obtenerElemento(ii).getIdHistoriaClinica())) {
						lblNombrePaciente.setText(pacientes.obtenerElemento(ii).getNombreCompleto());
						pacienteEncontrado = true; // Se encontró el paciente
						break; // Salir del bucle ya que se encontró el paciente
					}
				}
				// Si no se encuentra el paciente, mostrar el mensaje "Paciente No Encontrado"
				if (!pacienteEncontrado) {
					lblNombrePaciente.setText("Paciente No Encontrado");
				}
			}
		});

		// Creación de JComboBox para la selección de un Examen Médico:
		comboBoxExamenes = new JComboBox<TipoExamen>();
		comboBoxExamenes.setFont(new Font("Montserrat", Font.PLAIN, 25));
		comboBoxExamenes.setBounds(310, 564, 612, 63);
		comboBoxExamenes.addItem(TipoExamen.ELECTROCARDIOGRAMA);
		comboBoxExamenes.addItem(TipoExamen.ECOCARDIOGRAFIA);
		comboBoxExamenes.addItem(TipoExamen.PRUEBA_DE_ESFUERZO);
		panelFondo.add(comboBoxExamenes);

		// Creación de JComboBox para la selección de una Especialidad Médica:
		comboBoxEspecialidades = new JComboBox<TipoEspecialidad>();
		comboBoxEspecialidades.setFont(new Font("Montserrat", Font.PLAIN, 25));
		comboBoxEspecialidades.setBounds(310, 453, 612, 63);
		comboBoxEspecialidades.addItem(TipoEspecialidad.CARDIOLOGIA);
		comboBoxEspecialidades.addItem(TipoEspecialidad.NEUROLOGIA);
		comboBoxEspecialidades.addItem(TipoEspecialidad.OFTALMOLOGIA);
		panelFondo.add(comboBoxEspecialidades);
		comboBoxEspecialidades.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TipoEspecialidad especialidad = (TipoEspecialidad) comboBoxEspecialidades.getSelectedItem();
				comboBoxExamenes.removeAllItems();
				Lista<TipoExamen> examenes = new ListaEnlazada<>();
				examenes = especialidad.getExamenes();
				for (int ii = 0; ii < examenes.getTamano(); ii++) {
					comboBoxExamenes.addItem(examenes.obtenerElemento(ii));
				}
				comboBoxExamenes.repaint();
			}
		});

		// Creación de JLabel con el texto: "Especialidad:":
		lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lblEspecialidad.setBounds(41, 463, 248, 43);
		panelFondo.add(lblEspecialidad);

		// Creación de JLabel con el texto: "Examen:":
		lblExamen = new JLabel("Examen:");
		lblExamen.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lblExamen.setBounds(41, 574, 248, 43);
		panelFondo.add(lblExamen);

		// Creación de JLabel con el texto: "Paciente:":
		lblPaciente = new JLabel("Paciente:");
		lblPaciente.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lblPaciente.setBounds(41, 358, 248, 43);
		panelFondo.add(lblPaciente);

		// Creación de RoundedButton para la continuación de procesos:
		RoundedButton buttonContinuar = new RoundedButton("Continuar", new Color(23, 174, 191), new Color(0, 139, 139),
				1000, 60);
		buttonContinuar.setText("Continuar");
		buttonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorRegistroOrden.validarDatos();
			}
		});
		buttonContinuar.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonContinuar.setForeground(new Color(255, 255, 255));
		buttonContinuar.setBackground(new Color(23, 174, 191));
		buttonContinuar.setBounds(400, 889, 320, 57);
		buttonContinuar.setFocusable(false);
		panelFondo.add(buttonContinuar);

		scrollBar = new JScrollBar();
		scrollBar.setMaximum(200);
		scrollBar.setBounds(1170, 188, 23, 780);
		panelFondo.add(scrollBar);

		lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lblFecha.setBounds(41, 685, 248, 43);
		panelFondo.add(lblFecha);

		// Agrega AdjustmentListener al JScrollBar
		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				int scrollValue = e.getValue();
				// Desplaza el panel verticalmente según el valor del JScrollBar:
				panelFondo.setLocation(panelFondo.getX(), -scrollValue);
			}
		});

		// Creación de JDateChooser para la selección de la fecha de nacimiento del paciente:
		calendarioFecha = new JDateChooser();
		calendarioFecha.setDateFormatString("y/MM/d");
		calendarioFecha.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		calendarioFecha.setBounds(310, 667, 612, 74);
		calendarioFecha.getJCalendar().setFont(new Font("Montserrat", Font.PLAIN, 14));
		calendarioFecha.getDateEditor().getUiComponent().setFont(new Font("Montserrat", Font.PLAIN, 25));
		panelFondo.add(calendarioFecha);

		// Creación de JTextArea dentro de JScrollPane
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Montserrat", Font.PLAIN, 20));
		textArea.setBackground(new Color(241, 241, 241));
		// Configurar el JTextArea para que el texto se ajuste automáticamente al ancho del área de visualización:
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(310, 778, 789, 95);
		panelFondo.add(scrollPane);

	} // public PanelRegistrarOrden()

	public String getCampoIdHistoriaClinica() {
		return campoIdHistoriaClinica.getText();
	}

	public String getLblNombrePaciente() {
		return lblNombrePaciente.getText();
	}

	public TipoEspecialidad getEspecialidad() {
		return (TipoEspecialidad) comboBoxEspecialidades.getSelectedItem();
	}

	public TipoExamen getExamen() {
		return (TipoExamen) comboBoxExamenes.getSelectedItem();
	}

	public void setCampoIdHistoriaClinica(String texto) {
		campoIdHistoriaClinica.setText(texto);
	}

	public Date getFechaOrden() {
		java.util.Date utilDate = calendarioFecha.getDate();
		if (utilDate != null) {
			return new java.sql.Date(utilDate.getTime());
		} else {
			return null;
		}
	}
}
