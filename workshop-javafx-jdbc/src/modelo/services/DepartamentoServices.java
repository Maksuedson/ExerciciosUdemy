package modelo.services;

import java.util.List;

import modelo.dao.DaoFactory;
import modelo.dao.DepartamentoDao;
import modelo.entidade.Departamento;

public class DepartamentoServices {
	private DepartamentoDao dao = DaoFactory.criarDepartamentoDao();
		
	public List<Departamento> bucarTodos(){
		return dao.buscarTodos();
	}
}
