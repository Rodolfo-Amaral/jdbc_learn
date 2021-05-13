package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	private static Connection conexao = null;

	public static Connection iniciarConexao() {
			if  (conexao == null) {
				try {
					Properties props = carregaPropriedades();
					String url = props.getProperty("dburl");
					conexao = DriverManager.getConnection(url, props);
				}catch (SQLException sql) {
					throw new DbException("ERRO " + sql.getMessage());
			}
			}
			return conexao;
		}
	
	public static void fecharConexao() {
		if (conexao != null) {
			try {
				System.out.println("Conexão Realizada!");
				conexao.close();
			}catch (SQLException sql) {
				throw new DbException("ERRO " + sql.getMessage());
			}
		}else {
			System.out.println("Conexão Falhou!");
		}
	}

	private static Properties carregaPropriedades() {
		try(FileInputStream fs = new FileInputStream("db.props")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		}catch (IOException e) {
			throw new DbException("ERRO " + e.getMessage());
		}
	}
	
	public static void fecharStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	public static void fecharResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
