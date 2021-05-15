package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
				Departamento dpt = instantiateDepartamento(rs); 
				Vendedores vendedores = instantiateVendedores(rs, dpt);
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

	private Vendedores instantiateVendedores(ResultSet rs, Departamento dpt) throws SQLException {
		Vendedores vendedores = new Vendedores();
		vendedores.setId(rs.getInt("ID"));
		vendedores.setNome(rs.getString("Nome"));
		vendedores.setEmail(rs.getString("Email"));
		vendedores.setSalarioBase(rs.getDouble("Salario_Base"));
		vendedores.setDataNascimento(rs.getDate("Data_Nascimento"));
		vendedores.setDepartamento(dpt); //pegar tudo que ja está definido na classe
		return vendedores;
	}

	private Departamento instantiateDepartamento(ResultSet rs) throws SQLException {
		Departamento dpt = new Departamento();
		dpt.setId(rs.getInt("Id_dpt"));
		dpt.setNome(rs.getString("DepNome"));
		return dpt;
	}

	@Override
	public List<Vendedores> findAll() {
		return null;
	}

	@Override
	public List<Vendedores> findByDepartment(Departamento departamento) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//Query
			ps = conexao.prepareStatement("SELECT vendedor.*,departamento.Nome as DepNome "
					+ "FROM vendedor INNER JOIN departamento "
					+ "ON vendedor.Id_dpt = departamento.ID "
					+ "WHERE Id_dpt = ? "
					+ "ORDER BY Nome");
			ps.setInt(1, departamento.getId());
			rs = ps.executeQuery();
			
			//Teste do resultado da consulta
			List<Vendedores> lista = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();
			while(rs.next()) {
				//Se o dpt existir o map vai pegar ele e se o if der falso ira reaproveitar o dpt, para nao ficar criando varios departamentos aleatorios
				Departamento dpt = map.get(rs.getInt("Id_dpt"));
				if(dpt == null) {
					dpt = instantiateDepartamento(rs);
					map.put(rs.getInt("Id_dpt"), dpt);
				}
				Vendedores vendedores = instantiateVendedores(rs, dpt);
				lista.add(vendedores);			
			}
			return lista;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.fecharStatement(ps);
			DB.fecharResultSet(rs);
		}
	}
	

}
