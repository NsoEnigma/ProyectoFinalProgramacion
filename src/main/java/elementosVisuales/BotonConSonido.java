package elementosVisuales;

/**
 * 
 * Elemento visual que contiene un boton que emite un sonido al ser clikeado, este boton se puede asignar a todos los 
 * botones que creemos para ahorrar codigo.
 * @author Alejandro Asencio Montes.
 *
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
/**
 * @see http://www.jc-mouse.net/
 * @author mouse
 */
public class BotonConSonido extends JButton {
    
    private final File archivowav;
    private Clip clip;
    private AudioInputStream audioInputStream;
    private String texto;

	/**
	 * Constructor que sirve para crear el BotonNegro.
	 * @param m Texto asignado.
	 */
    public BotonConSonido(String texto) {        
       super(texto);
       
       archivowav = new File(
                FileSystems.getDefault().getPath("")
                        .toAbsolutePath() + "/imagenes/botonSonido.wav");
        
        //Cuando se presione el boton, se reproducira el sonido
        BotonConSonido.this.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {                
                 play();
            }

        });
    }
    
    /**
     * Metodo para reproducir un archivo de audio 
     */
    private void play(){
        try {
            audioInputStream = AudioSystem.getAudioInputStream(archivowav);            
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);            
            clip.start();
        } catch (LineUnavailableException | IOException| UnsupportedAudioFileException e) {
            System.err.println(e.getMessage());
        }
    }

}