package calcularimposto_sem_padrao_strategy;

public class TesteCalculadora {

	public static void main(String[] args) {
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		System.out.println("ICMS -- " + calculadora.calcular( "ICMS", 100));
		System.out.println("IPI -- " + calculadora.calcular( "IPI", 100));
		System.out.println("OUTRO -- " + calculadora.calcular( "NOVO_IMPOSTO", 100));

	}

}
