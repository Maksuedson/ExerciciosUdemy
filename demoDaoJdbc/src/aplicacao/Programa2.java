package aplicacao;

import java.util.List;
import java.util.Scanner;

import modelo.dao.DaoFactory;
import modelo.dao.DepartamentoDao;
import modelo.entidade.Departamento;

public class Programa2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartamentoDao departamentoDao = DaoFactory.criarDepartamentoDao();

		System.out.println("\n=== TESTE 1: Departamento buscarPorId ===");
		Departamento departamento = departamentoDao.buscarPorId(1);
		System.out.println(departamento);

		System.out.println("\n=== TESTE 3: Departamento buscarTodos ===");
		List<Departamento> list = departamentoDao.buscarTodos();
		for (Departamento dep : list) {
			System.out.println(dep);
		}

		/*
		 * System.out.println("\n=== TESTE 4: Departamento Salvar ==="); Departamento
		 * novoDepartamento = new Departamento(null, "DESENVOLVIMENTO");
		 * departamentoDao.salvar(novoDepartamento);
		 * System.out.println("Inserido! New Id: " + novoDepartamento.getId());
		 */

		System.out.println("\n=== TESTE 5: Departamento Alterar ===");
		departamento = departamentoDao.buscarPorId(5);
		departamento.setNome("SUPORTE");
		departamentoDao.alterar(departamento);
		System.out.println("Alterado com sucesso");
		
		System.out.println("\n=== TESTE 5: Departamento Excluir ===");
		System.out.println("Entro com o código");
		int id = sc.nextInt();
		departamentoDao.excluir(id);
		System.out.println("Excluido com sucesso");
		
		sc.close();
	}

}
