package loops;

public class ForAninhado {

	public static void main(String[] args) {
		for (int hora=1; hora<=12; hora++) {
			System.out.println("hora: "+hora);
			System.out.print("minutos: ");
			for (int minuto=1; minuto<=60; minuto++) {
				System.out.print(minuto + " ");
			}
			System.out.println("\n");
		}

	}

}
