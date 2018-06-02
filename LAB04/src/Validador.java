public class Validador {
	
	public static void validaStringNaoVazia(String dado, String mensagem) {
		if (dado.trim().isEmpty()) {
			throw new IllegalArgumentException("Argumento inválido, " + mensagem + " vazio(a)");
		}
	}
	
	public static void validaStringNaoNula(String dado) {
		if (dado == null) {
			throw new NullPointerException("Argumento inválido, valor nulo");
		}
	}	
}