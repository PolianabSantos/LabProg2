
public class Contato {
	private String nome;
	private String sobrenome;
	private String telefone;
	
	public Contato (String nome, String sobrenome, String telefone) {
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

	public String toString() {
		return this.getNome() + " " + this.getSobrenome() + " - " + this.getTelefone();
	}
	
	/** 
	*   Método que retorna uma string com o nome e o sobrenome do contato
	*   @returns String
	*/
	public String dadosContato() {
		return this.getNome() + " " + this.getSobrenome();
	}
	
}