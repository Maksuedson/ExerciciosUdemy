package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidade.Aluno;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Aluno aluno;
		aluno = new Aluno();
		
		System.out.println("Insira o nome do aluno: ");
		aluno.nome = sc.next();

		System.out.println("Insira as 03 notas do Aluno: ");
		aluno.grade1 = sc.nextDouble();
		aluno.grade2 = sc.nextDouble();
		aluno.grade3 = sc.nextDouble();
		
		System.out.println(aluno.nome);
		System.out.printf("Grade final: %.2f%n", aluno.gradeFinal());

		if (aluno.gradeFinal() < 170.0) {
			System.out.println("Reprovado");
			System.out.printf("Faltando %.2f PONTOS%n", aluno.pontosFaltando());
		} else {
			System.out.println("Aluno Aprovado");
		}
		sc.close();
	}

}
