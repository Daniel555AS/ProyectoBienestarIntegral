package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelConfirmarPaciente extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lblConfirmarPaciente;

	/**
	 * Create the panel.
	 */
	public PanelConfirmarPaciente() {
		setLayout(null);

		// Creación de JPanel como fondo para PanelRegistraPaciente:
		JPanel panelFondo = new JPanel();
		panelFondo.setBounds(0, 0, 1203, 783);
		panelFondo.setBackground(new Color(255, 255, 255));
		add(panelFondo);
		panelFondo.setLayout(null);

		// Creación de JPanel con propósito decorativo, ubicado en la parte superior del
		// panel:
		JPanel panelDecorativoSup = new JPanel();
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
		
		JLabel lblNewLabel = new JLabel("Nombres:");
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 30));
		lblNewLabel.setBounds(60, 222, 170, 49);
		panelFondo.add(lblNewLabel);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Montserrat", Font.BOLD, 30));
		lblApellidos.setBounds(60, 310, 170, 49);
		panelFondo.add(lblApellidos);
		
		JLabel lblIdentificacin = new JLabel("Identificación:");
		lblIdentificacin.setFont(new Font("Montserrat", Font.BOLD, 30));
		lblIdentificacin.setBounds(60, 398, 237, 49);
		panelFondo.add(lblIdentificacin);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setFont(new Font("Montserrat", Font.BOLD, 30));
		lblTelfono.setBounds(60, 486, 155, 49);
		panelFondo.add(lblTelfono);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Montserrat", Font.BOLD, 30));
		lblEdad.setBounds(60, 574, 100, 49);
		panelFondo.add(lblEdad);
		
		JLabel lblIdHistoraClnica = new JLabel("ID Historía Clínica:");
		lblIdHistoraClnica.setFont(new Font("Montserrat", Font.BOLD, 30));
		lblIdHistoraClnica.setBounds(60, 662, 301, 49);
		panelFondo.add(lblIdHistoraClnica);
	} //public PanelConfirmarPaciente() 
}
