<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page.jsp</title>

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

<style type="text/css">
	a:HOVER {
		text-decoration: none;	
	}
	.active, .btn-group-sm {
		color: black;
	}
	.activeColor {
		color: white;
		background-color: darkGray;
	}
	.table-responsive {
		white-space : nowrap;
		text-overflow : ellipsis;
	}
	tr, td {
		text-transform: capitalize;
	}
	.registerBox {
		text-align: right;
	}
	.btnColor {
		background-color: black;
		color: white;
	}
</style>

</head>
<body>
<c:set var="memos" value="${page.memos}"/>
<c:set var="paging" value="${page.paging}"/>

<h1>Memo</h1>
<div class="registerBox">
	<a href="/memo/register/${memo.mno}?pageNo=${pageNo}" class="btn btn-info btn-sm">
	<span class="glyphicon glyphicon-inbox"></span> Memo Register</a>
</div>
<BR>

<div class="table-responsive">
	<table class="table table-hover">
		<tr>
		 	<td>memo_No</td>
		 	<td>title</td>
		 	<td>UserId</td>
		 	<td>date</td>
		 	<td>member_Srl</td>
		 </tr>
	<c:forEach var="memo" items="${memos}">
		<tr>
			<td>${memo.mno}</td>
			<td><a href="/memo/item/${memo.mno}?pageNo=${paging.pageNo}">
			<span class="glyphicon glyphicon-hand-right"></span> ${memo.mname}
			</a></td>
			<td>${memo.member.userid}</td>
			<td> <fmt:formatDate value="${memo.mdate}" pattern="yyyy-MM-dd"/></td>
			<td>${memo.membersrl}</td>
		</tr>
	</c:forEach>
	</table>
</div>

<div class="text-center">
	<a href="/memo/page/1" class="btn btn-group-sm active">first</a>
	
	<c:choose>
	<c:when test="${paging.firstGroup == true}">
		<a href="/memo/page/${paging.firstPage}" class="btn btn-sm btnColor">&laquo;</a>
	</c:when>
	<c:when test="${paging.firstGroup == false}">
		<a href="/memo/page/${paging.firstPage - 1}" class="btn btn-sm btnColor">&laquo;</a>
	</c:when>
	</c:choose>
	<c:forEach var="i" begin="${paging.firstPage}" end="${paging.lastPage}">
		<c:if test="${paging.pageNo == i}">
			<a href="/memo/page/${i}" class="btn btn-group-sm active activeColor">${i}</a>
		</c:if>
		<c:if test="${paging.pageNo != i}">
			<a href="/memo/page/${i}" class="btn btn-group-sm">${i}</a>
		</c:if>
	</c:forEach>
	
	<c:choose>
	<c:when test="${paging.lastGroup == true}">
		<a href="/memo/page/${paging.lastPage}"class="btn btn-sm btnColor">&raquo;</a>
	</c:when>
	<c:when test="${paging.lastGroup == false}">
		<a href="/memo/page/${paging.lastPage + 1}"class="btn btn-sm btnColor">&raquo;</a>
	</c:when>
	</c:choose>
	
	<a href="/memo/page/${paging.totalPage}" class="btn btn-group-sm active">last</a>
</div>


</body>
</html>