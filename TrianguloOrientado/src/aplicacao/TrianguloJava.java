package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidade.Triangulo;

public class TrianguloJava {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Triangulo x, y;
		x= new Triangulo();
		y= new Triangulo();

		

		System.out.println("Entre com as medidas do triângulo X");
		x.a = sc.nextDouble();
		x.b = sc.nextDouble();
		x.c = sc.nextDouble();

		System.out.println("Entre com as medidas do triângulo Y");
		y.a = sc.nextDouble();
		y.b = sc.nextDouble();
		y.c = sc.nextDouble();
		
		double Xarea = x.area();
		double Yarea = y.area();
		
		
		System.out.printf("A medida dos lados do triangulo X: %.4f%n", Xarea);
		System.out.printf("A medida dos lados do triangulo X: %.4f%n", Yarea);

		sc.close();
	}
}
