package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;
import vo.Employees;

/**
 * Servlet implementation class GetEmployeesListByPageServlet
 */
@WebServlet("/employees/getEmployeesListByPage")
public class GetEmployeesListByPageServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1;
		int rowPerPage = 10;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		System.out.println("currentPage : " + currentPage);
		
		if(request.getParameter("rowPerPage") != null) {
			rowPerPage = Integer.parseInt(request.getParameter("rowPerPage"));
		}
		System.out.println("rowPerPage : " + rowPerPage);
		
		employeesDao = new EmployeesDao();
				
		int lastPage = employeesDao.selectEmployeesRowCount()/rowPerPage;
		
		System.out.println("lastPage : " + lastPage);
		
		List<Employees> list = employeesDao.selectEmployeesListByPage(currentPage, rowPerPage);
		
		request.setAttribute("rowPerPage", rowPerPage);
		request.setAttribute("list", list);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesListByPage.jsp").forward(request, response);
				
	}

}
