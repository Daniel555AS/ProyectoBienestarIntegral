package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import co.edu.upb.proyecto_bienestar_integral.controller.*;
import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.Cita;
import co.edu.upb.proyecto_bienestar_integral.view.componentes.RoundedButton;

public class PanelConfirmacionCitaValoracionControl extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Cita cita;
	private JScrollPane scrollPaneGeneral;
	private JPanel panelFondo;
	private JPanel panelDecorativoSup;
	private JLabel lblConfirmarOrdenMedica;
	private JLabel lblIdCita;
	private JLabel lblIdHistoriaClinica;
	private JLabel lblEspecialidad;
	private JLabel lblMotivo;
	private JLabel lblProfesional;
	private JLabel lblCosto;
	private JLabel lblComentario;
	private JLabel lblDatoIdCita;
	private JLabel lblDatoIdHistoriaClinica;
	private JLabel lblDatoEspecialidad;
	private JLabel lblDatoMotivo;
	private JLabel lblDatoProfesionalAsignado;
	private JLabel lblDatoCosto;
	private JTextArea textAreaComentario;
	private JScrollPane innerScrollPaneComentario;
	private RoundedButton buttonConfirmar;
	private ModeloConfirmacionCitaValoracionControl modeloConfirmacionCitaValoracionControl;
	private ControladorConfirmarCitaValoracionControl controladorConfirmarCitaValoracionControl;

	/**
	 * Create the panel.
	 */
	public PanelConfirmacionCitaValoracionControl(Cita cita) {
		this.modeloConfirmacionCitaValoracionControl = new ModeloConfirmacionCitaValoracionControl();
		this.controladorConfirmarCitaValoracionControl = new ControladorConfirmarCitaValoracionControl(
				modeloConfirmacionCitaValoracionControl, this);

		this.cita = cita;
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
		lblConfirmarOrdenMedica = new JLabel("Confirmar Cita: " + cita.getMotivo());
		lblConfirmarOrdenMedica.setForeground(new Color(240, 255, 240));
		lblConfirmarOrdenMedica.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblConfirmarOrdenMedica.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblConfirmarOrdenMedica);

		// Creación de JLabel con el el texto: "ID Cita:"
		lblIdCita = new JLabel("ID Cita:");
		lblIdCita.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblIdCita.setBounds(39, 210, 248, 43);
		panelFondo.add(lblIdCita);

		// Creación de JLabel con el texto: "ID Historia Clínica:":
		lblIdHistoriaClinica = new JLabel("ID Historia Clínica:");
		lblIdHistoriaClinica.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblIdHistoriaClinica.setBounds(39, 290, 248, 43);
		panelFondo.add(lblIdHistoriaClinica);

		// Creación de JLabel con el texto: "Especialidad:":
		lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblEspecialidad.setBounds(39, 370, 299, 43);
		panelFondo.add(lblEspecialidad);

		// Creación de JLabel con el texto: "Motivo:":
		lblMotivo = new JLabel("Motivo:");
		lblMotivo.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblMotivo.setBounds(39, 450, 248, 43);
		panelFondo.add(lblMotivo);

		// Creación de JLabel con el texto: "Profesional:":
		lblProfesional = new JLabel("Profesional:");
		lblProfesional.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblProfesional.setBounds(39, 530, 248, 43);
		panelFondo.add(lblProfesional);

		// Creación de JLabel con el texto: "Costo:":
		lblCosto = new JLabel("Costo:");
		lblCosto.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblCosto.setBounds(39, 610, 248, 43);
		panelFondo.add(lblCosto);

		// Creación de JLabel con el texto: "Profesional:":
		lblComentario = new JLabel("Comentario:");
		lblComentario.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblComentario.setBounds(39, 690, 248, 43);
		panelFondo.add(lblComentario);

		lblDatoIdCita = new JLabel(cita.getIdentificador());
		lblDatoIdCita.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoIdCita.setBounds(354, 210, 802, 43);
		panelFondo.add(lblDatoIdCita);

		lblDatoIdHistoriaClinica = new JLabel(cita.getIdHistoriaClinicaPaciente());
		lblDatoIdHistoriaClinica.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoIdHistoriaClinica.setBounds(354, 290, 802, 43);
		panelFondo.add(lblDatoIdHistoriaClinica);

		lblDatoEspecialidad = new JLabel(cita.getEspecialidad());
		lblDatoEspecialidad.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoEspecialidad.setBounds(354, 370, 802, 43);
		panelFondo.add(lblDatoEspecialidad);

		lblDatoMotivo = new JLabel(cita.getMotivo());
		lblDatoMotivo.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoMotivo.setBounds(354, 450, 802, 43);
		panelFondo.add(lblDatoMotivo);

		lblDatoProfesionalAsignado = new JLabel(cita.getProfesionalAsignado().getNombreCompleto());
		lblDatoProfesionalAsignado.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoProfesionalAsignado.setBounds(354, 530, 802, 43);
		panelFondo.add(lblDatoProfesionalAsignado);

		lblDatoCosto = new JLabel("$" + cita.getCosto());
		lblDatoCosto.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoCosto.setBounds(354, 610, 802, 43);
		panelFondo.add(lblDatoCosto);

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
		textAreaComentario.setText(cita.getComentario());
		textAreaComentario.setEditable(false);
		innerScrollPaneComentario = new JScrollPane(textAreaComentario);
		innerScrollPaneComentario.setBounds(354, 690, 802, 180);
		panelFondo.add(innerScrollPaneComentario);

		buttonConfirmar = new RoundedButton("Confirmar", new Color(23, 174, 191), new Color(0, 139, 139), 1000, 60);
		buttonConfirmar.setText("Confirmar");
		buttonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorConfirmarCitaValoracionControl.registrarCita();
			}
		});
		buttonConfirmar.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonConfirmar.setForeground(new Color(255, 255, 255));
		buttonConfirmar.setBackground(new Color(23, 174, 191));
		buttonConfirmar.setBounds(400, 948, 320, 57);
		buttonConfirmar.setFocusable(false);
		panelFondo.add(buttonConfirmar);

		panelFondo.setPreferredSize(new Dimension(0, 1040));

	}

	public Cita getCita() {
		return cita;
	}

}
