package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;

public class AttDados {

	public static void main(String[] args) {
		Connection conexao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//Iniciando conexão com o banco de dados:
			conexao = DB.iniciarConexao();
			
			//Coleta dos dados
			ps = conexao.prepareStatement("UPDATE vendedor "
					+ "SET Salario_Base = Salario_Base + ?"
					+ "WHERE "
					+ "(Id_dpt = ?)");
			ps.setDouble(1, 200.0);
			ps.setInt(2, 2);
			
			//Executar comando
			int afetados = ps.executeUpdate();
			
			System.out.println("COMPLETO!\n" + afetados + " linhas afetadas");
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			//fechando conexões
			DB.fecharResultSet(rs);
			DB.fecharStatement(ps);
			DB.fecharConexao();
			
		}

	}

}
