<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerForm.jsp</title>
<link rel="stylesheet" href="/css/RegisterForm.css">

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>
<h1>Register Country</h1>
	<div class="preButton">
		<a class="btn btn-sm"href="/country/page/${param.pageNo}">
		<span class="glyphicon glyphicon-arrow-left"></span> Country Page</a>
	</div>
	<BR>
<form:form action="/country/register?pageNo=${param.pageNo}" method="post" modelAttribute="countryForm">
	
	<!-- code -->
	<div>
		<label for="code" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>
		Country Code</label>
		<form:input path="code" class="Define-Input-Box"/>
		<form:errors path="code" class="Define-Error-Region"/>	
	</div>
	<div>
		<form:errors/>
	</div> 
	<!-- name -->
	<div>
		<label for="name" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>
		Country Name</label>
		<form:input path="name" class="Define-Input-Box"/>
		<form:errors path="name" class="Define-Error-Region"/>	
	</div>
	<!-- continent -->
	<div>
		<label for="continent" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>
		Continent</label>
		<form:select path="continent">
			<form:option value="Asia"/>
			<form:option value="Europe"/>
			<form:option value="North America"/>
			<form:option value="Africa"/>
			<form:option value="Oceania"/>
			<form:option value="Antarctica"/>
			<form:option value="South America"/>
		</form:select>
		<form:errors path="continent" class="Define-Error-Region"/>	
	</div>
	<!-- region -->
	<div>
		<label for="region" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>
		Region</label>
		<form:input path="region" class="Define-Input-Box"/>
		<form:errors path="region" class="Define-Error-Region"/>	
	</div>
	<!-- surfaceArea -->
	<div>
		<label for="surfaceArea" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>
		Surface Area</label>
		<form:input path="surfaceArea" class="Define-Input-Box"/>
		<form:errors path="surfaceArea" class="Define-Error-Region"/>	
	</div>
	<!-- indepYear -->
	<div>
		<label for="indepYear" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>
		Indep Year</label>
		<form:input path="indepYear" class="Define-Input-Box"/>
		<form:errors path="indepYear" class="Define-Error-Region"/>	
	</div>
	<!-- population -->
	<div>
		<label for="population" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>
		Population</label>
		<form:input path="population" class="Define-Input-Box"/>
		<form:errors path="population" class="Define-Error-Region"/>	
	</div>
	<!-- lifeExpectancy -->
	<div>
		<label for="lifeExpectancy" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>
		Life Expectancy</label>
		<form:input path="lifeExpectancy" class="Define-Input-Box"/>
		<form:errors path="lifeExpectancy" class="Define-Error-Region"/>	
	</div>
	<!-- gnp -->
	<div>
		<label for="gnp" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>
		GNP</label>
		<form:input path="gnp" class="Define-Input-Box"/>
		<form:errors path="gnp" class="Define-Error-Region"/>	
	</div>
	<!-- gnpOld -->
	<div>
		<label for="gnpOld" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>
		GNP Old</label>
		<form:input path="gnpOld" class="Define-Input-Box"/>
		<form:errors path="gnpOld" class="Define-Error-Region"/>	
	</div>
	<!-- localName -->
	<div>
		<label for="localName" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>
		Local Name</label>
		<form:input path="localName" class="Define-Input-Box"/>
		<form:errors path="localName" class="Define-Error-Region"/>	
	</div>
	<!-- governmentForm -->
	<div>
		<label for="governmentForm" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>
		Country code</label>
		<form:input path="governmentForm" class="Define-Input-Box"/>
		<form:errors path="governmentForm" class="Define-Error-Region"/>	
	</div>
	<!-- headOfState -->
	<div>
		<label for="headOfState" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>
		Head Of State</label>
		<form:input path="headOfState" class="Define-Input-Box"/>
		<form:errors path="headOfState" class="Define-Error-Region"/>	
	</div>
	<!-- capital -->
	<div>
		<label for="capital" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>
		Capital</label>
		<form:input path="capital" class="Define-Input-Box"/>
		<form:errors path="capital" class="Define-Error-Region"/>	
	</div>
	<!-- code2 -->
	<div>
		<label for="code2" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>
		Country code2</label>
		<form:input path="code2" class="Define-Input-Box"/>
		<form:errors path="code2" class="Define-Error-Region"/>	
	</div>
	<BR>
	
	<!-- register Button -->
	<div class="registerButton">
		<input type="submit" value="Country Register">	
	</div>
	

</form:form>

</body>
</html>