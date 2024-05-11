package dao;

import dal.EmployeeDAL;

public class EmployeeDAO {
	public static EmployeeDAL getEmployeeDAL() {
		return new EmployeeDAL();
	}
}
