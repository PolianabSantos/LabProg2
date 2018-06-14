public class Aposta {
	
	private String apostador;
	private double valor;
	private String previsao;
	
	public Aposta(String apostador, double valor, String previsao) {
		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;
	}

	@Override
	public String toString() {
		return this.apostador + " - " + this.valor + " - " + this.previsao;
	}
	
	public int valorTotalDeApostas() {
		int soma = 0;
		soma += valor;
		return soma;
	}
	
}
