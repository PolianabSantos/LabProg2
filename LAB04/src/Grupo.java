import java.util.HashSet;
import java.util.Set;

public class Grupo {
	
	private String nome;
	private Set<Aluno> alunos;
	
	public Grupo (String nome) {
		
		Validador.validaStringNaoNula(nome);
		Validador.validaStringNaoVazia(nome, "nome");
		
		this.nome = nome;
		this.alunos = new HashSet<Aluno>();
	}
	
	public String getNome() { return this.nome; }
	
	public void alocarAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

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
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
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
