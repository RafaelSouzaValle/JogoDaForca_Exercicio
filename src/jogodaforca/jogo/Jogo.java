package jogodaforca.jogo;

import java.util.HashSet;
import java.util.Set;

import jogodaforca.exceptions.CaracterInvalidoException;
import jogodaforca.exceptions.JogoDaForcaException;
import jogodaforca.utils.ConsoleUtils;

/**
 * Responsável pelo funcionamento do jogo
 * 
 * @author Rafael.Valle
 *
 */
public class Jogo {

	/**
	 * Constante que contém o limite de erros
	 * permitidos pelo jogo ao tentar acertar
	 * as letras de uma palavra
	 */
	private static final int LIMITE_ERROS = 7;

	public void iniciar() throws JogoDaForcaException {

		/**
		 * Coleção de letras já digitadas
		 * nas tentativas do jogador
		 */
		Set<Character> letrasDigitadas = new HashSet<>();

		/**
		 * Número de erros
		 */
		int erros = 0;

		/**
		 * Sorteio da palavra
		 */
		Dicionario dicionario = Dicionario.getInstancia();
		Palavra palavra = dicionario.proximaPalavra();

		System.out.println("====== JOGO DA FORCA ======");
		System.out.println("A palavras possui " + palavra.comprimento() + " letras.");

		while (true) {
			/**
			 * Método toString sobrescrito em
			 * Palavra faz retornar a palavra sorteada
			 * substituindo por '_' as letras não acertadas
			 * ou exibindo as letras já acertadas
			 */
			System.out.println(palavra);

			System.out.println();

			char letra;
			try {
				System.out.print("Digite uma letra: ");

				/**
				 * char 'letra' recebe a letra
				 * digitada no console
				 */
				letra = ConsoleUtils.lerLetra();

				/**
				 * Verifica se a letra já foi inserida anteriormente
				 */
				if (letrasDigitadas.contains(letra)) {
					throw new CaracterInvalidoException("Esta letra já foi utilizada.");
				}

				/**
				 * Caso a letra não seja repetida,
				 * a adiciona na lista de letras digitadas
				 */
				letrasDigitadas.add(letra);

				/**
				 * Verifica se a palavra a
				 * ser adivinhada possui a
				 * letra digitada
				 */
				if (palavra.possuiLetra(letra)) {
					System.out.println("Acertou uma letra.");
				} else if (erros < LIMITE_ERROS){
					/**
					 * incrementa o número de erros
					 * caso ainda hajam tentativas restantes
					 */
					erros++;

					/**
					 * Receb o número de tentativas restantes
					 */
					int errosRestantes = LIMITE_ERROS - erros;

					/**
					 * Mensagem a ser exibida caso erre,
					 * mas ainda hajam tentativas restantes,
					 * mostrando o número de tentativas que ainda restam.
					 */
					String mensagemErrosRestantes = "Errou a letra. Você ainda pode tentar %d %s";

					/**
					 * Formata a palavra 'vezes' exibida no final da mensagem
					 * que mostra o número de tentativas restantes. No caso de 1
					 * tentativa restante, mostra 'vez', do contrário, mostra 'vezes'.
					 */
					if (errosRestantes == 1) {
						System.out.format(mensagemErrosRestantes, errosRestantes, "vez");
						System.out.println(mensagemErrosRestantes);
					} else {
						System.out.format(mensagemErrosRestantes, errosRestantes, "vezes");
						System.out.println(mensagemErrosRestantes);
					}

					/**
					 * Imprime a mensagem com o número de tentativas restantes
					 */
					System.out.println(System.out.format(mensagemErrosRestantes, errosRestantes, " vezes"));
				} else {
					System.out.println("Limite de erros atingido. Você perdeu.");
					break;
				}

				System.out.println();

				/**
				 * No caso de acertar a palavra inteira,
				 * imprime mensagem e termina o looping do jogo.
				 */
				if (palavra.acertouPalavra()) {
					System.out.println("Acertou a palavra completa: " + palavra.getPalavraJogada());
					System.out.println("Fim do jogo");
					break;
				}

			} catch (CaracterInvalidoException e) {
				/**
				 * No caso de ocorrer uma exceção,
				 * exibe mensagem de erro e prossegue
				 * com o looping do jogo.
				 */
				System.out.println("Erro: " + e.getMessage());
				System.out.println();
			}
		}
	}
}