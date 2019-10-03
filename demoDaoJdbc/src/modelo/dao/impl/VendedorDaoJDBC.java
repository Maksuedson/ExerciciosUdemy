package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import modelo.dao.VendedorDao;
import modelo.entidade.Departamento;
import modelo.entidade.Vendedor;

public class VendedorDaoJDBC implements VendedorDao {
	private Connection conn = null;

	
	
	public VendedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void salvar(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listar(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor buscarPorId(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?"
					);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				Departamento dep = new Departamento();
				dep.setId(rs.getInt("DepartmentId"));
				dep.setNome(rs.getString("DepName"));
				Vendedor vend = new Vendedor();
				vend.setId(rs.getInt("Id"));
				vend.setNome(rs.getString("Name"));
				vend.setEmail(rs.getString("Email"));
				vend.setDataNasc(rs.getDate("BirthDate"));
				vend.setSalarioBase(rs.getDouble("BaseSalary"));
				vend.setDepartamento(dep);
				
				return vend;
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.fecharStatement(ps);
			DB.fecharResult(rs);			
		}
		return null;
	}

	@Override
	public List<Vendedor> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
