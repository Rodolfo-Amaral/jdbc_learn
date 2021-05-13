package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class InserirDados {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conexao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conexao = DB.iniciarConexao();
			ps = conexao.prepareStatement(
					"INSERT INTO vendedor"
					+ "(Nome, Email, Data_Nascimento, Salario_Base, Id_dpt) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)"); //PlaceHolder (valor salvo posteriormente)
					
			ps.setString(1, "Carlos Johnson");
			ps.setString(2, "cj@gmail.com");
			ps.setDate(3, new java.sql.Date(sdf.parse("13/06/1968").getTime()));
			ps.setDouble(4, 3500.0);
			ps.setInt(5, 4);
			
			int linhasAfetadas = ps.executeUpdate();
			System.out.println("COMPLETO!\n" + linhasAfetadas + " linhas afetadas!");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ParseException e) {
			e.printStackTrace();
		}
		finally {
			//fechamento das conexões
			DB.fecharStatement(ps);
			DB.fecharResultSet(rs);
			DB.fecharConexao();
		}
	}
}
