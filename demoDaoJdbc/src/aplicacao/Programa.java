package aplicacao;

import java.util.List;
import java.util.Scanner;

import modelo.dao.DaoFactory;
import modelo.dao.VendedorDao;
import modelo.entidade.Departamento;
import modelo.entidade.Vendedor;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		VendedorDao vendedorDao = DaoFactory.criarVendedorDao();
		
		System.out.println("=== TESTE 1: Vendedor buscarPorId ===");
		Vendedor vendedor = vendedorDao.buscarPorId(2);				
		System.out.println(vendedor);
				
		System.out.println("\n=== TESTE 2: Vendedor buscarPorId ===");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> list = vendedorDao.buscaPorDepartamento(departamento);
		for (Vendedor vend: list) {
			System.out.println(vend);
		}
		
		System.out.println("\n=== TESTE 3: Vendedor buscarTodos ===");
		list = vendedorDao.buscarTodos();
		for (Vendedor vend: list) {
			System.out.println(vend);
		}	
				
		/*
		 * System.out.println("\n=== TESTE 4: Vendedor Salvar ==="); Vendedor
		 * novoVendedor = new Vendedor(null, "Greg", "greg@bol.com.br", new Date(),
		 * 4000.0, departamento); vendedorDao.salvar(novoVendedor);
		 * System.out.println("Inserido! New Id: " + novoVendedor.getId());
		 */
		
		System.out.println("\n=== TESTE 5: Vendedor Alterar ===");
		vendedor = vendedorDao.buscarPorId(11);
		vendedor.setEmail("martawayne@hotmail.com");
		vendedorDao.alterar(vendedor);
		System.out.println("Atualização completa!");
		
		System.out.println("\n=== TESTE 6: Vendedor Deletar ===");
		System.out.println("Entre com o id para excluir: ");
		int id = sc.nextInt();
		vendedorDao.excluir(id);
		System.out.println("Exclusão completa!");
		
		
		sc.close();
		
	}

}
