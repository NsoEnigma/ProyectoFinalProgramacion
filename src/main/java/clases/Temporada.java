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

public class Temporada extends EntidadPortada {

	private byte numeroTemporadas;
	private Date fechaEstreno;
	private String anime;
	protected String text;
	private ArrayList<Capitulo> capitulos;

	public Temporada(String nombre, String descripcion, byte numeroTemporadas, Date fechaEstreno, String anime) {
		super(nombre, descripcion);
		this.numeroTemporadas = numeroTemporadas;
		this.fechaEstreno = fechaEstreno;
		this.anime = anime;

	}

	public Temporada(String text) {

		Statement smt = UtilsBD.conectarBD();

		try {
			ResultSet cursor = smt.executeQuery("SELECT * FROM temporada WHERE anime='" + text + "';");
			while (cursor.next()) {

				this.setNumeroTemporadas(cursor.getByte("numeroTemporada"));
				this.setFechaEstreno(cursor.getDate("fechaEstreno"));
				this.setNombre(cursor.getString("nombre"));
				this.setAnime(cursor.getString("anime"));
				this.setDescripcion(cursor.getString("descripcion"));

			}
		} catch (SQLException e) {

			e.printStackTrace();

		}

		UtilsBD.desconectarBD();
	}
	
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

	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
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
