package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.upb.proyecto_bienestar_integral.model.*;

public class PanelConfirmarOrden extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelFondo;
	private JPanel panelDecorativoSup;
	private JLabel lblConfirmarOrdenMedica;
	private JLabel lblPaciente;
	private JLabel lblIdHistoriaClinica;
	private JLabel lblIdOrden;
	private JLabel lblEspecialidad;
	private JLabel lblExamen;
	private JLabel lblDescripcion;
	
	/**
	 * Create the panel.
	 */
	public PanelConfirmarOrden(Orden orden) {
		setLayout(null);
		
		// Creación de JPanel para fondo de PanelGestionPacientes:
		panelFondo = new JPanel();
		panelFondo.setBackground(new Color(255, 255, 255));
		panelFondo.setBounds(0, 0, 1203, 783);
		add(panelFondo);
		panelFondo.setLayout(null);

		// Creación de JPanel con propósito decorativo, ubicado en la parte superior del
		// panel:
		panelDecorativoSup = new JPanel();
		panelDecorativoSup.setBackground(new Color(2, 138, 102));
		panelDecorativoSup.setBounds(0, 47, 1203, 142);
		panelFondo.add(panelDecorativoSup);
		panelDecorativoSup.setLayout(null);

		// Creación de JLabel con el texto: "Confirmar Orden Médica":
		lblConfirmarOrdenMedica = new JLabel("Confirmar Orden Médica");
		lblConfirmarOrdenMedica.setForeground(new Color(240, 255, 240));
		lblConfirmarOrdenMedica.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblConfirmarOrdenMedica.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblConfirmarOrdenMedica);
		
		// Creación de JLabel con el el texto: "Paciente:"
		lblPaciente = new JLabel("Paciente:");
		lblPaciente.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblPaciente.setBounds(39, 210, 248, 43);
		panelFondo.add(lblPaciente);
		
		// Creación de JLabel con el texto: "ID Historia Clínica:":
		lblIdHistoriaClinica = new JLabel("ID Historia Clínica:");
		lblIdHistoriaClinica.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblIdHistoriaClinica.setBounds(39, 290, 248, 43);
		panelFondo.add(lblIdHistoriaClinica);
		
		// Creación de JLabel con el texto: "ID Orden:":
		lblIdOrden = new JLabel("ID Orden:");
		lblIdOrden.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblIdOrden.setBounds(39, 370, 248, 43);
		panelFondo.add(lblIdOrden);
		
		// Creación de JLabel con el texto: "Especialidad:":
		lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblEspecialidad.setBounds(39, 450, 248, 43);
		panelFondo.add(lblEspecialidad);
		
		// Creación de JLabel con el texto: "Examen:":
		lblExamen = new JLabel("Examen:");
		lblExamen.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblExamen.setBounds(39, 530, 248, 43);
		panelFondo.add(lblExamen);
		
		// Creación de JLabel con el texto: "Descripción:":
		lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDescripcion.setBounds(39, 600, 248, 43);
		panelFondo.add(lblDescripcion);

	}
	
}
