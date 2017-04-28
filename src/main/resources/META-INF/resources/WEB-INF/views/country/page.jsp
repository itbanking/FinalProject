<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
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

<c:set var="countrys" value="${page.countrys}"/>
<c:set var="paging" value="${page.paging}"/>


<h1>Country Info</h1>
<div class="registerBox">
	<a href="/country/register/${country.code}?pageNo=${paging.pageNo}" class="btn btn-info btn-sm">
	<span class="glyphicon glyphicon-inbox"></span> Country Register</a>
</div>
<BR>

<div class="table-responsive">
	<table class="table table-hover">
		<tr>
			<td>Remove</td>
			<td>Modify</td>
			<td>No.</td>
			<td>code</td>
			<td>name</td>
			<td>continent</td>
			<td>region</td>
			<td>surfaceArea</td>
			<td>indepYear</td>
			<td>population</td>
			<td>lifeExpectancy</td>
			<td>gnp</td>
			<td>gnpOld</td>
			<td>localName</td>
			<td>governmentForm</td>
			<td>headOfState</td>
			<td>capital</td>
			<td>code2</td>
		</tr>
	<c:forEach var="c" items="${countrys}" varStatus="status">
		<tr>
			<td><a href="/country/unregister/${c.code}?pageNo=${paging.pageNo}">
				<span class="glyphicon glyphicon-remove"></span></a></td>
			<td><a href="/country/modify/${c.code}?pageNo=${paging.pageNo}">
				<span class="glyphicon glyphicon-edit"></span></a></td>
			<td><b>${status.index + 1}</b></td>
			<td>${c.code}</td> 
			<td><a href="/country/item/${c.code}?pageNo=${paging.pageNo}">${c.name}</a></td>
			<td>${c.continent}</td>
			<td>${c.region}</td>
			<td>${c.surfaceArea}</td>
			<td>${c.indepYear}</td>
			<td>${c.population}</td>
			<td>${c.lifeExpectancy}</td> 
			<td>${c.gnp}</td> 
			<td>${c.gnpOld}</td> 
			<td>${c.localName}</td> 
			<td>${c.governmentForm}</td> 
			<td>${c.headOfState}</td> 
			<td>${c.capital}</td> 
			<td>${c.code2}</td>
		</tr> 
	</c:forEach>
	</table>
</div>
<br>
<div class="text-center">
	<a href="/country/page/1" class="btn btn-group-sm active">first</a>
	
	<c:choose>
	<c:when test="${paging.firstGroup == true}">
		<a href="/country/page/${paging.firstPage}" class="btn btn-sm btnColor">&laquo;</a>
	</c:when>
	<c:when test="${paging.firstGroup == false}">
		<a href="/country/page/${paging.firstPage - 1}" class="btn btn-sm btnColor">&laquo;</a>
	</c:when>
	</c:choose>
	<c:forEach var="i" begin="${paging.firstPage}" end="${paging.lastPage}">
		<c:if test="${paging.pageNo == i}">
			<a href="/country/page/${i}" class="btn btn-group-sm active activeColor">${i}</a>
		</c:if>
		<c:if test="${paging.pageNo != i}">
			<a href="/country/page/${i}" class="btn btn-group-sm">${i}</a>
		</c:if>
	</c:forEach>
	
	<c:choose>
	<c:when test="${paging.lastGroup == true}">
		<a href="/country/page/${paging.lastPage}"class="btn btn-sm btnColor">&raquo;</a>
	</c:when>
	<c:when test="${paging.lastGroup == false}">
		<a href="/country/page/${paging.lastPage + 1}"class="btn btn-sm btnColor">&raquo;</a>
	</c:when>
	</c:choose>
	
	<a href="/country/page/${paging.totalPage}" class="btn btn-group-sm active">last</a>
</div>

<!-- <footer> -->
<!-- <button onclick="displayBox(event)" class="btn btn-default animated fadeIn"> -->
<%-- ${paging} --%>
<!-- </button> -->
<!-- </footer> -->

<!-- <script type="text/javascript"> -->
<!--  	function displayBox(event) { -->
<!-- 		$('.btn-default').toggleClass('btn-primary') -->
<!--  	} -->
<!-- </script> -->

</body>
</html>