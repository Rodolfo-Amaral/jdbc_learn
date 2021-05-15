package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Departamento;
import entities.Vendedores;
import model.dao.DAOFactory;
import model.dao.DAOVendedores;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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
		System.out.println("\n=====TESTE 3: FIND ALL=====");
		lista = daoVendedor.findAll();
		for (Vendedores registro : lista) {
			System.out.println(registro);
		}/*
		System.out.println("\n=====TESTE 4: INSERT=====");
		Vendedores novoVendedor = new Vendedores(null, "Chris e Greg", "crisgreg@outlook.com", new Date(), 1000.0, dpt);
		daoVendedor.insert(novoVendedor);
		System.out.println("Registro inserido!\nNovo ID = "+novoVendedor.getId()+"\nVendedor: " + novoVendedor.getNome());
		*/
		System.out.println("\n=====TESTE 5: UPDATE=====");
		vendedor = daoVendedor.findById(2);
		vendedor.setNome("Martha Vania");
		daoVendedor.update(vendedor);
		System.out.println("Atualizado com sucesso os dados do vendedor ID = "+ vendedor.getId());
		
		System.out.println("\n=====TESTE 6: DELETE=====");
		System.out.println("Digite o ID do vendedor a excluir: ");
		int id = sc.nextInt();
		daoVendedor.deleteById(id);
		System.out.println("Vendedor deletado com sucesso!");
		sc.close();
	}

}
