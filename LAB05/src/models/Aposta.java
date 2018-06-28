package models;

/**
 * Representação de uma Aposta que tem como atributos: Nome do apostador,
 * valor da aposta e previsao.
 * @author Walisson Farias - 117210716
 */

public class Aposta {

	private String apostador;
	private int valor;
	private String previsao;

	/**
	 * Constrói uma Aposta com os parâmetros dados: (apostador, valor, previsao)
	 * @param apostador O nome do apostador (String)
	 * @param valor O valor da aposta (inteiro)
	 * @param previsao A previsao do apostador (String)
	 */
	
	public Aposta(String apostador, int valor, String previsao) {
		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao;
	}
	
	public String getApostador() {
		return this.apostador;
	}
	
	public boolean getPrevisao() {
		if (this.previsao.equals("VAI ACONTECER")) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getValor() {
		return this.valor;
	}
	
	/**
	 * O método 'toString' retorna a representação em string de uma aposta.
	 * A representação varia de acordo com sua previsão.
	 */

	public String toString() {
		if (this.getPrevisao() == true) {
			return this.apostador + " - R$" + (this.getValor() / 100.0) + " - " + "VAI ACONTECER" + System.lineSeparator();
		} else {
			return this.apostador + " - R$" + (this.getValor() / 100.0) + " - " + "NAO VAI ACONTECER" + System.lineSeparator();
		}
	}

}
