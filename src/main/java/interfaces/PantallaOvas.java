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
import clases.Capitulo;
import clases.Ova;
import clases.Temporada;
import elementosVisuales.BotonConSonido;
import elementosVisuales.ElementoListaCapitulos;
import elementosVisuales.ElementoListaOvas;

/**
 * 
 * Pantalla en la que se mostraran las ovas de cada anime distribuidas en secciones.
 * @author Alejandro Asencio Montes.
 *
 */

public class PantallaOvas extends JPanel{
	
	private Ventana ventana;
	private Temporada temporada;
	private Ova ova;
	
	/**
	 * PantallaOvas va generando un apartado de cada ova con sus distintas propiedades sacadas de la base de datos para mostrar en un 
	 * ArrayList<Ova> cada una de las distintas ovas de los animes.
	 * @param v Con este objeto ventana nuestra pantalla tendra los valores por defecto de la clase Ventana.
	 */
	
	public PantallaOvas(Ventana v) {
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
			}
		});
		
		JPanel listaOva = new JPanel();
		listaOva.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(listaOva);
		listaOva.setLayout(new BoxLayout(listaOva, BoxLayout.Y_AXIS));
		
		ArrayList<Ova> ovas=Temporada.getOvas(this.ventana.ovaActual.getTemporada());
		for(int i=0;i<ovas.size();i++) {
			listaOva.add(new ElementoListaOvas(ventana,ovas.get(i)));
		}
	}
	
	
	
}
