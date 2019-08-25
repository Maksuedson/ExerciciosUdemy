package exercicios;

public class Atribuicao {

	public static void main(String[] args) {
		int a = 10;
		System.out.println("ANTES DO INCREMENTO");
		System.out.println("o valor de A: "+a);
		System.out.println("-----------------");
		int b = a++;
		int x = a;
		System.out.println("DEPOIS DO INCREMENTO");
		System.out.println("o valor de A: "+a);
		System.out.println("o valor de B: "+b);
		System.out.println("o valor de X: "+x);

	}

}
