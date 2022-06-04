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
import exceptions.Contrase�aIncorrectaException;
import exceptions.UsuarioNoExisteException;
import interfaces.Ventana;

public class PantallaLogin extends JPanel{
	private Ventana ventana;
	private JTextField campoUsuario;
	private JPasswordField campoContrase�a;
	
	public PantallaLogin(Ventana v) {
		this.ventana=v;
		this.setLayout(null);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setBounds(220, 182, 46, 14);
		this.add(labelUsuario);
		
		JLabel labelContrase�a = new JLabel("Contrase�a");
		labelContrase�a.setBounds(220, 236, 64, 14);
		add(labelContrase�a);
		
		JButton botonLogin = new JButton("Login");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				String nombre=campoUsuario.getText();
				String contrase�a= new String (campoContrase�a.getPassword());
					
						ventana.usuarioLogado=new Usuario(nombre,contrase�a);
						
						JOptionPane.showMessageDialog(ventana, 
						"Bienvenid@, "+ventana.usuarioLogado.getNombre(),
						"Login correcto",JOptionPane.PLAIN_MESSAGE);
						
						ventana.cambiarAPantalla("listaUsuarios");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Contrase�aIncorrectaException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UsuarioNoExisteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		botonLogin.setToolTipText("Inicia Sesi�n, cermuzo");
		botonLogin.setBounds(183, 324, 152, 37);
		add(botonLogin);
		
		JButton botonRegistro = new JButton("Registrarse");
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla("registro");
			}
		});
		botonRegistro.setBounds(358, 324, 159, 37);
		add(botonRegistro);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(361, 179, 156, 23);
		add(campoUsuario);
		campoUsuario.setColumns(10);
		
		campoContrase�a = new JPasswordField();
		campoContrase�a.setEchoChar('$');
		campoContrase�a.setBounds(358, 233, 159, 23);
		add(campoContrase�a);
		
		JLabel labelInicioSesion = new JLabel("Iniciar Sesion");
		labelInicioSesion.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelInicioSesion.setBounds(255, 66, 159, 23);
		add(labelInicioSesion);
	}
}
