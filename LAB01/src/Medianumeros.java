import java.util.Scanner;

public class Medianumeros {

    public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        
		float numero1 = sc.nextFloat();
		float numero2 = sc.nextFloat();
		
		float soma = numero1 + numero2;
		float media = soma / 2;
		
		if (media >= 7.0) {
			System.out.println("pass: True!");
		}
		else {
			System.out.println("pass: False!");
		}

	}

}
