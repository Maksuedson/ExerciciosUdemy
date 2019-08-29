package entidade;

public class Funcionario {
	public String nome;
	public double salarioBruto;
	public double taxa;
	
	public double SalarioLiquido() {
		return salarioBruto - taxa;
	}
	public void aumentarSalario(double porcentagem) {
		this.salarioBruto += salarioBruto * porcentagem/100;
	}
	
	@Override
	public String toString() {
		return "Funcionario Nome: " + nome + ", Sálario Bruto: "+String.format("%.2f", salarioBruto)+","+ " Taxa: " + String.format("%.2f", taxa) + "";
	}
	
	

}