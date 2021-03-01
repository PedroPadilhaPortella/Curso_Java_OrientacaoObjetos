package model.dao;

import db.DB;
import model.dao.implementation.DepartmentDaoJdbc;
import model.dao.implementation.SellerDaoJdbc;

public class DAOFactory {

	public static SellerDAO createSellerDAO() {
		return new SellerDaoJdbc(DB.getConnection());
	}
	
	public static DepartmentDAO createDepartmentDAO() {
		return new DepartmentDaoJdbc();
	}
}