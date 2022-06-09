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

	
	
	public Temporada(String nombre, String descripcion, byte numeroTemporadas, Date fechaEstreno, String anime) {
		super(nombre, descripcion);
		this.numeroTemporadas = numeroTemporadas;
		this.fechaEstreno = fechaEstreno;
		this.anime = anime;
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

	public static ArrayList<Temporada> getTemporadasNaruto() {
		Statement smt = UtilsBD.conectarBD();
		// Inicializamos un ArrayList para devolver.
		ArrayList<Temporada> temporadasNaruto = new ArrayList<Temporada>();

		try {
			ResultSet cursor = smt.executeQuery("select * from temporada where anime='Naruto'");
			while (cursor.next()) {
				Temporada actual = new Temporada();

				actual.nombre = cursor.getString("nombre");
				actual.descripcion = cursor.getString("descripcion");
				actual.numeroTemporadas = cursor.getByte("numeroTemporada");
				actual.fechaEstreno = cursor.getDate("fechaEstreno");
				actual.anime = cursor.getString("anime");



				temporadasNaruto.add(actual);
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
		return temporadasNaruto;
	}
	
	
	

}
