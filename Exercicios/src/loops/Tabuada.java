package loops;

import java.util.Scanner;

public class Tabuada {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite um numero para tabuada");
		int n = sc.nextInt();

		for (int i = 1; i <= 10; i++) {
			int produto = n * i;
			System.out.println(i + " X " + n + " = " + produto);
		}
		sc.close();
	}
}
