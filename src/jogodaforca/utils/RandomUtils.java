package jogodaforca.utils;

/**
 * Classe geredora de n�meros rand�micos 
 * 
 * @author Rafael.Valle
 *
 */
public class RandomUtils {

	/**
	 * Retorna um n�mero inteiro de forma rand�mica,
	 * sendo que o maior poss�vel � max - 1.
	 * @param min : valor m�nimo retornado
	 * @param max : valor m�ximo do intervalo + 1
	 * @return : n�mero inteiro pseudo-aleat�rio
	 */
	public static int gerarNumeroRandomico(int min, int max) {
		int intervalo = max - min;
		return (int) (Math.random() * intervalo) + min;
	}
}
