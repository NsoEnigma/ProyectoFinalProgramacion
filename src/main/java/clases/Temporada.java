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

	public void anime(String string) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}
