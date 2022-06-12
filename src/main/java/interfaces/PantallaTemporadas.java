package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import clases.Anime;
import clases.Temporada;
import interfaces.Ventana;
import elementosVisuales.BotonConSonido;
import elementosVisuales.ElementoListaAnimes;
import elementosVisuales.ElementoListaTemporadas;

/**
 * 
 * Pantalla en la que se mostraran las temporadas de cada anime distribuidas en secciones.
 * @author Alejandro Asencio Montes.
 *
 */

public class PantallaTemporadas extends JPanel{
private Ventana ventana;
private Anime anime;
	
/**
 * Pantalla temporada va generando un apartado de cada anime con sus distintas propiedades sacadas de la base de datos para mostrar en un 
 * ArrayList<Temporada> cada una de las distintas temporadas de los animes.
 * @param v Con este objeto ventana nuestra pantalla tendra los valores por defecto de la clase Ventana.
 */

	public PantallaTemporadas(Ventana v) {
		this.ventana=v;
		setBackground(Color.DARK_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{210, 193, 0, 0};
		gridBagLayout.rowHeights = new int[]{42, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("AnimeFlvHacendado");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setIcon(new ImageIcon("./imagenes/Akatsuki-Logo-Pequeno.png"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		JButton botonAtras = new BotonConSonido("\u27A1");
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.insets = new Insets(0, 0, 5, 0);
		gbc_botonAtras.gridx = 5;
		gbc_botonAtras.gridy = 0;
		add(botonAtras, gbc_botonAtras);
		
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("anime");
				java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
			}
		});
		
		JPanel listaTemporadas = new JPanel();
		listaTemporadas.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(listaTemporadas);
		listaTemporadas.setLayout(new BoxLayout(listaTemporadas, BoxLayout.Y_AXIS));
		
		ArrayList<Temporada> naruto=Anime.getTemporadas(this.ventana.temporadaActual.getAnime());
		for(int i=0;i<naruto.size();i++) {
			listaTemporadas.add(new ElementoListaTemporadas(ventana,naruto.get(i)));
		}
		


	}

}

