package controllers;

import easyaccept.EasyAccept;

public class Facade {

	Controle controle;

	public void inicializa(int caixa, double taxa) {
		this.controle = new Controle(caixa, taxa);
	}

	public int getCaixa() {
		return this.controle.getCaixa();
	}

	public int cadastrarCenario(String descricao) {
		return this.controle.cadastraCenario(descricao);
	}

	public int cadastrarCenario(String descricao, int bonus) {
		return this.controle.cadastraCenario(descricao, bonus);
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

	public int getTotalRateioCenario(int cenario) {
		return controle.valorRateio(cenario);
	}

	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorSeguro,
			int custo) {
		return this.controle.cadastrarAposta(cenario, apostador, valor, previsao, valorSeguro, custo);
	}

	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa,
			int custo) {
		return this.controle.cadastrarAposta(cenario, apostador, valor, previsao, taxa, custo);
	}

	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		return this.controle.alterarSeguroValor(cenario, apostaAssegurada, valor);
	}

	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		return this.controle.alterarSeguroTaxa(cenario, apostaAssegurada, taxa);
	}

	public void alterarOrdem(String ordem) {
		this.controle.alterarOrdem(ordem);
	}

	public String exibirCenarioOrdenado(int cenario) {
		return this.controle.exibirCenarioOrdenado(cenario);
	}

	public static void main(String[] args) {
		args = new String[] { "controllers.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt",
				"acceptance_test/us3_test.txt", "acceptance_test/us4_test.txt", "acceptance_test/us5_test.txt",
				"acceptance_test/us6_test.txt", "acceptance_test/us7_test.txt" };
		EasyAccept.main(args);
	}
}