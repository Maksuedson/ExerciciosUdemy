package aplicacao;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] mat = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = sc.nextInt();

			}
		}
		for (int i = 0; i < n; i++) {

			System.out.print(mat[i][i] + " ");
		}
		System.out.println("Diagonal");
		int contador = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] < 0) {
					contador++;
				}
			}
		}
		System.out.println();
		System.out.println("Números negativos " + contador);
		sc.close();
	}

}
