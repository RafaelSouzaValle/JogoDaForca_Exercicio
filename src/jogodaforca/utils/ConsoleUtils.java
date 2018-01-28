package jogodaforca.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jogodaforca.exceptions.CaracterInvalidoException;
import jogodaforca.exceptions.JogoDaForcaException;

/**
 * Classe contendo m�todos
 * utilit�rios de console
 * 
 * @author Rafael.Valle
 *
 */
public class ConsoleUtils {

	/**
	 * M�todo que l� o caractere digitado no teclado
	 * 
	 * @return letra : caractere digitado
	 * @throws CaracterInvalidoException : no caso do caractere nulo,
	 * 		   mais de um caractere ou n�o for letra de A a Z
	 * @throws JogoDaForcaException : para problemas na leitura do console
	 */
	public static char lerLetra() throws JogoDaForcaException{
		BufferedReader bReader = null;
		
		try {
			bReader = new BufferedReader(new InputStreamReader(System.in));
			
			/**
			 * String que armazena linha digitada
			 */
			String line = bReader.readLine();
			
			/**
			 * Condi��o: linha n�o pode ser vazia
			 */
			if (line == null) {
				throw new CaracterInvalidoException("N�o houve letra digitada");
			}
			
			/**
			 * Condi��o: Apenas um caractere � aceito
			 */
			if (line.length() > 1) {
				throw new CaracterInvalidoException("Mais de uma letra foi digitada");
			}
			
			/**
			 * Converte a letra em um char mai�sculo
			 */
			char letra = line.toUpperCase().charAt(0);
			
			/**
			 * Condi��o: apenas letras s�o aceitas
			 */
			if (!Character.isLetter(letra)) {
				throw new CaracterInvalidoException("Apenas letras s�o aceitas");
			}
			
			return letra;
			
		} catch (IOException e) {
			throw new JogoDaForcaException("Erro na leitura do catactere digitado", e);
		}
	}
}
