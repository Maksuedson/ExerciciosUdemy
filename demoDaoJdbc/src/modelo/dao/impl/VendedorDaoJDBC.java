package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(
				"insert into seller "
				+"(Name, Email, BirthDate, BaseSalary, DepartmentId) "
				+"values "
				+"(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS									
					);
			ps.setString(1, obj.getNome());
			ps.setString(2, obj.getEmail());
			ps.setDate(3, new java.sql.Date(obj.getDataNasc().getTime()));
			ps.setDouble(4, obj.getSalarioBase());
			ps.setInt(5, obj.getDepartamento().getId());
			
			int linhaAfetada = ps.executeUpdate();
			
			if (linhaAfetada > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.fecharResult(rs);
			}else {
				throw new DbException("Erro inesperado! nenhuma linha afetadas");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			//e.printStackTrace();
		} finally {
			DB.fecharStatement(ps);
		}		
	}

	@Override
	public void alterar(Vendedor obj) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(
					"update seller "
					+"set name=?, email=?, birthdate=?, basesalary=?, departmentid=? "
					+"where id=?"								
					);
			ps.setString(1, obj.getNome());
			ps.setString(2, obj.getEmail());
			ps.setDate(3, new java.sql.Date(obj.getDataNasc().getTime()));
			ps.setDouble(4, obj.getSalarioBase());
			ps.setInt(5, obj.getDepartamento().getId());
			ps.setInt(6, obj.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			//e.printStackTrace();
		} finally {
			DB.fecharStatement(ps);
		} 		
	}

	@Override
	public void excluir(Integer id) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(
					"delete from seller where id=?"							
					);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.fecharStatement(ps);
		} 	
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
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "ORDER BY name"
					);
			rs = ps.executeQuery();
			
			List<Vendedor> list  = new ArrayList<Vendedor>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			while (rs.next()) {
				
				Departamento dep = map.get(rs.getInt("departmentid"));
				
				if (dep == null) {
					dep = instanciarDepartamento(rs);
					map.put(rs.getInt("departmentid"), dep);
				}				
				Vendedor vend = instanciarVendedor(rs, dep);
				list.add(vend);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.fecharStatement(ps);
			DB.fecharResult(rs);			
		}		
	}	

	@Override
	public List<Vendedor> buscaPorDepartamento(Departamento departamento) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY name"
					);
			
			ps.setInt(1, departamento.getId());
			rs = ps.executeQuery();
			
			List<Vendedor> list  = new ArrayList<Vendedor>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			while (rs.next()) {
				
				Departamento dep = map.get(rs.getInt("departmentid"));
				
				if (dep == null) {
					dep = instanciarDepartamento(rs);
					map.put(rs.getInt("departmentid"), dep);
				}				
				Vendedor vend = instanciarVendedor(rs, dep);
				list.add(vend);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.fecharStatement(ps);
			DB.fecharResult(rs);			
		}		
	}

}
