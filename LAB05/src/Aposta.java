public class Aposta {
	
	private String apostador;
	private double valor;
	private String previsao;
	
	public Aposta(String apostador, double valor, String previsao) {
		
		Validador.validaStringNaoVazia(apostador, "apostador");
		Validador.validaDoubleMaiorQue0(valor);
		Validador.validaStringNaoVazia(previsao, "previsão");
		Validador.validaStringNaoNula(apostador);
		Validador.validaStringNaoNula(previsao);
		
		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;
	}
	
	public String getApostador() { return this.apostador; }
	public double getValor() { return this.valor; }
	public String getPrevisao() { return this.previsao; }

	@Override
	public String toString() {
		return this.getApostador() + " - " + this.getValor() + " - " + this.getPrevisao();
	}
	
}
