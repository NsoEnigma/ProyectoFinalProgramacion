package elementosVisuales;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import clases.Capitulo;
import clases.Ova;
import interfaces.Ventana;

public class ElementoListaOvas extends JPanel {
	private Ventana ventana;
	private Ova ova;

	public ElementoListaOvas(Ventana v, Ova o) {
		super();
		this.ventana = v;
		this.ova = o;
		setBorder(new LineBorder(new Color(218, 165, 32), 3, true));
		this.setMaximumSize(new Dimension(80000, 137));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 50, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel fotoUsuario = new JLabel("");

		if (this.ova.getNombre().contains("Naruto")) {
			fotoUsuario.setIcon(new ImageIcon(".\\imagenes\\naruto.jpg"));
			GridBagConstraints gbc_fotoUsuario = new GridBagConstraints();
			gbc_fotoUsuario.gridheight = 3;
			gbc_fotoUsuario.insets = new Insets(0, 0, 0, 5);
			gbc_fotoUsuario.gridx = 0;
			gbc_fotoUsuario.gridy = 0;
			add(fotoUsuario, gbc_fotoUsuario);
		} else if (this.ova.getTemporada().contains("Spy x Family")) {
			fotoUsuario.setIcon(new ImageIcon(".\\imagenes\\2-scaled.jpg"));
			GridBagConstraints gbc_fotoUsuario = new GridBagConstraints();
			gbc_fotoUsuario.gridheight = 3;
			gbc_fotoUsuario.insets = new Insets(0, 0, 0, 5);
			gbc_fotoUsuario.gridx = 0;
			gbc_fotoUsuario.gridy = 0;
			add(fotoUsuario, gbc_fotoUsuario);
		} else if (this.ova.getTemporada().contains("Tokyo Ghoul")) {
			fotoUsuario.setIcon(new ImageIcon(".\\imagenes\\tkg.jpg"));
			GridBagConstraints gbc_fotoUsuario = new GridBagConstraints();
			gbc_fotoUsuario.gridheight = 3;
			gbc_fotoUsuario.insets = new Insets(0, 0, 0, 5);
			gbc_fotoUsuario.gridx = 0;
			gbc_fotoUsuario.gridy = 0;
			add(fotoUsuario, gbc_fotoUsuario);
		} else if (this.ova.getTemporada().contains("Konosuba")) {
			fotoUsuario.setIcon(new ImageIcon("./imagenes/konosuba.jpg"));
			GridBagConstraints gbc_fotoUsuario = new GridBagConstraints();
			gbc_fotoUsuario.gridheight = 3;
			gbc_fotoUsuario.insets = new Insets(0, 0, 0, 5);
			gbc_fotoUsuario.gridx = 0;
			gbc_fotoUsuario.gridy = 0;
			add(fotoUsuario, gbc_fotoUsuario);
		}
		
		final JLabel labelNombre = new JLabel(this.ova.getNombre());
		labelNombre.setHorizontalAlignment(SwingConstants.LEFT);
		labelNombre.setFont(new Font("Segoe UI", Font.BOLD, 17));
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.anchor = GridBagConstraints.WEST;
		gbc_labelNombre.gridwidth = 3;
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 1;
		gbc_labelNombre.gridy = 0;
		add(labelNombre, gbc_labelNombre);
		
		JLabel labelDescripcion = new JLabel(this.ova.getDescripcion());
		labelDescripcion.setFont(new Font("Tahoma", Font.ITALIC, 11));
		GridBagConstraints gbc_labelDescripcion = new GridBagConstraints();
		gbc_labelDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_labelDescripcion.gridx = 1;
		gbc_labelDescripcion.gridy = 1;
		add(labelDescripcion, gbc_labelDescripcion);
		
		JLabel labelGuion = new JLabel(" - ");
		GridBagConstraints gbc_labelGuion = new GridBagConstraints();
		gbc_labelGuion.insets = new Insets(0, 0, 5, 5);
		gbc_labelGuion.gridx = 2;
		gbc_labelGuion.gridy = 1;
		add(labelGuion, gbc_labelGuion);
		
		JButton verOva = new BotonConSonido("Ver Ovas");
		verOva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				ventana.ovaActual = new Ova(labelNombre.getText());
				ventana.cambiarAPantalla("ova");
			}
		});

	}

}