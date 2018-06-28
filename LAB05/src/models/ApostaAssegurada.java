package models;
public class ApostaAssegurada extends Aposta {
	
	private String tipoSeguro;
	private int valorSeguro;
	private int custo;
	
	public ApostaAssegurada (String apostador, int valor, String previsao, String tipoSeguro, int valorSeguro, int custo) {
		super(apostador, valor, previsao);
		this.tipoSeguro = tipoSeguro;
		this.valorSeguro = valorSeguro;
		this.custo = custo;
	}
}
