/**
* Laboratório de Programação 2 - Lab 1
*
* @author Walisson Nascimento de Farias - 117210716
*/

import java.util.Scanner;

public class AvaliaPopulacao {
	
    public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        
        String numero = sc.nextLine();
        
        String[] lista = numero.split(" ");
        
        int soma = 0;
        for (int i = 0; i < lista.length; i ++) {

			soma += Integer.parseInt(lista[i]);
		}		
		
		double media = soma / lista.length;
		
        for (int i = 0; i < lista.length; i ++) {
			
			if (Integer.parseInt(lista[i]) > media) {
				
				System.out.print(lista[i] + " ");
			}
		}
    }
}
