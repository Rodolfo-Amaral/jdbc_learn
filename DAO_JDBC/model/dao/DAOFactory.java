package model.dao;

import model.dao.impl.DAOVendedoresJDBC;

public class DAOFactory {
	
	public static DAOVendedores criarDaoVendedores() {
		return new DAOVendedoresJDBC();
	}

}
