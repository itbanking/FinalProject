<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>item.jsp</title>

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>
<style>
	.preButton, .registerButton, .modifyButton {
		width: 1100px;
		text-align: right;
	}

</style>
</head>
<body>

<div class="container">
	<div>
		<h1>Board</h1>
		<div class="preButton">
			<a class="btn btn-sm" href="/memo/page/${param.pageNo}">
			<span class="glyphicon glyphicon-arrow-left"></span> Memo Page</a>
		</div>
		<BR>
		<div>
		<table class="table table-bordered">
			<tbody>
				<tr>
					<td><h3>${memo.mname}</h3>
						<div align="right">
							<fmt:formatDate value="${memo.mdate}" pattern="yyyy/MM/dd"/>
						</div></td>
				</tr>
				<tr>
					<td colspan="2" height="500px">${memo.mcontent}</td>
				</tr>
				<tr>
					<td>
					<div style="float:right" align="left">
						<a href="/memo/unregister/${memo.mno}?pageNo=${param.pageNo}" class="btn btn-info btn-sm" id="modifyMemo">Memo Delete</a>
						<a href="/memo/modify/${memo.mno}?pageNo=${param.pageNo}" class="btn btn-warning btn-sm" id="modifyMemo">Memo Modify</a>
					</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<hr>
	
	<hr>
	</div>
</div>

</body>
</html>