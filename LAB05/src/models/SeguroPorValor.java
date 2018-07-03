package models;

public class SeguroPorValor implements Seguro {
	
	private int valor;
	
	public SeguroPorValor(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	@Override
	public int valorAssegurado(int valorAposta) {
		return this.valor;
	}
	
	@Override
	public String toString() {
		return "ASSEGURADA (VALOR) - R$" + String.format("%.2f", (this.valor / 100.0));
	}
	
}
