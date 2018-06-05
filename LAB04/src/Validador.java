public class Validador {
	
	/**
	 * O métódo 'validaStringNaoVazia' analisa se uma variável do tipo String contém espaços vazios,
	 * caso contenha espaços é criada uma exceção.
	 * @param dado String que será analisada
	 * @param mensagem String que será adicionada na descrição do argumento inválido
	 */
	
	public static void validaStringNaoVazia(String dado, String mensagem) {
		if (dado.trim().isEmpty()) {
			throw new IllegalArgumentException("Argumento inválido, " + mensagem + " vazio(a)");
		}
	}
	
	/**
	 * O método 'validaStringNaoNula' analisa se uma variável do tipo String é nula,
	 * caso seja nula, é criada uma exceção.
	 * @param dado String que será analisada.
	 */
	
	public static void validaStringNaoNula(String dado) {
		if (dado == null) {
			throw new NullPointerException("Argumento inválido, valor nulo");
		}
	}	
}