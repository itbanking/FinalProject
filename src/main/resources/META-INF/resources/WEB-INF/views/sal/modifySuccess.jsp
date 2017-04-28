<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifySuccess.jsp</title>

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>
<h1>Modify Success !</h1>
<div class="text-center table-responsive">
	<table class="table table-bordered">
		<tr class="danger">
			<td>sal_No</td>
			<td>basic Salary</td>
			<td>overtime Salary</td>
			<td>Commission</td>
			<td>aid Salary</td>
			<td>salary Date</td>
			<td>member_Srl</td>
		</tr>
		<tr>
			<td>${sal.salno}</td>
			<td><fmt:formatNumber value="${sal.basicSal}" pattern="##,###,###"/></td>
			<td><fmt:formatNumber value="${sal.overtimeSal}" pattern="##,###,###"/>${sal.overtimeSal == null ? '-' : ''}</td>
			<td><fmt:formatNumber value="${sal.comm}" pattern="##,###,###"/>${sal.comm == null ? '-' : ''}</td>
			<td><fmt:formatNumber value="${sal.aidSal}" pattern="##,###,###"/>${sal.aidSal == null ? '-' : ''}</td>
			<td> <fmt:formatDate value="${sal.saldate}" pattern="yyyy-MM-dd"/> </td>
			<td>${sal.membersrl}</td>
		</tr>
	</table>
</div>

<script>
	setTimeout("location.href='/sal/page/1'", 3000);
</script>
</body>
</html>