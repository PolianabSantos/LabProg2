import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsável por controlar Alunos e Grupos
 * Nessa classe contém os mapas e listas de alunos/grupos
 * e os métodos para controlá-los.
 * @author Walisson Farias - 117210716
 */

public class Controle {
	
	private Map<String, Aluno> alunos;
	private Map<String, Grupo> grupos;
	private List<Aluno> alunosQueRespondem;
	
	/**
	 * Constrói 'Controle' sem parâmetros
	 * Nele inicia-se os mapas de alunos e grupos e a
	 * lista de alunos que respondem questões no quadro.
	 */
	
	public Controle () {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.alunosQueRespondem = new ArrayList<>();
	}
	
	/**
	 * O método 'verificaMatriculaValida' serve para verificar se a matrícula é maior ou igual a 0
	 * Como a matrícula é do tipo String, primeiro converte-se para uma variável do tipo inteiro, para depois fazer a análise.
	 * @param matricula String contendo a mátricula do aluno
	 * @return boolean True ou False
	 */
	
	public boolean verificaMatriculaValida(String matricula) {
		int numero = Integer.parseInt(matricula);
		if (numero <= 0) { return false; }
		else { return true;	}
	}
	
	/**
	 * O método 'adicionaAluno' serve para armazenar o aluno informado no array de alunos.
	 * @param matricula String contendo a matrícula do Aluno
	 * @param aluno 
	 * @return
	 */
	
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
	
	public void adicionaAlunoQueRespondeu(String matricula) {
		this.alunosQueRespondem.add(this.alunos.get(matricula));
	}
	
	public String listarAlunosQueResponderam() {
		String listagem = "";
		for (int i = 0; i < alunosQueRespondem.size(); i++) {
			listagem += i+1 + ". " + alunosQueRespondem.get(i) + System.lineSeparator();
		}
		return listagem;
	}
	
}