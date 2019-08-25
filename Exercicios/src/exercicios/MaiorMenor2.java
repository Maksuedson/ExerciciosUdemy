package exercicios;

import java.util.Scanner;

public class MaiorMenor2 {
public static void main(String[] args) {
	
	int a, b, maior;
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("digite um numero");
	a = sc.nextInt();
	
	System.out.println("digite um numero");
	b = sc.nextInt();
	
	if(a>b) {
		maior =a;
	}else {
		maior =b;
	}
	
	System.out.println("O mairo numero é " +maior);
	sc.close();
}
}
