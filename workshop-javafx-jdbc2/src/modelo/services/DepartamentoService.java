package modelo.services;

import java.util.List;

import modelo.dao.DaoFactory;
import modelo.dao.DepartamentoDao;
import modelo.entidade.Departamento;

public class DepartamentoService {
	private DepartamentoDao dao = DaoFactory.criarDepartamentoDao();
		
	public List<Departamento> bucarTodos(){
		return dao.buscarTodos();
	}
	
	public void salvarOuAlterar(Departamento obj) {
		if (obj.getId() == null) {
			dao.salvar(obj);
		}else {
			dao.alterar(obj);
		}
	}
	
	public void remove(Departamento obj) {
		dao.excluir(obj.getId());
	}	
}
