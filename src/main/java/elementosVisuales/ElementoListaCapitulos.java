package elementosVisuales;

import java.awt.Color;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;
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

import interfaces.Ventana;

/**
 * 
 * Elemento visual que contiene el estilo de como se mostrar los capitulos con sus datos preestablecidos,
 * esto se utiliza para ahorrar codigo.
 * @author Alejandro Asencio Montes.
 *
 */

public class ElementoListaCapitulos extends JPanel{
	private Ventana ventana;
	private Capitulo capitulo;
	private String link;
	
	/**
	 * Constructor que sirve para asignar un estilo personalizado.
	 * @param m Texto asignado.
	 */
	
	
	public ElementoListaCapitulos(Ventana v, Capitulo t) {
		super();
		this.ventana = v;
		this.capitulo = t;
		setBorder(new LineBorder(new Color(218, 165, 32), 3, true));
		this.setMaximumSize(new Dimension(80000,137));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel fotoUsuario = new JLabel("");
		
		fotoUsuario.setIcon(new ImageIcon(this.capitulo.getImagenRuta()));
		GridBagConstraints gbc_fotoUsuario = new GridBagConstraints();
		gbc_fotoUsuario.gridheight = 3;
		gbc_fotoUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_fotoUsuario.gridx = 0;
		gbc_fotoUsuario.gridy = 0;
		add(fotoUsuario, gbc_fotoUsuario);
		
		
		final JLabel labelNombre = new JLabel(this.capitulo.getNombre());
		labelNombre.setHorizontalAlignment(SwingConstants.LEFT);
		labelNombre.setFont(new Font("Segoe UI", Font.BOLD, 17));
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.anchor = GridBagConstraints.WEST;
		gbc_labelNombre.gridwidth = 3;
		gbc_labelNombre.insets = new Insets(0, 0, 5, 5);
		gbc_labelNombre.gridx = 1;
		gbc_labelNombre.gridy = 0;
		add(labelNombre, gbc_labelNombre);
		
		JLabel labelDescripcion = new JLabel(this.capitulo.getDescripcion());
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
		
		
		
		JLabel labelNumeroTemporadas = new JLabel(""+this.capitulo.getNumeroCapitulo()+" capitulo");
		GridBagConstraints gbc_labelNumeroTemporadas = new GridBagConstraints();
		gbc_labelNumeroTemporadas.insets = new Insets(0, 0, 5, 5);
		gbc_labelNumeroTemporadas.gridx = 3;
		gbc_labelNumeroTemporadas.gridy = 1;
		add(labelNumeroTemporadas, gbc_labelNumeroTemporadas);
		
		link = this.capitulo.getLink();
		
		JButton verCapitulo = new BotonConSonido("Ver Capitulo");
		verCapitulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI(link));
				} catch (Exception ex) {
					
					JOptionPane.showMessageDialog(ventana,
							"Error, no se puede acceder al capitulo",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		GridBagConstraints gbc_verCapitulo = new GridBagConstraints();
		gbc_verCapitulo.anchor = GridBagConstraints.WEST;
		gbc_verCapitulo.insets = new Insets(0, 0, 0, 5);
		gbc_verCapitulo.gridx = 1;
		gbc_verCapitulo.gridy = 2;
		add(verCapitulo, gbc_verCapitulo);
		
		
		
		
		
		
		
	}
}
