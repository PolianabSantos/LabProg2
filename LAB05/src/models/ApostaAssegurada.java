package models;
public class ApostaAssegurada extends Aposta {
	
	private Seguro seguro;
	
	public ApostaAssegurada (String apostador, int valor, String previsao, int valorSeguro) {
		super(apostador, valor, previsao);
		this.seguro = new SeguroPorValor(valorSeguro);
	}
	
	public ApostaAssegurada(String apostador, int valor, String previsao, double taxa) {
		super(apostador, valor, previsao);
		this.seguro = new SeguroPorTaxa(taxa);
	}

	public void setSeguro(int valor) {
		this.seguro = new SeguroPorValor(valor);
	}

	public void setSeguro(double taxa) {
		this.seguro = new SeguroPorTaxa(taxa);
	}
	
	@Override
	public int valorPerdido() {
		return this.getValor() - this.seguro.valorAssegurado(this.getValor());
	}
	
	@Override
	public String toString() {
		return super.toString() + " - " + this.seguro.toString();
	}
	
}
