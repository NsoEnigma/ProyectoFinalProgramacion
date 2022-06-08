package clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
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

import utils.UtilsBD;

public class Anime {
    
    private String nombre;
	private String descripcion;
	private byte numeroTemporadas;
	

	
	
	public Anime(String nombre, String descripcion, byte numeroTemporadas) {
		super();
		PreparedStatement ps = null;
		FileInputStream fis = null;
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.numeroTemporadas = numeroTemporadas;
		
	}
	
	public Anime() {
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<Anime> getTodos() {
		Statement smt = UtilsBD.conectarBD();
		// Inicializamos un ArrayList para devolver.
		ArrayList<Anime> ret = new ArrayList<Anime>();

		try {
			ResultSet cursor = smt.executeQuery("select * from anime");
			while (cursor.next()) {
				Anime actual = new Anime();

				actual.nombre = cursor.getString("nombre");
				actual.descripcion = cursor.getString("descripcion");
				actual.numeroTemporadas = cursor.getByte("numeroTemporada");



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
	public byte getNumeroTemporadas() {
		return numeroTemporadas;
	}
	public void setNumeroTemporadas(byte numeroTemporadas) {
		this.numeroTemporadas = numeroTemporadas;
	}

	
	

}
