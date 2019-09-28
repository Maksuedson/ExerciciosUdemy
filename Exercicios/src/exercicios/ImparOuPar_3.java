package exercicios;

import java.util.Scanner;

public class ImparOuPar_3 {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String ans = "";

		if (n >= 1 && n <= 100) {
			if (n % 2 == 1) {
				ans = "Weird";
			} else {
				if (n >= 2 && n <= 5) {
					ans = "Not Weird";
				} else if (n >= 6 && n <= 20) {
					ans = "Weird";
				} else if (n > 20) {
					ans = "Not Weird";
				}
			}
		} else {
			ans = "Invalid no! Enter a number between 1 and 100.";
		}

		System.out.println(ans);

	}
}
