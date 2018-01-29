package jogodaforca.jogo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jogodaforca.exceptions.JogoDaForcaException;
import jogodaforca.utils.RandomUtils;

/**
 * Responsável pela lógica de leitura e sorteio
 * das palavras a serem adivinhadas durante o jogo
 * 
 * @author Rafael.Valle
 *
 */
public class Dicionario {

	/**
	 * Constante contendo nome do
	 * arquivo de texto com as palavras
	 * a serem adivinhas no jogo.
	 */
	private static final String DICIONARIO_FILE = "dicionario.txt";
	
	/**
	 * Instância de Dicionario
	 */
	private static Dicionario instancia;
	
	/**
	 * Lista de palavras disponíveis no jogo
	 */
	private List<String> palavras = new ArrayList<>();

	/**
	 * Construtor
	 * 
	 * Chama o método que carrega as
	 * palavras do arquivo no ArrayList palavras
	 */
	public Dicionario() {
		carregarPalavras();
	}
	
	/**
	 * Retorna instância de Dicionario
	 * 
	 * @return
	 */
	public static Dicionario getInstancia() {
		if (instancia == null) {
			instancia = new Dicionario();
		}
		return instancia;
	}
	
	/**
	 * Faz a leituras das palavras no arquivo
	 * e copia cada uma para o ArrayList palavras
	 */
	private void carregarPalavras() {
		
		Scanner scanner = null;
		
		try {
			/**
			 * Carrega o arquivo indicado na constante
			 */
			scanner = new Scanner(new File(DICIONARIO_FILE));
			
			/**
			 * Considerando que há apenas uma
			 * palavra por linha, carrega
			 * as palavras do arquivo no ArrayList
			 */
			while (scanner.hasNext()) {
				palavras.add(scanner.nextLine().trim());
			}
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
	
	/**
	 * Método que sorteia a palavra
	 * 
	 * @return : palavra sorteada
	 * @throws JogoDaForcaException : se não for encontrada palavra na lista
	 */
	public Palavra proximaPalavra() throws JogoDaForcaException {
		
		/**
		 * Verifica se a lista de palavras não está vazia
		 * e sorteia a palavra da lista que será adivinhada
		 */
		if (palavras.size() > 0) {
			/**
			 * Recebe um número randômico que
			 * varia entre 0 e o tamanho da ArrayList palavras - 1
			 */
			int pos = RandomUtils.gerarNumeroRandomico(0, palavras.size());
			
			Palavra palavra = new Palavra(palavras.get(pos));
			
			return palavra;
		} else {
			/**
			 * Lança uma exceção se não
			 * for encontrada palavra.
			 */
			throw new JogoDaForcaException("Sem palavra encontrada");
		}
	}
}
