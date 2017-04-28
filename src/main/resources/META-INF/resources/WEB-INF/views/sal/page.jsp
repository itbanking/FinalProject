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
		text-align: center;
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
<c:set var="sals" value="${page.sals}"/>
<c:set var="paging" value="${page.paging}"/>

<h1>Salary Info</h1>
<div class="registerBox">
	<a href="/sal/register/${sal.salno}?pageNo=${pageNo}" class="btn btn-info btn-sm">
	<span class="glyphicon glyphicon-inbox"></span> Sal Register</a>
</div>
<BR>

<div class="table-responsive">
	<table class="table table-hover">
		<tr>
			<td>sal_No</td>
			<td>basic Salary</td>
			<td>overtime Salary</td>
			<td>Commission</td>
			<td>aid Salary</td>
			<td>salary Date</td>
			<td>member_Srl</td>
			<td>Remove</td>
			<td>Modify</td>
		</tr>
	<c:forEach var="sal" items="${sals}">
		<tr>
			<td>${sal.salno}</td>
			<td><fmt:formatNumber value="${sal.basicSal}" pattern="##,###,###"/></td>
			<td><fmt:formatNumber value="${sal.overtimeSal}" pattern="##,###,###"/>${sal.overtimeSal == null ? '-' : ''}</td>
			<td><fmt:formatNumber value="${sal.comm}" pattern="##,###,###"/>${sal.comm == null ? '-' : ''}</td>
			<td><fmt:formatNumber value="${sal.aidSal}" pattern="##,###,###"/>${sal.aidSal == null ? '-' : ''}</td>
			<td><fmt:formatDate value="${sal.saldate}" pattern="yyyy-MM-dd"/></td>
			<td><a href="/sal/item/${sal.salno}?pageNo=${paging.pageNo}">
			<span class="glyphicon glyphicon-hand-right"></span> ${sal.membersrl}</a></td>
			<td><a href="/sal/unregister/${sal.salno}?pageNo=${paging.pageNo}">
				<span class="glyphicon glyphicon-remove"></span></a></td>
			<td><a href="/sal/modify/${sal.salno}?pageNo=${paging.pageNo}">
				<span class="glyphicon glyphicon-edit"></span></a></td>
		</tr>
	</c:forEach>
	</table>
</div>

<div class="text-center">
	<a href="/sal/page/1" class="btn btn-group-sm active">first</a>
	
	<c:choose>
	<c:when test="${paging.firstGroup == true}">
		<a href="/sal/page/${paging.firstPage}" class="btn btn-sm btnColor">&laquo;</a>
	</c:when>
	<c:when test="${paging.firstGroup == false}">
		<a href="/sal/page/${paging.firstPage - 1}" class="btn btn-sm btnColor">&laquo;</a>
	</c:when>
	</c:choose>
	<c:forEach var="i" begin="${paging.firstPage}" end="${paging.lastPage}">
		<c:if test="${paging.pageNo == i}">
			<a href="/sal/page/${i}" class="btn btn-group-sm active activeColor">${i}</a>
		</c:if>
		<c:if test="${paging.pageNo != i}">
			<a href="/sal/page/${i}" class="btn btn-group-sm">${i}</a>
		</c:if>
	</c:forEach>
	
	<c:choose>
	<c:when test="${paging.lastGroup == true}">
		<a href="/sal/page/${paging.lastPage}"class="btn btn-sm btnColor">&raquo;</a>
	</c:when>
	<c:when test="${paging.lastGroup == false}">
		<a href="/sal/page/${paging.lastPage + 1}"class="btn btn-sm btnColor">&raquo;</a>
	</c:when>
	</c:choose>
	
	<a href="/sal/page/${paging.totalPage}" class="btn btn-group-sm active">last</a>
</div>


</body>
</html>