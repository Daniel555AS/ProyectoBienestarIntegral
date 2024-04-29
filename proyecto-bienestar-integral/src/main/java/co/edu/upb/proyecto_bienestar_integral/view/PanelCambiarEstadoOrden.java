package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCambiarEstadoOrden extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelFondo;
	private JPanel panelDecorativoSup;
	private JLabel lblAutorizacionExames;
	/**
	 * Create the panel.
	 */
	public PanelCambiarEstadoOrden() {
		
		setLayout(null); // Establecimiento Absolute Layout
		
		// Creación de JPanel como fondo para PanelAutorizarExamen:
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

		// Creación de JLabel con el texto: "Autorización de Exámenes":
		lblAutorizacionExames = new JLabel("Autorización de Exámenes");
		lblAutorizacionExames.setForeground(new Color(240, 255, 240));
		lblAutorizacionExames.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblAutorizacionExames.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblAutorizacionExames);

	}

}
