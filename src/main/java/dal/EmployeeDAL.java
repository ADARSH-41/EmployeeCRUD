package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Employee;

public class EmployeeDAL implements Employees {

	public ArrayList<Employee> getEmployees() {
		ArrayList<Employee> employees = new ArrayList<>();
		Connection con = null;
		// String url = "jdbc:postgresql://192.168.110.48:5432/plf_training";
		// String username = "plf_training_admin";
		// String password = "pff123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/pennant?user=root&password=19178");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("select * from employee");
			while (rs.next()) {
				Employee e1 = new Employee();
				e1.setEmpno(rs.getInt(1));
				e1.setEname(rs.getString(2));
				e1.setJob(rs.getString(3));
				e1.setSalary(rs.getInt(4));
				e1.setDept(rs.getInt(5));
				employees.add(e1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return employees;
	}

}
