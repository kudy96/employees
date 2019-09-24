<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
ul.b {
  list-style-type: square;
}
</style>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<!--
		1. 디렉티비 : x
		2. 선언식 : 사용x
		3. 스크립트릿 : jstl(사용자 생성한 태그)
		4. 표현식 : el
	  -->
<div class="container col-md-8" >
	<h1>index</h1>
	<h2>테이블 정보</h2>
	
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>테이블이름</th>
					<th>전체 행의 수</th>
					
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>departments</td>
					<td>${departmentsRowCount}</td>
				</tr>
				<tr>
					<td>employees</td>
					<td>${employeesRowCount }</td>
				</tr>
				<tr>
					<td>dept_emp</td>
					<td>${deptEmpRowCount }</td>
				</tr>
				<tr>
					<td>dept_manager</td>
					<td>${deptManagerRowCount }</td>
				</tr>
				<tr>
					<td>titles</td>
					<td>${titlesRowCount }</td>
				</tr>
					<tr>
					<td>salaries</td>
					<td>${salariesRowCount }</td>
				</tr>
			</tbody>
		</table>
	
	<!-- WEB APP 네비게이션 -->
	<div>
		<ul class="b">
			<li><a href="${pageContext.request.contextPath}/departments/getDepartmentsList">부서 목록</a></li>
			<li><a href="${pageContext.request.contextPath}/employees/getEmployeesList">사원 목록</a></li>
			<li>
				사원 목록 first_name
				<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc">오름차순</a>
				<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc">내림차순</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/titles/getTitlesListDistinct">업무 목록(중복 제거Distinct)</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/salaries/getSalariesStatistics">연봉 통계값(count,sum,avg,max,min,std)</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/employees/getEmployeesCountByGender">사원 수(성별 group by gender)</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/departments/getDepartmentsCountByDeptNo">현재 부서별 사원수</a>
			</li>
		</ul>
	</div>
		<div>
			<form method="post" action="${pageContext.request.contextPath}/employees/getEmployeesListBetween">
				<input type="number" name="begin">~<input type="number" name="end">
				<button type="submit">사원 목록 between and</button>
				(${minEmpNo } ~ ${maxEmpNo})
			</form>
		</div>
</div>
	
	<div>	
		표현식 : employees table row count : ${requestScope.employeesRowCount }
	</div>
	<div>	
		EL : employees table row count : ${employeesRowCount}
	</div>
</body>	
</html>