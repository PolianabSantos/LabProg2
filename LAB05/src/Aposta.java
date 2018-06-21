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
	
	/**
	 * O método 'getValorApostaReais' divide o valor por 100
	 * e depois o retorna convertido para o tipo 'double'.
	 * @return double A representação do valor da aposta em Real
	 */

	public double getValorApostaReais() {
		return (double) this.valor / 100;
	}

	public int getValorApostaCentavos() {
		return this.valor;
	}
	
	/**
	 * O método 'getPrevisao' analisa se a previsao da aposta vai acontecer ou não vai acontecer
	 * Se a previsão for 'VAI ACONTECER' é retornado true, se não, é retornado false.
	 * @return boolean A representação da ocorrência ou não da previsão
	 */

	public boolean getPrevisao() {
		if (this.previsao.equals("VAI ACONTECER")) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * O método 'toString' retorna a representação em string de uma aposta.
	 * A representação varia de acordo com sua previsão.
	 */

	public String toString() {
		if (previsao.equals("VAI ACONTECER")) {
			return this.apostador + " - R$" + getValorApostaReais() + " - " + "VAI ACONTECER" + System.lineSeparator();
		} else {
			return this.apostador + " - R$" + getValorApostaReais() + " - " + "NAO VAI ACONTECER" + System.lineSeparator();
		}
	}

}
