import enums.Estado;

public class CenarioBonus extends Cenario {

	private int bonus;

	public CenarioBonus(String descricao, int numeracao, int bonus) {
		super(descricao, numeracao);
		this.bonus = bonus;
	}

	public int getBonus() {
		return this.bonus;
	}

	@Override
	public int valorRateio(double taxa) {
		return super.valorRateio(taxa) + this.getBonus();
	}

	public double converteParaReais(int valor) {
		double d = (double) valor / 100;
		return d;
	}

	@Override
	public String toString() {
		String stringCenario = "";
		if (estado == Estado.FINALIZADO_OCORREU) {
			stringCenario += getNumeracao() + " - " + this.descricao + " - " + "Finalizado (ocorreu)" + " - R$ " + String.format("%.2f", converteParaReais(this.bonus));
		} else if (estado == Estado.FINALIZADO_N_OCORREU) {
			stringCenario += getNumeracao() + " - " + this.descricao + " - " + "Finalizado (n ocorreu)" + " - R$ " + String.format("%.2f", converteParaReais(this.bonus));
		} else if (estado == Estado.NAO_FINALIZADO) {
			stringCenario += getNumeracao() + " - " + this.descricao + " - " + "Nao finalizado" + " - R$ " + String.format("%.2f", converteParaReais(this.bonus));
		}
		return stringCenario;
	}

}