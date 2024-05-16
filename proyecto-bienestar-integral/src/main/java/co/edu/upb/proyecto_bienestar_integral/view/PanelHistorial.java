package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import co.edu.upb.proyecto_bienestar_integral.estructuras.Lista;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.Cita;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.ElementoHistorial;
import co.edu.upb.proyecto_bienestar_integral.model.logica_del_sistema.GestorBaseDeDatos;

public class PanelHistorial extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelFondo;
	private JPanel panelDecorativoSup;
	private JLabel lblHistorial;
	private JTable tablaHistorial;
	private DefaultTableModel modeloTabla;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public PanelHistorial() {
		setLayout(null); // Establecimiento de Absolute Layout

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

		lblHistorial = new JLabel("Historial");
		lblHistorial.setForeground(new Color(240, 255, 240));
		lblHistorial.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblHistorial.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblHistorial);

		// Crear la tabla y su respectivo modelo:
		tablaHistorial = new JTable();
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("Fecha");
		modeloTabla.addColumn("Hora");
		modeloTabla.addColumn("Acción");
		modeloTabla.addColumn("Administrador");
		// Puedes agregar más columnas según sea necesario

		// Asignar el modelo a la tabla:
		tablaHistorial.setModel(modeloTabla);
		// Deshabilitar la edición de las celdas:
		tablaHistorial.setDefaultEditor(Object.class, null);
		// Permitir la selección de filas:
		tablaHistorial.setRowSelectionAllowed(true);
		// Para seleccionar solo una fila a la vez:
		tablaHistorial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Agregar la tabla a un JScrollPane
		scrollPane = new JScrollPane(tablaHistorial);
		scrollPane.setBounds(50, 235, 1100, 441);
		panelFondo.add(scrollPane);

		llenarTabla(GestorBaseDeDatos.obtenerElementosHistorial());

		// Centrar el contenido de las celdas
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER); // Centrar el contenido

		// Aplicar el renderizador centrado a cada columna de la tabla
		for (int ii = 0; ii < tablaHistorial.getColumnCount(); ii++) {
			tablaHistorial.getColumnModel().getColumn(ii).setCellRenderer(centerRenderer);
		}

		// Cambiar la fuente y el tamaño de la letra del contenido de la Tabla:
		Font font = new Font("Montserrat", Font.PLAIN, 17);
		tablaHistorial.setFont(font);

		JTableHeader header = tablaHistorial.getTableHeader();

		// Cambiar la fuente y el tamaño de la letra de la cabecera de la Tabla
		Font fontHeader = new Font("Montserrat", Font.PLAIN, 19);
		header.setFont(fontHeader);

	} // public PanelHistorial()
	
	private void llenarTabla(Lista<ElementoHistorial> historialMedico) {
		ElementoHistorial elemento;
		for (int ii = historialMedico.getTamano() - 1; ii >= 0; ii--) {
			elemento = historialMedico.obtenerElemento(ii);
			Object[] fila = { elemento.getFechaFormateada(), elemento.getHoraFormateada(),
					elemento.getAccion(), elemento.getAdmin().getNombreJuntoId() };
			modeloTabla.addRow(fila);
		}
		ajustarAnchoColumnas();
	}
	
	// Método para ajustar el ancho de las columnas según el contenido más grande
	private void ajustarAnchoColumnas() {
		// Iterar sobre todas las columnas de la tabla:
		for (int i = 0; i < tablaHistorial.getColumnCount(); i++) {
			TableColumn columna = tablaHistorial.getColumnModel().getColumn(i);
			int ancho = 0;

			// Obtener el ancho máximo del encabezado de la columna
			TableCellRenderer renderer = columna.getHeaderRenderer();
			if (renderer == null) {
				renderer = tablaHistorial.getTableHeader().getDefaultRenderer();
			}
			Component comp = renderer.getTableCellRendererComponent(tablaHistorial, columna.getHeaderValue(), false,
					false, 0, 0);
			ancho = comp.getPreferredSize().width;

			// Iterar sobre todas las filas para obtener el ancho máximo del contenido de la
			// columna:
			for (int j = 0; j < tablaHistorial.getRowCount(); j++) {
				TableCellRenderer cellRenderer = tablaHistorial.getCellRenderer(j, i);
				Component c = tablaHistorial.prepareRenderer(cellRenderer, j, i);
				int width = c.getPreferredSize().width + tablaHistorial.getIntercellSpacing().width;
				ancho = Math.max(ancho, width);
			}

			// Establecer el ancho de la columna al ancho máximo calculado + 10 unidades de
			// espacio extra:
			columna.setPreferredWidth(ancho + 15);
		}
	}

} // public class PanelHistorial extends JPanel
