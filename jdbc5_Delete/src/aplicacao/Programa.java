package aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

public class Programa {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps= null;
		try {
			conn = DB.getConnection();
			
			ps = conn.prepareStatement(
					"delete from department "
					+ "where id = ?"
					);
			
			ps.setInt(1, 1);
			int linhasAfetadas = ps.executeUpdate();
			System.out.println("Pronto ! Linhas afetadas: "+ linhasAfetadas);
		} catch (Exception e) {
			throw new DbIntegrityException(e.getMessage());
		}finally {
			DB.fecharStatement(ps);
			DB.closeConnection();			
		}
		

						

	}

}
