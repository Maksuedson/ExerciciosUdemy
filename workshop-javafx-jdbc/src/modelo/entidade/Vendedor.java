package modelo.entidade;

import java.io.Serializable;
import java.util.Date;

public class Vendedor implements Serializable{
	private static final long serialVersionUID = 1L;	
	private Integer id;
	private String nome;
	private String email;
	private Date dataNasc;
	private Double SalarioBase;
	
	private Departamento departamento;
		
	public Vendedor() {
	}

	public Vendedor(Integer id, String nome, String email, Date dataNasc, Double salarioBase,
			Departamento departamento) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataNasc = dataNasc;
		SalarioBase = salarioBase;
		this.departamento = departamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Double getSalarioBase() {
		return SalarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		SalarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vendedor [Id: " + id + ", Nome: " + nome + ", Email: " + email + ", Data de Nascimento: " + dataNasc
				+ ", Salario Base: " + SalarioBase + "]";
	}
	
	
	
}
