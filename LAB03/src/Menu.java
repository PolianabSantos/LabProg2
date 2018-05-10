import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		
		while (true) {
			
			System.out.println("(C)adastrar Contato");
			System.out.println("(L)istar Contato");
			System.out.println("(E)xibir Contato");
			System.out.println("(S)air");
			System.out.print(System.lineSeparator());
			Scanner sc = new Scanner(System.in);
			System.out.print("Opção> ");
			String opcao = sc.nextLine();
			
			if (opcao.equalsIgnoreCase("C")) {
				System.out.print("");
				System.out.print("Posição: ");
				int posicao = sc.nextInt();
				sc.nextLine();
				if (!agenda.verificaPosicao(posicao)) {
					System.out.println("POSIÇÃO INVÁLIDA!");
				} else {
					System.out.print("Nome: ");
					String nome = sc.nextLine();
					System.out.print("Sobrenome: ");
					String sobrenome = sc.nextLine();
					System.out.print("Telefone: ");
					String telefone = sc.nextLine();
					agenda.cadastrarContato(nome, sobrenome, telefone, posicao);
					System.out.println("CADASTRO REALIZADO!" + System.lineSeparator());
				}
			} else if (opcao.equalsIgnoreCase("L")) {
				System.out.println(agenda.listarContatos());
			} else if (opcao.equalsIgnoreCase("E")) {
				System.out.print("Contato> ");
				int posicao = sc.nextInt();
				if (agenda.verificaContato(posicao)) {
					System.out.println(agenda.exibirContato(posicao));
				} else {
					System.out.println("POSIÇÃO INVÁLIDA!");				
				}
			} else if (opcao.equalsIgnoreCase("S")) {
				break;
			} else {
				System.out.println("OPÇÃO INVÁLIDA");
			}
		}
	}
}