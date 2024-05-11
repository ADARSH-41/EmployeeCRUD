package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.Employees;
import dao.EmployeeDAO;
import model.Employee;

/**
 * Servlet implementation class StartupServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/" })
public class StartupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StartupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Employees employees = EmployeeDAO.getEmployeeDAL();
		ArrayList<Employee> emps = employees.getEmployees();
		request.setAttribute("empls", emps);
		RequestDispatcher rd = request.getRequestDispatcher("CrudWindow.jsp");
		rd.forward(request, response);
	}

}
