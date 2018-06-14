import java.util.ArrayList;
import java.util.List;

public class Controle {
	
	private int caixa;
	private double taxa;
	private List<Cenario> cenarios;
	
	public Controle(int caixa, double taxa) {
		this.caixa = caixa;
		this.taxa = taxa;
		this.cenarios = new ArrayList<>();
	}
	
	public int getCaixa() {
		return this.caixa;
	}

	public int cadastraCenario(String descricao) {
		Cenario cenario = new Cenario(descricao);
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
		this.cenarios.get(cenario-1).
