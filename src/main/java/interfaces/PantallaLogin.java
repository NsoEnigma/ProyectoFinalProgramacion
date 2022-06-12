package interfaces;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import clases.Usuario;
import elementosVisuales.BotonesInicio;
import exceptions.ContraseñaIncorrectaException;
import exceptions.UsuarioNoExisteException;
import interfaces.Ventana;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.ImageIcon;

public class PantallaLogin extends JPanel{
	private Ventana ventana;
	private JTextField campoUsuario;
	private JPasswordField campoContraseña;
	
	public PantallaLogin(Ventana v) {
		setBackground(Color.DARK_GRAY);
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{15, 108, 152, 160, 100, 94, 0};
		gridBagLayout.rowHeights = new int[]{0, 23, 90, 23, 31, 23, 68, 37, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon("./imagenes/Akatsuki-Logo-Pequeno.png"));
		GridBagConstraints gbc_icono = new GridBagConstraints();
		gbc_icono.insets = new Insets(0, 0, 5, 5);
		gbc_icono.gridx = 0;
		gbc_icono.gridy = 0;
		add(icono, gbc_icono);
		
		JButton botonAtras = new JButton("\u27A1");
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.insets = new Insets(0, 0, 5, 0);
		gbc_botonAtras.gridx = 5;
		gbc_botonAtras.gridy = 0;
		add(botonAtras, gbc_botonAtras);
		
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("inicio");
			}
		});
		
		JLabel labelInicioSesion = new JLabel("Iniciar Sesion");
		labelInicioSesion.setForeground(Color.RED);
		labelInicioSesion.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_labelInicioSesion = new GridBagConstraints();
		gbc_labelInicioSesion.fill = GridBagConstraints.VERTICAL;
		gbc_labelInicioSesion.insets = new Insets(0, 0, 5, 5);
		gbc_labelInicioSesion.gridwidth = 2;
		gbc_labelInicioSesion.gridx = 2;
		gbc_labelInicioSesion.gridy = 1;
		add(labelInicioSesion, gbc_labelInicioSesion);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelUsuario.setForeground(Color.RED);
		GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
		gbc_labelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelUsuario.gridx = 2;
		gbc_labelUsuario.gridy = 3;
		this.add(labelUsuario, gbc_labelUsuario);
		
		campoUsuario = new JTextField();
		GridBagConstraints gbc_campoUsuario = new GridBagConstraints();
		gbc_campoUsuario.fill = GridBagConstraints.BOTH;
		gbc_campoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_campoUsuario.gridx = 3;
		gbc_campoUsuario.gridy = 3;
		add(campoUsuario, gbc_campoUsuario);
		campoUsuario.setColumns(10);
		
		JLabel labelContraseña = new JLabel("Contraseña");
		labelContraseña.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelContraseña.setForeground(Color.RED);
		GridBagConstraints gbc_labelContraseña = new GridBagConstraints();
		gbc_labelContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_labelContraseña.gridx = 2;
		gbc_labelContraseña.gridy = 5;
		add(labelContraseña, gbc_labelContraseña);
		
		JButton botonLogin = new BotonesInicio("Login");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				String nombre=campoUsuario.getText();
				String contraseña= new String (campoContraseña.getPassword());
					
						ventana.usuarioLogado=new Usuario(nombre,contraseña);
						
						JOptionPane.showMessageDialog(ventana, 
						"Bienvenid@, "+ventana.usuarioLogado.getNombre(),
						"Login correcto",JOptionPane.PLAIN_MESSAGE);
						
						ventana.cambiarAPantalla("anime");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ContraseñaIncorrectaException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(ventana,
								"Contraseña Incorrecta",
								"Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (UsuarioNoExisteException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(ventana,
								"El usuario no existe",
								"Error",
								JOptionPane.ERROR_MESSAGE);
					}
				
			}
		});
		
		campoContraseña = new JPasswordField();
		campoContraseña.setEchoChar('*');
		GridBagConstraints gbc_campoContraseña = new GridBagConstraints();
		gbc_campoContraseña.fill = GridBagConstraints.BOTH;
		gbc_campoContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_campoContraseña.gridx = 3;
		gbc_campoContraseña.gridy = 5;
		add(campoContraseña, gbc_campoContraseña);
		botonLogin.setToolTipText("Inicia Sesión, cermuzo");
		GridBagConstraints gbc_botonLogin = new GridBagConstraints();
		gbc_botonLogin.gridwidth = 2;
		gbc_botonLogin.fill = GridBagConstraints.BOTH;
		gbc_botonLogin.insets = new Insets(0, 0, 5, 5);
		gbc_botonLogin.gridx = 2;
		gbc_botonLogin.gridy = 7;
		add(botonLogin, gbc_botonLogin);
		


	}
}
