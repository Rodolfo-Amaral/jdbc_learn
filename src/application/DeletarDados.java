package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import db.DBIntegrityException;

public class DeletarDados {

	public static void main(String[] args) {
		Connection conexao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//iniciando conexão com o banco
			conexao = DB.iniciarConexao();
			
			//Deletando dados
			ps = conexao.prepareStatement(
					"DELETE FROM vendedor "
					+ "WHERE "
					+ "ID = ?");
			ps.setInt(1, 8);
			
			int afetados = ps.executeUpdate();
			System.out.println("COMPLETO!\n" + afetados + " linhas afetadas!");
			
		} catch (SQLException e) {
			throw new DBIntegrityException(e.getMessage());
		}
		finally {
			//Fechando conexões
			DB.fecharStatement(ps);
			DB.fecharResultSet(rs);
			DB.fecharConexao();
		}
	}

}
