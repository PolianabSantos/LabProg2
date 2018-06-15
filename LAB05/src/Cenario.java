import java.util.ArrayList;
import java.util.List;

public class Cenario {
	
	private int id;
	private String descricao;
	private String estado;
	private List<Aposta> apostas;
	private boolean ocorreu;
	
	public Cenario(String descricao) {
		this.id = id;
		this.descricao = "";
		this.estado = "Não finalizado";
		this.apostas = new ArrayList<>();
		this.ocorreu = false;
	}
	
	public int getId() { return this.id; }
	public String getDescricao() { return this.descricao; }
	public String getEstado() { return this.estado; }
	
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
		return this.getId() + " - " + this.getDescricao() + " - " + this.getEstado();
	}

	public void fechaAposta(boolean ocorreu) {
		if (ocorreu) {
			int 
			for (Aposta aposta : apostas) {
				
			}
		}
		
	}
	

}
