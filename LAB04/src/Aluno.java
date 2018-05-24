public class Aluno {
	
	private String matricula;
	private String nome;
	private String curso;
	
	public Aluno(String matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	public String getMatricula() { return this.matricula; }
	public String getNome() { return this.nome; }
	public String getCurso() { return this.curso; }
	
	public String toString() {
		return "Aluno: " + this.getMatricula() + " - " + this.getNome() + " - " + this.getCurso();
	}
	
}
