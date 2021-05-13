package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class DemoTransacoes {

	public static void main(String[] args) {
		Connection conexao = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			//iniciando conexão com o banco
			conexao = DB.iniciarConexao();
			
			//Nao confirmar as operações automaticamente
			conexao.setAutoCommit(false); 
			
			//Deletando dados
			st = conexao.createStatement();
			
			int linhas1 = st.executeUpdate("UPDATE vendedor SET Salario_Base = 2090 WHERE Id_dpt = 2");
			/*Gerar uma exceção falsa no meio da execução
			int x = 1;
			if (x <2) {
				throw new SQLException("MAHOOOEEE");
			}*/
			int linhas2 = st.executeUpdate("UPDATE vendedor SET Salario_Base = 3090 WHERE Id_dpt = 1");
			
			//Confirmar a operação
			conexao.commit();
			
			System.out.println("COMPLETO!\nRegistros alterados: "
					+ linhas1 
					+ "\nRegistros alterados: "
					+ linhas2);
			
		} catch (SQLException e) {
			  try {
				  //Voltar a transação caso ela tenha parado no meio da execução
				conexao.rollback();
				throw new DbException("Transação não concluída! Causa: " + e.getMessage());
				
			} //Quando der erro no rollback
			  catch (SQLException e1) {	
				throw new DbException("Erro ao reverter transação :(\n Causa: " + e1.getMessage());
			}
		}
		finally {
			//Fechando conexões
			DB.fecharStatement(st);
			DB.fecharResultSet(rs);
			DB.fecharConexao();
		}
	}

}
