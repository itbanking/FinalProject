<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>template.jsp</title>

<link rel="stylesheet" href="/css/ListService.css">

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>


<style type="text/css">
	.registerBox {
		text-align: right;
	}
</style>

</head>
<body>

	<H1>Control Member Database Page</H1>
	
	<div class="registerBox">
		<a class="btn btn-info btn-sm" href="/Admin/CMD/Add">
		<span class="glyphicon glyphicon-inbox"></span> Member Register</a>
	</div><BR>
	
	<table class='table'>
		<tr>
			<td>MemberSrl</td>
			<td>UserID</td>
			<td>Email</td>
			<td>UserName</td>
			<td>Password(Encrypted)</td>
			<td>IsAdmin</td>
			<td>IsAllowed</td>
			<td class="ButtonTD">Modify</td>
			<td class="ButtonTD">Delete</td>
		</tr>
		<c:forEach var="Member" items="${Members}" >
			<tr>
				<td>${Member.membersrl}</td>
				<td>${Member.userid}</td>
				<td>${Member.email}</td>
				<td>${Member.username}</td>
				<td>${Member.password}</td>
				<td>${Member.isadmin}</td>
				<td>${Member.isallowed}</td>
				<td><a href="/Admin/CMD/Mod/${Member.membersrl}"><span class="glyphicon glyphicon-edit"></span></a></td>
				<td><a href="/Admin/CMD/Rem/${Member.membersrl}"><span class="glyphicon glyphicon-remove"></span></a></td>
			</tr>
		</c:forEach> 
	</table>

</body>
</html>