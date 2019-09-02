package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import util.MoedaConversor;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Qual é o valor do dolar? ");
		double dolarPreco = sc.nextDouble();
		
		System.out.println("Quantos dolares você vai comprar? ");
		double montante = sc.nextDouble();		
		
		double resultado = MoedaConversor.DolarParaReal(montante, dolarPreco);
		
		System.out.printf("Valor pago em R$ %.2f%n", resultado);
		sc.close();
	}

}
