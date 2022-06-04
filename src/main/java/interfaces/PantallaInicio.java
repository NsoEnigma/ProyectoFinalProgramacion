package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PantallaInicio extends JPanel{
	
	
	public PantallaInicio() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 125, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel titulo = new JLabel("AnimeFlvHacendado");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_titulo = new GridBagConstraints();
		gbc_titulo.gridwidth = 2;
		gbc_titulo.insets = new Insets(0, 0, 5, 5);
		gbc_titulo.gridx = 3;
		gbc_titulo.gridy = 1;
		add(titulo, gbc_titulo);
		
		JButton botonLogin = new JButton("Login");
		GridBagConstraints gbc_botonLogin = new GridBagConstraints();
		gbc_botonLogin.insets = new Insets(0, 0, 0, 5);
		gbc_botonLogin.gridx = 3;
		gbc_botonLogin.gridy = 6;
		add(botonLogin, gbc_botonLogin);
		
		JButton botonRegistro = new JButton("Registro");
		GridBagConstraints gbc_botonRegistro = new GridBagConstraints();
		gbc_botonRegistro.insets = new Insets(0, 0, 0, 5);
		gbc_botonRegistro.gridx = 4;
		gbc_botonRegistro.gridy = 6;
		add(botonRegistro, gbc_botonRegistro);
	}

}
