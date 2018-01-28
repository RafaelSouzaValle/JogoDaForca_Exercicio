package jogodaforca.exceptions;

public class JogoDaForcaException extends Exception {

	/**
	 * Construtor da exce��o que gera a mensagem de erro
	 * quando houver falha de execu��o.
	 * @param message
	 */
	public JogoDaForcaException(String message) {
		super (message);
	}
	
	/**
	 * Construtor da exce��o que gera a mensagem de erro
	 * e causa quando houver falha de execu��o.
	 * @param message
	 * @param cause
	 */
	public JogoDaForcaException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
}
