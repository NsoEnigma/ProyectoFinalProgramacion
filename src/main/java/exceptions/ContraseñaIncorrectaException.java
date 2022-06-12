package exceptions;

/**
 * 
 * Excepcion que se activara cuando la contrase�a sea incorrecta.
 * @author Alejandro Asencio Montes
 *
 */


public class Contrase�aIncorrectaException extends Exception {
	
	/**
	 * Constructor para crear la excepcion.
	 * @param msg Mensaje emitido cuando salte el error.
	 */
	
	public Contrase�aIncorrectaException(String msg) {
		super(msg);
	}
}
