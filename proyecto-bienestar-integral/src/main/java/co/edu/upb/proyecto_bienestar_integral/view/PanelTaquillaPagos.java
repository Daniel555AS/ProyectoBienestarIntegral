package co.edu.upb.proyecto_bienestar_integral.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.upb.proyecto_bienestar_integral.view.componentes.RoundedPanel;
import javax.swing.SwingConstants;

public class PanelTaquillaPagos extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RoundedPanel panelPagos;
	private JTextField campoPago;

	/**
	 * Create the panel.
	 */
	public PanelTaquillaPagos() {
		setLayout(null);
		
		// Creación de JPanel para fondo de PanelTaquillaPagos:
		JPanel panelFondo = new JPanel();
		panelFondo.setBackground(new Color(255, 255, 255));
		panelFondo.setBounds(0, 0, 1203, 783);
		add(panelFondo);
		panelFondo.setLayout(null);
		
		// Creación de JPanel con propósito decorativo, ubicado en la parte superior del panel:
		JPanel panelDecorativoSup = new JPanel();
		panelDecorativoSup.setBackground(new Color(2, 138, 102));
		panelDecorativoSup.setBounds(0, 47, 1203, 142);
		panelFondo.add(panelDecorativoSup);
		panelDecorativoSup.setLayout(null);
		
		// Creación de JLabel con el texto: "Gestión de Pacientes":
		JLabel lblGestionPacientes = new JLabel("Taquilla de Pagos");
		lblGestionPacientes.setForeground(new Color(240, 255, 240));
		lblGestionPacientes.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblGestionPacientes.setBounds(45, 43, 973, 57);
		panelDecorativoSup.add(lblGestionPacientes);
		
        // Creación de RoundedPanel decorativo para el ingreso del ID de Historia
        // Clínica del Paciente:
        panelPagos = new RoundedPanel(50);
        panelPagos.setBounds(218, 431, 789, 74);
        panelFondo.add(panelPagos);
        panelPagos.setBackground(new Color(241, 241, 241));
        panelPagos.setLayout(null);

        
        // Creación de JTextField para ingresar ID de la Historia Clínica del Paciente;
        campoPago = new JTextField();
        campoPago.setBounds(26, 2, 739, 71);
        panelPagos.add(campoPago);
        campoPago.setFont(new Font("Montserrat", Font.PLAIN, 25));
        campoPago.setBorder(null);
        campoPago.setBackground(null);
        campoPago.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Ingrese Ticket de Cita Médica:");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Montserrat", Font.PLAIN, 26));
        lblNewLabel.setBounds(315, 371, 566, 45);
        panelFondo.add(lblNewLabel);
		
	}
}
