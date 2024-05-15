package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import co.edu.upb.proyecto_bienestar_integral.view.componentes.*;
import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.controller.*;

public class PanelHistoriaClinicaPaciente extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelFondo;
	private JPanel panelDecorativoSup;
	private JPanel panelIDHistoriaClinica;
	private JLabel lblHistoriaClinica;
	private JLabel lblIdHC;
	private JLabel lblNombres;
	private JLabel lblDatoNombres;
	private JLabel lblApellidos;
	private JLabel lblDatoApellidos;
	private JLabel lblId;
	private JLabel lblDatosPersonales;
	private JLabel lblHistorialMedico;
	private JLabel lblDatoIdPaciente;
	private JLabel lblFechaNacimiento;
	private JLabel lblDatoFechaNacimiento;
	private JLabel lblIdHistoriaClinica;
	private JLabel lblDatoHistoriaClinica;
	private JTextField campoIdHistoriaClinica;
	private RoundedPanel panelDecoraCen;
	private RoundedPanel panelDatoNombres;
	private RoundedPanel panelDatoApellidos;
	private RoundedPanel panelDatoIdPaciente;
	private RoundedPanel panelDatoFechaNacimiento;
	private RoundedPanel panelDatoHistoriClinica;
	private RoundedButton buttonBuscar;
	private ModeloBuscarHistoriaClinica modeloBuscarHistoriaClinica;
	private ControladorBuscarHistoriaClinica controladorBuscarHistoriaClinica;

	/**
	 * Create the panel.
	 */
	public PanelHistoriaClinicaPaciente() {
		modeloBuscarHistoriaClinica = new ModeloBuscarHistoriaClinica();
		controladorBuscarHistoriaClinica = new ControladorBuscarHistoriaClinica(modeloBuscarHistoriaClinica, this);

		setLayout(null); // Establecimiento de Absolute Layout.
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1192, 783);
		add(scrollPane);

		panelFondo = new JPanel();
		panelFondo.setBackground(new Color(255, 255, 255));
		panelFondo.setBounds(0, 0, 1192, 999);
		panelFondo.setLayout(null);
		scrollPane.setViewportView(panelFondo);

		// Creación de JPanel con propósito decorativo, ubicado en la parte superior del
		// panel:
		panelDecorativoSup = new JPanel();
		panelDecorativoSup.setBackground(new Color(2, 138, 102));
		panelDecorativoSup.setBounds(0, 47, 1203, 142);
		panelFondo.add(panelDecorativoSup);
		panelDecorativoSup.setLayout(null);

		// Creación de JLabel con el texto: "Historia Clínica":
		lblHistoriaClinica = new JLabel("Historia Clínica");
		lblHistoriaClinica.setForeground(new Color(240, 255, 240));
		lblHistoriaClinica.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblHistoriaClinica.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblHistoriaClinica);

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

		lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblNombres.setBounds(678, 362, 187, 32);
		panelFondo.add(lblNombres);

		// Creación de RoundedPanel Decorativo en la sección central del
		// PanelHistoriaClinicaPaciente:
		panelDecoraCen = new RoundedPanel(10);
		panelDecoraCen.setBackground(new Color(169, 169, 169));
		panelDecoraCen.setBounds(644, 307, 4, 600);
		panelFondo.add(panelDecoraCen);

		// Creación de RoundedPanel decorativo, con el propósito de exponer el dato
		// correspondiente a los Nombres del Paciente:
		panelDatoNombres = new RoundedPanel(50);
		panelDatoNombres.setLayout(null);
		panelDatoNombres.setBackground(new Color(241, 241, 241));
		panelDatoNombres.setBounds(678, 404, 458, 50);
		panelFondo.add(panelDatoNombres);

		// Creación de JLabel, con el propósito de exponer el dato
		// correspondiente a los Nombres del Paciente:
		lblDatoNombres = new JLabel("");
		lblDatoNombres.setFont(new Font("Montserrat", Font.PLAIN, 22));
		lblDatoNombres.setBounds(22, 0, 413, 50);
		panelDatoNombres.add(lblDatoNombres);

		// Creación de RoundedPanel decorativo, con el propósito de exponer el dato
		// correspondiente a los Apellidos del Paciente:
		panelDatoApellidos = new RoundedPanel(50);
		panelDatoApellidos.setLayout(null);
		panelDatoApellidos.setBackground(new Color(241, 241, 241));
		panelDatoApellidos.setBounds(678, 525, 458, 50);
		panelFondo.add(panelDatoApellidos);

		// Creación de JLabel, con el propósito de exponer el dato
		// correspondiente a los Apellidos del Paciente:
		lblDatoApellidos = new JLabel("");
		lblDatoApellidos.setFont(new Font("Montserrat", Font.PLAIN, 22));
		lblDatoApellidos.setBounds(21, 0, 413, 50);
		panelDatoApellidos.add(lblDatoApellidos);

		// Creación de JLabel con el texto "Apellidos:":
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblApellidos.setBounds(678, 483, 187, 32);
		panelFondo.add(lblApellidos);

		// Creación de RoundedPanel decorativo, con el propósito de exponer el dato
		// correspondiente a la Identificación del Paciente:
		panelDatoIdPaciente = new RoundedPanel(50);
		panelDatoIdPaciente.setLayout(null);
		panelDatoIdPaciente.setBackground(new Color(241, 241, 241));
		panelDatoIdPaciente.setBounds(678, 652, 458, 50);
		panelFondo.add(panelDatoIdPaciente);

		// Creación de JLabel, con el propósito de exponer el dato
		// correspondiente a la Identificación del Paciente:
		lblDatoIdPaciente = new JLabel("");
		lblDatoIdPaciente.setFont(new Font("Montserrat", Font.PLAIN, 22));
		lblDatoIdPaciente.setBounds(24, 0, 413, 50);
		panelDatoIdPaciente.add(lblDatoIdPaciente);

		// Creación de JLabel con el texto: "Identificación:":
		lblId = new JLabel("Identificación:");
		lblId.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblId.setBounds(678, 610, 187, 32);
		panelFondo.add(lblId);

		// Creación de JLabel con el texto: "Datos Personales":
		lblDatosPersonales = new JLabel("Datos Personales");
		lblDatosPersonales.setForeground(new Color(47, 79, 79));
		lblDatosPersonales.setFont(new Font("Montserrat", Font.BOLD, 30));
		lblDatosPersonales.setBounds(773, 307, 294, 32);
		panelFondo.add(lblDatosPersonales);

		// Creación de JLabel con el texto: "Historial Médico"
		lblHistorialMedico = new JLabel("Historial Médico");
		lblHistorialMedico.setForeground(new Color(47, 79, 79));
		lblHistorialMedico.setFont(new Font("Montserrat", Font.BOLD, 30));
		lblHistorialMedico.setBounds(158, 307, 267, 32);
		panelFondo.add(lblHistorialMedico);

		// Creación de JLabel con el texto "Fecha de Nacimiento:":
		lblFechaNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaNacimiento.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblFechaNacimiento.setBounds(678, 731, 294, 32);
		panelFondo.add(lblFechaNacimiento);

		// Creación de RoundedPanel decorativo, con el propósito de exponer el dato
		// correspondiente a la Fecha de Nacimiento del Paciente:
		panelDatoFechaNacimiento = new RoundedPanel(50);
		panelDatoFechaNacimiento.setLayout(null);
		panelDatoFechaNacimiento.setBackground(new Color(241, 241, 241));
		panelDatoFechaNacimiento.setBounds(678, 773, 458, 50);
		panelFondo.add(panelDatoFechaNacimiento);

		// Creación de JLabel, con el propósito de exponer el dato
		// correspondiente a la Fecha de Nacimiento del Paciente:
		lblDatoFechaNacimiento = new JLabel("");
		lblDatoFechaNacimiento.setFont(new Font("Montserrat", Font.PLAIN, 22));
		lblDatoFechaNacimiento.setBounds(24, 0, 413, 50);
		panelDatoFechaNacimiento.add(lblDatoFechaNacimiento);

		// Creación de JLabel con el texto "ID Historia Clínica:":
		lblIdHistoriaClinica = new JLabel("ID Historia Clínica:");
		lblIdHistoriaClinica.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblIdHistoriaClinica.setBounds(678, 852, 294, 52);
		panelFondo.add(lblIdHistoriaClinica);

		// Creación de RoundedPanel decorativo, con el propósito de exponer el dato
		// correspondiente al ID de Historia Clínica del Paciente:
		panelDatoHistoriClinica = new RoundedPanel(50);
		panelDatoHistoriClinica.setLayout(null);
		panelDatoHistoriClinica.setBackground(new Color(241, 241, 241));
		panelDatoHistoriClinica.setBounds(678, 894, 458, 50);
		panelFondo.add(panelDatoHistoriClinica);

		// Creación de JLabel, con el propósito de exponer el dato
		// correspondiente al ID de Historia Clínica Paciente:
		lblDatoHistoriaClinica = new JLabel("");
		lblDatoHistoriaClinica.setFont(new Font("Montserrat", Font.PLAIN, 22));
		lblDatoHistoriaClinica.setBounds(24, 0, 413, 50);
		panelDatoHistoriClinica.add(lblDatoHistoriaClinica);
		
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

		panelFondo.setPreferredSize(new Dimension(0, 1010));

	}

	// Getters:
	public String getCampoIdHistoriaClinica() {
		return campoIdHistoriaClinica.getText();
	}

	// Setters:
	public void setLblDatoNombres(String nombres) {
		lblDatoNombres.setText(nombres);
	}

	public void setLblDatoApellidos(String apellidos) {
		lblDatoApellidos.setText(apellidos);
	}

	public void setLblDatoIdPaciente(String tipoId, String id) {
		lblDatoIdPaciente.setText(tipoId + " " + id);
	}

	public void setLblDatoFechaNacimiento(String fecha) {
		lblDatoFechaNacimiento.setText(fecha);
	}

	public void setLblDatoHistoriaClinica(String idHistoriaClinica) {
		lblDatoHistoriaClinica.setText(idHistoriaClinica);
	}

	public void setCampoIdHistoriaClinica(String id) {
		campoIdHistoriaClinica.setText(id);
	}

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

}
