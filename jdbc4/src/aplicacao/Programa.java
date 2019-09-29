package aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.xml.bind.DataBindingException;

import db.DB;
import db.DbException;

public class Programa {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DB.getConnection();
			ps = conn.prepareStatement("UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "where "
					+ "(DepartmentId = ?)"
					);
			ps.setDouble(1, 200);
			ps.setInt(2, 2);
			int linhasAfetadas = ps.executeUpdate();
			System.out.println("Pronto! Linhas afetadas: " + linhasAfetadas);
			
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		}
						

	}

}
