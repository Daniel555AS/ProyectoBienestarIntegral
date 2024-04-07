package co.edu.upb.proyecto_bienestar_integral.view;

import co.edu.upb.proyecto_bienestar_integral.view.componentes.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import co.edu.upb.proyecto_bienestar_integral.controller.*;
import co.edu.upb.proyecto_bienestar_integral.model.*;

public class PanelRegistrarPaciente extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RoundedPanel panelNombres;
	private RoundedPanel panelApellidos;
	private RoundedPanel panelTelefono;
	private RoundedPanel panelId;
	private RoundedPanel panelEdad;
	private JTextField campoNombres;
	private JTextField campoApellidos;
	private JTextField campoTelefono;
	private JTextField campoId;
	private JTextField campoEdad;
	private JLabel lblApellidos;
	private JLabel lblGestionPacientes;
	private JLabel lblAos;
	private JComboBox<String> comboBoxTipoId;
	
	private ControladorRegistroPaciente controladorRegistroPaciente;
	private ModeloGestorDatosPaciente modeloGestorDatosPaciente;
	/**
	 * Create the panel.
	 */
	public PanelRegistrarPaciente() {
		modeloGestorDatosPaciente = new ModeloGestorDatosPaciente();
		controladorRegistroPaciente = new ControladorRegistroPaciente(this, modeloGestorDatosPaciente);
		
		
		setLayout(null);
		// Creación de JPanel como fondo para PanelRegistraPaciente:
		JPanel panelFondo = new JPanel();
		panelFondo.setBackground(new Color(255, 255, 255));
		panelFondo.setBounds(0, 0, 1203, 783);
		add(panelFondo);
		panelFondo.setLayout(null);

		// Creación de JPanel con propósito decorativo, ubicado en la parte superior del
		// panel:
		JPanel panelDecorativoSup = new JPanel();
		panelDecorativoSup.setBackground(new Color(2, 138, 102));
		panelDecorativoSup.setBounds(0, 47, 1203, 142);
		panelFondo.add(panelDecorativoSup);
		panelDecorativoSup.setLayout(null);

		// Creación de JLabel con el texto: "Gestión de Pacientes":
		lblGestionPacientes = new JLabel("Registrar Paciente");
		lblGestionPacientes.setForeground(new Color(240, 255, 240));
		lblGestionPacientes.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblGestionPacientes.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblGestionPacientes);

		// Creación de RoundedPanel decorativo para el ingreso de Nombres:
		panelNombres = new RoundedPanel(50);
		panelNombres.setBackground(new Color(241, 241, 241));
		panelNombres.setBounds(50, 284, 520, 74);
		panelFondo.add(panelNombres);
		panelNombres.setLayout(null);

		// Creación de JTextField como campo para ingresar los nombres del paciente:
		campoNombres = new JTextField();
		campoNombres.setBackground(null);
		campoNombres.setBorder(null);
		campoNombres.setFont(new Font("Montserrat", Font.PLAIN, 25));
		campoNombres.setBounds(20, 0, 478, 74);
		panelNombres.add(campoNombres);
		campoNombres.setColumns(10);

		// Creación de RoundedPanel decorativo para el ingreso de Edad:
		panelEdad = new RoundedPanel(50);
		panelEdad.setBackground(new Color(241, 241, 241));
		panelEdad.setBounds(632, 429, 310, 74);
		panelFondo.add(panelEdad);
		panelEdad.setLayout(null);
		
		// Creación de JTextField como campo para ingresar la edad del paciente:
		campoEdad = new JTextField();
		campoEdad.setFont(new Font("Montserrat", Font.PLAIN, 25));
		campoEdad.setColumns(10);
		campoEdad.setBorder(null);
		campoEdad.setBackground((Color) null);
		campoEdad.setBounds(23, 0, 131, 74);
		panelEdad.add(campoEdad);
		
		lblAos = new JLabel("Años");
		lblAos.setBounds(184, 23, 94, 24);
		panelEdad.add(lblAos);
		lblAos.setFont(new Font("Montserrat", Font.PLAIN, 30));

		// Creación de JComboBox para la determinación de opciones de Tipo de
		// Identificación:
		comboBoxTipoId = new JComboBox<String>();
		comboBoxTipoId.setFont(new Font("Montserrat", Font.PLAIN, 25));
		comboBoxTipoId.addItem("CC");
		comboBoxTipoId.addItem("TI");
		comboBoxTipoId.addItem("CE");
		comboBoxTipoId.setBounds(593, 584, 86, 51);
		panelFondo.add(comboBoxTipoId);

		// Creación de RoundedPanel decorativo para el ingreso de Número Telefónico:
		panelTelefono = new RoundedPanel(50);
		panelTelefono.setBounds(50, 429, 520, 74);
		panelFondo.add(panelTelefono);
		panelTelefono.setBackground(new Color(241, 241, 241));
		panelTelefono.setLayout(null);
		
		// Creación de JTextField como campo para ingresar el teléfono del paciente:
		campoTelefono = new JTextField();
		campoTelefono.setFont(new Font("Montserrat", Font.PLAIN, 25));
		campoTelefono.setColumns(10);
		campoTelefono.setBorder(null);
		campoTelefono.setBackground((Color) null);
		campoTelefono.setBounds(20, 0, 478, 74);
		panelTelefono.add(campoTelefono);

		// Creación de JLabel con el el texto: "Nombres:"
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lblNombres.setBounds(64, 250, 145, 24);
		panelFondo.add(lblNombres);

		// Creación de RoundedPanel decorativo para el ingreso de Apellidos:
		panelApellidos = new RoundedPanel(50);
		panelApellidos.setBounds(632, 284, 520, 74);
		panelFondo.add(panelApellidos);
		panelApellidos.setBackground(new Color(241, 241, 241));
		panelApellidos.setLayout(null);

		// Creación de JTextField como campo para ingresar los apellidos del paciente:
		campoApellidos = new JTextField();
		campoApellidos.setFont(new Font("Montserrat", Font.PLAIN, 25));
		campoApellidos.setColumns(10);
		campoApellidos.setBorder(null);
		campoApellidos.setBackground((Color) null);
		campoApellidos.setBounds(21, 0, 478, 74);
		panelApellidos.add(campoApellidos);

		// Creación de JLabel con el texto: "Apellidos":
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lblApellidos.setBounds(648, 243, 124, 32);
		panelFondo.add(lblApellidos);

		// Creación de RoundedButton para la continuación de procesos:
		RoundedButton buttonContinuar = new RoundedButton("Continuar", new Color(23, 174, 191), new Color(0, 139, 139),
				1000, 60);
		buttonContinuar.setText("Continuar");
		buttonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorRegistroPaciente.validarDatosPaciente();
			}
		});
		buttonContinuar.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonContinuar.setForeground(new Color(255, 255, 255));
		buttonContinuar.setBackground(new Color(23, 174, 191));
		buttonContinuar.setBounds(832, 581, 320, 57);
		buttonContinuar.setFocusable(false);
		panelFondo.add(buttonContinuar);

		// Creación de JLabel con el texto: "Teléfono:":
		JLabel lblTel = new JLabel("Teléfono:");
		lblTel.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lblTel.setBounds(64, 395, 145, 24);
		panelFondo.add(lblTel);

		// Creación de JLabel con el texto: "Identificación:":
		JLabel lblId = new JLabel("Identificación:");
		lblId.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lblId.setBounds(64, 540, 202, 24);
		panelFondo.add(lblId);

		// Creación de JLabel con el texto: "Edad":
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lblEdad.setBounds(648, 395, 145, 24);
		panelFondo.add(lblEdad);

		// Creación de RoundedPanel decorativo para el ingreso de Identificación:
		panelId = new RoundedPanel(50);
		panelId.setBounds(50, 574, 520, 74);
		panelFondo.add(panelId);
		panelId.setBackground(new Color(241, 241, 241));
		panelId.setLayout(null);
		
		// Creación de JTextField como para ingresar la identificación del paciente:
		campoId = new JTextField();
		campoId.setFont(new Font("Montserrat", Font.PLAIN, 25));
		campoId.setColumns(10);
		campoId.setBorder(null);
		campoId.setBackground((Color) null);
		campoId.setBounds(20, 0, 478, 74);
		panelId.add(campoId);

	} // public PanelRegistrarPaciente()
	
	// Método público que retorna el String ingresado en campoNombres:
	public String getNombres() {
		return campoNombres.getText();
	}
	
	// Método público que retorna el String ingresado en campoApellidos:
	public String getApellidos() {
		return campoApellidos.getText();
	}
	
	// Método público que retorna el String ingresado en campoTelefono:
	public String getTelefono() {
		return campoTelefono.getText();
	}
	
	// Método público que retorna el String ingresado en campoId:
	public String getId() {
		return campoId.getText();
	}
	
	// Método público que retorna el String ingresado en campoEdad:
	public String getEdad() {
		return campoEdad.getText();
	}
	
	public String getTipoId() {
		return (String) comboBoxTipoId.getSelectedItem();
	}
	
	// Métodos setters para los campos JTextField:
	public void setCampoNombres(String texto) {
		campoNombres.setText(texto);
	}
	
	public void setCampoApellidos(String texto) {
		campoApellidos.setText(texto);
	}
	
	public void setCampoTelefono(String texto) {
		campoTelefono.setText(texto);
	}
	
	public void setcomboBoxTipoId(String tipoId) {
		comboBoxTipoId.setSelectedItem(tipoId);
	}
	
	public void setCampoId(String texto) {
		campoId.setText(texto);
	}
	
	public void setCampoEdad(String texto) {
		campoEdad.setText(texto);
	}
		
} // public class PanelRegistrarPaciente extends JPanel
