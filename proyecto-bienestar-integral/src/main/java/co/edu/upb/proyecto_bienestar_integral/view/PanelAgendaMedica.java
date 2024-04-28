package co.edu.upb.proyecto_bienestar_integral.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import co.edu.upb.proyecto_bienestar_integral.estructuras.*;
import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.view.componentes.RoundedButton;
import co.edu.upb.proyecto_bienestar_integral.controller.*;

public class PanelAgendaMedica extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelDecorativoSup;
	private JPanel panelFondo;
	private JLabel lblRegistrarOrdenMedica;
	private JTable tablaAgendaMedica;
	private DefaultTableModel modeloTabla;
	private Orden ordenActual;
	private ModeloAgendaMedica modeloAgendaMedica;
	private ControladorAgendaMedica controladorAgendaMedica;
	private RoundedButton buttonContinuar;

	/**
	 * Create the panel.
	 */
	public PanelAgendaMedica(Orden orden) {
		ordenActual = orden;
		modeloAgendaMedica = new ModeloAgendaMedica();
		controladorAgendaMedica = new ControladorAgendaMedica(modeloAgendaMedica, this);

		setLayout(null);
		panelFondo = new JPanel();
		panelFondo.setBackground(Color.WHITE);
		panelFondo.setBounds(0, 0, 1203, 783);
		add(panelFondo);
		panelFondo.setLayout(null);

		panelDecorativoSup = new JPanel();
		panelDecorativoSup.setBackground(new Color(2, 138, 102));
		panelDecorativoSup.setBounds(0, 47, 1203, 142);
		panelFondo.add(panelDecorativoSup);
		panelFondo.setLayout(null);
		panelDecorativoSup.setLayout(null);

		lblRegistrarOrdenMedica = new JLabel("Agenda Médica:");
		lblRegistrarOrdenMedica.setForeground(new Color(240, 255, 240));
		lblRegistrarOrdenMedica.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblRegistrarOrdenMedica.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblRegistrarOrdenMedica);

		// Crear la tabla y su respectivo modelo:
		tablaAgendaMedica = new JTable();
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Hora");
		modeloTabla.addColumn("ID - Orden");
		modeloTabla.addColumn("Tipo Examen");
		modeloTabla.addColumn("ID - Profesional Asignado");
		// Puedes agregar más columnas según sea necesario

		// Asignar el modelo a la tabla
		tablaAgendaMedica.setModel(modeloTabla);

		// Deshabilitar la edición de las celdas
		tablaAgendaMedica.setDefaultEditor(Object.class, null);

		// Permitir la selección de filas
		tablaAgendaMedica.setRowSelectionAllowed(true);
		tablaAgendaMedica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Para seleccionar solo una fila a la
																					// vez

		// Agregar la tabla a un JScrollPane
		JScrollPane scrollPane = new JScrollPane(tablaAgendaMedica);
		scrollPane.setBounds(50, 235, 1100, 346);
		panelFondo.add(scrollPane);

		llenarTabla();

		// Centrar el contenido de las celdas
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER); // Centrar el contenido

		// Aplicar el renderizador centrado a cada columna de la tabla
		for (int ii = 0; ii < tablaAgendaMedica.getColumnCount(); ii++) {
			tablaAgendaMedica.getColumnModel().getColumn(ii).setCellRenderer(centerRenderer);
		}

		// Cambiar la fuente y el tamaño de la letra del contenido de la Tabla:
		Font font = new Font("Montserrat", Font.PLAIN, 17);
		tablaAgendaMedica.setFont(font);

		JTableHeader header = tablaAgendaMedica.getTableHeader();

		// Cambiar la fuente y el tamaño de la letra de la cabecera de la Tabla
		Font fontHeader = new Font("Montserrat", Font.PLAIN, 19);
		header.setFont(fontHeader);

		// Creación de RoundedButton para la continuación con el proceso de registro de
		// Orden Médica:
		buttonContinuar = new RoundedButton("Continuar", new Color(23, 174, 191), new Color(0, 139, 139), 1000, 60);
		buttonContinuar.setText("Continuar");
		buttonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		buttonContinuar.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonContinuar.setForeground(new Color(255, 255, 255));
		buttonContinuar.setBackground(new Color(23, 174, 191));
		buttonContinuar.setBounds(920, 716, 259, 57);
		buttonContinuar.setFocusable(false);
		panelFondo.add(buttonContinuar);

	}

	public Orden getOrdenActual() {
		return ordenActual;
	}

	private void llenarTabla() {
		// Limpiar la tabla antes de llenarla
		modeloTabla.setRowCount(0);
		// Obtener el modelo de agenda médica
		ModeloAgendaMedica modeloAgenda = new ModeloAgendaMedica();
		Lista<Orden> ordenesFiltradas = controladorAgendaMedica.obtenerOrdenesFiltradas();
		// Llenar la tabla con los datos de las órdenes
		LocalTime horaActual = LocalTime.of(8, 0); // Hora de inicio
		LocalTime horaFin = LocalTime.of(19, 0); // Hora de fin
		while (horaActual.isBefore(horaFin)) {
			String hora = horaActual.toString();
			String idOrden = "-";
			String tipoExamen = "-";
			String idProfesional = "-";

			// Verificar si hay una orden en esta hora
			for (int i = 0; i < ordenesFiltradas.getTamano(); i++) {
				Orden orden = ordenesFiltradas.obtenerElemento(i);
				if (orden.getHora().equals(Time.valueOf(horaActual))) {
					idOrden = orden.getIdentificador();
					tipoExamen = orden.getTipoExamen();
					idProfesional = orden.getProfesionalAsignado().getIdentificacion();
					break;
				}
			}
			// Agregar fila a la tabla:
			modeloTabla.addRow(new Object[] { hora, idOrden, tipoExamen, idProfesional });
			// Incrementar 30 minutos para la próxima hora:
			horaActual = horaActual.plusMinutes(30);
		}
	} // public void llenarTabla(LocalDate fecha, String especialidad)

	public Time getHoraFilaSeleccionada() {
		// Obtener la fila seleccionada
		int filaSeleccionada = tablaAgendaMedica.getSelectedRow();
		Time horaTime = null;
		if (filaSeleccionada != -1) { // Si hay una fila seleccionada
			// Obtener la hora de la fila seleccionada
			String idOrden = (String) tablaAgendaMedica.getValueAt(filaSeleccionada, 1); // Columna de ID - Orden
			if (idOrden != "-") {
				return horaTime;
			}
			String horaString = (String) tablaAgendaMedica.getValueAt(filaSeleccionada, 0); // Columna de la hora
			LocalTime horaLocal = LocalTime.parse(horaString);

			// Convertir la horaLocal a Time
			horaTime = Time.valueOf(horaLocal);
		}
		return horaTime;
	}

} // public class PanelAgendaMedica extends JPanel
