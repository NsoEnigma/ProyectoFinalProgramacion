package superclases;

/**
 * 
 * superclase que nos proporciona las variables descripciones, fechaEmision, imagenruta con herencia de la clase EntidadConNombre.
 * @author Alejandro Asencio Montes.
 *
 */

import java.sql.Date;

public class EntidadPortada extends EntidadConNombre{
	
	protected String descripcion;
	private Date fechaEmision;
	private String imagenRuta;

	public EntidadPortada(String nombre, String descripcion, Date fechaEmision, String imagenRuta) {
		super(nombre);
		this.descripcion = descripcion;
		this.fechaEmision = fechaEmision;
		this.imagenRuta = imagenRuta;
	}
	
	
	public EntidadPortada() {
		super();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}


	public String getImagenRuta() {
		return imagenRuta;
	}


	public void setImagenRuta(String imagenRuta) {
		this.imagenRuta = imagenRuta;
	}
	
	
	
	
	
	
}
