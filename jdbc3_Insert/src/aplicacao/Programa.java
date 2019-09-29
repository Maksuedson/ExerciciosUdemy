package aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbException;

public class Programa {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DB.getConnection();
			
			ps = conn.prepareStatement(
					"insert into seller "
					+ "(Name, email, birthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			
			ps.setString(1, "JACKSON KLESS");
			ps.setString(2, "jackson@gmail.com");
			ps.setDate(3, new java.sql.Date(sdf.parse("02/12/1984").getTime()));
			ps.setDouble(4, 8000);
			ps.setInt(5, 3);
			
			int linhasAfetadas = ps.executeUpdate();
			
			if (linhasAfetadas > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Pronto! Id = "+id);
				}
			}
			//System.out.println("Pronto! Linhas afetadas: " + linhasAfetadas);
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.fecharStatement(ps);
			DB.closeConnection();
		}
						

	}

}
