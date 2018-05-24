import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
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
				
				// Se a matrícula já existe > Não cadastrar e exibir "MATRICULA JÁ CADASTRADA"
				
			} else if (opcao.equalsIgnoreCase("E")) {
				System.out.println();
			}
		}
	}
}