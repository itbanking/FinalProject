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



</head>
<body>

<c:set var="member" value="${sal.member}"/>

<h1>Salary of Member Info</h1>

<BR>

<div class="text-center table-responsive">
	<table class="table table-bordered">
		<tr class="danger">
			<td>member_srl</td>
			<td>user_ID</td>
			<td>email</td>
			<td>user_Name</td>
		</tr>
		<tr>
			<td>${member.membersrl}</td>
			<td>${member.userid}</td>
			<td>${member.email}</td>
			<td>${member.username}</td>
		</tr>
	</table>
</div>
<a class="btn btn-sm btn-default" href="/sal/page/${param.pageNo}">
<span class="glyphicon glyphicon-arrow-left"></span> salary page</a>
</body>
</html>