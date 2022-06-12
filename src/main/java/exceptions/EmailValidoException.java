package exceptions;

/**
 * 
 * Excepcion que se activara cuando el email no sea valido.
 * @author Alejandro Asencio Montes
 *
 */

public class EmailValidoException extends Exception{
	
	/**
	 * Constructor para crear la excepcion.
	 * @param msg Mensaje emitido cuando salte el error.
	 */
	
	public EmailValidoException(String msg) {
		super(msg);
	}
}
