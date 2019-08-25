package exercicios;
import java.util.Locale;
import java.util.Scanner;

public class HorasTrabalhadas {
	public static void main(String[] args) {

		int numero, horas;
		double salario, valorhora;
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o numero do funcionario");
		numero = sc.nextInt();
		System.out.println(numero);

		System.out.println("Digite o número de horas trabalhadas");
		horas = sc.nextInt();
		System.out.println(horas);

		System.out.println("Digite o valor da hora trabalhada");
		valorhora = sc.nextDouble();
		System.out.println(valorhora);

		salario = valorhora * horas;

		System.out.printf("O seu salario é: U$ %.2f%n",salario);
		sc.close();

	}
}
