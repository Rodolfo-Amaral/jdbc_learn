package model.dao;

import db.DB;
import model.dao.impl.DAOVendedoresJDBC;

public class DAOFactory {
	
	public static DAOVendedores criarDaoVendedores() {
		return new DAOVendedoresJDBC(DB.iniciarConexao());
	}

}
