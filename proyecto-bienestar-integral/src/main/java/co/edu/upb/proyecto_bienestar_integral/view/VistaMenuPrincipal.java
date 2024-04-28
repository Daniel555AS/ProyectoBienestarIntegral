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
	private PanelRegistrarOrden panelRegistrarOrden;
	private RoundedButton buttonRegistroExamenes;
	private RoundedButton buttonRegistroCitas;
	private RoundedButton buttonRegistroOrdenes;

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

		panelPrincipal = new PanelPrincipal();
		panelGestionPacientes = new PanelGestionPacientes();
		panelRegistrarOrden = new PanelRegistrarOrden();

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
				mostrarPanel(panelPrincipal);
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
		buttonRegistroOrdenes.setBounds(0, 399, 337, 57);
		panelMenu.add(buttonRegistroOrdenes);
		buttonRegistroOrdenes.setText("Registro de Órdenes");
		buttonRegistroOrdenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPanel(panelRegistrarOrden);
			}
		});
		buttonRegistroOrdenes.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonRegistroOrdenes.setForeground(new Color(255, 255, 255));
		buttonRegistroOrdenes.setBackground(new Color(0, 172, 168));
		buttonRegistroOrdenes.setFocusable(false);

		// Creación de RoundedButton para el Registro de Exámenes
		buttonRegistroExamenes = new RoundedButton("Registro de Exámenes", new Color(0, 172, 168),
				new Color(0, 204, 199), 1000, 0);
		buttonRegistroExamenes.setBounds(0, 455, 337, 57);
		panelMenu.add(buttonRegistroExamenes);
		buttonRegistroExamenes.setText("Registro de Exámenes");
		buttonRegistroExamenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		buttonRegistroExamenes.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonRegistroExamenes.setForeground(new Color(255, 255, 255));
		buttonRegistroExamenes.setBackground(new Color(0, 172, 168));
		buttonRegistroExamenes.setFocusable(false);

		// Creación de RoundedButton para el Registro de Citas:
		buttonRegistroCitas = new RoundedButton("Registro de Citas", new Color(0, 172, 168), new Color(0, 204, 199),
				1000, 0);
		buttonRegistroCitas.setBounds(0, 343, 337, 57);
		panelMenu.add(buttonRegistroCitas);
		buttonRegistroCitas.setText("Registro de Citas");
		buttonRegistroCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		buttonRegistroCitas.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonRegistroCitas.setForeground(new Color(255, 255, 255));
		buttonRegistroCitas.setBackground(new Color(0, 172, 168));
		buttonRegistroCitas.setFocusable(false);

		// Creación de JPanel Dinámico:
		panelDinamico = new JPanel();
		panelDinamico.setBounds(336, 0, 1203, 783);
		contentPane.add(panelDinamico);
		panelDinamico.setLayout(new BorderLayout(0, 0));
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
