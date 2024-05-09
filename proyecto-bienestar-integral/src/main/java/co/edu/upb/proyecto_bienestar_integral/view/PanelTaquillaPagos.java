package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import co.edu.upb.proyecto_bienestar_integral.estructuras.Lista;
import co.edu.upb.proyecto_bienestar_integral.model.*;
import co.edu.upb.proyecto_bienestar_integral.model.logicadelsistema.Cita;
import co.edu.upb.proyecto_bienestar_integral.controller.*;
import co.edu.upb.proyecto_bienestar_integral.view.componentes.*;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PanelTaquillaPagos extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelFondo;
	private JPanel panelDecorativoSup;
	private RoundedPanel panelPagos;
	private RoundedPanel panelCosto;
	private RoundedButton buttonPagar;
	private JTextField campoIdCita;
	private JLabel lblCostoCita;
	private JLabel lblTaquillaPagos;
	private JLabel lblIngresarTicket;
	private JLabel lblCosto;
	private JLabel lblImagenTaquilla;
	private Cita citaIdentificada;
	private ModeloTaquillaPagos modeloTaquillaPagos;
	private ControladorTaquillaPagos controladorTaquillaPagos;

	/**
	 * Create the panel.
	 */
	public PanelTaquillaPagos() {
		citaIdentificada = null;
		modeloTaquillaPagos = new ModeloTaquillaPagos();
		controladorTaquillaPagos = new ControladorTaquillaPagos(modeloTaquillaPagos, this);
		setLayout(null);

		// Creación de JPanel para fondo de PanelTaquillaPagos:
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

		// Creación de JLabel con el texto: "Taquilla de Pagos":
		lblTaquillaPagos = new JLabel("Taquilla de Pagos");
		lblTaquillaPagos.setForeground(new Color(240, 255, 240));
		lblTaquillaPagos.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblTaquillaPagos.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblTaquillaPagos);

		// Creación de RoundedPanel decorativo para el ingreso del ID de la Cita Médica:
		panelPagos = new RoundedPanel(50);
		panelPagos.setBounds(50, 341, 633, 74);
		panelFondo.add(panelPagos);
		panelPagos.setBackground(new Color(241, 241, 241));
		panelPagos.setLayout(null);

		// Creación de JTextField para ingresar ID de la Cita Médica:
		campoIdCita = new JTextField();
		campoIdCita.setBounds(26, 2, 585, 71);
		panelPagos.add(campoIdCita);
		campoIdCita.setFont(new Font("Montserrat", Font.PLAIN, 25));
		campoIdCita.setBorder(null);
		campoIdCita.setBackground(null);
		campoIdCita.setColumns(10);
		campoIdCita.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateName();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				updateName();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateName();
			}

			private void updateName() {
				Lista<Cita> citas = SistemaDeSalud.conseguirCitas();
				String idCita = getCampoIdCita();
				boolean citaEncontrada = false; // Variable para controlar si se encuentra la Cita
				for (int ii = citas.getTamano() - 1; ii >= 0; ii--) {
					Cita citaActual = citas.obtenerElemento(ii);
					if (citaActual.getIdentificador().equals(idCita)) {
						lblCostoCita.setText("$ " + citaActual.getCosto());
						citaIdentificada = citaActual;
						citaEncontrada = true; // Se encontró la cita médica
						break; // Salir del bucle ya que se encontró la cita médica
					}
				}
				// Si no se encuentra la cita médica, mostrar el mensaje "ID de Cita Médica No
				// Encontrado"
				if (!citaEncontrada) {
					citaIdentificada = null;
					lblCostoCita.setText("ID de Cita Médica No Encontrado");
				}
			}
		});

		// Creación de JLabel con el texto: "Ingrese Ticket de Cita Médica:":
		lblIngresarTicket = new JLabel("Ingrese Ticket de Cita Médica:");
		lblIngresarTicket.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngresarTicket.setFont(new Font("Montserrat", Font.PLAIN, 26));
		lblIngresarTicket.setBounds(50, 286, 421, 45);
		panelFondo.add(lblIngresarTicket);

		// Creación de JLabel con el texto: "Costo:":
		lblCosto = new JLabel("Costo:");
		lblCosto.setHorizontalAlignment(SwingConstants.LEFT);
		lblCosto.setFont(new Font("Montserrat", Font.PLAIN, 26));
		lblCosto.setBounds(50, 465, 421, 45);
		panelFondo.add(lblCosto);

		// Creación de RoundedPanel decorativo para exponer el costo de la Cita Médica:
		panelCosto = new RoundedPanel(50);
		panelCosto.setLayout(null);
		panelCosto.setBackground(new Color(241, 241, 241));
		panelCosto.setBounds(50, 520, 633, 74);
		panelFondo.add(panelCosto);

		// Creación de JLabel para exponer el costo de la Cita:
		lblCostoCita = new JLabel("ID de Cita Médica No Encontrado");
		lblCostoCita.setBounds(27, 0, 563, 74);
		panelCosto.add(lblCostoCita);
		lblCostoCita.setFont(new Font("Montserrat", Font.PLAIN, 25));

		// Creación de JLabel para agregar imagen decorativa con respecto a la Taquilla
		// de Pagos:
		lblImagenTaquilla = new JLabel();
		lblImagenTaquilla.setBounds(736, 306, 415, 383);
		panelFondo.add(lblImagenTaquilla);
		setImageLabel(lblImagenTaquilla, "Media\\IconoTaquilla.png");

		// Creación de RoundedButton para el proceso de Pago en Taquilla:
		buttonPagar = new RoundedButton("Confirmar Pago", new Color(23, 174, 191), new Color(0, 139, 139), 1000, 60);
		buttonPagar.setText("Confirmar Pago");
		buttonPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorTaquillaPagos.confirmarPago();
			}
		});
		buttonPagar.setFont(new Font("Montserrat", Font.BOLD, 25));
		buttonPagar.setForeground(new Color(255, 255, 255));
		buttonPagar.setBackground(new Color(23, 174, 191));
		buttonPagar.setBounds(194, 653, 320, 57);
		buttonPagar.setFocusable(false);
		panelFondo.add(buttonPagar);
	} // public PanelTaquillaPagos()

	// Métodos Getters:
	public String getCampoIdCita() {
		return campoIdCita.getText();
	}

	public String getCostoCita() {
		return lblCostoCita.getText();
	}

	public Cita getCitaIdentificada() {
		return citaIdentificada;
	}
	
	// Métodos Setters:
	public void setCampoIdCitaNull() {
		campoIdCita.setText("");
	}

	// Método private void que permite insertar una imagen con relación al tamaño
	// definido de un JLabel:
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

} // public class PanelTaquillaPagos extends JPanel
