import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		while (true) {
			
			System.out.println("(C)adastrar Contato");
			System.out.println("(L)istar Contato");
			System.out.println("(E)xibir Contato");
			System.out.println("(S)air");
			System.out.print(System.lineSeparator());
			Scanner sc = new Scanner(System.in);
			System.out.print("Opção> ");
			String opcao = sc.nextLine();
			
			if (opcao.equals("C")) {
				System.out.println("Posição: ");
			} else if (opcao.equals("L")) {
				//LLL
			} else if (opcao.equals("E")) {
				//EEE
			} else if (opcao.equals("S")) {
				break;
			} else {
				System.out.println("OPÇÃO INVÁLIDA");
			}
		}
	}
}