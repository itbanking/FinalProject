<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>item.jsp</title>

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>
	<style>
		h1,#tableDiv, th{
			text-align: center;
		}

	</style>
</head>
<body>

	<h1>Worktime List</h1>
<div id="tableDiv" class="table-responsive">
	<table class="table table-bordered container">
			<tr class="danger">
				<th>member_srl</th>
				<th>user_ID</th>
				<th>email</th>
				<th>user_Name</th>
				<th>password</th>
				<th>is_admin</th>
			</tr>
			<tr>
				<td>${dnltime.member.membersrl}</td>
				<td>${dnltime.member.userid}</td>
				<td>${dnltime.member.email}</td>
				<td><a href="/dnltime/member/${dnltime.member.membersrl}"><span class="glyphicon glyphicon-hand-right"></span>
				${dnltime.member.username}</a></td>
				<td>${dnltime.member.password}</td>
				<td>${dnltime.member.isadmin}</td>
			</tr>
	</table>
</div>

<a href="/dnltime/page/${param.pageNo}" class="btn btn-default">Worktime Page</a>

</body>
</html>