package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelColaVacia extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelFondo;
	private JPanel panelDecorativoSup;
	private JLabel lblRegistrarOrdenMedica;
	private JLabel lblNoHayPacientes;
	private JLabel lblIconoColaVacia;

	/**
	 * Create the panel.
	 */
	public PanelColaVacia(String especialidad) {
		setLayout(null); // Establecimiento de Absolute Layout

		panelFondo = new JPanel();
		panelFondo.setBackground(Color.WHITE);
		panelFondo.setBounds(0, 0, 1203, 783);
		add(panelFondo);
		panelFondo.setLayout(null);

		panelDecorativoSup = new JPanel();
		panelDecorativoSup.setBackground(new Color(2, 138, 102));
		panelDecorativoSup.setBounds(0, 47, 1203, 142);
		panelFondo.add(panelDecorativoSup);
		panelFondo.setLayout(null);
		panelDecorativoSup.setLayout(null);

		lblRegistrarOrdenMedica = new JLabel("Cola Vacía: " + especialidad);
		lblRegistrarOrdenMedica.setForeground(new Color(240, 255, 240));
		lblRegistrarOrdenMedica.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblRegistrarOrdenMedica.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblRegistrarOrdenMedica);

		lblNoHayPacientes = new JLabel("No Hay Pacientes en la Cola de Espera");
		lblNoHayPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoHayPacientes.setFont(new Font("Montserrat", Font.ITALIC, 30));
		lblNoHayPacientes.setBounds(10, 688, 1067, 44);
		panelFondo.add(lblNoHayPacientes);

		lblIconoColaVacia = new JLabel("");
		lblIconoColaVacia.setBounds(249, 230, 585, 445);
		panelFondo.add(lblIconoColaVacia);
		setImageLabel(lblIconoColaVacia, "Media\\IconoColaVacia.jpg");
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

}
