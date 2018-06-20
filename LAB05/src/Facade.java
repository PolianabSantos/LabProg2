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
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		this.controle.cadastrarAposta(cenario, apostador, valor, previsao);
	}
	
	public int valorTotalDeApostas(int cenario) {
		return this.controle.valorTotalDeApostas(cenario);
	}
	
	public int totalDeApostas(int cenario) {
		return this.controle.totalDeApostas(cenario);
	}
	
	public String exibeApostas(int cenario) {
		return this.controle.exibeApostas(cenario);
	}
	
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.controle.fecharAposta(cenario, ocorreu);
	}
	
	public int getCaixaCenario(int cenario) {
		return controle.valorCaixaCenario(cenario);
	}
	
	public int getTotalRateioCenario(int cenario){
		return controle.valorRateio(cenario);
	 }
}