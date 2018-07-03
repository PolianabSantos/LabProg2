package models;

public class SeguroPorTaxa implements Seguro {
	
	private double taxa;
	
	public SeguroPorTaxa(double taxa) {
		this.taxa = taxa;
	}
	
	public double getTaxa() {
		return this.taxa;
	}
	
	public int valorAssegurado(int valorAposta) {
		return (int) (Math.round(valorAposta * this.taxa));
	}
	
	@Override
	public String toString() {
		return "ASSEGURADA (TAXA) - " + (int) (this.taxa * 100) + "%";
	}
}
