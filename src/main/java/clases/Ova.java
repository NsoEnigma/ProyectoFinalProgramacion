package clases;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import superclases.EntidadPortada;
import utils.UtilsBD;

/**
 * Clase con todos los constructores y todo lo relacionado con las ovas
 * @author Alejandro Asencio Montes
 *
 */
public class Ova extends EntidadPortada{
	private String link;
	private Byte numeroOva;
	private String temporada;
	
	
	/**
	 * Cosntructor para crear nuestra ova
	 * @param nombre nombre de la ova
	 * @param descripcion descripcion de la ova
	 * @param fechaEmision fecha de emision de la ova
	 * @param link link de la ova 
	 * @param numeroOva numero de la ova
	 * @param temporada temporada a la que pertenece la ova
	 * @param imagenRuta ruta de la portada de la ova
	 */
	public Ova(String nombre, String descripcion, Date fechaEmision, String link, Byte numeroOva, String temporada, String imagenRuta) {
		super(nombre, descripcion, fechaEmision, imagenRuta);
		this.link = link;
		this.numeroOva = numeroOva;
		this.temporada = temporada;
	}
	
	/**
	 * Constructor que consulta todas las ovas de la base de datos
	 * @param text texto para que se muestre cada ova en su correspondiente temporada
	 */
	public Ova(String text) {

		Statement smt = UtilsBD.conectarBD();

		try {
			ResultSet cursor = smt.executeQuery("SELECT * FROM ova WHERE temporada='" + text + "';");
			while (cursor.next()) {

				this.setNumeroOva(cursor.getByte("numeroOva"));
				this.setFechaEmision(cursor.getDate("fechaEstreno"));
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
	
	public Ova() {
		// TODO Auto-generated constructor stub
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Byte getNumeroOva() {
		return numeroOva;
	}
	public void setNumeroOva(Byte numeroOva) {
		this.numeroOva = numeroOva;
	}
	public String getTemporada() {
		return temporada;
	}
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	protected String text;
	
	
}
