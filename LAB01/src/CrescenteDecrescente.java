/**
* Laboratório de Programação 2 - Lab 1
*
* @author Walisson Nascimento de Farias - 117210716
*/

import java.util.Scanner;

public class CrescenteDecrescente {

    public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);

		int numero1 = sc.nextInt();
		int numero2 = sc.nextInt();
		int numero3 = sc.nextInt();
		int numero4 = sc.nextInt();
		
		if (numero2 > numero1 && numero3 > numero2 && numero4 > numero3) {
			System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
		}
		else if (numero2 < numero1 && numero3 < numero2 && numero4 < numero3) {
			System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
		}
		else {
			System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
		}
	}
}
