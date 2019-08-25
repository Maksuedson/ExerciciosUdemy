package exercicios;

import java.util.Scanner;

public class ImparOuPar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite um número inteiro");
		int n = sc.nextInt();
		if (n % 2 == 0) {
			System.out.println("Este número é par");
		}else {
			System.out.println("Este número é impar");
		}
		sc.close();

	}

}
