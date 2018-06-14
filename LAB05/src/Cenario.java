import java.util.ArrayList;
import java.util.List;

public class Cenario {
	
	private int id;
	private String descricao;
	private String estado;
	private List<Aposta> apostas;
	
	public Cenario(String descricao) {
		this.id = id;
		this.descricao = "";
		this.estado = "Não finalizado";
		this.apostas = new ArrayList<>();
	}

	@Override
	public String toString() {
		return this.id + " - " + this.descricao + " - " + this.estado;
	}
	
	public void cadastraAposta(String nomeApostador, int valorAposta, String previsao) {
		Aposta aposta = new Aposta(nomeApostador, valorAposta, previsao);
		this.apostas.add(aposta);
	}

}
