package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import co.edu.upb.proyecto_bienestar_integral.view.componentes.*;

public class PanelSeleccionCita extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelFondo;
	private RoundedButton buttonExamen;
	private RoundedButton buttonValoracionControl;
	private JLabel lblImagenExamen;
	private JLabel lblImagenValoracionControl;
	private JPanel panelDecorativoSup;
	private RoundedPanel panelDecoraCen;
	private JLabel lblRegistroDeCita;

	/**
	 * Create the panel.
	 */
	public PanelSeleccionCita() {
		setLayout(null);

		// Creación de JPanel para fondo de PanelSeleccionCita:
		panelFondo = new JPanel();
		panelFondo.setBackground(new Color(255, 255, 255));
		panelFondo.setBounds(0, 0, 1203, 783);
		add(panelFondo);
		panelFondo.setLayout(null);

		// Creación de RoundedButton para Examen:
		buttonExamen = new RoundedButton("Examen", new Color(23, 174, 191), new Color(0, 139, 139), 1000, 60);
		buttonExamen.setText("Examen");
		buttonExamen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaMenuPrincipal.mostrarPanel(new PanelRegistroCitaExamen());
			}
		});
		buttonExamen.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonExamen.setForeground(new Color(255, 255, 255));
		buttonExamen.setBackground(new Color(23, 174, 191));
		buttonExamen.setBounds(134, 649, 320, 57);
		buttonExamen.setFocusable(false);
		panelFondo.add(buttonExamen);

		// Creación de RoundedButton para Valoración o Control:
		buttonValoracionControl = new RoundedButton("Valoración o Control", new Color(23, 174, 191),
				new Color(0, 139, 139), 1000, 60);
		buttonValoracionControl.setText("Valoración o Control");
		buttonValoracionControl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaMenuPrincipal.mostrarPanel(new PanelRegistroCitaValoracionControl());
			}
		});
		buttonValoracionControl.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonValoracionControl.setForeground(new Color(255, 255, 255));
		buttonValoracionControl.setBackground(new Color(23, 174, 191));
		buttonValoracionControl.setBounds(761, 649, 320, 57);
		buttonValoracionControl.setFocusable(false);
		panelFondo.add(buttonValoracionControl);

		// Creación de JLabel con propósito decorativo para Examen:
		lblImagenExamen = new JLabel("");
		lblImagenExamen.setBounds(58, 259, 486, 428);
		setImageLabel(lblImagenExamen, "Media\\ImagenExamen.jpg");
		panelFondo.add(lblImagenExamen);
		
		// Creación de JLabel con propósito decorativo para Valoracion o Control:
		lblImagenValoracionControl = new JLabel("");
		lblImagenValoracionControl.setBounds(665, 258, 486, 428);
		setImageLabel(lblImagenValoracionControl, "Media\\ImagenValoracionControl.jpg");
		panelFondo.add(lblImagenValoracionControl);

		// Creación de JPanel con propósito decorativo, ubicado en la parte superior del
		// panel:
		panelDecorativoSup = new JPanel();
		panelDecorativoSup.setBackground(new Color(2, 138, 102));
		panelDecorativoSup.setBounds(0, 47, 1203, 142);
		panelFondo.add(panelDecorativoSup);
		panelDecorativoSup.setLayout(null);

		// Creación de JLabel con el texto: "Registro de Cita":
		lblRegistroDeCita = new JLabel("Registrar Cita");
		lblRegistroDeCita.setForeground(new Color(240, 255, 240));
		lblRegistroDeCita.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblRegistroDeCita.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblRegistroDeCita);

		// Creación de RoundedPanel Decorativo en la sección central del
		// PanelRegistroCita:
		panelDecoraCen = new RoundedPanel(10);
		panelDecoraCen.setBackground(new Color(169, 169, 169));
		panelDecoraCen.setBounds(598, 257, 4, 449);
		panelFondo.add(panelDecoraCen);
	} // public PanelSeleccionCita()
	
	// Método private void que permite insertar una imagen con relación al tamaño definido de un JLabel:
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
	}

} // public class PanelSeleccionCita extends JPanel
