package exercicios;

import java.util.Scanner;

public class Senha {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the password");
		int a = sc.nextInt();

		while (a != 2002) {
			System.out.println("Senha invalida");
			a = sc.nextInt();
		}
		System.out.println("Acesso permitido");

		sc.close();
	}
}
