public class Facade {
	
	Controle controle;
	
	public void inicializa(int caixa, double taxa) {
		this.controle = new Controle(caixa, taxa);
	}
	
	public int recuperaCaixa() {
		return this.controle.getCaixa();
	}
	
	public int cadastrarCenario(String descricao) {
		return this.controle.cadastraCenario(descricao);
	}
	
	public String exibirCenario(int cenario) {
		return this.controle.exibeCenario(cenario);
	}
	
	public String exibirCenarios() {
		return this.controle.listarCenariosCadastrados();
	}
	
}