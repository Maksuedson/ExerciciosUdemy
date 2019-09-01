package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidade.Retangulo;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Retangulo q;
		q = new Retangulo();

		System.out.println("Entre com a altura do quadrado");
		q.altura = sc.nextDouble();

		System.out.println("Entre com a largura do quadrado");
		q.largura = sc.nextDouble();

		System.out.printf("A área do quadrao é %.4f%n", q.area());
		System.out.printf("O perimetro do quadrao é %.4f%n", q.perimetro());
		System.out.printf("A diagonal do quadrao é %.4f%n", q.diagonal());
		
		sc.close();

	}

}
