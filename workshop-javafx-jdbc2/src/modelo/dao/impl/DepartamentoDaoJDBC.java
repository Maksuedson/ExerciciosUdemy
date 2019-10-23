package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import modelo.dao.DepartamentoDao;
import modelo.entidade.Departamento;

public class DepartamentoDaoJDBC implements DepartamentoDao{
	private Connection conn = null;

	public DepartamentoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void salvar(Departamento obj) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(
					"insert into department "
					+ "(name) "
					+ "values "
					+ "(?)", Statement.RETURN_GENERATED_KEYS
					);
			ps.setString(1, obj.getNome());
			
			int linhaAfetada = ps.executeUpdate();
			
			if (linhaAfetada > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.fecharResult(rs);
			}else {
				throw new DbException("Erro inesperado! nenhuma linha afetada");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			//e.printStackTrace();			
		} finally {
			DB.fecharStatement(ps);
		}
	}

	@Override
	public void alterar(Departamento obj) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(
					"update department "
					+ "set name=? where id=?"
					);
			ps.setString(1, obj.getNome());
			ps.setInt(2, obj.getId());
			
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
					"delete from department "
					+ "where id=?"
					);
			ps.setInt(1, id);
			
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			//e.printStackTrace();			
		} finally {
			DB.fecharStatement(ps);
		}
	}

	@Override
	public Departamento buscarPorId(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from department where id = ?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Departamento obj = new Departamento();
				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("name"));
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.fecharStatement(ps);
			DB.fecharResult(rs);
		}
	}

	@Override
	public List<Departamento> buscarTodos() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("Select * from department order by name");
			rs = ps.executeQuery();
			
			List<Departamento> list = new ArrayList<>();
			
			while(rs.next()) {
				Departamento obj = new Departamento();
				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("name"));
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.fecharStatement(ps);
			DB.fecharResult(rs);
		}		
	}

}
