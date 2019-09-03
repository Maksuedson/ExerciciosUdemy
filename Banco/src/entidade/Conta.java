package entidade;

public class Conta {
	int numero;
	String titular;
	double saldo;
	
	public Conta(int numero, String titular) {
		this.numero = numero;
		this.titular = titular;
	}

	public Conta(int numero, String titular, double depositoInical) {
		this.numero = numero;
		this.titular = titular;
		depositar(depositoInical);
	}

	public void depositar( double montante) {
		saldo += montante;
	}
	
	public void sacar(double montante) {
		saldo -= montante + 5.0;
	}

	public int getNumero() {
		return numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return "Conta Número: "+ numero
				+ "\nTitular: "
				+ titular
				+ "\nSaldo: R$ "
				+ String.format("%.2f", saldo);
	}
	
	
	
	
}
