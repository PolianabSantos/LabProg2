import enums.Estado;

public class CenarioBonus extends Cenario{

	private double bonus;
	
	public CenarioBonus(String descricao, int numeracao, double bonus) {
		super(descricao, numeracao);
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		String stringCenario = "";
		if (estado == Estado.FINALIZADO_OCORREU) {
			stringCenario += getNumeracao() + " - " + this.descricao + " - " + "Finalizado (ocorreu)" + " - " + this.bonus;
		} else if (estado == Estado.FINALIZADO_N_OCORREU) {
			stringCenario += getNumeracao() + " - " + this.descricao + " - " + "Finalizado (n ocorreu)" + " - " + this.bonus;
		} else if (estado == Estado.NAO_FINALIZADO) {
			stringCenario += getNumeracao() + " - " + this.descricao + " - " + "Nao finalizado" + " - " + this.bonus;;
		}
		return stringCenario;
	}

}