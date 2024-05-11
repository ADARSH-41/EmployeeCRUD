package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.CRUDOps;
import model.Employee;

/**
 * Servlet implementation class CRUDServlet
 */
@WebServlet("/crudserve")
public class CRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) {

		try {
			doPost(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Came");
		String p1 = request.getParameter("action");
		Integer eno = Integer.parseInt(request.getParameter("eno"));
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		Integer salary = Integer.parseInt(request.getParameter("sal"));
		Integer dept = Integer.parseInt(request.getParameter("dept"));
		Employee e1 = new Employee();
		e1.setEmpno(eno);
		e1.setEname(ename);
		e1.setJob(job);
		e1.setSalary(salary);
		e1.setDept(dept);

		System.out.println(p1);
		System.out.println(eno);
		System.out.println(ename);
		System.out.println(job);
		if (p1 != null) {
			switch (p1) {
			case "Add":
				addEmployee(response, e1);
				break;
			case "Delete":
				delEmployee(response, e1);
				break;
			case "Edit":
				updateEmployee(response, e1);
				break;
			}
		}

	}

	private void updateEmployee(HttpServletResponse response, Employee e1) {
		// TODO Auto-generated method stub
		CRUDOps update = new CRUDOps();
		update.updateEmployee(e1);
		System.out.println("rfghsfhsrthsardhbgsr");
		 try {
		 response.sendRedirect("StartupServlet");
		 } catch (IOException e) {
		 System.out.println("IOException occured at sending data after updation");
		 }
	}

	private void delEmployee(HttpServletResponse response, Employee e1) {
		// TODO Auto-generated method stub
		CRUDOps.deleteEmployee(e1);
		try {

			System.out.println("Deleted");
			response.sendRedirect("StartupServlet");
		} catch (IOException e) {
			System.out.println("IOException occured at sending data after deletion");
		}
	}

	public void addEmployee(HttpServletResponse response, Employee e1) {

		CRUDOps add = new CRUDOps();
		add.addEmployee(e1);
		try {
			response.sendRedirect("StartupServlet");
		} catch (IOException e) {
			System.out.println("IOException occured at sending data after Addition");
		}
	}

}

