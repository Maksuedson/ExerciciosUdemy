package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidade.Funcionario;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Funcionario func = new Funcionario();
		
		System.out.println("Insira o nome do Funcionário: ");
		func.nome = sc.nextLine();
		
		
		System.out.println("Insira o salário bruto: ");
		func.salarioBruto = sc.nextDouble();
		
		System.out.println("Insira o imposto");
		func.taxa = sc.nextDouble();
		
		System.out.println(func);
		
		System.out.println();
		

		func.SalarioLiquido();
		System.out.println("Entre com a porcentagem de acrescimo");
		double porcentagem = sc.nextDouble();		
		func.aumentarSalario(porcentagem);
		
		System.out.println("Dados atualizados"+func);
		
		sc.close();

	}

}
