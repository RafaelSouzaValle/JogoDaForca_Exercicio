package jogodaforca.exceptions;

public class JogoDaForcaException extends Exception {

	/**
	 * Construtor da exceção que gera a mensagem de erro
	 * quando houver falha de execução.
	 * @param message
	 */
	public JogoDaForcaException(String message) {
		super (message);
	}
	
	/**
	 * Construtor da exceção que gera a mensagem de erro
	 * e causa quando houver falha de execução.
	 * @param message
	 * @param cause
	 */
	public JogoDaForcaException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
}
