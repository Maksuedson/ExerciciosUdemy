package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		
		Produto produto = new Produto();		

		System.out.println("Entre com os dados do produto");
		System.out.print("Nome: ");
		produto.nome = sc.nextLine();
		
		System.out.print("Preço: ");
		produto.preco = sc.nextDouble();

		
		System.out.print("Quantidade no estoque: ");
		produto.quantidade = sc.nextInt();
		
		System.out.println("Dados do produto: "+produto);
		
		
		System.out.println();
		System.out.println("Entre com a quantidade de produtos para adicionar no estoque");
		int quantidade = sc.nextInt();
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
