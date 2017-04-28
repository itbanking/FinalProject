<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>
<h1>Memo List</h1>
<div class="text-center table-responsive">
	<table class="table">
	 <tr>
	 	<td>memo_No</td>
	 	<td>title</td>
	 	<td>content</td>
	 	<td>date</td>
	 	<td>member_Srl</td>
	 </tr>
	<c:forEach var="memo" items="${memos}">
		<tr>
			<td>${memo.mno}</td>
			<td>${memo.mname}</td>
			<td>${memo.mcontent}</td>
			<td>${memo.mdate}</td>
			<td>${memo.membersrl}</td>
		</tr>
	
	</c:forEach>
	</table>

</div>
</body>
</html>