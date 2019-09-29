package aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DB;

public class Programa {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps= null;
		try {
			conn = DB.getConnection();
			
			ps = conn.prepareStatement(
					"delete * from depart"
					);
		} catch (Exception e) {
			// TODO: handle exception
		}
		

						

	}

}
