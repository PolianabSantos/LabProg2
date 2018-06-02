import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controle {
	
	private Map<String, Aluno> alunos;
	private Map<String, Grupo> grupos;
	private List<String> alunosquerespondem;

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
	
	public Grupo adicionaGrupo(String nome, Grupo grupo) {
		return this.grupos.put(nome, grupo);
	}
	
	public boolean existeAluno(String matricula) {
		return this.alunos.containsKey(matricula);
	}
	
	public boolean existeGrupo(String nome) {
		return this.grupos.containsKey(nome);
	}
	
	public Aluno consultarAluno(String matricula) {
	    return this.alunos.get(matricula);
	}
	
	public void alocarAluno(String matricula, String nome) {
		this.grupos.get(nome).alocarAluno(this.alunos.get(matricula));
	}
	
	public String imprimirGrupo(String nome) {
		return this.grupos.get(nome).toString() + System.lineSeparator();
	}
	
	public boolean adicionarAlunoQueRespondeu(String matricula) {
	    return alunosquerespondem.add(matricula);
	}

	public String imprimirAlunosQueResponderam() {
		String listagem = "";
		for (int i = 0; i < alunosquerespondem.size(); i++) {
			listagem += alunosquerespondem.get(i) + System.lineSeparator();
		}
		return listagem;
	}

}