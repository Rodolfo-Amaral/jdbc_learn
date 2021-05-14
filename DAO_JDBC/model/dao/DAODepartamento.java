package model.dao;

import java.util.List;

import entities.Departamento;

public interface DAODepartamento {
	
	void insert(Departamento dpt);
	void update(Departamento dpt);
	void deleteById(Integer id);
	Departamento findById(Integer id);
	List<Departamento> findAll();

}
