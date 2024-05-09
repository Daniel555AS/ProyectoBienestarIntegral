package co.edu.upb.proyecto_bienestar_integral.view;

import co.edu.upb.proyecto_bienestar_integral.view.componentes.*;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaMenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JPanel panelDinamico;
	private RoundedButton buttonGestionPacientes;
	private RoundedButton buttonPrincipal;
	private PanelPrincipal panelPrincipal;
	private PanelGestionPacientes panelGestionPacientes;
	private PanelAutorizarExamen panelAutorizarExamen;
	private PanelRegistrarOrden panelRegistrarOrden;
	private PanelSeleccionCita panelSeleccionCita;
	private RoundedButton buttonRegistroExamenes;
	private RoundedButton buttonRegistroCitas;
	private RoundedButton buttonRegistroOrdenes;
	private RoundedButton buttonTaquilla;
	private RoundedButton buttonColas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaMenuPrincipal frame = new VistaMenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaMenuPrincipal() {
		// Deshabilitar la redimensión del JFrame:
		setResizable(false);
		panelDinamico = new JPanel();
		panelPrincipal = new PanelPrincipal();
		panelGestionPacientes = new PanelGestionPacientes();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1540, 820);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Creación de JPanel con propósito decorativo para el menú:
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 337, 783);
		panelMenu.setBackground(new Color(0, 139, 139));
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);

		// Creación de JLabel con el texto: "Menú":
		JLabel lblMenu = new JLabel("Menú");
		lblMenu.setForeground(new Color(240, 255, 255));
		lblMenu.setFont(new Font("Montserrat", Font.BOLD, 35));
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setBounds(55, 100, 209, 37);
		panelMenu.add(lblMenu);

		// Creación de JPanel con un propósito decorativo en la sección de Menú:
		JPanel panelDecorativoMenu = new JPanel();
		panelDecorativoMenu.setBackground(new Color(154, 205, 50));
		panelDecorativoMenu.setBounds(50, 147, 240, 4);
		panelMenu.add(panelDecorativoMenu);

		// Creación de RoundedButton para la sección Principal
		buttonPrincipal = new RoundedButton("Principal", new Color(0, 172, 168), new Color(0, 204, 199), 1000, 0);
		buttonPrincipal.setBounds(0, 235, 337, 57);
		panelMenu.add(buttonPrincipal);
		buttonPrincipal.setText("Principal");
		buttonPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPanel(new PanelPrincipal());
			}
		});
		buttonPrincipal.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonPrincipal.setForeground(new Color(255, 255, 255));
		buttonPrincipal.setBackground(new Color(0, 172, 168));
		buttonPrincipal.setFocusable(false);

		// Creación de RoundedButton para la Gestión de Pacientes
		buttonGestionPacientes = new RoundedButton("Gestión de Pacientes", new Color(0, 172, 168),
				new Color(0, 204, 199), 1000, 0);
		buttonGestionPacientes.setBounds(0, 287, 337, 57);
		panelMenu.add(buttonGestionPacientes);
		buttonGestionPacientes.setText("Gestión de Pacientes");
		buttonGestionPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPanel(panelGestionPacientes);
			}
		});
		buttonGestionPacientes.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonGestionPacientes.setForeground(new Color(255, 255, 255));
		buttonGestionPacientes.setBackground(new Color(0, 172, 168));
		buttonGestionPacientes.setFocusable(false);

		// Creación de RoundedButton para el Registro de Órdenes
		buttonRegistroOrdenes = new RoundedButton("Registro de Órdenes", new Color(0, 172, 168), new Color(0, 204, 199),
				1000, 0);
		buttonRegistroOrdenes.setBounds(0, 342, 337, 57);
		panelMenu.add(buttonRegistroOrdenes);
		buttonRegistroOrdenes.setText("Registro de Órdenes");
		buttonRegistroOrdenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRegistrarOrden = new PanelRegistrarOrden();
				mostrarPanel(panelRegistrarOrden);
			}
		});
		buttonRegistroOrdenes.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonRegistroOrdenes.setForeground(new Color(255, 255, 255));
		buttonRegistroOrdenes.setBackground(new Color(0, 172, 168));
		buttonRegistroOrdenes.setFocusable(false);

		// Creación de RoundedButton para el Registro de Exámenes
		buttonRegistroExamenes = new RoundedButton("Autorización de Exámenes", new Color(0, 172, 168),
				new Color(0, 204, 199), 1000, 0);
		buttonRegistroExamenes.setBounds(0, 398, 337, 57);
		panelMenu.add(buttonRegistroExamenes);
		buttonRegistroExamenes.setText("Autorización de Exámenes");
		buttonRegistroExamenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAutorizarExamen = new PanelAutorizarExamen("Media\\ImagenExamenes.jpg", "Módulo Para la Autorización de Exámenes de Nuestros Pacientes");
				mostrarPanel(panelAutorizarExamen);
			}
		});
		buttonRegistroExamenes.setFont(new Font("Montserrat", Font.BOLD, 21));
		buttonRegistroExamenes.setForeground(new Color(255, 255, 255));
		buttonRegistroExamenes.setBackground(new Color(0, 172, 168));
		buttonRegistroExamenes.setFocusable(false);

		// Creación de RoundedButton para el Registro de Citas:
		buttonRegistroCitas = new RoundedButton("Registro de Citas", new Color(0, 172, 168), new Color(0, 204, 199),
				1000, 0);
		buttonRegistroCitas.setBounds(0, 453, 337, 57);
		panelMenu.add(buttonRegistroCitas);
		buttonRegistroCitas.setText("Registro de Citas");
		buttonRegistroCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSeleccionCita = new PanelSeleccionCita();
				mostrarPanel(panelSeleccionCita);
			}
		});
		buttonRegistroCitas.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonRegistroCitas.setForeground(new Color(255, 255, 255));
		buttonRegistroCitas.setBackground(new Color(0, 172, 168));
		buttonRegistroCitas.setFocusable(false);
		
		// Creación de RoundedButton para la Taquilla:
		buttonTaquilla = new RoundedButton("Taquilla", new Color(0, 172, 168), new Color(0, 204, 199),
				1000, 0);
		buttonTaquilla.setBounds(0, 506, 337, 57);
		panelMenu.add(buttonTaquilla);
		buttonTaquilla.setText("Taquilla");
		buttonTaquilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPanel(new PanelTaquillaPagos());
			}
		});
		buttonTaquilla.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonTaquilla.setForeground(new Color(255, 255, 255));
		buttonTaquilla.setBackground(new Color(0, 172, 168));
		buttonTaquilla.setFocusable(false);
		
		// Creación de RoundedButton para el Sistema de Colas:
		buttonColas = new RoundedButton("Gestionar Colas", new Color(0, 172, 168), new Color(0, 204, 199),
				1000, 0);
		buttonColas.setBounds(0, 558, 337, 57);
		panelMenu.add(buttonColas);
		buttonColas.setText("Gestionar Colas");
		buttonColas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPanel(new PanelSistemaColas());
			}
		});
		buttonColas.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonColas.setForeground(new Color(255, 255, 255));
		buttonColas.setBackground(new Color(0, 172, 168));
		buttonColas.setFocusable(false);
		
		
			
		// Creación de JPanel Dinámico:
		panelDinamico.setLayout(new BorderLayout(0, 0));
		panelDinamico.setBounds(336, 0, 1203, 783);
		contentPane.add(panelDinamico);
		mostrarPanel(panelPrincipal);
		
		// Centrar el JFrame en la pantalla:
		setLocationRelativeTo(null);
	}

	public static void mostrarPanel(JPanel panel) {
		// panel.setSize(1203, 783);
		panel.setLocation(0, 0);

		panelDinamico.removeAll();
		panelDinamico.add(panel);
		panelDinamico.revalidate();
		panelDinamico.repaint();
	} // private void mostrarPanel(JPanel panel)
} // public class VistaMenuPrincipal extends JFrame
