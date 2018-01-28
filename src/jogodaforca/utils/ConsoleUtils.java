package jogodaforca.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jogodaforca.exceptions.CaracterInvalidoException;
import jogodaforca.exceptions.JogoDaForcaException;

/**
 * Classe contendo métodos
 * utilitários de console
 * 
 * @author Rafael.Valle
 *
 */
public class ConsoleUtils {

	/**
	 * Método que lê o caractere digitado no teclado
	 * 
	 * @return letra : caractere digitado
	 * @throws CaracterInvalidoException : no caso do caractere nulo,
	 * 		   mais de um caractere ou não for letra de A a Z
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
			 * Condição: linha não pode ser vazia
			 */
			if (line == null) {
				throw new CaracterInvalidoException("Não houve letra digitada");
			}
			
			/**
			 * Condição: Apenas um caractere é aceito
			 */
			if (line.length() > 1) {
				throw new CaracterInvalidoException("Mais de uma letra foi digitada");
			}
			
			/**
			 * Converte a letra em um char maiúsculo
			 */
			char letra = line.toUpperCase().charAt(0);
			
			/**
			 * Condição: apenas letras são aceitas
			 */
			if (!Character.isLetter(letra)) {
				throw new CaracterInvalidoException("Apenas letras são aceitas");
			}
			
			return letra;
			
		} catch (IOException e) {
			throw new JogoDaForcaException("Erro na leitura do catactere digitado", e);
		}
	}
}
