package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import elementosVisuales.BotonesInicio;

public class PantallaElegir extends JPanel {
	private Ventana ventana;

	public PantallaElegir(Ventana v) {
		this.ventana = v;

		setLayout(null);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("./imagenes/Akatsuki-Logo.png"));
		logo.setBounds(250, 43, 250, 141);
		add(logo);

		JLabel hola = new JLabel("");
		hola.setIcon(new ImageIcon("./imagenes/hola.png"));
		hola.setBounds(659, 0, 141, 92);
		add(hola);

		JLabel titulo = new JLabel("AnimeFlvHacendado");
		titulo.setForeground(Color.RED);
		titulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(250, 210, 250, 35);
		add(titulo);
		
		JButton botonLogin = new BotonesInicio("Login");
		botonLogin.setBackground(Color.LIGHT_GRAY);
		botonLogin.setForeground(Color.RED);
		botonLogin.setBounds(230, 302, 112, 32);
		add(botonLogin);
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

					ventana.cambiarAPantalla("anime");
			}
			
		});
		
		JButton botonRegistro = new BotonesInicio("Registrar");
		botonRegistro.setForeground(Color.RED);
		botonRegistro.setBounds(411, 302, 112, 32);
		add(botonRegistro);
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

					ventana.cambiarAPantalla("favorito");
			}
			
		});
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("./imagenes/fondoPantallasRedimensionado.jpg"));
		fondo.setBounds(0, 0, 800, 501);
		add(fondo);
		
	}

}
