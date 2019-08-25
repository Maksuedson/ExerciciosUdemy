package entidades;

public class Produto {
	public String nome;
	public int quantidade;
	public double preco;
	
	public double totalValorEstoque() {
		return preco * quantidade;
	}
	
	public void addProduto(int quantidade) {
		this.quantidade += quantidade;
	}
	
	public void removerProduto(int quantidade) {
		this.quantidade -= quantidade;
	}
	

	public String toString() {
		return nome + ", R$ " +String.format("%.2f", preco)+", "+ quantidade+ " unidades, Total R$ "+ String.format("%.2f", totalValorEstoque());				
	}
}
