package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import co.edu.upb.proyecto_bienestar_integral.view.componentes.*;
import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.controller.*;

public class PanelBuscarHistoriaClinica extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelFondo;
	private JPanel panelDecorativoSup;
	private JPanel panelIDHistoriaClinica;
	private JLabel lblBuscarHistoriaClinica;
	private JLabel lblIdHC;
	private JLabel lblImagenBuscarHistoriaClinica;
	private JLabel lblTxtBuscarHistoriaClinica;
	private JTextField campoIdHistoriaClinica;
	private RoundedButton buttonBuscar;
	private ModeloBuscarHistoriaClinica modeloBuscarHistoriaClinica;
	private ControladorBuscarHistoriaClinica controladorBuscarHistoriaClinica;

	/**
	 * Create the panel.
	 */
	public PanelBuscarHistoriaClinica(String rutaImagen, String mensaje) {
		modeloBuscarHistoriaClinica = new ModeloBuscarHistoriaClinica();
		controladorBuscarHistoriaClinica = new ControladorBuscarHistoriaClinica(modeloBuscarHistoriaClinica, this);

		setLayout(null);

		// Creación de JPanel como fondo para PanelBuscarHistoriaClinica:
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

		// Creación de JLabel con el texto: "Buscar Historia Clínica":
		lblBuscarHistoriaClinica = new JLabel("Buscar Historia Clínica");
		lblBuscarHistoriaClinica.setForeground(new Color(240, 255, 240));
		lblBuscarHistoriaClinica.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblBuscarHistoriaClinica.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblBuscarHistoriaClinica);

		// Creación de RoundedPanel decorativo para el ingreso del ID de Historia
		// Clínica de un Paciente:
		panelIDHistoriaClinica = new RoundedPanel(50);
		panelIDHistoriaClinica.setBackground(new Color(241, 241, 241));
		panelIDHistoriaClinica.setBounds(158, 198, 835, 74);
		panelFondo.add(panelIDHistoriaClinica);
		panelIDHistoriaClinica.setLayout(null);

		// Creación de JTextField como campo para ingresar el ID de la Historia Clínica
		// del Paciente:
		campoIdHistoriaClinica = new JTextField();
		campoIdHistoriaClinica.setBounds(20, 0, 789, 74);
		campoIdHistoriaClinica.setFont(new Font("Montserrat", Font.PLAIN, 25));
		campoIdHistoriaClinica.setColumns(10);
		campoIdHistoriaClinica.setBorder(null);
		campoIdHistoriaClinica.setBackground((Color) null);
		panelIDHistoriaClinica.add(campoIdHistoriaClinica);

		// Creación de JLabel con el texto: "ID HC:":
		lblIdHC = new JLabel("ID HC:");
		lblIdHC.setFont(new Font("Montserrat", Font.BOLD, 30));
		lblIdHC.setBounds(35, 228, 109, 24);
		panelFondo.add(lblIdHC);

		// Creación de JLabel para la inserción de imagen ilustrativa al proceso de
		// buscar la Historia Clínica de un Paciente:
		lblImagenBuscarHistoriaClinica = new JLabel("");
		lblImagenBuscarHistoriaClinica.setBounds(338, 307, 469, 372);
		setImageLabel(lblImagenBuscarHistoriaClinica, rutaImagen);
		panelFondo.add(lblImagenBuscarHistoriaClinica);

		// Creación de JLabel con el propósito de mostrar texto relacionado con el
		// proceso de Buscar la Historia Clínica de un Paciente:
		lblTxtBuscarHistoriaClinica = new JLabel(mensaje);
		lblTxtBuscarHistoriaClinica.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtBuscarHistoriaClinica.setFont(new Font("Montserrat", Font.ITALIC, 24));
		lblTxtBuscarHistoriaClinica.setBounds(81, 702, 1067, 44);
		panelFondo.add(lblTxtBuscarHistoriaClinica);

		// Creación de RoundedButton con imagen insertada, con el propósito de buscar la
		// Historia Clínica de un Paciente, según el ID ingresado:
		buttonBuscar = new RoundedButton("", new Color(203, 53, 53), new Color(234, 68, 68), 1000, 60);
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorBuscarHistoriaClinica.verificarExistenciaHistoriaClinica(getCampoIdHistoriaClinica());
			}
		});
		buttonBuscar.setBounds(1003, 200, 85, 72);
		buttonBuscar.setFocusable(false);
		panelFondo.add(buttonBuscar);
		setImageButton(buttonBuscar, "Media\\ImagenBuscar.jpg");
	}

	// Getters:
	public String getCampoIdHistoriaClinica() {
		return campoIdHistoriaClinica.getText();
	}

	// Setters:
	public void setCampoIdHistoriaClinica(String id) {
		campoIdHistoriaClinica.setText(id);
	}

	// Método private void para insertar imagen en JLabel, según las dimensiones de
	// este componente:
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

}
