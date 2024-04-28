package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.controller.*;
import co.edu.upb.proyecto_bienestar_integral.estructuras.ListaDoblementeEnlazada;
import javax.swing.SwingConstants;

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
	private JLabel lblDatoDescripcion;
	private Orden ordenActual;
	private JScrollBar scrollBar;
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
		// Creación de JPanel para fondo de PanelGestionPacientes:
		panelFondo = new JPanel();
		panelFondo.setBackground(new Color(255, 255, 255));
		panelFondo.setBounds(0, 0, 1203, 999);
		add(panelFondo);
		panelFondo.setLayout(null);
		
		
		scrollBar = new JScrollBar();
		scrollBar.setMaximum(200);
		scrollBar.setBounds(1170, 188, 23, 790);
		panelFondo.add(scrollBar);
		
        // Agrega AdjustmentListener al JScrollBar
        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                int scrollValue = e.getValue();
                // Desplaza el panel verticalmente según el valor del JScrollBar
                panelFondo.setLocation(panelFondo.getX(), -scrollValue);
            }
        });

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
		
		lblDatoDescripcion = new JLabel("");
		lblDatoDescripcion.setVerticalAlignment(SwingConstants.TOP);
		lblDatoDescripcion.setFont(new Font("Montserrat", Font.PLAIN, 23));
		lblDatoDescripcion.setBounds(354, 770, 802, 200);
		panelFondo.add(lblDatoDescripcion);
		ajustarTamanioFuenteConSaltos(ordenActual.getDescripcion(), lblDatoDescripcion);

	} // public PanelConfirmarOrden(Orden ordenActual)
	
	// Métodos Getters:
	public Orden getOrdenActual() {
		return ordenActual;
	}
	
    private void ajustarTamanioFuenteConSaltos(String texto, JLabel label) {
        ListaDoblementeEnlazada<String> lineas = dividirTextoEnLineas(texto, label);
        StringBuilder textoAjustado = new StringBuilder();

        for (int i = 0; i < lineas.getTamano(); i++) {
            textoAjustado.append(lineas.obtenerElemento(i)).append("<br>");
        }

        label.setText("<html>" + textoAjustado.toString() + "</html>");
    }

    private ListaDoblementeEnlazada<String> dividirTextoEnLineas(String texto, JLabel label) {
        FontMetrics metrics = label.getFontMetrics(label.getFont());
        int width = label.getWidth();

        ListaDoblementeEnlazada<String> lineas = new ListaDoblementeEnlazada<>();
        StringBuilder currentLine = new StringBuilder();
        String[] words = texto.split("\\s+");

        for (String word : words) {
            if (metrics.stringWidth(currentLine.toString() + word) <= width) {
                currentLine.append(word).append(" ");
            } else {
                lineas.agregarAlFinal(currentLine.toString());
                currentLine = new StringBuilder(word + " ");
            }
        }

        if (currentLine.length() > 0) {
            lineas.agregarAlFinal(currentLine.toString());
        }

        return lineas;
    }
	
	
} // public class PanelConfirmarOrden extends JPanel
