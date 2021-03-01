package model.dao;

import model.dao.implementation.SellerDaoJdbc;

public class DAOFactory {

	public static SellerDAO createSellerDAO() {
		return new SellerDaoJdbc();
	}
}
