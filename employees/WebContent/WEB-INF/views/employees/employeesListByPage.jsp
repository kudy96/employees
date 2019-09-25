<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="col-md-6">
<h1>회원 목록 10명씩</h1>

<a href="${pageContext.request.contextPath}/views/index">홈으로</a>

<form method="get" action="${pageContext.request.contextPath}/employees/getEmployeesListByPage">
		<select name = "rowPerPage">						
			<option value="${rowPerPage }" selected="selected">${rowPerPage }</option>					
			<option value="10">10</option>			
			<option value="20">20</option>
			<option value="30">30</option>
			<option value="40">40</option>
			<option value="50">50</option>
		</select> 개씩 
		<button type="submit" class="btn btn-dark">보기</button>
	</form>
<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>사원 번호</th>
				<th>사원 생일</th>
				<th>사원 성</th>
				<th>사원 이름</th>
				<th>사원 성별</th>
				<th>입사 날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employees" items="${list}">
				<tr>
					<td>${employees.empNo}</td>
					<td>${employees.birthDate}</td>
					<td>${employees.firstName}</td>
					<td>${employees.lastName}</td>
					<td>${employees.gender}</td>
					<td>${employees.hireDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<c:if test="${currentPage > 1 }">
	<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}">이전</a>
</c:if>
<c:if test="${currentPage<lastPage }">
	<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}">다음</a>
</c:if>
</div>
</body>
</html>