package elementosVisuales;

import javax.swing.JPanel;

import clases.Anime;
import clases.Ova;
import clases.Temporada;
import clases.Usuario;
import exceptions.ContraseñaIncorrectaException;
import exceptions.UsuarioNoExisteException;
import interfaces.Ventana;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class ElementoListaAnimes extends JPanel{

	private Ventana ventana;
	private Anime anime;
	public ElementoListaAnimes(Ventana v, Anime a) {
		super();
		this.ventana = v;
		this.anime = a;
		setBorder(new LineBorder(new Color(218, 165, 32), 3, true));
		this.setMaximumSize(new Dimension(80000,137));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel fotoUsuario = new JLabel("");
		
		if (this.anime.getNombre().contains("Naruto")) {
			fotoUsuario.setIcon(new ImageIcon(".\\imagenes\\naruto.jpg"));
			GridBagConstraints gbc_fotoUsuario = new GridBagConstraints();
			gbc_fotoUsuario.gridheight = 3;
			gbc_fotoUsuario.insets = new Insets(0, 0, 0, 5);
			gbc_fotoUsuario.gridx = 0;
			gbc_fotoUsuario.gridy = 0;
			add(fotoUsuario, gbc_fotoUsuario);
		}else if(this.anime.getNombre().contains("Spy x Family")) {
			fotoUsuario.setIcon(new ImageIcon(".\\imagenes\\2-scaled.jpg"));
			GridBagConstraints gbc_fotoUsuario = new GridBagConstraints();
			gbc_fotoUsuario.gridheight = 3;
			gbc_fotoUsuario.insets = new Insets(0, 0, 0, 5);
			gbc_fotoUsuario.gridx = 0;
			gbc_fotoUsuario.gridy = 0;
			add(fotoUsuario, gbc_fotoUsuario);
		}else if(this.anime.getNombre().contains("Tokyo Ghoul")) {
			fotoUsuario.setIcon(new ImageIcon(".\\imagenes\\tkg.jpg"));
			GridBagConstraints gbc_fotoUsuario = new GridBagConstraints();
			gbc_fotoUsuario.gridheight = 3;
			gbc_fotoUsuario.insets = new Insets(0, 0, 0, 5);
			gbc_fotoUsuario.gridx = 0;
			gbc_fotoUsuario.gridy = 0;
			add(fotoUsuario, gbc_fotoUsuario);
		}else if(this.anime.getNombre().contains("Konosuba")) {
			fotoUsuario.setIcon(new ImageIcon("./imagenes/konosuba.jpg"));
			GridBagConstraints gbc_fotoUsuario = new GridBagConstraints();
			gbc_fotoUsuario.gridheight = 3;
			gbc_fotoUsuario.insets = new Insets(0, 0, 0, 5);
			gbc_fotoUsuario.gridx = 0;
			gbc_fotoUsuario.gridy = 0;
			add(fotoUsuario, gbc_fotoUsuario);
		}
		
		
		final JLabel labelNombre = new JLabel(this.anime.getNombre());
		labelNombre.setHorizontalAlignment(SwingConstants.LEFT);
		labelNombre.setFont(new Font("Segoe UI", Font.BOLD, 17));
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.anchor = GridBagConstraints.WEST;
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 1;
		gbc_labelNombre.gridy = 0;
		add(labelNombre, gbc_labelNombre);
		
		JLabel labelGuion = new JLabel(" - ");
		GridBagConstraints gbc_labelGuion = new GridBagConstraints();
		gbc_labelGuion.anchor = GridBagConstraints.WEST;
		gbc_labelGuion.insets = new Insets(0, 0, 5, 5);
		gbc_labelGuion.gridx = 2;
		gbc_labelGuion.gridy = 0;
		add(labelGuion, gbc_labelGuion);
		
		JLabel labelNumeroTemporadas = new JLabel(""+this.anime.getNumeroTemporadas()+"Temporadas");
		GridBagConstraints gbc_labelNumeroTemporadas = new GridBagConstraints();
		gbc_labelNumeroTemporadas.anchor = GridBagConstraints.WEST;
		gbc_labelNumeroTemporadas.insets = new Insets(0, 0, 5, 5);
		gbc_labelNumeroTemporadas.gridx = 3;
		gbc_labelNumeroTemporadas.gridy = 0;
		add(labelNumeroTemporadas, gbc_labelNumeroTemporadas);
		
		JLabel labelDescripcion = new JLabel(this.anime.getDescripcion());
		labelDescripcion.setFont(new Font("Tahoma", Font.ITALIC, 11));
		GridBagConstraints gbc_labelDescripcion = new GridBagConstraints();
		gbc_labelDescripcion.gridwidth = 2;
		gbc_labelDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_labelDescripcion.gridx = 1;
		gbc_labelDescripcion.gridy = 1;
		add(labelDescripcion, gbc_labelDescripcion);
		
		JButton verAnime = new BotonConSonido("Ver Temporadas");
		verAnime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ventana.temporadaActual = new Temporada(labelNombre.getText());
				ventana.cambiarAPantalla("temporada");
			}
		});
		GridBagConstraints gbc_verAnime = new GridBagConstraints();
		gbc_verAnime.anchor = GridBagConstraints.WEST;
		gbc_verAnime.insets = new Insets(0, 0, 0, 5);
		gbc_verAnime.gridx = 1;
		gbc_verAnime.gridy = 2;
		add(verAnime, gbc_verAnime);
		
		JButton verOva = new BotonConSonido("Ver Ovas");
		verOva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ventana.ovaActual = new Ova(labelNombre.getText());
				ventana.cambiarAPantalla("ova");
			}
		});
		GridBagConstraints gbc_verOva = new GridBagConstraints();
		gbc_verOva.gridwidth = 2;
		gbc_verOva.anchor = GridBagConstraints.WEST;
		gbc_verOva.insets = new Insets(0, 0, 0, 5);
		gbc_verOva.gridx = 2;
		gbc_verOva.gridy = 2;
		add(verOva, gbc_verOva);
		
		
		
	}
	
	

}

