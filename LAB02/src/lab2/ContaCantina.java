package lab2;

/**
* Essa Classe serve para controlar os gastos de uma cantina.
* @author Walisson Farias - 117210716
*/

public class ContaCantina {
	
	private String nomeDaCantina;
	private int itensConsumidos;
	private int valorConta;
	private String[] listaDetalhes;
	private int controleDetalhe;

	 /**
	   * Constrói a conta da cantina a partir do seu nome
	   * Os itens consumidos e o valor da conta são declarados com valor 0
	   * @param nomeDaCantina o nome da cantina
	   */
	
	public ContaCantina(String nomeDaCantina) {
		this.nomeDaCantina = nomeDaCantina;
		this.itensConsumidos = 0;
		this.valorConta = 0;
		this.listaDetalhes = new String[5];
	}
	
	 /**
	   * O método 'cadastraLanche' serve para armazenar a quantidade
	   * de itens consumidos e o valor da conta.
	   * @param qtdItens a quantidade de itens consumidos
	   * @param valorCentavos o valor (em centavos) gastos.
	   */
		
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.cadastraLanche(qtdItens, valorCentavos, "");
	}
	
	 /**
	   * O método 'cadastraLanche' serve para armazenar a quantidade
	   * de itens consumidos e o valor da conta.
	   * O parâmetro 'detalhes' é adicionado a 'listaDetalhes' e a cada vez que isso é acontece,
	   * soma +1 na variável 'controleDetalhe', e, se essa variável for igual a 5, ela é zerada
	   * para que retorne os últimos 5 detalhes cadastrados.
	   * @param qtdItens a quantidade de itens consumidos
	   * @param valorCentavos o valor (em centavos) gastos.
	   * @param detalhes o detalhe que descreve o lanche.
	   */
	
	public void cadastraLanche(int qtdItens, int valorCentavos, String detalhes) {
		this.itensConsumidos += qtdItens;
		this.valorConta += valorCentavos;
		this.listaDetalhes[controleDetalhe] = detalhes;
		this.controleDetalhe++;
		if (controleDetalhe == 5) {
			this.controleDetalhe = 0;
		}
	}
	
	 /**
	   * O método 'pagaConta' serve para descontar os valores em centavos da Conta.
	   * @param valorCentavos o valor (em centavos) gastos.
	   */	
	
	public void pagaConta(int valorCentavos) {
		this.valorConta -= valorCentavos;
	}
    
	/**
    * Retorna a String que representa o controle de gastos da Cantina
    * A representação segue o formato: "Nome da Cantina - Quantidade de itens consumidos - O valor total da Conta”
    * @returns a representação em String do controle de gastos da Cantina.
   	*/
	
	public String toString() {
		return this.nomeDaCantina + " " + this.itensConsumidos + " " + this.valorConta;
	}
}
