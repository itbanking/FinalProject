<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>item.jsp</title>

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>

	<H1>
		${city.name} [${city.countryCode}] : ${city.population}<br>
	</H1>
	
	<table class="table">
		<tr>
			<td>Name</td>
			<td>CountryCode</td>
			<td>District</td>
			<td>Population</td>
		</tr>
		<tr>
			<td>${city.name}</td>
			<td>${city.countryCode}</td>
			<td>${city.district}</td>
			<td>${city.population}</td>
		</tr>
	</table>
	
	<hr>
	
	<table class="table">
		<tr>
			<td>Code</td>
			<td>Name</td>
			<td>Population</td>
		</tr>
		<tr>
			<td>${city.country.code}</td>
			<td><a href="/country/item/${city.country.code}">${city.country.name}</a></td>
			<td>${city.country.population}</td>
		</tr>
	</table>

</body>
</html>