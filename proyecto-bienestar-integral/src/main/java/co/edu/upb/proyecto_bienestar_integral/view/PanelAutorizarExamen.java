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
import co.edu.upb.proyecto_bienestar_integral.view.componentes.*;
import co.edu.upb.proyecto_bienestar_integral.controller.*;
import co.edu.upb.proyecto_bienestar_integral.controller.gestion_ordenes.ControladorAutorizarExamen;
import co.edu.upb.proyecto_bienestar_integral.model.*;
import javax.swing.SwingConstants;

public class PanelAutorizarExamen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelFondo;
	private JPanel panelDecorativoSup;
	private JLabel lblAutorizacionExames;
	private RoundedPanel panelIDHistoriaClinica;
	private JLabel lblidHC;
	private JLabel lblImagenExamenes;
	private JLabel lblTxtAutorizacionExa;
	private RoundedButton buttonRegresar;
	private JTextField campoIdHistoriaClinica;
	private ModeloAutorizarExamen modeloAutorizarExamen;
	private ControladorAutorizarExamen controladorAutorizarExamen;

	/**
	 * Create the panel.
	 */
	public PanelAutorizarExamen(String rutaImagen, String mensaje) {
		modeloAutorizarExamen = new ModeloAutorizarExamen();
		controladorAutorizarExamen = new ControladorAutorizarExamen(modeloAutorizarExamen, this);

		setLayout(null); // Establecimiento Absolute Layout
		// Creación de JPanel como fondo para PanelAutorizarExamen:
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

		// Creación de JLabel con el texto: "Autorización de Exámenes":
		lblAutorizacionExames = new JLabel("Autorización de Exámenes");
		lblAutorizacionExames.setForeground(new Color(240, 255, 240));
		lblAutorizacionExames.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblAutorizacionExames.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblAutorizacionExames);

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
		lblidHC = new JLabel("ID HC:");
		lblidHC.setFont(new Font("Montserrat", Font.BOLD, 30));
		lblidHC.setBounds(35, 228, 109, 24);
		panelFondo.add(lblidHC);

		// Creación de JLabel para la inserción de imagen ilustrativa al proceso de
		// autorizar exámenes:
		lblImagenExamenes = new JLabel("");
		lblImagenExamenes.setBounds(338, 307, 469, 372);
		setImageLabel(lblImagenExamenes, rutaImagen);
		panelFondo.add(lblImagenExamenes);

		// Creación de JLabel con el propósito de mostrar texto relacionado con el
		// proceso de Autorización de Exámenes:
		lblTxtAutorizacionExa = new JLabel(mensaje);
		lblTxtAutorizacionExa.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtAutorizacionExa.setFont(new Font("Montserrat", Font.ITALIC, 30));
		lblTxtAutorizacionExa.setBounds(81, 702, 1067, 44);
		panelFondo.add(lblTxtAutorizacionExa);

		// Creación de RoundedButton con imagen insertada, con el propósito de buscar
		// las Órdenes de Exámenes por autorizar de un paciente, según su ID de Historia
		// Clínica:
		buttonRegresar = new RoundedButton("", new Color(203, 53, 53), new Color(234, 68, 68), 1000, 60);
		buttonRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorAutorizarExamen.verificacionOrdenes(getCampoIdHistoriaClinica());
			}
		});
		buttonRegresar.setBounds(1003, 200, 85, 72);
		buttonRegresar.setFocusable(false);
		panelFondo.add(buttonRegresar);
		setImageButton(buttonRegresar, "Media\\ImagenBuscar.jpg");

	} // public PanelAutorizarExamen()

	// Métodos Getters:
	// Método para obtener la cadena de texto ingresada en campoIdHistoriaClinica:
	public String getCampoIdHistoriaClinica() {
		return campoIdHistoriaClinica.getText();
	}

	// Métodos Setters:
	// Método para establecer un texto en campoIdHistoriaClinica:
	public void setCampoIdHistoriaClinica(String texto) {
		campoIdHistoriaClinica.setText(texto);
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

	// Método private void par insertar imagen en JButton, según las dimensiones de
	// este componenten:
	private static void setImageButton(JButton button, String imagePath) {
		ImageIcon imageIcon = new ImageIcon(imagePath);
		Image image = imageIcon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(image);
		button.setIcon(icon);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	} // private static void setImageButton(JButton button, String imagePath)

} // public class PanelAutorizarExamen extends JPanel
