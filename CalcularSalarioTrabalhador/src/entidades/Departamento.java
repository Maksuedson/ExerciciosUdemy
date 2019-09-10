package entidades;

public class Departamento {
	private String nome;

	public Departamento(String nome) {
		this.nome = nome;
	}
	
	public Departamento() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}
	
	
}
