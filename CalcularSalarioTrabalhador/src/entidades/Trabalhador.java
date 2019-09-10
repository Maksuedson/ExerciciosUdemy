package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.NivelTrabalhador;

public class Trabalhador {
	private String nome;
	private NivelTrabalhador nivel;
	private Double baseSalarial;

	private Departamento departamento;
	private List<ContratoHora> contratos = new ArrayList<>();

	public Trabalhador() {

	}

	public Trabalhador(String nome, NivelTrabalhador nivel, Double baseSalarial, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.baseSalarial = baseSalarial;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getBaseSalarial() {
		return baseSalarial;
	}

	public void setBaseSalarial(Double baseSalarial) {
		this.baseSalarial = baseSalarial;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoHora> getContratos() {
		return contratos;
	}

	public void adicionarContrato(ContratoHora contrato) {
		contratos.add(contrato);
	}

	public void removerContrato(ContratoHora contrato) {
		contratos.remove(contrato);
	}

	public double receita(int ano, int mes) {
		double soma = baseSalarial;
		Calendar calendario = Calendar.getInstance();
		for (ContratoHora c : contratos) {
			calendario.setTime(c.getData());
			int contratoAno = calendario.get(Calendar.YEAR);
			int contratoMes = 1+ calendario.get(Calendar.MONTH);
			if(ano == contratoAno && mes == contratoMes) {
				soma += c.valorTotal();
			}

		}
		return soma;
	}

	@Override
	public String toString() {
		return "Trabalhador: " + nome + "\n Nível: " + nivel + "\n Salário Base: R$ " + String.format("%.2f", baseSalarial) + "\n Departamento: "
				+ departamento;
	}
	
	
}
