package exceptions;

/**
 * 
 * Excepcion que se activara cuando el a�o sea invalido
 * @author Alejandro Asencio Montes
 *
 */

public class A�oInvalidoException extends Exception{
	
	/**
	 * Constructor para crear la excepcion.
	 * @param msg Mensaje emitido cuando salte el error.
	 */
	
	public A�oInvalidoException(String msg) {
		super(msg);
	}
}

