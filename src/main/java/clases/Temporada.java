package clases;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import superclases.EntidadConNombre;
import superclases.EntidadPortada;
import utils.UtilsBD;

/**
 * Clase que contiene todo lo relacionado con las temporadas, tanto datos como constructores
 * @author Alejandro Asencio Montes
 *
 */
public class Temporada extends EntidadPortada {

	private byte numeroTemporadas;
	private String anime;
	protected String text;
	private ArrayList<Capitulo> capitulos;
	
	/**
	 * Constructor utilizado pra crear nuestra temporada
	 * @param nombre nombr de la temporada
	 * @param descripcion descripcion de la temporada
	 * @param numeroTemporadas numero de temporadas disponibles
	 * @param fechaEmision fecha de emision de la temporada
	 * @param anime anime al que pertenece la temporada
	 * @param imagenRuta ruta de la portada de la temporada
	 */

	public Temporada(String nombre, String descripcion, byte numeroTemporadas, Date fechaEmision, String anime, String imagenRuta) {
		super(nombre, descripcion, fechaEmision, imagenRuta);
		this.numeroTemporadas = numeroTemporadas;
		this.anime = anime;

	}

		/**
		 * Constructor utilizado para consultar todas las temporadas de los aniems de la base de datos
		 * @param text texto para que se muestre cada temporada en su correspondiente anime
		 */
	public Temporada(String text) {

		Statement smt = UtilsBD.conectarBD();

		try {
			ResultSet cursor = smt.executeQuery("SELECT * FROM temporada WHERE anime='" + text + "';");
			while (cursor.next()) {

				this.setNumeroTemporadas(cursor.getByte("numeroTemporada"));
				this.setFechaEmision(cursor.getDate("fechaEstreno"));
				this.setNombre(cursor.getString("nombre"));
				this.setAnime(cursor.getString("anime"));
				this.setDescripcion(cursor.getString("descripcion"));
				this.setImagenRuta(cursor.getString("imagenRuta"));

			}
		} catch (SQLException e) {

			e.printStackTrace();

		}

		UtilsBD.desconectarBD();
	}
	
	/**
	 * Constructor que consulta todos los capitulos de la base de datos
	 * @param text texto para que se muestre cada capitulo en su correspondiente temporada
	 * @return ArrayList con todo los capitulos de contenido
	 */
	public static ArrayList<Capitulo> getCapitulos(String text) {
		Statement smt = UtilsBD.conectarBD();
        // Inicializamos un ArrayList para devolver.
        ArrayList<Capitulo> capitulos = new ArrayList<Capitulo>();
        
        try {
            ResultSet cursor = smt.executeQuery("SELECT * FROM capitulo where temporada= '" + text + "';" );
            while (cursor.next()) {
                Capitulo actual = new Capitulo();

                actual.setLink(cursor.getString("link"));
                actual.setNumeroCapitulo(cursor.getByte("numeroCapitulo"));
                actual.setNombre(cursor.getString("nombre"));
                actual.setTemporada(cursor.getString("temporada"));
                actual.setDescripcion(cursor.getString("descripcion"));
                actual.setImagenRuta(cursor.getString("imagenRuta"));



                capitulos.add(actual);
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
        return capitulos;
	}
	
	/**
	 * Constructor que consulta las ovas de la base de datos
	 * @param text texto para que se muestre cada ova en su correspondiente temporada
	 * @return
	 */
	public static ArrayList<Ova> getOvas(String text) {
		Statement smt = UtilsBD.conectarBD();
        // Inicializamos un ArrayList para devolver.
        ArrayList<Ova> ovas = new ArrayList<Ova>();
        
        try {
            ResultSet cursor = smt.executeQuery("SELECT * FROM ova where temporada= '" + text + "';" );
            while (cursor.next()) {
                Ova actual = new Ova();

                actual.setLink(cursor.getString("link"));
                actual.setNumeroOva(cursor.getByte("numeroOva"));
                actual.setNombre(cursor.getString("nombre"));
                actual.setTemporada(cursor.getString("temporada"));
                actual.setDescripcion(cursor.getString("descripcion"));
                actual.setImagenRuta(cursor.getString("imagenRuta"));



                ovas.add(actual);
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
        return ovas;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Temporada() {
		// TODO Auto-generated constructor stub
	}

	public byte getNumeroTemporadas() {
		return numeroTemporadas;
	}

	public void setNumeroTemporadas(byte numeroTemporadas) {
		this.numeroTemporadas = numeroTemporadas;
	}

	public String getAnime() {
		return anime;
	}

	public void setAnime(String anime) {
		this.anime = anime;
	}

	public void anime(String string) {
		// TODO Auto-generated method stub

	}

}
