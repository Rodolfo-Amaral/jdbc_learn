package application;

import java.util.Date;

import entities.Departamento;
import entities.Vendedores;

public class Main {

	public static void main(String[] args) {
		Departamento dpt = new Departamento(1, "Computadores");
		Vendedores vendedores = new Vendedores(1, "Big Smoke", "fatman@yahoo.com", new Date(), 2500.0, dpt);
		System.out.println(dpt);
		System.out.println();
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
		System.out.println(vendedores);
	}

}
