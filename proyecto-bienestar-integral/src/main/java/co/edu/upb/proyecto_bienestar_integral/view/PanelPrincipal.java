package co.edu.upb.proyecto_bienestar_integral.view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class PanelPrincipal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		panelDecorativoSup.setBounds(0, 47, 1203, 55);
		panelFondo.add(panelDecorativoSup);

	}
	
} // public class PanelPrincipal extends JPanel 
