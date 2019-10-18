package modelo.services;

import java.util.ArrayList;
import java.util.List;

import modelo.entidade.Departamento;

public class DepartamentoServices {
	public List<Departamento> bucarTodos(){
		List<Departamento> list = new ArrayList<>();
		list.add(new Departamento(1, "Livros"));
		list.add(new Departamento(2, "Computadores"));
		list.add(new Departamento(3, "Eletronicos"));
		return list;
	}

}
