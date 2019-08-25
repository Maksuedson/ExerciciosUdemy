package exercicios;

import java.util.Locale;
import java.util.Scanner;

public class TrianguloJava {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		double xA, xB, xC,  yA, yB, yC;
		

		System.out.println("Entre com as medidas do tri�ngulo X");
		xA = sc.nextDouble();
		xB = sc.nextDouble();
		xC = sc.nextDouble();

		System.out.println("Entre com as medidas do tri�ngulo Y");
		yA = sc.nextDouble();
		yB = sc.nextDouble();
		yC = sc.nextDouble();
		
		double p = (xA+xB+xC)/2.0;
		double Xarea = Math.sqrt(p*(p-xA)*(p-xB)*(p-xC));
		
		p = (yA+yB+yC)/2.0;
		double Yarea = Math.sqrt(p*(p-yA)*(p-yB)*(p-yC));
		
		System.out.printf("A medida dos lados do triangulo X: %.4f%n", Xarea);
		System.out.printf("A medida dos lados do triangulo X: %.4f%n", Yarea);

		sc.close();
	}
}
