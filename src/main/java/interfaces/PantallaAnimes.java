package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class PantallaAnimes extends JPanel{
	public PantallaAnimes() {
		setBackground(Color.DARK_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{303, 193, 0, 0};
		gridBagLayout.rowHeights = new int[]{42, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("AnimeFlvHacendado");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setIcon(new ImageIcon("D:\\alejandro\\Cenec 21-22\\programas\\github\\ProyectoFinalProgramacion\\imagenes\\Akatsuki-Logo-Pequeno.png"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel portadaNaruto = new JLabel("");
		portadaNaruto.setVerticalAlignment(SwingConstants.BOTTOM);
		portadaNaruto.setIcon(new ImageIcon("D:\\alejandro\\Cenec 21-22\\programas\\github\\ProyectoFinalProgramacion\\imagenes\\naruto.jpg"));
		portadaNaruto.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_portadaNaruto = new GridBagConstraints();
		gbc_portadaNaruto.insets = new Insets(0, 0, 5, 5);
		gbc_portadaNaruto.gridx = 0;
		gbc_portadaNaruto.gridy = 2;
		add(portadaNaruto, gbc_portadaNaruto);
		
		JLabel portadaSpy = new JLabel("");
		portadaSpy.setIcon(new ImageIcon("D:\\alejandro\\Cenec 21-22\\programas\\github\\ProyectoFinalProgramacion\\imagenes\\2-scaled (1).jpg"));
		GridBagConstraints gbc_portadaSpy = new GridBagConstraints();
		gbc_portadaSpy.insets = new Insets(0, 0, 5, 5);
		gbc_portadaSpy.gridx = 1;
		gbc_portadaSpy.gridy = 2;
		add(portadaSpy, gbc_portadaSpy);
		
		JLabel portadaTokyoGhoul = new JLabel("");
		portadaTokyoGhoul.setIcon(new ImageIcon("D:\\alejandro\\Cenec 21-22\\programas\\github\\ProyectoFinalProgramacion\\imagenes\\tkg.jpg"));
		GridBagConstraints gbc_portadaTokyoGhoul = new GridBagConstraints();
		gbc_portadaTokyoGhoul.insets = new Insets(0, 0, 5, 0);
		gbc_portadaTokyoGhoul.gridx = 2;
		gbc_portadaTokyoGhoul.gridy = 2;
		add(portadaTokyoGhoul, gbc_portadaTokyoGhoul);
		
		JLabel tituloNaruto = new JLabel("Naruto");
		tituloNaruto.setForeground(Color.RED);
		tituloNaruto.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_tituloNaruto = new GridBagConstraints();
		gbc_tituloNaruto.insets = new Insets(0, 0, 5, 5);
		gbc_tituloNaruto.gridx = 0;
		gbc_tituloNaruto.gridy = 3;
		add(tituloNaruto, gbc_tituloNaruto);
		
		JLabel tituloSpy = new JLabel("Spy x Family");
		tituloSpy.setForeground(Color.RED);
		tituloSpy.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_tituloSpy = new GridBagConstraints();
		gbc_tituloSpy.insets = new Insets(0, 0, 5, 5);
		gbc_tituloSpy.gridx = 1;
		gbc_tituloSpy.gridy = 3;
		add(tituloSpy, gbc_tituloSpy);
		
		JLabel tokyo = new JLabel("Tokyo Ghoul");
		tokyo.setFont(new Font("Tahoma", Font.BOLD, 11));
		tokyo.setForeground(Color.RED);
		GridBagConstraints gbc_tokyo = new GridBagConstraints();
		gbc_tokyo.anchor = GridBagConstraints.NORTH;
		gbc_tokyo.insets = new Insets(0, 0, 5, 0);
		gbc_tokyo.gridx = 2;
		gbc_tokyo.gridy = 3;
		add(tokyo, gbc_tokyo);
		
		JButton boton1 = new JButton("Ver Anime");
		GridBagConstraints gbc_boton1 = new GridBagConstraints();
		gbc_boton1.insets = new Insets(0, 0, 5, 5);
		gbc_boton1.gridx = 0;
		gbc_boton1.gridy = 4;
		add(boton1, gbc_boton1);
		
		JButton boton2 = new JButton("Ver Anime");
		GridBagConstraints gbc_boton2 = new GridBagConstraints();
		gbc_boton2.insets = new Insets(0, 0, 5, 5);
		gbc_boton2.gridx = 1;
		gbc_boton2.gridy = 4;
		add(boton2, gbc_boton2);
		
		JButton boton3 = new JButton("Ver Anime");
		GridBagConstraints gbc_boton3 = new GridBagConstraints();
		gbc_boton3.insets = new Insets(0, 0, 5, 0);
		gbc_boton3.gridx = 2;
		gbc_boton3.gridy = 4;
		add(boton3, gbc_boton3);
	}

}
