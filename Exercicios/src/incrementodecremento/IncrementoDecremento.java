package incrementodecremento;

public class IncrementoDecremento {
	public static void main(String[] args) {
		int num = 10;
		int result = 0;

		System.out.println("Valor original: " + result);
		result = num++;
		System.out.println("Valor de num ap�s o incremento: " + num);
		System.out.println("Valor de result ap�s o incremento: " + result + "\n");

		num = 10; result = 0;
		result = ++num;
		System.out.println("Valor de num ap�s o incremento: " + num +"       //PRE-INCREMENTO");
		System.out.println("Valor de result ap�s o incremento: " + result+"      //PRE-INCREMENTO");
	}
}
