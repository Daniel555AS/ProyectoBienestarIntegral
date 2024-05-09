package co.edu.upb.proyecto_bienestar_integral.view;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class PanelPrincipal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lblGestionPacientes;



	/**
	 * Create the panel.
	 */
	public PanelPrincipal() {
		
		setLayout(null);
		
		// Creación de JPanel para fondo de PanelPrincipal:
		JPanel panelFondo = new JPanel();
		panelFondo.setBackground(Color.WHITE);
		panelFondo.setBounds(0, 0, 1203, 783);
		add(panelFondo);
		panelFondo.setLayout(null);
		
		// Creación de JPanel con propósito decorativo, ubicado en la parte superior del panel:
		JPanel panelDecorativoSup = new JPanel();
		panelDecorativoSup.setBackground(new Color(2, 138, 102));
		panelDecorativoSup.setBounds(0, 47, 1203, 142);
		panelFondo.add(panelDecorativoSup);
		panelDecorativoSup.setLayout(null);
		
		// Creación de JLabel con el texto: "Registrar Paciente":
		lblGestionPacientes = new JLabel("Principal");
		lblGestionPacientes.setForeground(new Color(240, 255, 240));
		lblGestionPacientes.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblGestionPacientes.setBounds(47, 44, 188, 49);
		panelDecorativoSup.add(lblGestionPacientes);
		
		JLabel lblNewLabel_1 = new JLabel("¡Tu Salud es Nuestro Compromiso!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(201, 697, 790, 52);
		panelFondo.add(lblNewLabel_1);
		
	} 
    
    
} // public class PanelPrincipal extends JPanel 
