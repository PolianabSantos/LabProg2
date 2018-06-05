/**
 * A classe 'Aluno' representa um aluno que tem matrícula, nome e curso como atributos.
 * @author Walisson Farias - 117210712
 */

public class Aluno {
	
	private String matricula;
	private String nome;
	private String curso;
	
	/**
	 * Constrói um aluno a partir da sua mátricula, nome e curso
	 * Antes de construir, os métodos 'validaStringNaoVazia' e 'validaStringNaoNula' da classe Validador
	 * são utilizados para validar os 3 parâmetros informados.
	 * @param matricula A matrícula do aluno
	 * @param nome O nome do aluno
	 * @param curso O curso do aluno.
	 */
	
	public Aluno (String matricula, String nome, String curso) {
		
		Validador.validaStringNaoVazia(matricula, "matricula");
		Validador.validaStringNaoVazia(nome, "nome");
		Validador.validaStringNaoVazia(curso, "curso");
		Validador.validaStringNaoNula(matricula);
		Validador.validaStringNaoNula(nome);
		Validador.validaStringNaoNula(curso);
		
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	public String getMatricula() { return this.matricula; }
	public String getNome() { return this.nome; }
	public String getCurso() { return this.curso; }
	
	/**
	 * Gera o hashCode do aluno a partir da sua matrícula
	 * @return int HashCode do aluno
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	
	/**
	 * O método 'equals' avalia se dois objetos são iguais
	 * Para dois objetos serem iguais, ambos tem que ter a mesma matrícula
	 * @param obj O objeto a ser comparado com o aluno
	 * @return true or false referente ao teste de igualdade entre os alunos.
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	
	/**
	 * Gera uma representação em String dos dados do aluno
	 * contendo matrícula, nome e curso do aluno.
	 */

	public String toString() {
		return "Aluno: " + this.getMatricula() + " - " + this.getNome() + " - " + this.getCurso();
	}
	
}
