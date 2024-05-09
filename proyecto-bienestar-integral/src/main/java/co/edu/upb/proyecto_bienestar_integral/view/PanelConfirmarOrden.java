package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.Orden;
import co.edu.upb.proyecto_bienestar_integral.view.componentes.RoundedButton;
import co.edu.upb.proyecto_bienestar_integral.controller.*;
import javax.swing.JTextArea;

public class PanelConfirmarOrden extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelFondo;
	private JPanel panelDecorativoSup;
	private JLabel lblConfirmarOrdenMedica;
	private JLabel lblPaciente;
	private JLabel lblIdHistoriaClinica;
	private JLabel lblIdOrden;
	private JLabel lblEspecialidad;
	private JLabel lblDescripcion;
	private JLabel lblProfesionalAsignado;
	private JLabel lblFechaYHora;
	private JLabel lblCosto;
	private JLabel lblDatoPaciente;
	private JLabel lblDatoIdHistoriaClinica;
	private JLabel lblDatoIdOrden;
	private JLabel lblDatoEspecialidadYExamen;
	private JLabel lblDatoProfesionalAsignado;
	private JLabel lblDatoFechaYHora;
	private JLabel lblDatoCosto;
	private JLabel lblComentario;
	private JScrollPane scrollPaneGeneral;
	private Orden ordenActual;
	private JTextArea textAreaDescripcion;
	private JTextArea textAreaComentario;
	private JScrollPane innerScrollPaneDescripcion;
	private JScrollPane innerScrollPaneComentario;
	private RoundedButton buttonConfirmar;
	private ModeloConfirmarOrden modeloConfirmarOrden;
	private ControladorConfirmacionOrden controladorConfirmacionOrden;

	/**
	 * Create the panel.
	 */
	public PanelConfirmarOrden(Orden ordenActual) {
		
		this.ordenActual = ordenActual;
		modeloConfirmarOrden = new ModeloConfirmarOrden();
		controladorConfirmacionOrden = new ControladorConfirmacionOrden(modeloConfirmarOrden, this);

		setLayout(null);
		scrollPaneGeneral = new JScrollPane();
		scrollPaneGeneral.setBounds(0, 0, 1192, 783);
		add(scrollPaneGeneral);

		// Creación de JPanel como fondo para PanelConfirmarOrden:
		panelFondo = new JPanel();
		panelFondo.setBackground(new Color(255, 255, 255));
		panelFondo.setBounds(0, 0, 1192, 1040);
		panelFondo.setLayout(null);
		scrollPaneGeneral.setViewportView(panelFondo);

		// Creación de JPanel con propósito decorativo, ubicado en la parte superior del
		// panel:
		panelDecorativoSup = new JPanel();
		panelDecorativoSup.setBackground(new Color(2, 138, 102));
		panelDecorativoSup.setBounds(0, 47, 1203, 142);
		panelFondo.add(panelDecorativoSup);
		panelDecorativoSup.setLayout(null);

		// Creación de JLabel con el texto: "Confirmar Orden Médica":
		lblConfirmarOrdenMedica = new JLabel("Confirmar Orden Médica");
		lblConfirmarOrdenMedica.setForeground(new Color(240, 255, 240));
		lblConfirmarOrdenMedica.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblConfirmarOrdenMedica.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblConfirmarOrdenMedica);

		// Creación de JLabel con el el texto: "Paciente:"
		lblPaciente = new JLabel("Paciente:");
		lblPaciente.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblPaciente.setBounds(39, 210, 248, 43);
		panelFondo.add(lblPaciente);

		// Creación de JLabel con el texto: "ID Historia Clínica:":
		lblIdHistoriaClinica = new JLabel("ID Historia Clínica:");
		lblIdHistoriaClinica.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblIdHistoriaClinica.setBounds(39, 290, 248, 43);
		panelFondo.add(lblIdHistoriaClinica);

		// Creación de JLabel con el texto: "ID Orden:":
		lblIdOrden = new JLabel("ID Orden:");
		lblIdOrden.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblIdOrden.setBounds(39, 370, 248, 43);
		panelFondo.add(lblIdOrden);

		// Creación de JLabel con el texto: "Especialidad:":
		lblEspecialidad = new JLabel("Especialidad - Examen:");
		lblEspecialidad.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblEspecialidad.setBounds(39, 450, 299, 43);
		panelFondo.add(lblEspecialidad);

		// Creación de JLabel con el texto: "Descripción:":
		lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblDescripcion.setBounds(39, 770, 248, 43);
		panelFondo.add(lblDescripcion);

		// Creación de JLabel con el texto: "Comentario:":
		lblComentario = new JLabel("Comentario:");
		lblComentario.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblComentario.setBounds(39, 999, 248, 43);
		panelFondo.add(lblComentario);

		// Creación de JLabel con el texto: "Profesional Asignado:"
		lblProfesionalAsignado = new JLabel("Profesional Asignado:");
		lblProfesionalAsignado.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblProfesionalAsignado.setBounds(39, 530, 299, 43);
		panelFondo.add(lblProfesionalAsignado);

		lblFechaYHora = new JLabel("Fecha y Hora:");
		lblFechaYHora.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblFechaYHora.setBounds(39, 610, 217, 43);
		panelFondo.add(lblFechaYHora);

		lblCosto = new JLabel("Costo:");
		lblCosto.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblCosto.setBounds(39, 690, 217, 43);
		panelFondo.add(lblCosto);

		lblDatoPaciente = new JLabel(controladorConfirmacionOrden.obtenerNombreCompletoPaciente());
		lblDatoPaciente.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoPaciente.setBounds(354, 210, 802, 43);
		panelFondo.add(lblDatoPaciente);

		lblDatoIdHistoriaClinica = new JLabel(ordenActual.getIdPaciente());
		lblDatoIdHistoriaClinica.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoIdHistoriaClinica.setBounds(354, 290, 802, 43);
		panelFondo.add(lblDatoIdHistoriaClinica);

		lblDatoIdOrden = new JLabel(ordenActual.getIdentificador());
		lblDatoIdOrden.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoIdOrden.setBounds(354, 370, 802, 43);
		panelFondo.add(lblDatoIdOrden);

		lblDatoEspecialidadYExamen = new JLabel(ordenActual.getEspecialidad() + " - " + ordenActual.getTipoExamen());
		lblDatoEspecialidadYExamen.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoEspecialidadYExamen.setBounds(354, 450, 802, 43);
		panelFondo.add(lblDatoEspecialidadYExamen);

		lblDatoProfesionalAsignado = new JLabel(ordenActual.getProfesionalAsignado().getNombreCompleto());
		lblDatoProfesionalAsignado.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoProfesionalAsignado.setBounds(354, 530, 802, 43);
		panelFondo.add(lblDatoProfesionalAsignado);

		lblDatoFechaYHora = new JLabel(ordenActual.getFechaFormateada() + " - " + ordenActual.getHoraFormateada());
		lblDatoFechaYHora.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoFechaYHora.setBounds(354, 610, 802, 43);
		panelFondo.add(lblDatoFechaYHora);

		lblDatoCosto = new JLabel(String.valueOf("$ " + ordenActual.getCosto()));
		lblDatoCosto.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoCosto.setBounds(354, 690, 802, 43);
		panelFondo.add(lblDatoCosto);

		// Creación de un JTextArea, sin la posibilidad de ser modificado, dentro de un
		// JSCrollPane, para asignar la descripción del examen correspondiente a la
		// orden:
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setFont(new Font("Montserrat", Font.PLAIN, 20));
		textAreaDescripcion.setBackground(new Color(241, 241, 241));
		// Configurar el JTextArea para que el texto se ajuste automáticamente al ancho
		// del área de visualización:
		textAreaDescripcion.setLineWrap(true);
		textAreaDescripcion.setWrapStyleWord(true);
		textAreaDescripcion.setText(ordenActual.getDescripcion());
		textAreaDescripcion.setEditable(false);
		innerScrollPaneDescripcion = new JScrollPane(textAreaDescripcion);
		innerScrollPaneDescripcion.setBounds(354, 770, 802, 180);
		panelFondo.add(innerScrollPaneDescripcion);

		// Creación de un JTextArea, sin la posibilidad de ser modificado, dentro de un
		// JScrollPane,
		// para asignar el comentario, ingresado anteriormente, correspondiente a la
		// orden médica actual:
		textAreaComentario = new JTextArea();
		textAreaComentario.setFont(new Font("Montserrat", Font.PLAIN, 20));
		textAreaComentario.setBackground(new Color(241, 241, 241));
		// Configurar el JTextArea para que el texto se ajuste automáticamente al ancho
		// del área de visualización:
		textAreaComentario.setLineWrap(true);
		textAreaComentario.setWrapStyleWord(true);
		textAreaComentario.setText(ordenActual.getComentario());
		textAreaComentario.setEditable(false);
		innerScrollPaneComentario = new JScrollPane(textAreaComentario);
		innerScrollPaneComentario.setBounds(354, 999, 802, 180);
		panelFondo.add(innerScrollPaneComentario);

		buttonConfirmar = new RoundedButton("Confirmar", new Color(23, 174, 191), new Color(0, 139, 139),
				1000, 60);
		buttonConfirmar.setText("Confirmar");
		buttonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorConfirmacionOrden.guardarOrden();
			}
		});
		buttonConfirmar.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonConfirmar.setForeground(new Color(255, 255, 255));
		buttonConfirmar.setBackground(new Color(23, 174, 191));
		buttonConfirmar.setBounds(400, 1240, 320, 57);
		buttonConfirmar.setFocusable(false);
		panelFondo.add(buttonConfirmar);

		panelFondo.setPreferredSize(new Dimension(0, 1350));

	} // public PanelConfirmarOrden(Orden ordenActual)

	// Métodos Getters:
	public Orden getOrdenActual() {
		return ordenActual;
	}

} // public class PanelConfirmarOrden extends JPanel
