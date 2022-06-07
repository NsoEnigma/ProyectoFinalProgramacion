package clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.logging.Logger;

import utils.UtilsBD;

public class Anime {
    
    private String nombre;
	private String descripcion;
	private byte numeroTemporadas;
	private File rutaPortada;
	

	
	
	public Anime(String nombre, String descripcion, byte numeroTemporadas, File rutaPortada) {
		super();
		PreparedStatement ps = null;
		FileInputStream fis = null;
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.numeroTemporadas = numeroTemporadas;
		this.rutaPortada = rutaPortada;
		
		Statement query = UtilsBD.conectarBD();
		
		
			
			
			String insert = "insert into anime values('" + nombre + "','" + descripcion + "','" + numeroTemporadas + "',"
					+ rutaPortada + "')";
			
			
			try {
				try {
					fis = new FileInputStream(rutaPortada);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ps = ((Connection) query).prepareStatement(insert);
				ps.setBinaryStream(1,fis,(int)rutaPortada.length());
				ps.setString(2, nombre);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UtilsBD.desconectarBD();
		
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
	public File getRutaPortada() {
		return rutaPortada;
	}
	public void setRutaPortada(File rutaPortada) {
		this.rutaPortada = rutaPortada;
	}
	
	

}
