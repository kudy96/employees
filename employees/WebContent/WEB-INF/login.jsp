<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form method="post" action="${pageContext.request.contextPath }/LoginAction">
		<table>			
			<tr>
				<td>first_name:</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>	
				<td>last_name:</td>
				<td><input type="text" name="firstName"></td>	
			</tr>
			<tr>
				<td>emp_no:</td>
				<td><input type="text" name="empNo"></td>				
			</tr>									
		</table>	
		<button type="submit">로그인</button>
	</form>
</body>
</html>