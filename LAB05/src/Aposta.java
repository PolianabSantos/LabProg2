public class Aposta {

	private String apostador;
	private int valor;
	private String previsao;

	public Aposta(String apostador, int valor, String previsao) {

		Validador.validaStringNaoVazia(apostador, "apostador");
		Validador.validaInteiroMaiorQue0(valor);
		Validador.validaStringNaoVazia(previsao, "previsão");
		Validador.validaStringNaoNula(apostador);
		Validador.validaStringNaoNula(previsao);

		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;
	}

	public double getValorApostaReais() {
		return (double) this.valor / 100;
	}

	public int getValorApostaCentavos() {
		return this.valor;
	}

	public boolean getPrevisao() {
		if (this.previsao.equals("VAI ACONTECER")) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		if (previsao.equals("VAI ACONTECER")) {
			return this.apostador + " - R$" + getValorApostaReais() + " - " + "VAI ACONTECER" + System.lineSeparator();
		} else {
			return this.apostador + " - R$" + getValorApostaReais() + " - " + "NAO VAI ACONTECER" + System.lineSeparator();
		}
	}

}
