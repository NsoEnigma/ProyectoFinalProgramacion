package clases;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import superclases.EntidadPortada;
import utils.UtilsBD;

public class Capitulo extends EntidadPortada{
	
	private String link;
	private Byte numeroCapitulo;
	private String temporada;
	protected String text;
	
	
	
	public Capitulo(String nombre, String descripcion, String link, Byte numeroCapitulo, String temporada,
			Date fechaEmision, String imagenRuta) {
		super(nombre, descripcion, fechaEmision, imagenRuta);
		this.link = link;
		this.numeroCapitulo = numeroCapitulo;
		this.temporada = temporada;
		
	}



	public Capitulo(String text) {

		Statement smt = UtilsBD.conectarBD();

		try {
			ResultSet cursor = smt.executeQuery("SELECT * FROM capitulo WHERE temporada='" + text + "';");
			while (cursor.next()) {

				this.setNumeroCapitulo(cursor.getByte("numeroCapitulo"));
				this.setFechaEmision(cursor.getDate("fechaEmision"));
				this.setNombre(cursor.getString("nombre"));
				this.setTemporada(cursor.getString("temporada"));
				this.setDescripcion(cursor.getString("descripcion"));
				this.setLink(cursor.getString("link"));
				this.setImagenRuta(cursor.getString("imagenRuta"));

			}
		} catch (SQLException e) {

			e.printStackTrace();

		}

		UtilsBD.desconectarBD();
	}
	
	
	public Capitulo() {
		// TODO Auto-generated constructor stub
	}
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Byte getNumeroCapitulo() {
		return numeroCapitulo;
	}

	public void setNumeroCapitulo(Byte numeroCapitulo) {
		this.numeroCapitulo = numeroCapitulo;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	
	
}
