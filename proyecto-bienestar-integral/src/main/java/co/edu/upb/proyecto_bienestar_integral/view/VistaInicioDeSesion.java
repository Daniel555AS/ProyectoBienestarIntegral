package co.edu.upb.proyecto_bienestar_integral.view;

import co.edu.upb.proyecto_bienestar_integral.view.componentes.*;
import co.edu.upb.proyecto_bienestar_integral.controller.*;
import co.edu.upb.proyecto_bienestar_integral.model.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class VistaInicioDeSesion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelRedondeadoId;
	private JPanel panelRedondeadoContrasena;
	private JTextField campoId;
	private JPasswordField campoContrasena;
	private ControladorInicioDeSesion controladorInicioDeSesion;
	private ModeloGestorInicioDeSesion modeloGestorInicioDeSesion;

	/**
	 * Create the frame.
	 */
	public VistaInicioDeSesion() {
		modeloGestorInicioDeSesion = new ModeloGestorInicioDeSesion();
		controladorInicioDeSesion = new ControladorInicioDeSesion(this, modeloGestorInicioDeSesion);
		
		
		// Deshabilitar la redimensión del JFrame:
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1540, 820);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Creación de JPanel con propósito decorativo (Ubicado en la zona derecha del JFrame):
		JPanel panelDecorativoDer = new JPanel();
		panelDecorativoDer.setBackground(new Color(0, 139, 139));
		panelDecorativoDer.setBounds(1179, 0, 347, 783);
		contentPane.add(panelDecorativoDer);

		// Creación de JLabel con el texto: "Iniciar Sesión":
		JLabel lblIniciarSesion = new JLabel("Iniciar Sesión");
		lblIniciarSesion.setFont(new Font("Montserrat", Font.BOLD, 65));
		lblIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSesion.setBounds(140, 98, 476, 74);
		contentPane.add(lblIniciarSesion);

		// Creación de RoundedPanel decorativo para ingreso de ID:
		panelRedondeadoId = new RoundedPanel(50);
		panelRedondeadoId.setBackground(new Color(241, 241, 241));
		panelRedondeadoId.setBounds(140, 280, 639, 74);
		contentPane.add(panelRedondeadoId);
		panelRedondeadoId.setLayout(null);
		
		// Creación de JTextField para ingreso de Identificación:
		campoId = new JTextField();
		campoId.setBackground(new Color(241, 241, 241));
		campoId.setFont(new Font("Montserrat", Font.PLAIN, 30));
		campoId.setBounds(73, 10, 556, 54);
		campoId.setBorder(null);
		panelRedondeadoId.add(campoId);
		campoId.setColumns(10);

		// Creación de JLabel con el texto: "Identificación: ":
		JLabel lblId = new JLabel("Identificación: ");
		lblId.setFont(new Font("Montserrat Light", Font.PLAIN, 25));
		lblId.setBounds(140, 240, 245, 30);
		contentPane.add(lblId);

		// Creación de JLabel con el texto: "Contraseña: ":
		JLabel lblContrasena = new JLabel("Contraseña: ");
		lblContrasena.setFont(new Font("Montserrat Light", Font.PLAIN, 25));
		lblContrasena.setBounds(140, 404, 245, 30);
		contentPane.add(lblContrasena);

		// Creación de RoundedPanel decorativo para ingreso de Contraseña:
		panelRedondeadoContrasena = new RoundedPanel(50);
		panelRedondeadoContrasena.setBackground(new Color(241, 241, 241));
		panelRedondeadoContrasena.setBounds(140, 444, 639, 74);
		contentPane.add(panelRedondeadoContrasena);
		panelRedondeadoContrasena.setLayout(null);
		
		// Creación de JPasswordField para ingresar contraseña:
		campoContrasena = new JPasswordField();
		campoContrasena.setBackground(new Color(241, 241, 241));
		campoContrasena.setFont(new Font("Calibri", Font.BOLD, 30));
		campoContrasena.setBounds(73, 10, 556, 54);
		campoContrasena.setBorder(null);
		panelRedondeadoContrasena.add(campoContrasena);
		
		// Creación de RoundedButton para Iniciar Sesión:
		RoundedButton buttonIngresar = new RoundedButton("Ingresar", new Color(23, 174, 191), new Color(0, 139, 139), 1000, 70);
		buttonIngresar.setText("Ingresar");
		buttonIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String identificacion = campoId.getText();
		        String contrasena = new String(campoContrasena.getPassword());
		        controladorInicioDeSesion.iniciarSesion(identificacion, contrasena);
		        // Limpiar los campos
		        campoId.setText("");
		        campoContrasena.setText("");			
			}
		});
		buttonIngresar.setFont(new Font("Montserrat", Font.BOLD, 31));
		buttonIngresar.setForeground(new Color(255, 255, 255));
		buttonIngresar.setBackground(new Color(23, 174, 191));
		buttonIngresar.setBounds(467, 559, 320, 57);
		buttonIngresar.setFocusable(false);
		contentPane.add(buttonIngresar);

		// Centrar el JFrame en la pantalla:
		setLocationRelativeTo(null);

	}
	
} // public class VistaInicioDeSesion extends JFrame
