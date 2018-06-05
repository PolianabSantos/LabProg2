import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		Controle controle = new Controle();
		
		while (true) {
			
			System.out.println("(C)adastrar Aluno");
			System.out.println("(E)xibir Aluno");
			System.out.println("(N)ovo Grupo");
			System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
			System.out.println("(R)egistrar Aluno que Respondeu");
			System.out.println("(I)mprimir Alunos que Responderam");
			System.out.println("(O)ra, vamos fechar o programa!");
			System.out.print(System.lineSeparator());
			Scanner sc = new Scanner(System.in);
			System.out.print("Opção> ");
			String opcao = sc.nextLine();
			
			if (opcao.equalsIgnoreCase("C")) {
				System.out.print("Matrícula: ");
				String matricula = sc.nextLine();
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				System.out.print("Curso: ");
				String curso = sc.nextLine();
				Aluno aluno = new Aluno (matricula, nome, curso);
				if (controle.verificaMatriculaValida(matricula)) {
					if (controle.existeAluno(matricula)) {
						System.out.println("MATRÍCULA JÁ CADASTRADA!" + System.lineSeparator());
					}
					else {
						controle.adicionaAluno(matricula, aluno);
						System.out.println("CADASTRO REALIZADO!" + System.lineSeparator());
					}
				} else { System.out.println("MATRÍCULA INVÁLIDA!" + System.lineSeparator()); }

			} else if (opcao.equalsIgnoreCase("E")) {
				System.out.print("Matrícula: ");
				String matricula = sc.nextLine();
				if (controle.existeAluno(matricula)) {
					System.out.println(controle.consultarAluno(matricula)  + System.lineSeparator());
				}
				else { System.out.println("Aluno não cadastrado."  + System.lineSeparator()); }

			} else if (opcao.equalsIgnoreCase("N")) {
				System.out.print("Grupo: ");
				String nome = sc.nextLine();
				Grupo grupo = new Grupo(nome);
				if (controle.existeGrupo(nome)) {
					System.out.println("GRUPO JÁ CADASTRADO!" + System.lineSeparator());
				}
				else {
					controle.adicionaGrupo(nome.toLowerCase(), grupo);
					System.out.println("CADASTRO REALIZADO!" + System.lineSeparator());
				}

			} else if (opcao.equalsIgnoreCase("A")) {
				System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
				String alocarimprimir = sc.nextLine();
				if (alocarimprimir.equalsIgnoreCase("A")) {
					System.out.print("Matrícula: ");
					String matricula = sc.nextLine();
					System.out.print("Grupo: ");
					String nome = sc.nextLine();
					if (controle.existeAluno(matricula)) {
						if (controle.existeGrupo(nome)) {
							controle.alocarAluno(matricula, nome.toLowerCase());
							System.out.println("ALUNO ALOCADO!" + System.lineSeparator());
						} else {
							System.out.println("Grupo não cadastrado." + System.lineSeparator());
						}
					} else {
						System.out.println("Aluno não cadastrado.");
						if (!(controle.existeGrupo(nome))) {
							System.out.println("Grupo não cadastrado." + System.lineSeparator());
						}
					}
				} else if (alocarimprimir.equalsIgnoreCase("I")) {
					System.out.print("Grupo: ");
					String nome_grupo = sc.nextLine();
					if (controle.existeGrupo(nome_grupo.toLowerCase())) {
						System.out.print(controle.imprimirGrupo(nome_grupo.toLowerCase()));
					} else { System.out.println("Grupo não cadastrado." + System.lineSeparator()); }
				}

			} else if (opcao.equalsIgnoreCase("R")) {
				System.out.print("Matricula: ");
				String matricula = sc.nextLine();
				if (controle.existeAluno(matricula)) {
					controle.adicionaAlunoQueRespondeu(matricula);
					System.out.println("ALUNO REGISTRADO!"+ System.lineSeparator());
				}
				else { System.out.println("Aluno não cadastrado." + System.lineSeparator()); }

			} else if (opcao.equalsIgnoreCase("I")) {
				System.out.println(controle.listarAlunosQueResponderam());

			} else if (opcao.equalsIgnoreCase("O")) {
				break;
			}
		}
	}
}