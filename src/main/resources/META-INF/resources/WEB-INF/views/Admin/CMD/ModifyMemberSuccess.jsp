<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ModifyForm.jsp</title>

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>

	<h1>Modify Success!</h1>
	
	<div class="text-center table-responsive">
	<table class="table table-bordered">
		<tr class="danger">
			<td>member Serial</td>
			<td>user ID</td>
			<td>email</td>
			<td>user Name</td>
			<td>isadmin</td>
			<td>isallowed</td>
		</tr>
		<tr>
			<td>${member.membersrl}</td>
			<td>${member.userid}</td>
			<td>${member.email}</td>
			<td>${member.username}</td>
			<td>${member.isadmin}</td>
			<td>${member.isallowed}</td>
		</tr>
	</table>
	</div>
	
	<script>
		setTimeout("location.href='/Admin/CMD/'", 3000);
	</script>
</body>
</html>