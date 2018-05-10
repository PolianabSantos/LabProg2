/**
* Laboratório de Programação 2 - Lab 1
*
* @author Walisson Nascimento de Farias - 117210716
*/

import java.util.Scanner;

public class Wally {
	
    public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        
        while (true) {
			
	        String nomes = sc.nextLine();
	        String resultado = "?";
	        if (!(nomes.equals("wally"))) {
				
				String[] lista = nomes.split(" ");
				
				for (int i = 0;i < lista.length; i ++) {
				
					if (lista[i].length() == 5) {
						resultado = lista[i];
					}
				}
				System.out.println(resultado);
			}
			
			else {
				break;
			}
		}
	}
}
