package interfaces;

import java.awt.Cursor;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Capitulo;
import clases.Ova;
import clases.Temporada;
import clases.Usuario;

/**
 * Esta clase ventana nos crea la pantalla con unos valores preestablecidos
 * @author Alejandro Asencio Montes
 *
 */

public class Ventana extends JFrame{
	/** Contiene a la única pantalla activa en cada momento **/
	private JPanel pantallaActual;
	protected Usuario usuarioLogado;
	public Temporada temporadaActual;
	public Capitulo capituloActual;
	public Ova ovaActual;
	private static final long serialVersionUID = 1L;
	private String nombreUsuario;
	private String contraseniaUsuario;
	
	/**
	 * El constructor ventana es utilizado para genrerar las pantalla con sus valores indicados ademas de una pequela personalizacion como
	 * pueden ser el logo o la localizacion de la pantalla. Ademas se indica la pantalla con la que el programa comenzara.
	 * @param nombreUsuario Nombre de usuario usada en el Login.
	 * @param contraseniaUsuario Contraseña de usuario usada en el Login.
	 */
	
	public Ventana(String nombreUsuario, String contraseniaUsuario) {
		this.nombreUsuario=nombreUsuario;
		this.contraseniaUsuario=contraseniaUsuario;
		temporadaActual=new Temporada("Konosuba");
		this.setSize(800,500);
		this.setLocationRelativeTo(null); //Te pone la ventana en el centro de la pantalla
		this.setIconImage(new ImageIcon("./imagenes/Akatsuki-Logo.png").getImage());
		this.setTitle("AnimeFlvHacendado");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setUndecorated(true);
		this.pantallaActual=new PantallaInicio(this);
		this.setContentPane(pantallaActual);
		
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	/**
	 * Funcion cambiarAPantalla sirve para indicar la pantalla que queremos ver al realizar una accion en nuestro programa. Se utiliza con 
	 * el constructor seguido de un string que indicamos a esa pantalla especifica (nombrePantalla)
	 * @param nombrePantalla Nombre de la pantalla a la que queremos cambiar.
	 */
	
	public void cambiarAPantalla(String nombrePantalla) {
		//Primero la ponemos invisible y la eliminamos
		this.pantallaActual.setVisible(false);
		this.pantallaActual=null;
		switch(nombrePantalla) {
			case "login":
			this.pantallaActual=new PantallaLogin(this,nombreUsuario,contraseniaUsuario);
			break;
			case "registro":
				this.pantallaActual=new PantallaRegistro(this);
			break;	
			case "inicio":
				this.pantallaActual=new PantallaInicio(this);
			break;
			case "anime":
				this.pantallaActual=new PantallaAnimes(this);
			break;
			case "temporada":
				this.pantallaActual=new PantallaTemporadas(this);
			break;
			case "capitulo":
				this.pantallaActual=new PantallaCapitulos(this);
			break;
			case "ova":
				this.pantallaActual=new PantallaOvas(this);
			break;
		}
		this.pantallaActual.setVisible(true);
		this.setContentPane(pantallaActual);
	
	}

}
