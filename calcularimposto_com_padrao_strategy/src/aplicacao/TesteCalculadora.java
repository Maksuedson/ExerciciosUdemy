package aplicacao;

import calcularimposto_com_padrao_strategy.CalculadoraDeImposto;
import calcularimposto_com_padrao_strategy.ICMS;
import calcularimposto_com_padrao_strategy.IPI;
import calcularimposto_com_padrao_strategy.NOVO_IMPOSTO;

public class TesteCalculadora {

	public static void main(String[] args) {
		CalculadoraDeImposto calculadora = new CalculadoraDeImposto();
		ICMS icms = new ICMS(100);
		IPI ipi = new IPI(100);
		NOVO_IMPOSTO novo_imposto = new NOVO_IMPOSTO(100);
		
		System.out.println(calculadora.calcular(icms));
		System.out.println(calculadora.calcular(ipi));
		System.out.println(calculadora.calcular(novo_imposto));

	}

}
