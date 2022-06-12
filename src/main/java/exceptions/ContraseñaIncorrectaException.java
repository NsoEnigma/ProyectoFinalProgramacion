package exceptions;

/**
 * 
 * Excepcion que se activara cuando la contraseña sea incorrecta.
 * @author Alejandro Asencio Montes
 *
 */


public class ContraseñaIncorrectaException extends Exception {
	
	/**
	 * Constructor para crear la excepcion.
	 * @param msg Mensaje emitido cuando salte el error.
	 */
	
	public ContraseñaIncorrectaException(String msg) {
		super(msg);
	}
}
