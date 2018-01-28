package jogodaforca.exceptions;

/**
 * Herda de JogoDaForcaException e retorna
 * uma mensagem de erro ao ser inserido um 
 * caractere inv�lido.
 */

@SuppressWarnings("serial")
public class CaracterInvalidoException extends JogoDaForcaException {

	
	public CaracterInvalidoException(String message) {
		super(message);
	}

}
