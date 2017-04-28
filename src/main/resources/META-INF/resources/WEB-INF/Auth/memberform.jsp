<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberform.jsp</title>
<!-- 2. bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">

<link rel="stylesheet" href="css/AuthForm.css">

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>
	<%
		if (request.getParameter("error") != null) {
			out.println("<script>"); 
			out.println("alert('ID 또는 비밀번호가 올바르지 않습니다.');"); 
			out.println("</script>"); 
		}	
	%>

	<div class="LoginBox">
		<div class="WarningBox">
			<h2>로그인을 해주세요!</h2>
			<div class="SystemMessage">
				<span class="Message"></span>
			</div>
		</div>
		<hr>
		<div class="Face">
			<div class="Circle">	
				<div class="UpperPadding"></div>
				<div class="PplHead"></div>
				<div class="UpperPadding"></div>
				<div class="PplBody"></div>
			</div>
		</div>
		<hr>
		<div class="InfoBox">
			<form action="/Auth" method="post">
				<input class="InputBox" name="id"><br>
				<input class="InputBox" name="pw" type="password"><br>
				<input class="btn Action" type="submit" value="login">
			</form>
			<form action="/Sign_in/Form" method="get">
				<input class="btn Action" type="submit" value="Sign in">
			</form>
		</div>
	</div>

</body>
</html>