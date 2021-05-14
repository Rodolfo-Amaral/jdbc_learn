package model.dao;

import java.util.List;

import entities.Vendedores;

public interface DAOVendedores {
	
	void insert(Vendedores dpt);
	void update(Vendedores dpt);
	void deleteById(Integer id);
	Vendedores findById(Integer id);
	List<Vendedores> findAll();

}
