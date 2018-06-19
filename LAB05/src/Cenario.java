import java.util.ArrayList;
import java.util.List;

public class Cenario {
	
	private String descricao;
	private String estado;
	private List<Aposta> apostas;
	
	public Cenario(String descricao) {
		this.descricao = "";
		this.estado = "Não finalizado";
		this.apostas = new ArrayList<>();
	}

	public String getDescricao() { return this.descricao; }
	public String getEstado() {	return this.estado;	}
	
	public void cadastraAposta(String nomeApostador, int valorAposta, String previsao) {
		Aposta aposta = new Aposta(nomeApostador, valorAposta, previsao);
		this.apostas.add(aposta);
	}

	public int valorTotalDeApostas() {
		int valorTotal = 0;
		for (Aposta aposta : this.apostas) {
				valorTotal += aposta.getValor();			
			}
		return valorTotal;
	}
	
	public int totalDeApostas(int cenario) {
		return this.apostas.size();
	}
	
	public String exibeApostas(int cenario) {
		String listagem = "";
		for (Aposta aposta : apostas) {
			listagem += aposta.toString() + System.lineSeparator();
		}
		return listagem;
	}
	
	@Override
	public String toString() {
		return " - " + this.getDescricao() + " - " + this.getEstado();
	}

	public void fechaAposta(int cenario, boolean ocorreu) {
		if (ocorreu) { this.estado = "Finalizado (Ocorreu).";
		} else { this.estado = "Finalizado (Não ocorreu)."; }
	}
	
	public int getCaixaCenario(int cenario) {
		return 1;
		
	}

}
