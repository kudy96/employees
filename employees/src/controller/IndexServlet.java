package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeesDao;

@WebServlet({"/","/index"})
public class IndexServlet extends HttpServlet {
	private EmployeesDao employeesDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		employeesDao = new EmployeesDao();
		//Dao의 리턴값
		int employeesRowCount = employeesDao.selectEmployeesRowCount();
		
		//employeesRowCount 설정
		request.setAttribute("employeesRowCount", employeesRowCount);
		
		//employeesRowCount의 저장된 값을 index에 보여줌 
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}

}
