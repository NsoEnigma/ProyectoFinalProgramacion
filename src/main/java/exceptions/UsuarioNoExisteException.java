package exceptions;

/**
 * 
 * Excepcion que se activara cuando la contraseña este vacia.
 * @author Alejandro Asencio Montes
 *
 */

public class UsuarioNoExisteException extends Exception {
	
	/**
	 * Constructor para crear la excepcion.
	 * @param msg Mensaje emitido cuando salte el error.
	 */
	
	public UsuarioNoExisteException(String msg) {
		super(msg);
	}
}