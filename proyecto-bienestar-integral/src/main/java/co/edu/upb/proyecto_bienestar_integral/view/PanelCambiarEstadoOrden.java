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
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.Orden;
import co.edu.upb.proyecto_bienestar_integral.controller.*;

public class PanelCambiarEstadoOrden extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelFondo;
	private JPanel panelDecorativoSup;
	private JLabel lblAutorizacionExames;
	private RoundedPanel panelIDHistoriaClinica;
	private JTextField campoIdHistoriaClinica;
	private JLabel lblidHC;
	private RoundedButton buttonRegresar;
	private JLabel lblPaciente;
	private JLabel lblEspecialidadExamen;
	private JScrollPane scrollPaneGeneral;
	private JLabel lblProfesionalAsignado;
	private JLabel lblIdOrden;
	private JLabel lblIdHistoriaClinica;
	private JLabel lblDatoEspecialidadYExamen;
	private JLabel lblDatoIdOrden;
	private JLabel lblDatoIdHistoriaClinica;
	private JLabel lblDatoNombrePaciente;
	private JLabel lblDatoFechaYHora;
	private JLabel lblDatoProfesionalAsignado;
	private JLabel lblPrecio;
	private JLabel lblDatoPrecio;
	private JLabel lblFechaYHora;
	private RoundedButton buttonAutorizar;
	private Orden ordenActual;
	private ModeloAutorizarExamen modeloAutorizarExamen;
	private ControladorAutorizarExamen controladorAutorizarExamen;

	/**
	 * Create the panel.
	 */
	public PanelCambiarEstadoOrden(Orden ordenActual) {
		this.ordenActual = ordenActual;
		modeloAutorizarExamen = new ModeloAutorizarExamen();
		controladorAutorizarExamen = new ControladorAutorizarExamen(modeloAutorizarExamen, this);

		setLayout(null); // Establecimiento Absolute Layout
		// Creación de JScrollPane para alamacenar al panelFondo y, por lo tanto,
		// observar los elementos que exceden el tamaño estándar de la pantalla:
		scrollPaneGeneral = new JScrollPane();
		scrollPaneGeneral.setBounds(0, 0, 1192, 783);
		add(scrollPaneGeneral);

		// Creación de JPanel como fondo para PanelAutorizarExamen:
		panelFondo = new JPanel();
		panelFondo.setBackground(new Color(255, 255, 255));
		panelFondo.setBounds(0, 0, 1203, 783);
		panelFondo.setLayout(null);
		scrollPaneGeneral.setViewportView(panelFondo);

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

		// Creación de JLabel con el texto: "ID HC:":
		lblidHC = new JLabel("ID HC:");
		lblidHC.setFont(new Font("Montserrat", Font.BOLD, 30));
		lblidHC.setBounds(35, 228, 109, 24);
		panelFondo.add(lblidHC);

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

		// Creación de JLabel con el el texto: "Paciente:"
		lblPaciente = new JLabel("Paciente:");
		lblPaciente.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblPaciente.setBounds(35, 320, 126, 43);
		panelFondo.add(lblPaciente);

		// Creación de JLabel con el texto: "ID Historia Clínica:":
		lblIdHistoriaClinica = new JLabel("ID Historia Clínica:");
		lblIdHistoriaClinica.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblIdHistoriaClinica.setBounds(35, 400, 229, 43);
		panelFondo.add(lblIdHistoriaClinica);

		// Creación de JLabel con el texto: "ID Orden:":
		lblIdOrden = new JLabel("ID Orden:");
		lblIdOrden.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblIdOrden.setBounds(35, 480, 126, 43);
		panelFondo.add(lblIdOrden);

		// Creación de JLabel con el texto: "Especialidad - Examen:":
		lblEspecialidadExamen = new JLabel("Especialidad - Examen:");
		lblEspecialidadExamen.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblEspecialidadExamen.setBounds(35, 560, 293, 43);
		panelFondo.add(lblEspecialidadExamen);

		// Creación de JLabel con el texto: "Profesional Asignado:":
		lblProfesionalAsignado = new JLabel("Profesional Asignado:");
		lblProfesionalAsignado.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblProfesionalAsignado.setBounds(35, 644, 293, 43);
		panelFondo.add(lblProfesionalAsignado);

		// Creación de JLabel con el texto: "Fecha y Hora:":
		lblFechaYHora = new JLabel("Fecha y Hora:");
		lblFechaYHora.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblFechaYHora.setBounds(35, 728, 293, 43);
		panelFondo.add(lblFechaYHora);

		// Creación de JLabel con el texto: "Precio:":
		lblPrecio = new JLabel("Costo:");
		lblPrecio.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblPrecio.setBounds(35, 812, 293, 43);
		panelFondo.add(lblPrecio);

		// Creación de JLabel con el texto correspondiente a la Especialidad y Examen de
		// la Orden de la Cima de la Pila de órdenes, según el Paciente:
		lblDatoEspecialidadYExamen = new JLabel(ordenActual.getEspecialidad() + " - " + ordenActual.getTipoExamen());
		lblDatoEspecialidadYExamen.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoEspecialidadYExamen.setBounds(383, 560, 704, 43);
		panelFondo.add(lblDatoEspecialidadYExamen);

		// Creación de JLabel con el texto correspondiente al ID de la Orden Médica
		// de la Orden de la Cima de la Pila de órdenes, según el Paciente:
		lblDatoIdOrden = new JLabel(ordenActual.getIdentificador());
		lblDatoIdOrden.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoIdOrden.setBounds(383, 480, 704, 43);
		panelFondo.add(lblDatoIdOrden);

		// Creación de JLabel con el texto correspondiente al ID de la Historia Clínica
		// del Paciente asoaciado a la Orden de la Cima de la Pila de órdenes, según el
		// Paciente:
		lblDatoIdHistoriaClinica = new JLabel(ordenActual.getIdPaciente());
		lblDatoIdHistoriaClinica.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoIdHistoriaClinica.setBounds(383, 400, 704, 43);
		panelFondo.add(lblDatoIdHistoriaClinica);

		// Creación de JLabel con el texto correspondiente al Nombre Completo
		// del Paciente asoaciado a la Orden de la Cima de la Pila de órdenes, según el
		// Paciente:
		lblDatoNombrePaciente = new JLabel(controladorAutorizarExamen.obtenerNombreCompletoPaciente(ordenActual));
		lblDatoNombrePaciente.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoNombrePaciente.setBounds(383, 320, 704, 43);
		panelFondo.add(lblDatoNombrePaciente);

		// Creación de JLabel con el texto correspondiente al Nombre Completo
		// e Identificación del Profesional Asignado, asoaciado a la Orden de la Cima de
		// la Pila de
		// órdenes, según el Paciente:
		lblDatoProfesionalAsignado = new JLabel(ordenActual.getProfesionalAsignado().getNombreCompleto() + " - CC "
				+ ordenActual.getProfesionalAsignado().getIdentificacion());
		lblDatoProfesionalAsignado.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoProfesionalAsignado.setBounds(383, 644, 704, 43);
		panelFondo.add(lblDatoProfesionalAsignado);

		// Creación de JLabel con el dato correspondiente a la Fecha
		// y Hora, asoaciadas a la Orden de la Cima de la Pila de
		// órdenes, según el Paciente:
		lblDatoFechaYHora = new JLabel(ordenActual.getFechaYHoraFormateada());
		lblDatoFechaYHora.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoFechaYHora.setBounds(383, 728, 704, 43);
		panelFondo.add(lblDatoFechaYHora);

		// Creación de JLabel con el dato correspondiente
		// al costo asoaciado a la Orden de la Cima de la Pila de
		// órdenes, según el Paciente:
		lblDatoPrecio = new JLabel("$ " + ordenActual.getCosto());
		lblDatoPrecio.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoPrecio.setBounds(383, 812, 704, 43);
		panelFondo.add(lblDatoPrecio);

		// Creación de RoundedButton para la ejecución de procesos en torno a la
		// autorización de órdenes médicas:
		buttonAutorizar = new RoundedButton("Autorizar", new Color(23, 174, 191), new Color(0, 139, 139), 1000, 60);
		buttonAutorizar.setText("Autorizar");
		buttonAutorizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorAutorizarExamen.autorizacionOrden(ordenActual);
			}
		});
		buttonAutorizar.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonAutorizar.setForeground(new Color(255, 255, 255));
		buttonAutorizar.setBackground(new Color(23, 174, 191));
		buttonAutorizar.setBounds(400, 930, 320, 57);
		buttonAutorizar.setFocusable(false);
		panelFondo.add(buttonAutorizar);

		panelFondo.setPreferredSize(new Dimension(0, 1050));

		// Creación de RoundedPanel decorativo para el ingreso del ID de Historia
		// Clínica de un Paciente:
		panelIDHistoriaClinica = new RoundedPanel(50);
		panelIDHistoriaClinica.setBackground(new Color(241, 241, 241));
		panelIDHistoriaClinica.setBounds(158, 198, 835, 74);
		panelFondo.add(panelIDHistoriaClinica);
		panelIDHistoriaClinica.setLayout(null);

		// Creación de JTextField como campo para ingresar los apellidos del paciente:
		campoIdHistoriaClinica = new JTextField("");
		campoIdHistoriaClinica.setFont(new Font("Montserrat", Font.PLAIN, 25));
		campoIdHistoriaClinica.setColumns(10);
		campoIdHistoriaClinica.setBorder(null);
		campoIdHistoriaClinica.setBackground(null);
		campoIdHistoriaClinica.setBounds(21, 0, 804, 74);
		panelIDHistoriaClinica.add(campoIdHistoriaClinica);
	} // public PanelCambiarEstadoOrden(Orden ordenActual)

	// Métodos Getters:
	public Orden getOrdenActual() {
		return ordenActual;
	}

	// Método para obtener la cadena de texto ingresada en campoIdHistoriaClinica:
	public String getCampoIdHistoriaClinica() {
		return campoIdHistoriaClinica.getText();
	}

	// Métodos Setters:
	public void setCampoIdHistoriaClinica(String id) {
		campoIdHistoriaClinica.setText(id);
	}

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

} // public class PanelCambiarEstadoOrden extends JPanel
