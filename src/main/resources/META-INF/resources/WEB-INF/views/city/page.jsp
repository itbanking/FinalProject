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

<!-- code_assist -->
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
<!-- Region for Defines -->
<c:set var="citys" 	value="${page.citys}"/>
<c:set var="paging" 	value="${page.paging}"/>
<!-- End of region -->

<!-- Region for Title -->
<h1>City Info</h1>
<!-- End of region -->

<div class="registerBox">
	<a href="/city/register/${city.id}?pageNo=${paging.pageNo}" class="btn btn-info btn-sm">
	<span class="glyphicon glyphicon-inbox"></span> City Register</a>
</div>
<BR>

<!-- Region for DataTable -->
<div class="table-responsive">
	<table class="table table-hover">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Code</td>
			<td>District</td>
			<td>Population</td>
			<td>Remove</td>
			<td>Modify</td>
		</tr>
		<c:forEach var="city" items="${citys}" varStatus="status">
			<tr>
				<td>${city.id}</td> 
			<td><a href="/city/item/${city.id}?pageNo=${paging.pageNo}">${city.name}</a></td> 
			<td>${city.countryCode}</td>
			<td>${city.district}</td>
			<td>${city.population}</td>
			<td><a href="/city/unregister/${city.id}?pageNo=${paging.pageNo}">
				<span class="glyphicon glyphicon-remove"></span></a></td>
			<td><a href="/city/modify/${city.id}?pageNo=${paging.pageNo}">
				<span class="glyphicon glyphicon-edit"></span></a></td>
			</tr>
		</c:forEach>
	</table>
</div>

 <!-- Region for Page Buttons -->
<div class="text-center">
	<a href="/city/page/1" class="btn btn-group-sm active">first</a>
	
	<c:choose>
	<c:when test="${paging.firstGroup == true}">
		<a href="/city/page/${paging.firstPage}" class="btn btn-sm btnColor">&laquo;</a>
	</c:when>
	<c:when test="${paging.firstGroup == false}">
		<a href="/city/page/${paging.firstPage - 1}" class="btn btn-sm btnColor">&laquo;</a>
	</c:when>
	</c:choose>
	
	<c:forEach var="i" begin="${paging.firstPage}" end="${paging.lastPage}">
		<c:if test="${paging.pageNo == i}">
			<a href="/city/page/${i}" class="btn btn-group-sm active activeColor">${i}</a>
		</c:if>
		<c:if test="${paging.pageNo != i}">
			<a href="/city/page/${i}" class="btn btn-group-sm">${i}</a>
		</c:if>
	</c:forEach>
	
	<c:choose>
	<c:when test="${paging.lastGroup == true}">
		<a href="/city/page/${paging.lastPage}"class="btn btn-sm btnColor">&raquo;</a>
	</c:when>
	<c:when test="${paging.lastGroup == false}">
		<a href="/city/page/${paging.lastPage + 1}"class="btn btn-sm btnColor">&raquo;</a>
	</c:when>
	</c:choose>
	
	<a href="/city/page/${paging.totalPage}" class="btn btn-group-sm active">last</a>
</div>


</body>
</html>