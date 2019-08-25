package exercicios;

import javax.swing.JOptionPane;

public class CalculaMedia {

	public static void main(String[] args) {
		int quantidade =0;
		float salario =0;
		float media =0;
		float total =0;
		
		int contador =0;
		
		
		quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade de funcionários", "Número de funcionários", JOptionPane.QUESTION_MESSAGE));
		
		while (contador < quantidade) {
			contador++;
			System.out.println(contador);
			salario = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o salário do funcionário","salario", JOptionPane.QUESTION_MESSAGE));
			total = total+quantidade;
			System.out.println(total);
		}
		
		media = total / salario;
		
		System.out.println("media salarial"+ media);
		System.exit(0);
		

	}

}
