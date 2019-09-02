package util;

public class MoedaConversor {
	public static double IOF = 0.06;
	
	public static double DolarParaReal(double montante, double dolarPreco) {
		return montante * dolarPreco * (1.0 + IOF);
	}
}
