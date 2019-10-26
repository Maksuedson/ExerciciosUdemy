package calcularimposto_com_padrao_strategy;

public class IPI implements Imposto{
	private double valor;
	
	public IPI (double valor) {
		this.valor = valor;
	}

	@Override
	public double calcular() {
		return this.valor * 0.20;
	}

}
