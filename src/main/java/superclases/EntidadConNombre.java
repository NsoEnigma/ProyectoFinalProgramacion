package superclases;


/**
 * 
 * superclase que nos proporciona la variable nombre.
 * @author Alejandro Asencio Montes.
 *
 */

public class EntidadConNombre {
	
	protected String nombre;

	public EntidadConNombre(String nombre) {
		super();
		this.nombre = nombre;
	}

	public EntidadConNombre() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
