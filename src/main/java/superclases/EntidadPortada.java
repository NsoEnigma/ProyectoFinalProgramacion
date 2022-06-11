package superclases;

import java.sql.Date;

public class EntidadPortada extends EntidadConNombre{
	
	protected String descripcion;
	private Date fechaEmision;

	public EntidadPortada(String nombre, String descripcion, Date fechaEmision) {
		super(nombre);
		this.descripcion = descripcion;
		this.fechaEmision = fechaEmision;
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
	
	
	
	
}
