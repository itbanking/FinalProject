<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>unregisterSuccess.jsp</title>

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>
<h1>Remove City Success !</h1>
<div class="text-center table-responsive">
<table class="table table-bordered">
	<tr class="success">
		<td>Removed City ID</td>
	</tr>
	<tr>
		<td>${id}</td>
	</tr>
</table>
</div>
<script>
	setTimeout("location.href='/city/page/1'", 3000);
</script>
</body>
</html>