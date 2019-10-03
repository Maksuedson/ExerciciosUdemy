package modelo.dao;

import java.util.List;

import modelo.entidade.Departamento;

public interface DepartamentoDao {
	
	void salvar(Departamento obj);
	void alterar(Integer id);
	void excluir(Integer id);
	void listar(Departamento obj);
	Departamento buscarPorId(Integer id);
	List<Departamento> buscarTodos();

}
