package exercicios;

import java.util.Scanner;

public class NumeroMaiorFunction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter 3 numbers");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int Higher = max(a, b, c);
		showResult(Higher);
		
		sc.close();
	}

	public static int max(int x, int y, int z) {
		int aux;
		if (x > y && x > z) {
			aux = x;
		} else if (y > z) {
			aux = y;
		} else {
			aux = z;
		}
		return aux;
	}

	public static void showResult(int value) {
		System.out.println("Higher = " + value);
	}
}
