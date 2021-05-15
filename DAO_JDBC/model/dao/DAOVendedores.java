package model.dao;

import java.util.List;

import entities.Departamento;
import entities.Vendedores;

public interface DAOVendedores {
	
	void insert(Vendedores vendedor);
	void update(Vendedores vendedor);
	void deleteById(Integer id);
	Vendedores findById(Integer id);
	List<Vendedores> findAll();
	List<Vendedores> findByDepartment(Departamento departamento);
}
