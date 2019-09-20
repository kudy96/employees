package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import vo.Departments;
import vo.DepartmentsDao;

//절대주소 서버기준
@WebServlet("/departments/getDepartmentsList")
public class GetDepartmentsListServlet extends HttpServlet {
	//캡슐화와 GetDepartmentsListServlet클래스 안에서 다 쓸 수 있도록 함
	private DepartmentsDao departmentsDao;
	
	//selectDepartmentsList메소드 사용하여 리스트 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		departmentsDao = new DepartmentsDao();
		List<Departments> list = departmentsDao.selectDepartmentsList();
		
		request.setAttribute("list", list);
		//절대주소 서버기준
		request.getRequestDispatcher("/WEB-INF/views/departments/departmentsList.jsp").forward(request, response);
	}




}
