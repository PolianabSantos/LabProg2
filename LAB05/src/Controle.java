import java.util.ArrayList;
import java.util.List;

public class Controle {
	
	private int numeracao;
	private int caixa;
	private double taxa;
	private List<Cenario> cenarios;
	
	public Controle(int caixa, double taxa) {
		this.caixa = caixa;
		this.taxa = taxa;
		this.cenarios = new ArrayList<>();
		this.numeracao = 0;
	}
	
	public int getCaixa() {
		return this.caixa;
	}

	public int cadastraCenario(String descricao) {
		this.numeracao++;
		Cenario cenario = new Cenario(descricao, numeracao);
		this.cenarios.add(cenario);
		return this.cenarios.size();
	}
	
	public String exibeCenario(int cenario) {
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
		this.cenarios.get(cenario-1).cadastraAposta(nomeApostador, valorAposta, previsao);
	}
	
	public int valorTotalDeApostas(int cenario) {
		return this.cenarios.get(cenario-1).valorTotalDeApostas();
	}
	
	public int totalDeApostas(int cenario) {
		return this.cenarios.get(cenario-1).totalDeApostas(cenario);
	}
	
	public String exibeApostas(int cenario) {
		return this.cenarios.get(cenario-1).exibeApostas(cenario);
	}
	
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.cenarios.get(cenario-1).fechaAposta(cenario, ocorreu);
	}
	
}

