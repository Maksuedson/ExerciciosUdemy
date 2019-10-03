package modelo.dao;

import java.util.List;

import modelo.entidade.Vendedor;

public interface VendedorDao {
	void salvar(Vendedor obj);
	void alterar(Integer id);
	void excluir(Integer id);
	void listar(Vendedor obj);
	Vendedor buscarPorId(Integer id);
	List<Vendedor> buscarTodos();
}
