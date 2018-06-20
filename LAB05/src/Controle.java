import java.util.ArrayList;
import java.util.List;

import enums.Estado;

public class Controle {

	private int numeracao;
	private int caixa;
	private double taxa;
	private List<Cenario> cenarios;

	public Controle(int caixa, double taxa) {
		if (caixa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
		if (taxa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
		
		this.caixa = caixa;
		this.taxa = taxa;
		this.cenarios = new ArrayList<>();
		this.numeracao = 0;
	}

	public int getCaixaCenario() {
		return this.caixa;
	}

	public double getTaxa() {
		return this.taxa;
	}

	public int cadastraCenario(String descricao) {
		this.numeracao++;
		Cenario cenario = new Cenario(descricao, numeracao);
		this.cenarios.add(cenario);
		return this.cenarios.size();
	}

	public String exibeCenario(int cenario) {
		if (cenario < 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		}
		if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		return this.cenarios.get(cenario-1).toString();
	}

	public String listarCenariosCadastrados() {
		String listagem = "";
		for (Cenario cenario : cenarios) {
			listagem += cenario.toString() + System.lineSeparator();
		}
		return listagem;
	}

	public void cadastrarAposta(int cenario, String nomeApostador, int valorAposta, String previsao) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		}
		if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		if (nomeApostador == null || (nomeApostador.trim().equals(""))) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		if (valorAposta <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao == null || (previsao.trim().equals(""))) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}
		if (!(previsao.equals("VAI ACONTECER") || (previsao.equals("N VAI ACONTECER")))) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
		
		this.cenarios.get(cenario - 1).cadastraAposta(nomeApostador, valorAposta, previsao);
	}

	public int valorTotalDeApostas(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		}
		if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		return this.cenarios.get(cenario - 1).valorTotalDeApostas();
	}

	public int totalDeApostas(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		}
		if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
		return this.cenarios.get(cenario - 1).totalDeApostas(cenario);
	}

	public String exibeApostas(int cenario) {
		return this.cenarios.get(cenario - 1).exibeApostas(cenario);
	}

	public void fecharAposta(int cenario, boolean ocorreu) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		}
		if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		if (this.cenarios.get(cenario).getEstado() == Estado.NAO_FINALIZADO) {
			if (ocorreu) {
				this.cenarios.get(cenario).setEstado(Estado.FINALIZADO_OCORREU);
			} else {
				this.cenarios.get(cenario).setEstado(Estado.FINALIZADO_N_OCORREU);
			}
		} else {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
	}

	public int valorCaixaCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		}
		if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		return this.cenarios.get(cenario).valorCaixaCenario(getTaxa(), cenario);
	}

	public int valorRateio(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		}
		if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
		/**if (this.cenarios.get(cenario).getEstado() == Estado.NAO_FINALIZADO) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}**/
		return this.cenarios.get(cenario).valorRateio(getTaxa(), cenario);
	}

}
