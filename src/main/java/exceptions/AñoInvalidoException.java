package exceptions;

/**
 * 
 * Excepcion que se activara cuando el año sea invalido
 * @author Alejandro Asencio Montes
 *
 */

public class AñoInvalidoException extends Exception{
	
	/**
	 * Constructor para crear la excepcion.
	 * @param msg Mensaje emitido cuando salte el error.
	 */
	
	public AñoInvalidoException(String msg) {
		super(msg);
	}
}

