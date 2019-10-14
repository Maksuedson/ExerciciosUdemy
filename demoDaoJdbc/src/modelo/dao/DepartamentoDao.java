package modelo.dao;

import java.util.List;

import modelo.entidade.Departamento;

public interface DepartamentoDao {
	
	void salvar(Departamento obj);
	void alterar(Departamento obj);
	void excluir(Integer id);
	Departamento buscarPorId(Integer id);
	List<Departamento> buscarTodos();

}
