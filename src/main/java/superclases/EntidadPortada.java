package superclases;

public class EntidadPortada extends EntidadConNombre{
	
	protected String descripcion;

	public EntidadPortada(String nombre, String descripcion) {
		super(nombre);
		this.descripcion = descripcion;
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
	
	
	
}
