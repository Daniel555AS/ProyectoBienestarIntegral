package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import co.edu.upb.proyecto_bienestar_integral.view.componentes.*;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.*;
import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.controller.*;
import co.edu.upb.proyecto_bienestar_integral.estructuras.*;

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
	private DefaultTableModel modeloTabla;
	private JScrollPane tablaScrollPane;
	private JTable tablaHistorialMedico;
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
		panelDecoraCen.setBounds(644, 307, 4, 670);
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

		// Crear la tabla y su respectivo modelo:
		tablaHistorialMedico = new JTable();
		tablaHistorialMedico.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Fecha");
		modeloTabla.addColumn("Hora");
		modeloTabla.addColumn("Especialidad");
		modeloTabla.addColumn("Servicio");
		modeloTabla.addColumn("Motivo");
		modeloTabla.addColumn("Profesional");
		// Puedes agregar más columnas según sea necesario

		// Asignar el modelo a la tabla
		tablaHistorialMedico.setModel(modeloTabla);
		// Deshabilitar la edición de las celdas
		tablaHistorialMedico.setDefaultEditor(Object.class, null);
		// Permitir la selección de filas
		tablaHistorialMedico.setRowSelectionAllowed(true);
		// / Para seleccionar solo una fila a la vez
		tablaHistorialMedico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Agregar la tabla a un JScrollPane
		tablaScrollPane = new JScrollPane(tablaHistorialMedico);
		tablaScrollPane.setBounds(35, 349, 571, 580);
		tablaScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tablaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelFondo.add(tablaScrollPane);

		// LLENA TABLA

		// Centrar el contenido de las celdas
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER); // Centrar el contenido

		// Aplicar el renderizador centrado a cada columna de la tabla
		for (int ii = 0; ii < tablaHistorialMedico.getColumnCount(); ii++) {
			tablaHistorialMedico.getColumnModel().getColumn(ii).setCellRenderer(centerRenderer);
		}

		// Cambiar la fuente y el tamaño de la letra del contenido de la Tabla:
		Font font = new Font("Montserrat", Font.PLAIN, 17);
		tablaHistorialMedico.setFont(font);

		JTableHeader header = tablaHistorialMedico.getTableHeader();

		// Cambiar la fuente y el tamaño de la letra de la cabecera de la Tabla
		Font fontHeader = new Font("Montserrat", Font.PLAIN, 19);
		header.setFont(fontHeader);

		panelFondo.setPreferredSize(new Dimension(0, 1010));
		tablaHistorialMedico.setPreferredScrollableViewportSize(tablaHistorialMedico.getPreferredSize());

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

	public void llenarTabla(Lista<Cita> historialMedico) {
		Cita citaActual;
		for (int ii = historialMedico.getTamano() - 1; ii >= 0; ii--) {
			citaActual = historialMedico.obtenerElemento(ii);
			Object[] fila = { citaActual.getFechaFormateada(), citaActual.getHoraFormateada(),
					citaActual.getEspecialidad(), citaActual.getServicio(), citaActual.getMotivo(),
					citaActual.getProfesionalAsignado().getNombreEId() };
			modeloTabla.addRow(fila);
		}
		ajustarAnchoColumnas();
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

	// Método para ajustar el ancho de las columnas según el contenido más grande:
	private void ajustarAnchoColumnas() {
		// Iterar sobre todas las columnas de la tabla
		for (int i = 0; i < tablaHistorialMedico.getColumnCount(); i++) {
			TableColumn columna = tablaHistorialMedico.getColumnModel().getColumn(i);
			int ancho = 0;

			// Obtener el ancho máximo del encabezado de la columna
			TableCellRenderer renderer = columna.getHeaderRenderer();
			if (renderer == null) {
				renderer = tablaHistorialMedico.getTableHeader().getDefaultRenderer();
			}
			Component comp = renderer.getTableCellRendererComponent(tablaHistorialMedico, columna.getHeaderValue(),
					false, false, 0, 0);
			ancho = comp.getPreferredSize().width;

			// Iterar sobre todas las filas para obtener el ancho máximo del contenido de la
			// columna
			for (int j = 0; j < tablaHistorialMedico.getRowCount(); j++) {
				TableCellRenderer cellRenderer = tablaHistorialMedico.getCellRenderer(j, i);
				Component c = tablaHistorialMedico.prepareRenderer(cellRenderer, j, i);
				int width = c.getPreferredSize().width + tablaHistorialMedico.getIntercellSpacing().width;
				ancho = Math.max(ancho, width);
			}

			// Establecer el ancho de la columna al ancho máximo calculado + 10 unidades de
			// espacio extra
			columna.setPreferredWidth(ancho + 15);
		}
	}

}
