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
	 * O método 'adicionaAluno' serve para armazenar o aluno informado no mapa de alunos.
	 * @param matricula String contendo a matrícula do Aluno
	 * @param aluno contendo a referência ao objeto Aluno
	 * @return a confirmação do cadastro do aluno
	 */
	
	public Aluno adicionaAluno(String matricula, Aluno aluno) {
		return this.alunos.put(matricula, aluno);
	}
	
	/**
	 * O método 'verificaExistenciaAluno' verifica se no mapa 'alunos' contém o aluno referenciado pela matrícula.
	 * @param matricula A matrícula do aluno
	 * @return a confirmação da existência do aluno no mapa
	 */
	
	public boolean verificaExistenciaAluno(String matricula) {
		return this.alunos.containsKey(matricula);
	}
	
	/**
	 * O método 'consultarAluno' exibe um aluno referenciado pela matrícula
	 * @param matricula A matrícula do aluno
	 * @return representação do aluno referenciado pela matrícula
	 */
	
	public Aluno consultarAluno(String matricula) {
	    return this.alunos.get(matricula);
	}
	
	/**
	 * O método 'adicionaGrupo' serve para armazenar o grupo informado no mapa de grupos.
	 * @param nome String contendo o nome do Grupo;
	 * @param grupo contendo a referência do objeto Grupo
	 * @return a confirmação do cadastro do grupo
	 */
	
	public Grupo adicionaGrupo(String nome, Grupo grupo) {
		return this.grupos.put(nome, grupo);
	}
	
	/**
	 * O método 'verificaExistenciaGrupo' verifica se no mapa 'grupos' contém o grupo referenciado pelo nome.
	 * @param nome O nome do grupo
	 * @return a confirmação da existênia do grupo no mapa
	 */
	
	public boolean verificaExistenciaGrupo(String nome) {
		return this.grupos.containsKey(nome.toLowerCase());
	}

	/**
	 * O método 'alocarAluno' insere um dado aluno em um dado grupo
	 * @param matricula A matrícula do aluno
	 * @param nome O nome do grupo
	 */
	
	public void alocarAluno(String matricula, String nome) {
		this.grupos.get(nome).alocarAluno(this.alunos.get(matricula));
	}
	
	/**
	 * O método 'imprimirGrupo' imprime os alunos do grupo dado como parâmetro;
	 * @param nome O nome do grupo que contém os alunos a serem impressos
	 * @return representação .toString() dos alunos do grupo
	 */
	
	public String imprimirGrupo(String nome) {
		return this.grupos.get(nome).toString() + System.lineSeparator();
	}
	
	/**
	 * O método 'adicionaAlunoQueRespondeu' insere no ArrayList 'alunosqueRespondem'
	 * o aluno referenciado pela matrícula.
	 * @param matricula A matrícula do aluno
	 */
	
	public void adicionaAlunoQueRespondeu(String matricula) {
		this.alunosQueRespondem.add(this.alunos.get(matricula));
	}
	
	/**
	 * O método 'listarAlunosQueResponderam' lista todos os alunos, em ordem de inserção, que responderam
	 * as questões no quadro.
	 * @return A representação em string dos alunos que respnderam as questões no quadro.
	 */
	
	public String listarAlunosQueResponderam() {
		String listagem = "";
		for (int i = 0; i < alunosQueRespondem.size(); i++) {
			listagem += i+1 + ". " + alunosQueRespondem.get(i) + System.lineSeparator();
		}
		return listagem;
	}
	
}