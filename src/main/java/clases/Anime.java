package clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Logger;

import superclases.EntidadConNombre;
import superclases.EntidadPortada;
import utils.UtilsBD;

/**
 * Clase donde estran las condiciones y constructores para lo relavionado con los animes
 * @author Alejandro Asencio Montes
 *
 */
public class Anime extends EntidadPortada{
    
    private String nombre;
	private String descripcion;
	private ArrayList<Temporada> temporadas;
	private ArrayList<Ova> ovas;
	private byte numeroTemporadas;
	
	
	
	
	/**
	 * Constructor utilizado para crear el anime
	 * @param nombre nombre del anime
	 * @param descripcion descripcion del anime
	 * @param numeroTemporadas numero de temporadas que contiene el anime
	 * @param anime nombre del grupo de anime
	 * @param fechaEmision fecha en la que se emitio el anime
	 * @param imagenRuta ruta de la imagen de portada
	 */
	
	
	public Anime(String nombre, String descripcion, byte numeroTemporadas, String anime, Date fechaEmision, String imagenRuta) {
		super(nombre,descripcion,fechaEmision, imagenRuta);
		PreparedStatement ps = null;
		FileInputStream fis = null;
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.numeroTemporadas = numeroTemporadas;
		
		
		
		
		
		
		
		
		
	}
	
	public Anime(String nombre) {
		//Te consulta todos los datos del anime con ese nombre, y de la tabla temporadas todas las temporadas
	}

	public Anime() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor donde se almacenan y recogen todos los animes de la base de datos
	 * @return ArrayList con todos los animes como contenido
	 */
	public static ArrayList<Anime> getTodos() {
		Statement smt = UtilsBD.conectarBD();
		// Inicializamos un ArrayList para devolver.
		
		
		ArrayList<Anime> ret = new ArrayList<Anime>();

		try {
			ResultSet cursor = smt.executeQuery("select * from anime");
			while (cursor.next()) {
				Anime actual = new Anime();

				actual.nombre = cursor.getString("nombre");
				actual.setFechaEmision(cursor.getDate("fechaEstreno"));
				actual.descripcion = cursor.getString("descripcion");
				actual.numeroTemporadas = cursor.getByte("numeroTemporada");
				actual.setImagenRuta(cursor.getString("imagenRuta"));



				ret.add(actual);
			}
		} catch (SQLException e) {
			// Si la conuslta falla no hay nada que devolver.
			e.printStackTrace();
			return null;
		}
		// Si no hay usuarios en la tabla, va a devolver un arraylist vacio.
		// Si la consulta fue erronea se devuelve un arraylist null, que son cosas
		// distintas.
		UtilsBD.desconectarBD();
		return ret;
	}	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * Constructor para denominar cada temporada de cada anime
	 * @param text grupo del anime al que pertenece
	 * @return ArrayList con todo el contenido de temporadas en su interior
	 */
	public static ArrayList<Temporada> getTemporadas(String text) {
		Statement smt = UtilsBD.conectarBD();
        // Inicializamos un ArrayList para devolver.
        ArrayList<Temporada> temporadas = new ArrayList<Temporada>();
        
        try {
            ResultSet cursor = smt.executeQuery("SELECT * FROM temporada where anime= '" + text + "';" );
            while (cursor.next()) {
                Temporada actual = new Temporada();

                actual.setNombre(cursor.getString("nombre"));
                actual.setDescripcion(cursor.getString("descripcion"));
                actual.setNumeroTemporadas(cursor.getByte("numeroTemporada"));
                actual.setFechaEmision(cursor.getDate("fechaEstreno"));
                actual.setAnime(cursor.getString("anime"));
                actual.setImagenRuta(cursor.getString("imagenRuta"));



                temporadas.add(actual);
            }
        } catch (SQLException e) {
            // Si la conuslta falla no hay nada que devolver.
            e.printStackTrace();
            return null;
        }
       
        // Si no hay usuarios en la tabla, va a devolver un arraylist vacio.
        // Si la consulta fue erronea se devuelve un arraylist null, que son cosas
        // distintas.
        UtilsBD.desconectarBD();
        return temporadas;
	}
	

	public void setTemporadas(ArrayList<Temporada> temporadas) {
		this.temporadas = temporadas;
	}
	
	public void setOvas(ArrayList<Ova> ovas) {
		this.ovas = ovas;
	}
	public byte getNumeroTemporadas() {
		return numeroTemporadas;
	}

	public void setNumeroTemporadas(byte numeroTemporadas) {
		this.numeroTemporadas = numeroTemporadas;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	protected String text;
	

	
	

}
