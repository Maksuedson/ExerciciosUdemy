package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.ContratoHora;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enums.NivelTrabalhador;

public class Programa {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Insira o nome do Departamento: ");
		String departamento = sc.nextLine();
		
		System.out.println("Insira os dados do Trablhador");		
		System.out.println("Nome: ");		
		String nomeTrabalhador = sc.nextLine();
		
		System.out.println("Nível");
		String nivelTrabalhador = sc.nextLine();
		
		System.out.println("Insira o Salário Base");
		double salarioBaseTrabalhador = sc.nextDouble();
		
		Trabalhador trab = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador), salarioBaseTrabalhador, new Departamento(departamento));
		System.out.println(trab);
		
		System.out.println("Quantos contratos para este funcionário? ");
		int n = sc.nextInt();
		
		for (int i=1; i <n; i++) {
			System.out.println("Insira o contrato #"+i);
			System.out.print("Insira a data: ");
			Date contratoData = sdf.parse(sc.next());
			System.out.println("Valor por Hora");
			double valorPorHora = sc.nextDouble();
			System.out.println("Duração em horas: ");
			int horas = sc.nextInt();
			
			ContratoHora contratoHora = new ContratoHora(contratoData, valorPorHora, horas);
			trab.adicionarContrato(contratoHora);
		}
		System.out.println();
		System.out.println("Entre com mês e ano para calcular o salário");
		String mesEano = sc.next();
		
		int mes  = Integer.parseInt(mesEano.substring(0, 2));
		int ano =  Integer.parseInt(mesEano.substring(3));
		
		System.out.println("Nome: "+trab.getNome());
		System.out.println("Departamento: "+ trab.getDepartamento().getNome());
		System.out.println("Receita: "+ mesEano + ":" + trab.receita(ano, mes));
		
		
		
		
		
		sc.close();
	}
}
