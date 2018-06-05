import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controle {
	
	private Map<String, Aluno> alunos;
	private Map<String, Grupo> grupos;
	private List<Aluno> alunosquerespondem;

	public Controle () {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.alunosquerespondem = new ArrayList<>();
	}
	
	public boolean verificaMatricula(String matricula) {
		int numero = Integer.parseInt(matricula);
		if (numero <= 0) { return false; }
		else { return true;	}
	}
	
	public Aluno adicionaAluno(String matricula, Aluno aluno) {
		return this.alunos.put(matricula, aluno);
	}
	
	public boolean existeAluno(String matricula) {
		return this.alunos.containsKey(matricula);
	}
	
	public Aluno consultarAluno(String matricula) {
	    return this.alunos.get(matricula);
	}
	
	public Grupo adicionaGrupo(String nome, Grupo grupo) {
		return this.grupos.put(nome, grupo);
	}
	
	public boolean existeGrupo(String nome) {
		return this.grupos.containsKey(nome.toLowerCase());
	}

	public void alocarAluno(String matricula, String nome) {
		this.grupos.get(nome).alocarAluno(this.alunos.get(matricula));
	}
	
	public String imprimirGrupo(String nome) {
		return this.grupos.get(nome).toString() + System.lineSeparator();
	}
	
	
}