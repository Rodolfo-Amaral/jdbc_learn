package application;

import java.util.List;

import entities.Departamento;
import entities.Vendedores;
import model.dao.DAOFactory;
import model.dao.DAOVendedores;

public class Main {

	public static void main(String[] args) {
		DAOVendedores daoVendedor = DAOFactory.criarDaoVendedores();
		System.out.println("=====TESTE 1: vendedor por ID=====");
		Vendedores vendedor = daoVendedor.findById(3);
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
		System.out.println(vendedor);
		System.out.println("\n=====TESTE 2: vendedor por Departamento=====");
		Departamento dpt = new Departamento(2, null);
		List<Vendedores> lista = daoVendedor.findByDepartment(dpt);
		for (Vendedores registro : lista) {
			System.out.println(registro + "\n");
		}

	}

}
