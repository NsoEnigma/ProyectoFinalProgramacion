package exceptions;

/**
 * 
 * Excepcion que se activara cuando la contrase�a este vacia.
 * @author Alejandro Asencio Montes
 *
 */

public class Contrase�aVaciaException extends Exception{
	
	/**
	 * Constructor para crear la excepcion.
	 * @param msg Mensaje emitido cuando salte el error.
	 */
	
	public Contrase�aVaciaException(String msg) {
		super(msg);
	}
}