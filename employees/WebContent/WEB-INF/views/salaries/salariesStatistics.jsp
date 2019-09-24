<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
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
<h1>연봉 테이블(count, sum, avg, max, min, std)</h1>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>count</th>
				<th>sum</th>
				<th>avg</th>
				<th>max</th>
				<th>min</th>
				<th>std</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${map.count}</td>
				<td>${map.sum }</td>
				<td>${map.avg }</td>
				<td>${map.max }</td>
				<td>${map.min }</td>
				<td>${map.std }</td>
			</tr>
		</tbody>
	</table>
	<a href="${pageContext.request.contextPath}/views/index">Index</a>
</div>
</body>
</html>