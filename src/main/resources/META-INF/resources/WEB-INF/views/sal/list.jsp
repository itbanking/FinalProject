<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

<style type="text/css">
	a:HOVER {
		text-decoration: none;	
	}
	a {
		color: black;
	}
	.text-center {
		margin :30px auto;
		white-space : nowrap;
		text-overflow : ellipsis;
	}
	tr, td {
		text-transform: capitalize;
	}
	.headTR {
		background-color: black;
		color: gold;
	}
</style>

</head>
<body>

<h1>Salary List</h1>
<div class="text-center table-responsive">
	<table class="table">
		<tr class="headTR">
			<td>sal_No</td>
			<td>basic Salary</td>
			<td>overtime Salary</td>
			<td>Commission</td>
			<td>aid Salary</td>
			<td>salary Date</td>
			<td>member_Srl</td>
		</tr>
	<c:forEach var="sal" items="${sals}">
		<tr>
			<td>${sal.salno}</td>
			<td>${sal.basicSal}</td>
			<td>${sal.overtimeSal}</td>
			<td>${sal.comm}</td>
			<td>${sal.aidSal}</td>
			<td>${sal.saldate}</td>
			<td>${sal.membersrl}</td>
		</tr>
	</c:forEach>	
	</table>
</div>

</body>
</html>