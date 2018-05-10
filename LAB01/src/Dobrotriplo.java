import java.util.Scanner;

public class Dobrotriplo {

    public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        
		int numero = sc.nextInt();
		
		int Y = (numero * 2);
		int Z = (numero * 3);

		System.out.println("dobro: " + Y + "," + " triplo: " + Z);

	}

}
