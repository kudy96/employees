package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmployeesDao;
import vo.Employees;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	
	//login form
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

	}
	
	//login action
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int empNo = Integer.parseInt(request.getParameter("empNo"));
			System.out.println("fisrtName :" + firstName);
			System.out.println("lastName :" + lastName);
			System.out.println("empNo:" + empNo);
		
		Employees employees = new Employees();
		employeesDao = new EmployeesDao();
		int sessionEmpNo = employeesDao.login(empNo, firstName, lastName);
		HttpSession session = request.getSession();
		session.setAttribute("sessionEmpNo", sessionEmpNo);
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

}
