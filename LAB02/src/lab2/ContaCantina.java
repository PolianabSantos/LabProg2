package lab2;

/**
* Essa Classe serve para controlar os gastos de uma cantina.
* @author Walisson Farias
*/

public class ContaCantina {
	
	 /**
	   * Atributo responsável pelo nome da Cantina.
	   */
	
	private String nomeDaCantina;
	
	 /**
	   * Atributo responsável pela quantidade de itens consumidos na cantina.
	   */

	private int itensConsumidos;
	
	 /**
	   * Atributo responsável pelo total de gastos realizados na cantina.
	   */
	
	private int valorConta;

	 /**
	   * Constrói a conta da cantina a partir do seu nome
	   * Os itens consumidos e o valor da conta são declarados com valor 0.
	   */
	
	public ContaCantina(String nomeDaCantina) {
		this.nomeDaCantina = nomeDaCantina;
		this.itensConsumidos = 0;
		this.valorConta = 0;
	}
	
	 /**
	   * O método 'cadastraLanche' serve para armazenar a quantidade
	   * de itens consumidos e o valor da conta.
	   * @param qtdItens a quantidade de itens consumidos
	   * @param valorCentavos o valor (em centavos) gastos.
	   */
		
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.itensConsumidos += qtdItens;
		this.valorConta += valorCentavos;
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
