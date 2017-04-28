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

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

<c:set var="working" scope="session" value="false"/>

</head>
<body>
	<h1>회원 정보</h1>
		
	<ul>
		<li><a href="/User/Mod">회원 정보 수정</a></li>
		<li>
			<a href="/User/TimeCheck">
				<c:out value="${working eq false ? '출근': '퇴근'}"/> 시간 기록
			</a>
		</li>
	</ul>
	
</body>
</html>