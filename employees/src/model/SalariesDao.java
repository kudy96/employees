package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import db.DBHelper;

public class SalariesDao {
	public Map<String, Long> selectSalariesStatistics(){
		Map<String, Long> map = new HashMap<String, Long>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select count(salary), sum(salary), avg(salary), max(salary), min(salary), std(salary) from salaries";			

		try {
			conn = DBHelper.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				//Long은 형변환을 사용해 int값으로 변환 시켜야 한다, 또는 Long으로 받아온다
				map.put("count", rs.getLong("count(salary)"));
				map.put("sum", rs.getLong("sum(salary)"));
				map.put("avg", rs.getLong("avg(salary)"));
				map.put("max", rs.getLong("max(salary)"));
				map.put("min", rs.getLong("min(salary)"));
				map.put("std", rs.getLong("std(salary)"));
				
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(rs, stmt, conn);
		}
		return map;
	}

	
	//전체행의 카운트를 구함
	public int selectSalariesRowCount() {
		int count = 0;
		final String sql = "select count(*) from salaries ";
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
