package elementosVisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class BotonesInicio extends JButton {

	Border blackline = BorderFactory.createLineBorder(Color.black);
	private final File archivowav;
	private Clip clip;
	private AudioInputStream audioInputStream;

	public BotonesInicio(String m) {
		super(m);
		estiloPorDefecto();
		
		archivowav = new File(FileSystems.getDefault().getPath("").toAbsolutePath() + "/imagenes/botonSonido.wav");

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(Color.WHITE);
				setBorder(blackline);
				setFont(new Font("Source Sans Pro", Font.BOLD, 26));
				setSize(125, 40);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				estiloPorDefecto();
			}

		});

		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				play();
			}

		});
	}

	private void estiloPorDefecto() {
		this.setBackground(Color.LIGHT_GRAY);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setBorder(blackline);
		this.setFont(new Font("Source Sans Pro", Font.PLAIN, 22));
		this.setForeground(Color.RED);
		setSize(112, 32);
	}

	private void play() {
		try {
			audioInputStream = AudioSystem.getAudioInputStream(archivowav);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			System.err.println(e.getMessage());
		}
	}
}
