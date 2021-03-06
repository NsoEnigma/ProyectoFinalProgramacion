package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import clases.Usuario;
import elementosVisuales.BotonesInicio;
import exceptions.ContraseñaIncorrectaException;
import exceptions.UsuarioNoExisteException;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * 
 * Pantalla en la que el individuo elegira si inicar sesion o registrar un nuevo usuario.
 * @author Alejandro Asencio Montes.
 *
 */

public class PantallaInicio extends JPanel{
	private Ventana ventana;
	
	/**
	 * PantallaInicio es el constructor utilizado para crear nuestra pantalla Incio donde el usuario elegira 
	 * una de las opciones indicadas anteriormente.
	 * @param v Con este objeto ventana nuestra pantalla tendra los valores por defecto de la clase Ventana.
	 */
	
	public PantallaInicio(Ventana v) {
		this.ventana=v;
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

					ventana.cambiarAPantalla("login");
			}
			
		});
		
		JButton botonRegistro = new BotonesInicio("Registrar");
		botonRegistro.setForeground(Color.RED);
		botonRegistro.setBounds(411, 302, 112, 32);
		add(botonRegistro);
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

					ventana.cambiarAPantalla("registro");
			}
			
		});
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("./imagenes/fondoPantallasRedimensionado.jpg"));
		fondo.setBounds(0, 0, 800, 501);
		add(fondo);
		

		
		
		
	}
}
