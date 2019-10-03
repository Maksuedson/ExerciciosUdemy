package aplicacao;

import modelo.dao.DaoFactory;
import modelo.dao.VendedorDao;
import modelo.entidade.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		VendedorDao vendedorDao = DaoFactory.criarVendedorDao();
		Vendedor vendedor = vendedorDao.buscarPorId(2);
		
		System.out.println(vendedor);
		
	}

}
