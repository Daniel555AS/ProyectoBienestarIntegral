package co.edu.upb.proyecto_bienestar_integral.view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

import javax.swing.SwingConstants;

public class PanelPrincipal extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lblGestionPacientes;
    private EmbeddedMediaPlayerComponent mediaPlayerComponent;
    private EmbeddedMediaPlayer mediaPlayer;

	/**
	 * Create the panel.
	 */
	public PanelPrincipal() {
		
		setLayout(null);
		
		// Creación de JPanel para fondo de PanelPrincipal:
		JPanel panelFondo = new JPanel();
		panelFondo.setBackground(Color.WHITE);
		panelFondo.setBounds(0, 0, 1203, 783);
		add(panelFondo);
		panelFondo.setLayout(null);
		
		// Creación de JPanel con propósito decorativo, ubicado en la parte superior del panel:
		JPanel panelDecorativoSup = new JPanel();
		panelDecorativoSup.setBackground(new Color(2, 138, 102));
		panelDecorativoSup.setBounds(0, 47, 1203, 142);
		panelFondo.add(panelDecorativoSup);
		panelDecorativoSup.setLayout(null);
		
		// Creación de JLabel con el texto: "Registrar Paciente":
		lblGestionPacientes = new JLabel("Principal");
		lblGestionPacientes.setForeground(new Color(240, 255, 240));
		lblGestionPacientes.setFont(new Font("Montserrat", Font.BOLD, 40));
		lblGestionPacientes.setBounds(47, 44, 188, 49);
		panelDecorativoSup.add(lblGestionPacientes);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(270, 238, 632, 440);
		panelFondo.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("¡Tu Salud es Nuestro Compromiso!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(201, 697, 790, 52);
		panelFondo.add(lblNewLabel_1);
		setImageLabel(lblNewLabel, "Media\\BienestarIntegral.png");
		
		 // Crear el componente de reproducción de video
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        mediaPlayerComponent.setBounds(270, 238, 632, 440);
        panelFondo.add(mediaPlayerComponent);
        mediaPlayer = mediaPlayerComponent.mediaPlayer(); // Obtener el reproductor de medios
        setVideo("Media\\VideoInicioBienestar.mp4");
	}
	
	// Método private void que permite insertar una imagen con relación al tamaño definido de un JLabel:
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
	}
	
    public void setVideo(String videoPath) {
        File videoFile = new File(videoPath);
        if (videoFile.exists()) {
            mediaPlayer.media().play(videoFile.getAbsolutePath());
        } else {
            JOptionPane.showMessageDialog(this, "El archivo de video no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
} // public class PanelPrincipal extends JPanel 
