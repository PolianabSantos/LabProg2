/**
 * 
 * A classe 'Contato' representa um contato que tem nome, sobrenome e telefone e pode retornar seus atributos.
 * Também retorna os dados do contato e o seu nome completo
 * @author Walisson Farias - 117210716
 *
 */

public class Contato {
	private String nome;
	private String sobrenome;
	private String telefone;
	
	/**
	 * 
	 * Antes de construir o Contato, verifica-se através do método 'validaStringNaoVazia'
	 * e 'validaStringNaoNula' da classe 'Validador', se os dados não apresentam dados inválidos,
	 * após isso constrói o Contato com nome, sobrenome e telefone 
	 * @param nome O nome do contato
	 * @param sobrenome O sobrenome do contato
	 * @param telefone O telefone do contato
	 * 
	 */
	
	public Contato (String nome, String sobrenome, String telefone) {
		Validador.validaStringNaoVazia(nome, "nome");
		Validador.validaStringNaoVazia(sobrenome, "sobrenome");
		Validador.validaStringNaoVazia(telefone, "telefone");
		
		Validador.validaStringNaoNula(nome);
		Validador.validaStringNaoNula(sobrenome);
		Validador.validaStringNaoNula(telefone);
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	@Override
	public String toString() {
		return this.getNome() + " " + this.getSobrenome() + " - " + this.getTelefone();
	}
	
	/** 
	*   Método que retorna o nome completo do contato
	*   @returns String contendo nome e sobrenome
	*/
	
	public String dadosContato() {
		return this.getNome() + " " + this.getSobrenome();
	}
	
}