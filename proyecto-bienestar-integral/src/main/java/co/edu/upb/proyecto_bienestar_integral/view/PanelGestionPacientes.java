package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;

import javax.swing.JPanel;

import co.edu.upb.proyecto_bienestar_integral.view.componentes.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

public class PanelGestionPacientes extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelGestionPacientes() {
		setLayout(null);

		// Creación de JPanel para fondo de PanelGestionPacientes:
		JPanel panelFondo = new JPanel();
		panelFondo.setBackground(new Color(255, 255, 255));
		panelFondo.setBounds(0, 0, 1203, 783);
		add(panelFondo);
		panelFondo.setLayout(null);
		
		// Creación  de RoundedButton para el registro de pacientes:
		RoundedButton buttonRegistrar = new RoundedButton("Registrar Paciente", new Color(23, 174, 191), new Color(0, 139, 139), 1000, 60);
		buttonRegistrar.setText("Registrar Pacientes");
		buttonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaMenuPrincipal.mostrarPanel(new PanelRegistrarPaciente());
			}
		});
		buttonRegistrar.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonRegistrar.setForeground(new Color(255, 255, 255));
		buttonRegistrar.setBackground(new Color(23, 174, 191));
		buttonRegistrar.setBounds(133, 689, 320, 57);
		buttonRegistrar.setFocusable(false);
		panelFondo.add(buttonRegistrar);
		
		
		
		// Creación  de RoundedButton para la modificación de pacientes:
		RoundedButton buttonModificar = new RoundedButton("Modificar Paciente", new Color(23, 174, 191), new Color(0, 139, 139), 1000, 60);
		buttonModificar.setText("Modificar Pacientes");
		buttonModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		buttonModificar.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonModificar.setForeground(new Color(255, 255, 255));
		buttonModificar.setBackground(new Color(23, 174, 191));
		buttonModificar.setBounds(760, 689, 320, 57);
		buttonModificar.setFocusable(false);
		panelFondo.add(buttonModificar);
		
		// Creación de JLabel con propósito decorativo para el registro de pacientes:
		JLabel lblRegistrar = new JLabel("");
		lblRegistrar.setBounds(55, 297, 486, 428);
		setImageLabel(lblRegistrar, "Media\\ImageRegistrar.png");
		panelFondo.add(lblRegistrar);
		
		
		//JPanel panel = new JPanel();
		//panel.setBounds(653, 297, 486, 428);
		//panelFondo.add(panel);
		
		//JPanel panelOtro = new JPanel();
		//panelOtro.setBounds(55, 297, 486, 428);
		//panelFondo.add(panelOtro);
		
		JLabel lblNewLabel_1 = new JLabel("<html>En nuestro Centro de Salud, Manejamos tu Información con Responsabilidad y Seguridad</html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(31, 220, 1082, 57);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelFondo.add(lblNewLabel_1);
		
		// Creación de JPanel con propósito decorativo, ubicado en la parte superior del panel:
		JPanel panelDecorativoSup = new JPanel();
		panelDecorativoSup.setBackground(new Color(2, 138, 102));
		panelDecorativoSup.setBounds(0, 47, 1203, 142);
		panelFondo.add(panelDecorativoSup);
		panelDecorativoSup.setLayout(null);
		
		// Creación de JLabel con el texto: "Gestión de Pacientes":
		JLabel lblGestionPacientes = new JLabel("Gestión de Pacientes");
		lblGestionPacientes.setForeground(new Color(240, 255, 240));
		lblGestionPacientes.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblGestionPacientes.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblGestionPacientes);
		
		// Creación de RoundedPanel Decorativo en la sección central del PanelGestionPacientes:
		RoundedPanel panelDecoraCen = new RoundedPanel(10);
		panelDecoraCen.setBackground(new Color(169, 169, 169));
		panelDecoraCen.setBounds(597, 297, 4, 449);
		panelFondo.add(panelDecoraCen);
			
	} // public PanelGestionPacientes() 
	
	private void setImageLabel(JLabel label, String root) {
        ImageIcon image = new ImageIcon(root); 
        ImageIcon icon = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icon);
        this.repaint();
	}
} // public class PanelGestionPacientes extends JPanel

