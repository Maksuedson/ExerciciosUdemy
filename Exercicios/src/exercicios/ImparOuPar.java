package exercicios;

import java.util.Scanner;

public class ImparOuPar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite um n�mero inteiro");
		int n = sc.nextInt();
		if (n % 2 == 0) {
			System.out.println("Este n�mero � par");
		}else {
			System.out.println("Este n�mero � impar");
		}
		sc.close();

	}

}
