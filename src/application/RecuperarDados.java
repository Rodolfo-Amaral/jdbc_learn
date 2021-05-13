package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class RecuperarDados {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.iniciarConexao();
			st = conn.createStatement();
			rs = st.executeQuery("select * from departamento");
			while (rs.next()) {
				System.out.println(rs.getInt("ID") + ", " + rs.getString("Nome"));
			}
		}catch (SQLException SQL) {
			SQL.printStackTrace();
			
		}
		finally {
			DB.fecharResultSet(rs);
			DB.fecharStatement(st);
			DB.fecharConexao();
		}
	}

}
