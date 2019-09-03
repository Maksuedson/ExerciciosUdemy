package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidade.Conta;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Conta conta;
		
		System.out.println("Insira o numero da conta: ");
		int numero = sc.nextInt();
		
		System.out.println("Insira o titular:");
		sc.nextLine();
		String titular = sc.nextLine();
		
		
		System.out.println();
		System.out.println("Existe um deposito inicial (y/n)?");
		char resposta = sc.next().charAt(0);
		if (resposta == 'y') {
			System.out.println("Insira o valor do deposito inicial: ");
			double depositoInicial = sc.nextDouble();
			conta = new Conta(numero, titular, depositoInicial);
		}else {
			conta = new Conta(numero, titular);
		}
		
		System.out.println();
		System.out.println(conta);
		
		System.out.println("Deposite um valor: ");
		double montante = sc.nextDouble();
		
		conta.depositar(montante);
		
		System.out.println();
		System.out.println(conta);
		
		System.out.println("Efetue um saque: ");
		montante = sc.nextDouble();
		conta.sacar(montante);
		
		System.out.println();
		System.out.println(conta);
		
		sc.close();
	}

}
