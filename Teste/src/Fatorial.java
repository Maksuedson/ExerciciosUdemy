import javax.swing.JOptionPane;

public class Fatorial {
public static void main(String[] args) {

		     int fat,n,i;
		        n = Integer.parseInt (JOptionPane.showInputDialog ("digite o numero"));
		        fat =1;
		        for (i = 1; i<= n; i++){
		              fat = fat * i;
		            System.out.println(fat);
		            }
		  
}
}
		        

