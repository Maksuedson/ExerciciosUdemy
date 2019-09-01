package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import util.Calculator;

public class Programa {


	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Calculator calc = new Calculator();
		
		System.out.println("Insira o raio");
		double raio = sc.nextDouble();

		double c = calc.circuferencia(raio);

		double v = calc.volume(raio);

		System.out.printf("Circuferência: %.2f%n", c);
		System.out.printf("Volume: %.2f%n", v);
		System.out.printf("PI: %.2f%n", calc.PI);

		sc.close();
	}


}
