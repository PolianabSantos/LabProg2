package lab2;

/**
* Essa classe é responsável por manter o registro da quantidade de espaço utilizado em 
* determinado laboratório.
* @author Walisson Farias - 117210716
*/

public class ContaLaboratorio {
	
	private String nomeLaboratorio;
	private int espacoOcupado;
	private int cota;
	
	 /**
	   * Constrói uma conta de laboratório a partir do seu nome
	   * Nesse construtor o espaço ocupado pelo usuário é 0
	   * O espaço disponível no sistema é de 2000
	   * @param nomeLaboratorio o nome do laboratório
	   */
	
	public ContaLaboratorio(String nomeLaboratorio) {
		this(nomeLaboratorio, 2000);
	}
	
	 /**
	   * Constrói também uma conta de laboratório a partir do seu nome e da sua cota
	   * Nesse construtor, a cota não é por padrão 2000
	   * @param nomeLaboratorio o nome do laboratório
	   * @param cota o limite de espaço disponível no sistema
	   */
	
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.espacoOcupado = 0;
		this.cota = cota;
	}
	
	 /**
	   * O método 'consomeEspaco' é responsável por aumentar o espaço ocupado pelo usuário.
	   * Recebe como parâmetro um valor inteiro e não retorna nada, apenas altera (dimunui)
	   * o valor atual do espaço ocupado.
	   */
	
	public void consomeEspaco(int mbytes) {
		this.espacoOcupado += mbytes;	
	}

	 /**
	   * O método 'liberaEspaco' é responsável por diminuir o espaço ocupado pelo usuário.
	   * Recebe como parâmetro um valor inteiro e não retorna nada, apenas altera (aumenta) o valor
	   * atual do espaço ocupado.
	   */
	
	public void liberaEspaco(int mbytes) {
		this.espacoOcupado -= mbytes;
	}
	
	 /**
	   * O método 'atingiuCota' retorna um valor boolean (verdadeiro ou falso).
	   * Se o espaço ocupado for maior ou igual a 2000 retorna verdadeiro, se for menor retorna falso.
	   * @returns true se o espaço for maior ou igual a 2000
	   * @returns false se o espaço for menor que 2000
	   */
	
	public boolean atingiuCota() {
		if (espacoOcupado >= 2000) {
			return true;
		} else {
			return false;
		}
	}
	
    /**
     * Retorna a String que representa os dados da Conta no laboratório
     * “Nome do laboratório Espaço Ocupado/Cota”.
     * @returns a representação em String dos dados da Conta do Laboratório.
     */
	
	public String toString() {
		return this.nomeLaboratorio + " " + this.espacoOcupado + "/" + this.cota;
	}
}