package model;

import java.sql.*;
import java.util.*;


public class EmployeesDao {
	
	public List<Employees> selectEmployeesListOrderBy(String order){
		System.out.println("selectEmployeesListOrderBy param order :" + order);
		List<Employees> list = new ArrayList<Employees>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = null;
		
		if(order.equals("asc")) {
			sql = "select emp_no, birth_date, first_name, last_name, gender, hire_date from employees order by first_name asc limit 50";
		} else if(order.equals("desc")) {
			sql = "select emp_no, birth_date, first_name, last_name, gender, hire_date from employees order by first_name desc limit 50";
		}
		//예외구절 데이터베이스에서 에러가 날 수 있음 finally sql종료 선언 list값 리턴
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while(rs.next()) {
					Employees employees = new Employees();
					employees.setEmpNo(rs.getInt("emp_no"));
					employees.setBirthDate(rs.getString("birth_date"));
					employees.setFirstName(rs.getString("first_name"));
					employees.setLastName(rs.getString("last_name"));
					employees.setGender(rs.getString("gender"));
					employees.setHireDate(rs.getString("hire_date"));
					list.add(employees);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					rs.close();
					stmt.close();
					conn.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return list;
		
	}
	
	public List<Employees> selectEmployeesListByLimit(int limit){
		System.out.println("selectEmployeesListByLimit param limit : " + limit);
		List<Employees> list = new ArrayList<Employees>();
		String sql = "select emp_no, birth_date, first_name, last_name, gender, hire_date from employees limit ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
			
		//예외구절 데이터베이스에서 에러가 날 수 있음 finally sql종료 선언 list값 리턴
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, limit);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Employees employees = new Employees();
				employees.setEmpNo(rs.getInt("emp_no"));
				employees.setBirthDate(rs.getString("birth_date"));
				employees.setFirstName(rs.getString("first_name"));
				employees.setLastName(rs.getString("last_name"));
				employees.setGender(rs.getString("gender"));
				employees.setHireDate(rs.getString("hire_date"));
				list.add(employees);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}		
	
	//employees의 카운트를 구하는 메소드
	public int selectEmployeesRowCount() {
		int count = 0;
		final String sql = "select count(*) from employees ";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");  
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return count;
	}
}
