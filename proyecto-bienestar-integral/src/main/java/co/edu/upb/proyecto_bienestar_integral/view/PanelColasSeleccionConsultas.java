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
	private RoundedButton buttonCardiologia;
	private RoundedButton buttonNeurologia;
	private RoundedButton buttonOftalmologia;
	private RoundedButton buttonGastroenterologia;
	private RoundedButton buttonMedicinaInterna;
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

		// Creación de JLabel con el texto: "Sistema Gestor de Colas: Selección":
		lblSistemaGestorColasSeleccion = new JLabel("Sistema Gestor de Colas: Selección");
		lblSistemaGestorColasSeleccion.setForeground(new Color(240, 255, 240));
		lblSistemaGestorColasSeleccion.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblSistemaGestorColasSeleccion.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblSistemaGestorColasSeleccion);

		// Creación de RoundedButton para el acceso a la Cola de Espera de Medicina
		// General:
		buttonMedicinaGeneral = new RoundedButton("Medicina General", new Color(23, 174, 191), new Color(0, 139, 139),
				1000, 60);
		buttonMedicinaGeneral.setText("Medicina General");
		buttonMedicinaGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorColaCitasConsulta.accederCola("A101", "Medicina General", "Valoración", "Control");
			}
		});
		buttonMedicinaGeneral.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonMedicinaGeneral.setForeground(new Color(255, 255, 255));
		buttonMedicinaGeneral.setBackground(new Color(23, 174, 191));
		buttonMedicinaGeneral.setBounds(46, 398, 320, 57);
		buttonMedicinaGeneral.setFocusable(false);
		panelFondo.add(buttonMedicinaGeneral);

		// Creación de RoundedButton para el acceso a la Cola de Espera de Cardiología:
		buttonCardiologia = new RoundedButton("Cardiología", new Color(23, 174, 191), new Color(0, 139, 139), 1000, 60);
		buttonCardiologia.setText("Cardiología");
		buttonCardiologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorColaCitasConsulta.accederCola("C304", "Cardiología", "Valoración", "Control");
			}
		});
		buttonCardiologia.setForeground(Color.WHITE);
		buttonCardiologia.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonCardiologia.setFocusable(false);
		buttonCardiologia.setBackground(new Color(23, 174, 191));
		buttonCardiologia.setBounds(452, 398, 320, 57);
		panelFondo.add(buttonCardiologia);

		// Creación de RoundedButton para el acceso a la Cola de Espera de Neurología:
		buttonNeurologia = new RoundedButton("Neurología", new Color(23, 174, 191), new Color(0, 139, 139), 1000, 60);
		buttonNeurologia.setText("Neurología");
		buttonNeurologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorColaCitasConsulta.accederCola("B200", "Neurología", "Valoración", "Control");
			}
		});
		buttonNeurologia.setForeground(Color.WHITE);
		buttonNeurologia.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonNeurologia.setFocusable(false);
		buttonNeurologia.setBackground(new Color(23, 174, 191));
		buttonNeurologia.setBounds(847, 398, 320, 57);
		panelFondo.add(buttonNeurologia);

		// Creación de RoundedButton para el acceso a la Cola de Espera de Oftalmología:
		buttonOftalmologia = new RoundedButton("Oftalmología", new Color(23, 174, 191), new Color(0, 139, 139), 1000,
				60);
		buttonOftalmologia.setText("Oftalmología");
		buttonOftalmologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorColaCitasConsulta.accederCola("B204", "Oftalmología", "Valoración", "Control");
			}
		});
		buttonOftalmologia.setForeground(Color.WHITE);
		buttonOftalmologia.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonOftalmologia.setFocusable(false);
		buttonOftalmologia.setBackground(new Color(23, 174, 191));
		buttonOftalmologia.setBounds(46, 686, 320, 57);
		panelFondo.add(buttonOftalmologia);

		// Creación de RoundedButton para el acceso a la Cola de Espera de Medicina
		// Interna:
		buttonMedicinaInterna = new RoundedButton("Medicina Interna", new Color(23, 174, 191), new Color(0, 139, 139),
				1000, 60);
		buttonMedicinaInterna.setText("Medicina Interna");
		buttonMedicinaInterna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorColaCitasConsulta.accederCola("C300", "Medicina Interna", "Valoración", "Control");
			}
		});
		buttonMedicinaInterna.setForeground(Color.WHITE);
		buttonMedicinaInterna.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonMedicinaInterna.setFocusable(false);
		buttonMedicinaInterna.setBackground(new Color(23, 174, 191));
		buttonMedicinaInterna.setBounds(452, 686, 320, 57);
		panelFondo.add(buttonMedicinaInterna);

		// Creación de RoundedButton para el acceso a la Cola de Espera de
		// Gastroenterología:
		buttonGastroenterologia = new RoundedButton("Gastroenterología", new Color(23, 174, 191),
				new Color(0, 139, 139), 1000, 60);
		buttonGastroenterologia.setText("Gastroenterología");
		buttonGastroenterologia.setForeground(Color.WHITE);
		buttonGastroenterologia.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonGastroenterologia.setFocusable(false);
		buttonGastroenterologia.setBackground(new Color(23, 174, 191));
		buttonGastroenterologia.setBounds(847, 686, 320, 57);
		panelFondo.add(buttonGastroenterologia);

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
