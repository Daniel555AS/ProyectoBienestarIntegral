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
	private JLabel lblImagenPrincipal;


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
		
		lblImagenPrincipal = new JLabel("");
		lblImagenPrincipal.setBounds(42, 215, 1095, 516);
		panelFondo.add(lblImagenPrincipal);	
		setImageLabel(lblImagenPrincipal, "Media\\ImagenPanelPrincipal.png");
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
		
} // public class PanelPrincipal extends JPanel 
