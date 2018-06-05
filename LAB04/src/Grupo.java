import java.util.HashSet;
import java.util.Set;

/**
 * A classe 'Grupo' representa um grupo com nome e um conjunto de alunos.
 * @author Walisson Farias - 117210712
 */

public class Grupo {
	
	private String nome;
	private Set<Aluno> alunos;
	
	/**
	 * Constrói um grupo a partir do seu nome e inicia um conjunto de alunos.
	 * Antes de construir o grupo, os métodos 'validaStringNaoNula' e 'validaStringNaoVazia' da classe Validador
	 * são utilizados para validar o nome informado.
	 * @param nome O nome do grupo
	 */
	
	public Grupo (String nome) {
		
		Validador.validaStringNaoNula(nome);
		Validador.validaStringNaoVazia(nome, "nome");
		
		this.nome = nome;
		this.alunos = new HashSet<Aluno>();
	}
	
	public String getNome() { return this.nome; }
	
	/**
	 * O método 'alocarAluno' insere no conjunto 'alunos' o aluno dado como parâmetro.
	 * @param aluno contendo a referência ao objeto Aluno
	 */
	
	public void alocarAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	/**
	 * Gera o hashCode do grupo a partir do seu nome
	 * @return int HashCode do grupo
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	/**
	 * O método 'equals' avalia se dois objetos são iguais
	 * Para dois grupos serem iguais, ambos tem que ter o mesmo nome
	 * @param obj O objeto a ser comparado com o grupo
	 * @return true or false referente ao teste de igualdade entre os grupos.
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.toLowerCase().equals(other.nome.toLowerCase()))
			return false;
		return true;
	}
	
	/**
	 * O método 'toString' retorna uma String com a listagem dos alunos de um determinado grupo.
	 */
	
	@Override
	public String toString() {
		String listagemDosAlunos = "";
		listagemDosAlunos += "Alunos do grupo " + this.getNome() + ":" + System.lineSeparator();
		for (Aluno aluno : alunos) {
			listagemDosAlunos += "* " + aluno.toString() + System.lineSeparator();
		}
		return listagemDosAlunos;
	}
	
}
