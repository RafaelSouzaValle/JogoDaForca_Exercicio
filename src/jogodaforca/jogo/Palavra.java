package jogodaforca.jogo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Responsável pela palavra sorteada pelo jogo
 * 
 * @author Rafael.Valle
 *
 */
public class Palavra {

	/**
	 * Caractere exibido no local da letra não acertada
	 */
	public static final char CARACTERE_ = '_';
	
	/**
	 * Palavra a ser acertada
	 */
	private String palavraJogada;
	
	/**
	 * Coleção de caracteres já acertados/adivinhados
	 */
	private Set<Character> caracteresAcertados = new HashSet<>();

	/**
	 * Construtor
	 * 
	 * @param palavraJogada : palavra a ser adivinhada/acertada
	 */
	public Palavra(String palavraJogada) {
		this.palavraJogada = palavraJogada.toUpperCase();
	}
	
	/**
	 * Sobrescreve método toString para retornar a palavra,
	 * substituindo as letras não descobertas por CARACTERE_
	 */
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		
		/**
		 * Array de caracteres formado pelas letras da palavra
		 * a ser acertada/jogada
		 */
		char[] letrasArray = palavraJogada.toCharArray();
		
		
		for(int i = 0; i < letrasArray.length; i++) {
			char c = letrasArray[i];
			
			/**
			 * Condição : Se o HashSet caracteresAcertados
			 * possuir o char c, então o StringBuilder sb
			 * acrescenta este caractere. Do contrário,
			 * sb acrescenta a constante CARACTERE_
			 */
			if (caracteresAcertados.contains(c)) {
				sb.append(c);
			} else {
				sb.append(CARACTERE_);
			}
			
			sb.append(" ");
		}
		
		/**
		 * Retorna o StringBuilder sb no tipo String,
		 * removendo o espaço em branco ao final
		 */
		return sb.toString().trim();
	}
	
	/**
	 * Retorna o número de letras
	 * da palavra a ser adivinhada/jogada
	 * 
	 * @return : inteiro (número de letras)
	 */
	public int comprimento() {
		return palavraJogada.length();
	}
	
	/**
	 * Método para verificar condição : se a letra
	 * digitada pelo jogador existe na palavra
	 * a ser acertada/jogada
	 * 
	 * @param letra : letra fornecida pelo jogados
	 * @return : true se a letra fornecida existir na palavra jogada,
	 * 			 do contrário, retorna false
	 */
	public boolean possuiLetra(char letra) {
		
		if (palavraJogada.indexOf(letra) > -1) {
			caracteresAcertados.add(letra);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Itera sobre a palavra a ser acertada
	 * e verifica se o jogador acertou
	 * todas as letras
	 * 
	 * @return true : quando jogador acerta todas as letras,
	 * 				 do contrário, false.
	 */
	public boolean acertouPalavra () {
		/**
		 * Carrega palavra jogada em um Array de char
		 */
		char[] letrasArray = palavraJogada.toCharArray();
		
		/**
		 * Coleção que conterá as letras do Array de char
		 */
		Set<Character> letras = new HashSet<>();
		
		/**
		 * Itera sobre o array de char
		 * que contém os caracteres da palavra certa,
		 * adicionando os caracteres do array
		 * na coleção HashSet de letras
		 */
		for (int i = 0; i < letrasArray.length; i++) {
			letras.add(letrasArray[i]);
		}
		
		/**
		 * Retorna se o Array de caracteres
		 * é igual a coleção de letras certas
		 */
		return letras.equals(caracteresAcertados);
	}
	
	/**
	 * Getter
	 * @return : palavra jogada/a ser adivinhada
	 */
	public String getPalavraJogada () {
		return palavraJogada;
	}
}
