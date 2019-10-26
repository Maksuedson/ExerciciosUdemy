package exercicios;

import java.util.Scanner;

public class Senha2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the password");
		int a = sc.nextInt();

		for (int i = 0; i < 3; i++) {
			if (a != 2022) {
				System.out.println("Senha invalida");
				a = sc.nextInt();
			} else {
				System.out.println("Senha Correta");
			}
		}
		if (a !=2022) {
			System.out.println("Acesso negado");
		}else {
			System.out.println("Acesso permitido");	
		}

		

		sc.close();
	}
}
