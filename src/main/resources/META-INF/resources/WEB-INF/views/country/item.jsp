<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>item.jsp</title>

<!-- code_assist -->
<c:if test="false">
<link rel="stylesheet" href="../code_assist/animate.css">
<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>
${error}<br>

<h1>Country Code ' ${country.code} ' info</h1>

<div class="text-center table-responsive">
	<table class="table table-bordered">
		<tr>
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
	
		<tr>
			<td><b>${status.index + 1}</b></td>
			<td>${country.code}</td> 
			<td>${country.name}</td>
			<td>${country.continent}</td>
			<td>${country.region}</td>
			<td>${country.surfaceArea}</td>
			<td>${country.indepYear}</td>
			<td>${country.population}</td>
			<td>${country.lifeExpectancy}</td> 
			<td>${country.gnp}</td> 
			<td>${country.gnpOld}</td> 
			<td>${country.localName}</td> 
			<td>${country.governmentForm}</td> 
			<td>${country.headOfState}</td> 
			<td>${country.capital}</td> 
			<td>${country.code2}</td>
		</tr>
	</table>
</div>
<hr>

<h1>Country Code of City ' ${country.code} ' info</h1>

<div class="text-center table-responsive">
	<table class="table table-bordered">
		<tr class="danger">
			<td>ID</td>
			<td>name</td>
			<td>country_code</td>
			<td>district</td>
			<td>population</td>
		</tr>
	
	<c:forEach var="city" items="${country.citys}">
		<tr>
			<td>${city.id}</td> 
			<td>${city.name}</td> 
			<td>${city.countryCode}</td>
			<td>${city.district}</td>
			<td>${city.population}</td>
		</tr>
	</c:forEach>
	</table>
</div>
<hr>
<a href="/country/page/${param.pageNo}">목록으로</a>
</body>
</html>