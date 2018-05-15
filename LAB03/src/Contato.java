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
	
	/**
	 * Gera o hashCode do contato a partir do seu nome
	 * @return int O hashCode do contato
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * O 'equals' avalia se dois objetos são iguais
	 * Para dois objetos serem iguais, ambos tem que ter o mesmo nome
	 * @param obj O objeto a ser comparado com o contato
	 * @return true or false referente ao teste de igualdade entre os contatos.
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}