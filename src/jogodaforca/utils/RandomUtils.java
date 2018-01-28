package jogodaforca.utils;

/**
 * Classe geredora de números randômicos 
 * 
 * @author Rafael.Valle
 *
 */
public class RandomUtils {

	/**
	 * Retorna um número inteiro de forma randômica,
	 * sendo que o maior possível é max - 1.
	 * @param min : valor mínimo retornado
	 * @param max : valor máximo do intervalo + 1
	 * @return : número inteiro pseudo-aleatório
	 */
	public static int gerarNumeroRandomico(int min, int max) {
		int intervalo = max - min;
		return (int) (Math.random() * intervalo) + min;
	}
}
