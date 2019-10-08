package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import db.DB;
import db.DbException;
import modelo.dao.VendedorDao;
import modelo.entidade.Departamento;
import modelo.entidade.Vendedor;

public class VendedorDaoJDBC implements VendedorDao {
	private Connection conn = null;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	
	
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
				Departamento dep = instanciarDepartamento(rs);
				Vendedor vend = instanciarVendedor(rs, dep);
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

	private Vendedor instanciarVendedor(ResultSet rs, Departamento dep) throws SQLException{
		Vendedor vend = new Vendedor();
		vend.setId(rs.getInt("id"));
		vend.setNome(rs.getString("name"));
		vend.setEmail(rs.getString("email"));
		vend.setSalarioBase(rs.getDouble("basesalary"));
		vend.setDataNasc(rs.getDate("birthdate"));
		vend.setDepartamento(dep);
		
		return vend;
	}

	private Departamento instanciarDepartamento(ResultSet rs) throws SQLException {
		Departamento dep = new Departamento();
		dep.setId(rs.getInt("departmentid"));
		dep.setNome(rs.getString("depname"));
		return dep;
	}

	@Override
	public List<Vendedor> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
