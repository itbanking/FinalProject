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
<title>template.jsp</title>
<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>
	<h1>City Register Service</h1>
	
	<form:form action="/dnltime/register" method="post" modelAttribute="dnltimeForm">
		<!-- Reason -->
		<div>
			<label for="reason" class="Define-Values">Reason : </label>
			<form:input path="reason"/>
			<form:errors path="reason"/>
		</div>

		<input type="submit" value="Register Dnltime">
	</form:form>
	
</body>
</html>