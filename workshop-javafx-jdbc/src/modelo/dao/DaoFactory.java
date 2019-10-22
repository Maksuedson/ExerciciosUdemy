package modelo.dao;

import db.DB;
import modelo.dao.impl.DepartamentoDaoJDBC;
import modelo.dao.impl.VendedorDaoJDBC;


public class DaoFactory {

	public static VendedorDao criarVendedorDao() {
		return new VendedorDaoJDBC(DB.getConnection());
	}
	
	public static DepartamentoDao criarDepartamentoDao() {
		return new DepartamentoDaoJDBC(DB.getConnection());
	}
}
