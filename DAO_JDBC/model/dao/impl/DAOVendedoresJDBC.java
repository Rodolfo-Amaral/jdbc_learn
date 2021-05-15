package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import entities.Departamento;
import entities.Vendedores;
import model.dao.DAOVendedores;

public class DAOVendedoresJDBC implements DAOVendedores {
	//Iniciar conexão com o banco
	private Connection conexao;


	public DAOVendedoresJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	//
	@Override
	public void insert(Vendedores dpt) {
		
		
	}

	@Override
	public void update(Vendedores dpt) {
		
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public Vendedores findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//Query
			ps = conexao.prepareStatement("SELECT vendedor.*,departamento.Nome as DepNome "
					+"FROM vendedor INNER JOIN departamento "
					+"ON vendedor.Id_dpt = departamento.ID "
					+"WHERE vendedor.ID = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			//Teste do resultado da consulta
			if (rs.next()) { 
				//Coleta dos dados
				Departamento dpt = new Departamento();
				dpt.setId(rs.getInt("Id_dpt"));
				dpt.setNome(rs.getString("DepNome"));
				Vendedores vendedores = new Vendedores();
				vendedores.setId(rs.getInt("ID"));
				vendedores.setNome(rs.getString("Nome"));
				vendedores.setEmail(rs.getString("Email"));
				vendedores.setSalarioBase(rs.getDouble("Salario_Base"));
				vendedores.setDataNascimento(rs.getDate("Data_Nascimento"));
				vendedores.setDepartamento(dpt); //pegar tudo que ja está definido na classe
				return vendedores;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.fecharStatement(ps);
			DB.fecharResultSet(rs);
		}
	}

	@Override
	public List<Vendedores> findAll() {
		return null;
	}
	

}
