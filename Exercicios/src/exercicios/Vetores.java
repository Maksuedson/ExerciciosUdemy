package exercicios;

import java.util.Scanner;

public class Vetores {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] nomes = new String[5];

		for (int i = 0; i < nomes.length; i++) {
			System.out.println("Digite um nome para inserir no vetor: ");
			nomes[i] = sc.nextLine();
		}

		System.out.println("Tamanho do vetor: " + nomes.length);

		for (int i = 0; i < nomes.length; i++) {
			System.out.println("--> : " + nomes[i]);
		}

//		for (String vetorNomes: nomes) {
//			System.out.println("--> : "+ vetorNomes);
//		}

		sc.close();
	}
}
