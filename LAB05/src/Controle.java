import java.util.HashMap;
import java.util.Map;

public class Controle {
	
	private int caixa;
	private double taxa;
	private int idAtual;
	private Map<Integer, Cenario> cenarios;
	
	
	public Controle(int caixa, double taxa) {
		this.caixa = caixa;
		this.taxa = taxa;
		this.cenarios = new HashMap<Integer, Cenario>();
		this.idAtual = 0;
	}
	
	public int getCaixa() {
		return this.caixa;
	}

	public int cadastraCenario(String descricao) {
		Cenario cenario = new Cenario(descricao);
		this.cenarios.put(idAtual, cenario);
		this.idAtual++;
		return this.idAtual;
	}
	
	public String exibeCenario(int cenario) {
	    return this.cenarios.get(cenario).toString();
	}
	
	public String listarCenariosCadastrados() {
		// Criar o arraylist dentro do metodo
		String listagem = "";
		for (int i = 0; i < cenarios.size(); i++) {
			listagem += i+1 + ". " + cenarios.get(i) + System.lineSeparator();
		}
		return listagem;
	}
	
}
