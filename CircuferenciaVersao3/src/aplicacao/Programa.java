package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import util.Calculator;

public class Programa {


	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira o raio");
		double raio = sc.nextDouble();

		double c = Calculator.circuferencia(raio);

		double v = Calculator.volume(raio);

		System.out.printf("Circuferência: %.2f%n", c);
		System.out.printf("Volume: %.2f%n", v);
		System.out.printf("PI: %.2f%n", Calculator.PI);

		sc.close();
	}


}
