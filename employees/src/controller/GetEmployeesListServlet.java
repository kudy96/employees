package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employees;
import model.EmployeesDao;
import java.util.*;


@WebServlet("/employees/getEmployeesList")
public class GetEmployeesListServlet extends HttpServlet {
	//private 현재 클래스 내에서만 사용가능 외부의 접근을 막음 캡슐화
	private EmployeesDao employeesDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//param limit이 null이 아니면 int값으로 저장
		int limit = 10;
		if(request.getParameter("limit") != null) {
			limit = Integer.parseInt(request.getParameter("limit"));
		}				
		System.out.println("limit : " + limit);
		
		//메소드 selectEmployeesListByLimit  매개변수 (limit) 사용 
		employeesDao = new EmployeesDao();
		employeesDao.selectEmployeesListByLimit(limit);
		
		//employeesDao.selectEmployeesListByLimit(limit) -> 리턴값 list 
		List<Employees> list = employeesDao.selectEmployeesListByLimit(limit);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/employees/employeesList.jsp").forward(request, response);
		
		
		
	}

}
