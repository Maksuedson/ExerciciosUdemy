package modelo.services;

import java.util.List;

import modelo.dao.DaoFactory;
import modelo.dao.VendedorDao;
import modelo.entidade.Vendedor;

public class VendedorService {
	private VendedorDao dao = DaoFactory.criarVendedorDao();
	
	public List<Vendedor> buscarTodos(){
		return dao.buscarTodos();
	}
	
	public void salvarOuAlterar(Vendedor obj) {
		if (obj.getId() ==  null) {
			dao.salvar(obj);
		} else {
			dao.alterar(obj);
		}
	}
}
