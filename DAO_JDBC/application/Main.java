package application;

import entities.Vendedores;
import model.dao.DAOFactory;
import model.dao.DAOVendedores;

public class Main {

	public static void main(String[] args) {
		DAOVendedores daoVendedor = DAOFactory.criarDaoVendedores();
		Vendedores vendedor = daoVendedor.findById(3);
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
		System.out.println(vendedor);

	}

}
