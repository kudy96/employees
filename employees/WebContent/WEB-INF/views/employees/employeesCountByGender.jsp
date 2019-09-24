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
<h1>사원 수 (성별)</h1>
<a href="${pageContext.request.contextPath}/views/index">Index</a>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>성별</th>
				<th>수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="map" items="${list}">
			<!-- forEach가없어서 받아주지못하고있었음 -->
			<tr>
				<td>${map.gender }</td>
				<!-- list가아닌 map으로 받아주어야함 -->
				<td>${map.cnt }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>