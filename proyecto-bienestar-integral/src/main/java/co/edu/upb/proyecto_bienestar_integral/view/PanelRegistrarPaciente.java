package co.edu.upb.proyecto_bienestar_integral.view;

import co.edu.upb.proyecto_bienestar_integral.view.componentes.*;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.upb.proyecto_bienestar_integral.view.componentes.RoundedPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PanelRegistrarPaciente extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RoundedPanel panelNombres;
	private RoundedPanel panelApellidos;
	private RoundedPanel panelTelefono;
	/**
	 * Create the panel.
	 */
	public PanelRegistrarPaciente() {
		setLayout(null);

		// Creación de JPanel como fondo para PanelRegistraPaciente:
		JPanel panelFondo = new JPanel();
		panelFondo.setBackground(new Color(255, 255, 255));
		panelFondo.setBounds(0, 0, 1203, 783);
		add(panelFondo);
		panelFondo.setLayout(null);

		// Creación de JPanel con propósito decorativo, ubicado en la parte superior del panel:
		JPanel panelDecorativoSup = new JPanel();
		panelDecorativoSup.setBackground(new Color(2, 138, 102));
		panelDecorativoSup.setBounds(0, 47, 1203, 142);
		panelFondo.add(panelDecorativoSup);
		panelDecorativoSup.setLayout(null);
		
		// Creación de JLabel con el texto: "Gestión de Pacientes":
		JLabel lblGestionPacientes = new JLabel("Registrar Paciente");
		lblGestionPacientes.setForeground(new Color(240, 255, 240));
		lblGestionPacientes.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblGestionPacientes.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblGestionPacientes);
		
		// Creación de RoundedPanel decorativo para el ingreso de Nombres:
		panelNombres = new RoundedPanel(50);
		panelNombres.setBackground(new Color(241, 241, 241));
		panelNombres.setBounds(75, 297, 520, 74);
		panelFondo.add(panelNombres);
		panelNombres.setLayout(null);
		
		// Creación de RoundedPanel decorativo para el ingreso de Apellidos :
		panelApellidos = new RoundedPanel(50);
		panelApellidos.setBackground(new Color(241, 241, 241));
		panelApellidos.setBounds(669, 283, 470, 74);
		panelFondo.add(panelApellidos);
		panelApellidos.setLayout(null);
		
		// Creación de RoundedPanel decorativo para el ingreso de Número Telefónico:
		panelTelefono = new RoundedPanel(50);
		panelTelefono.setBackground(new Color(241, 241, 241));
		panelTelefono.setBounds(101, 433, 520, 74);
		panelFondo.add(panelTelefono);
		panelTelefono.setLayout(null);
		
		// Creación de JComboBox para la determinación de opciones de Tipo de Identificación:
		JComboBox comboBoxTipoId = new JComboBox();
		comboBoxTipoId.setFont(new Font("Montserrat", Font.PLAIN, 25));
		comboBoxTipoId.setModel(new DefaultComboBoxModel(new String[] {"CC", "TI", "CE"}));
		comboBoxTipoId.setBounds(101, 543, 86, 51);
		panelFondo.add(comboBoxTipoId);

	}
} // public class PanelRegistrarPaciente extends JPanel
