<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/functions"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tregisterSuccess.jsp</title>
<!-- 1. animate -->
<link rel="stylesheet" href="/webjars/animate.css/3.5.2/animate.min.css">
<!-- 2. bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
<!-- 3. jquery -->
<script type="text/javascript" src="/webjars/jquery/1.11.1/jquery.min.js"></script>
<!-- 4. bootstrap.js -->
<script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>
<h1>Register Success !</h1>
<div class="text-center table-responsive">
	<table class="table">
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