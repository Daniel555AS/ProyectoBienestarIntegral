package co.edu.upb.proyecto_bienestar_integral.view;

import javax.swing.JPanel;

import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.PersonaAdministrativa;
import co.edu.upb.proyecto_bienestar_integral.view.componentes.RoundedButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PanelPrincipal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel lblGestionPacientes;
	private JLabel lblImagenPrincipal;
	private static JLabel lblAdminActual;
	private RoundedButton buttonSalir;

	/**
	 * Create the panel.
	 */
	// Primer Constructor del PanelPrincipal:
	public PanelPrincipal() {
		setLayout(null);

		// Creación de JPanel para fondo de PanelPrincipal:
		JPanel panelFondo = new JPanel();
		panelFondo.setBackground(Color.WHITE);
		panelFondo.setBounds(0, 0, 1203, 783);
		add(panelFondo);
		panelFondo.setLayout(null);

		// Creación de RoundedButton con imagen insertada, con el propósito de buscar la
		// Historia Clínica de un Paciente, según el ID ingresado:
		buttonSalir = new RoundedButton("", Color.white, Color.white, 1000, 90);
		buttonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showOptionDialog(null, "¿Confirma Cerrar Sesión?", "Cerrar Sesión",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						new String[] { "Confirmar", "Rechazar" }, null);
				if (opcion == JOptionPane.YES_OPTION) {
					VistaInicioDeSesion vistaInicioDeSesion = new VistaInicioDeSesion();
					cerrarTodasLasVentanas();
					vistaInicioDeSesion.setVisible(true);
				}
			}
		});
		buttonSalir.setBounds(1084, 701, 85, 72);
		buttonSalir.setFocusable(false);
		panelFondo.add(buttonSalir);
		setImageButton(buttonSalir, "Media\\IconoSalir.png");

		// Creación de JPanel con propósito decorativo, ubicado en la parte superior del
		// panel:
		JPanel panelDecorativoSup = new JPanel();
		panelDecorativoSup.setBackground(new Color(2, 138, 102));
		panelDecorativoSup.setBounds(0, 47, 1203, 142);
		panelFondo.add(panelDecorativoSup);
		panelDecorativoSup.setLayout(null);

		// Creación de JLabel con el texto: "Registrar Paciente":
		lblGestionPacientes = new JLabel("Principal");
		lblGestionPacientes.setForeground(new Color(240, 255, 240));
		lblGestionPacientes.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblGestionPacientes.setBounds(47, 44, 188, 49);
		panelDecorativoSup.add(lblGestionPacientes);

		lblImagenPrincipal = new JLabel("");
		lblImagenPrincipal.setBounds(42, 215, 1095, 516);
		panelFondo.add(lblImagenPrincipal);
		setImageLabel(lblImagenPrincipal, "Media\\ImagenPanelPrincipal.png");

		lblAdminActual = new JLabel("");
		lblAdminActual.setFont(new Font("Montserrat", Font.PLAIN, 20));
		lblAdminActual.setBounds(42, 741, 562, 32);
		panelFondo.add(lblAdminActual);

	}
	
	public PanelPrincipal(PersonaAdministrativa admin) {
		setLayout(null);

		// Creación de JPanel para fondo de PanelPrincipal:
		JPanel panelFondo = new JPanel();
		panelFondo.setBackground(Color.WHITE);
		panelFondo.setBounds(0, 0, 1203, 783);
		add(panelFondo);
		panelFondo.setLayout(null);

		// Creación de RoundedButton con imagen insertada, con el propósito de buscar la
		// Historia Clínica de un Paciente, según el ID ingresado:
		buttonSalir = new RoundedButton("", Color.white, Color.white, 1000, 90);
		buttonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showOptionDialog(null, "¿Confirma Cerrar Sesión?", "Cerrar Sesión",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						new String[] { "Confirmar", "Rechazar" }, null);
				if (opcion == JOptionPane.YES_OPTION) {
					VistaInicioDeSesion vistaInicioDeSesion = new VistaInicioDeSesion();
					cerrarTodasLasVentanas();
					vistaInicioDeSesion.setVisible(true);
				}
			}
		});
		buttonSalir.setBounds(1084, 701, 85, 72);
		buttonSalir.setFocusable(false);
		panelFondo.add(buttonSalir);
		setImageButton(buttonSalir, "Media\\IconoSalir.png");

		// Creación de JPanel con propósito decorativo, ubicado en la parte superior del
		// panel:
		JPanel panelDecorativoSup = new JPanel();
		panelDecorativoSup.setBackground(new Color(2, 138, 102));
		panelDecorativoSup.setBounds(0, 47, 1203, 142);
		panelFondo.add(panelDecorativoSup);
		panelDecorativoSup.setLayout(null);

		// Creación de JLabel con el texto: "Registrar Paciente":
		lblGestionPacientes = new JLabel("Principal");
		lblGestionPacientes.setForeground(new Color(240, 255, 240));
		lblGestionPacientes.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblGestionPacientes.setBounds(47, 44, 188, 49);
		panelDecorativoSup.add(lblGestionPacientes);

		lblImagenPrincipal = new JLabel("");
		lblImagenPrincipal.setBounds(42, 215, 1095, 516);
		panelFondo.add(lblImagenPrincipal);
		setImageLabel(lblImagenPrincipal, "Media\\ImagenPanelPrincipal.png");

		lblAdminActual = new JLabel("Admin. " + admin.getNombreJuntoId());
		lblAdminActual.setFont(new Font("Montserrat", Font.PLAIN, 20));
		lblAdminActual.setBounds(42, 741, 562, 32);
		panelFondo.add(lblAdminActual);

	}


	public static void setAdminActual(PersonaAdministrativa persona) {
		lblAdminActual.setText("Admin. " + persona.getNombreJuntoId());
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

	// Método private void para insertar imagen en JButton, según las dimensiones de
	// este componenten:
	private static void setImageButton(JButton button, String imagePath) {
		ImageIcon imageIcon = new ImageIcon(imagePath);
		Image image = imageIcon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(image);
		button.setIcon(icon);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	} // private static void setImageButton(JButton button, String imagePath)

	private void cerrarTodasLasVentanas() {
		Window[] ventanas = Window.getWindows();
		for (int i = 0; i < ventanas.length; i++) {
			ventanas[i].dispose();
		}
	}

} // public class PanelPrincipal extends JPanel
