package lab2;

public class ContaCantina {
	
	private String nomeDaCantina;
	private int itensConsumidos;
	private int valorConta;

	public ContaCantina(String nomeDaCantina) {
		this.nomeDaCantina = nomeDaCantina;
		this.itensConsumidos = 0;
		this.valorConta = 0;
	}
	
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.itensConsumidos += qtdItens;
		this.valorConta += valorCentavos;
	}
	
	public void pagaConta(int valorCentavos) {
		this.valorConta -= valorCentavos;
	}
	
	public String toString() {
		return this.nomeDaCantina + " " + this.itensConsumidos + " " + this.valorConta;
	}

}
