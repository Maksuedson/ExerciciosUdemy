package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);		

		System.out.println("Entre com os dados do produto");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		
		System.out.print("Preço: ");
		double preco = sc.nextDouble();
		
		System.out.print("Quantidade no estoque: ");
		int quantidade = sc.nextInt();
		
		Produto produto = new Produto(nome, quantidade, preco);		
								
		System.out.println("Dados do produto: "+produto);		
		
		System.out.println();
		System.out.println("Entre com a quantidade de produtos para adicionar no estoque");
		quantidade = sc.nextInt();
		produto.addProduto(quantidade);		
		System.out.println("Dados do produto: "+produto);
		
		
		System.out.println();
		System.out.println("Entre com a quantidade de produtos para retirar do estoque");
		quantidade = sc.nextInt();
		produto.removerProduto(quantidade);
		System.out.println("Dados do produto: "+produto);
		
		
		sc.close();

	}

}
