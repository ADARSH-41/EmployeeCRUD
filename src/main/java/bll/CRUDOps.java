package bll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBConnection;
import model.Employee;

public class CRUDOps {

	private static Connection con = DBConnection.getDBConnection();

	public void addEmployee(Employee e1) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?,?);");
			ps.setInt(1, e1.getEmpno());
			ps.setString(2, e1.getEname());
			ps.setString(3, e1.getJob());
			ps.setInt(4, e1.getSalary());
			ps.setInt(5, e1.getDept());

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL Exception due to PreparedStatement at CRUDOps addEmployee..." + e);
		}

	}

	public static void deleteEmployee(Employee e1) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from employee where eno=?");
			ps.setInt(1, e1.getEmpno());
			ps.executeUpdate();
			System.out.println("Delete Method");
		} catch (Exception e) {
			System.out.println("SQL Exception due to PreparedStatement at CRUDOps deleteEmployee..." + e);
		}
	}

	public void updateEmployee(Employee e1) {
		try {
			PreparedStatement ps = con
					.prepareStatement("update employee set eno=?,ename=?,job=?,salary=?,deptno=? where eno=?");
			ps.setInt(1, e1.getEmpno());
			ps.setString(2, e1.getEname());
			ps.setString(3, e1.getJob());
			ps.setInt(4, e1.getSalary());
			ps.setInt(5, e1.getDept());
			ps.setInt(6, e1.getEmpno());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL Exception due to PreparedStatement at CRUDOps updateEmployee..."+e);
		}
	}
}
