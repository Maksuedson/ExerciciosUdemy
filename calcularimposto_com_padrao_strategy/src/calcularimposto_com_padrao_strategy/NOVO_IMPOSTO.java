package calcularimposto_com_padrao_strategy;

public class NOVO_IMPOSTO implements Imposto {
	private double valor;
	
	public NOVO_IMPOSTO (double valor) {
		this.valor = valor;
	}

	@Override
	public double calcular() {
		return this.valor * 0.50;
	}

}
