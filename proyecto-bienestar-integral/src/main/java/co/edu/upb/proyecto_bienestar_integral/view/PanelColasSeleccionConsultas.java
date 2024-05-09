package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.view.componentes.*;
import co.edu.upb.proyecto_bienestar_integral.controller.*;

public class PanelColasSeleccionConsultas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelFondo;
	private JPanel panelDecorativoSup;
	private JLabel lblSistemaGestorColasSeleccion;
	private JLabel lblIconoMedicinaGeneral;
	private JLabel lblIconoCardiologia;
	private JLabel lblIconoNeurologia;
	private JLabel lblIconoOftalmologia;
	private JLabel lblIconoMedicinaInterna;
	private JLabel lblIconoGastro;
	private RoundedButton buttonMedicinaGeneral;
	private ModeloColaCitasConsulta modeloColaCitasConsulta;
	private PanelMirarColaConsulta panelMirarColaConsulta;
	private ControladorColaCitasConsulta controladorColaCitasConsulta;

	/**
	 * Create the panel.
	 */
	public PanelColasSeleccionConsultas() {
		modeloColaCitasConsulta = new ModeloColaCitasConsulta();
		panelMirarColaConsulta = new PanelMirarColaConsulta();
		controladorColaCitasConsulta = new ControladorColaCitasConsulta(modeloColaCitasConsulta,
				panelMirarColaConsulta);

		setLayout(null); // Establecimiento de Absolute Layout

		// Creación de JPanel para fondo de PanelSeleccionCita:
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

		// Creación de JLabel con el texto: "Registro de Cita":
		lblSistemaGestorColasSeleccion = new JLabel("Sistema Gestor de Colas: Selección");
		lblSistemaGestorColasSeleccion.setForeground(new Color(240, 255, 240));
		lblSistemaGestorColasSeleccion.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblSistemaGestorColasSeleccion.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblSistemaGestorColasSeleccion);

		// Creación de RoundedButton para la continuación de procesos:
		buttonMedicinaGeneral = new RoundedButton("Medicina General", new Color(23, 174, 191), new Color(0, 139, 139),
				1000, 60);
		buttonMedicinaGeneral.setText("Medicina General");
		buttonMedicinaGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorColaCitasConsulta.accederCola("G101", "Medicina General", "Valoración", "Control");
			}
		});
		buttonMedicinaGeneral.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonMedicinaGeneral.setForeground(new Color(255, 255, 255));
		buttonMedicinaGeneral.setBackground(new Color(23, 174, 191));
		buttonMedicinaGeneral.setBounds(46, 398, 320, 57);
		buttonMedicinaGeneral.setFocusable(false);
		panelFondo.add(buttonMedicinaGeneral);

		RoundedButton rndbtnCardiologa = new RoundedButton("Medicina General", new Color(23, 174, 191),
				new Color(0, 139, 139), 1000, 60);
		rndbtnCardiologa.setText("Cardiología");
		rndbtnCardiologa.setForeground(Color.WHITE);
		rndbtnCardiologa.setFont(new Font("Montserrat", Font.BOLD, 25));
		rndbtnCardiologa.setFocusable(false);
		rndbtnCardiologa.setBackground(new Color(23, 174, 191));
		rndbtnCardiologa.setBounds(452, 398, 320, 57);
		panelFondo.add(rndbtnCardiologa);

		RoundedButton rndbtnNeurologa = new RoundedButton("Medicina General", new Color(23, 174, 191),
				new Color(0, 139, 139), 1000, 60);
		rndbtnNeurologa.setText("Neurología");
		rndbtnNeurologa.setForeground(Color.WHITE);
		rndbtnNeurologa.setFont(new Font("Montserrat", Font.BOLD, 25));
		rndbtnNeurologa.setFocusable(false);
		rndbtnNeurologa.setBackground(new Color(23, 174, 191));
		rndbtnNeurologa.setBounds(847, 398, 320, 57);
		panelFondo.add(rndbtnNeurologa);

		RoundedButton rndbtnOftalmologa = new RoundedButton("Medicina General", new Color(23, 174, 191),
				new Color(0, 139, 139), 1000, 60);
		rndbtnOftalmologa.setText("Oftalmología");
		rndbtnOftalmologa.setForeground(Color.WHITE);
		rndbtnOftalmologa.setFont(new Font("Montserrat", Font.BOLD, 25));
		rndbtnOftalmologa.setFocusable(false);
		rndbtnOftalmologa.setBackground(new Color(23, 174, 191));
		rndbtnOftalmologa.setBounds(46, 686, 320, 57);
		panelFondo.add(rndbtnOftalmologa);

		RoundedButton buttonMedicinaGeneral_1_1 = new RoundedButton("Medicina General", new Color(23, 174, 191),
				new Color(0, 139, 139), 1000, 60);
		buttonMedicinaGeneral_1_1.setText("Medicina Interna");
		buttonMedicinaGeneral_1_1.setForeground(Color.WHITE);
		buttonMedicinaGeneral_1_1.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonMedicinaGeneral_1_1.setFocusable(false);
		buttonMedicinaGeneral_1_1.setBackground(new Color(23, 174, 191));
		buttonMedicinaGeneral_1_1.setBounds(452, 686, 320, 57);
		panelFondo.add(buttonMedicinaGeneral_1_1);

		RoundedButton buttonMedicinaGeneral_1_1_1 = new RoundedButton("Medicina General", new Color(23, 174, 191),
				new Color(0, 139, 139), 1000, 60);
		buttonMedicinaGeneral_1_1_1.setText("Gastroenterologia");
		buttonMedicinaGeneral_1_1_1.setForeground(Color.WHITE);
		buttonMedicinaGeneral_1_1_1.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonMedicinaGeneral_1_1_1.setFocusable(false);
		buttonMedicinaGeneral_1_1_1.setBackground(new Color(23, 174, 191));
		buttonMedicinaGeneral_1_1_1.setBounds(847, 686, 320, 57);
		panelFondo.add(buttonMedicinaGeneral_1_1_1);

		lblIconoMedicinaGeneral = new JLabel("");
		lblIconoMedicinaGeneral.setBounds(24, 214, 360, 214);
		panelFondo.add(lblIconoMedicinaGeneral);
		setImageLabel(lblIconoMedicinaGeneral, "Media\\IconoMedicinaGeneral.png");

		lblIconoOftalmologia = new JLabel("");
		lblIconoOftalmologia.setBounds(24, 504, 360, 214);
		panelFondo.add(lblIconoOftalmologia);
		setImageLabel(lblIconoOftalmologia, "Media\\IconoOfta.png");

		lblIconoCardiologia = new JLabel("");
		lblIconoCardiologia.setBounds(432, 214, 360, 214);
		panelFondo.add(lblIconoCardiologia);
		setImageLabel(lblIconoCardiologia, "Media\\IconoCardiologia.png");

		lblIconoMedicinaInterna = new JLabel("");
		lblIconoMedicinaInterna.setBounds(432, 504, 360, 214);
		panelFondo.add(lblIconoMedicinaInterna);
		setImageLabel(lblIconoMedicinaInterna, "Media\\IconoMedicinaInterna.png");

		lblIconoNeurologia = new JLabel("");
		lblIconoNeurologia.setBounds(822, 214, 360, 214);
		panelFondo.add(lblIconoNeurologia);
		setImageLabel(lblIconoNeurologia, "Media\\IconoNeuro.png");

		lblIconoGastro = new JLabel("");
		lblIconoGastro.setBounds(822, 504, 360, 214);
		panelFondo.add(lblIconoGastro);
		setImageLabel(lblIconoGastro, "Media\\IconoGastro.png");

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
	}

} // public class PanelColasSeleccionConsultas extends JPanel
