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
<title>modifyForm.jsp</title>
<link rel="stylesheet" href="/css/RegisterForm.css">

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>
<h1>Modify City</h1>

<div class="preButton">
	<a class="btn btn-sm"href="/city/page/${param.pageNo}">
	<span class="glyphicon glyphicon-arrow-left"></span> City Page</a>
</div>
<BR>

<form:form action="/city/modify?pageNo=${param.pageNo}" method="post" modelAttribute="cityForm">
                            
	<div class="modifyBox">
	
		<!-- id -->
		<div>
			<label for="id" class="Define-Values">
			<span class="glyphicon glyphicon-pencil"></span>
			Id</label>
			<form:input path="id" readonly="true" class="Define-Input-Box"/>
		</div>
		<!-- name -->
		<div>
			<label for="name" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>
			Name</label>
			<form:input path="name" class="Define-Input-Box"/>
			<form:errors path="name" class="Define-Error-Region"/>
		</div>
		<!-- countryCode -->
		<div>
			<label for="countryCode" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>
			CountryCode</label>
			<form:input path="countryCode" class="Define-Input-Box"/>
			<form:errors path="countryCode" class="Define-Error-Region"/>
		</div>
		<div>
			<form:errors/>
		</div> 
		<!-- district -->
		<div>
			<label for="district" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>
			District</label>
			<form:input path="district" class="Define-Input-Box"/>
			<form:errors path="district" class="Define-Error-Region"/>
		</div>
		<!-- population -->
		<div>
			<label for="population" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>
			Population</label>
			<form:input path="population" class="Define-Input-Box"/>
			<form:errors path="population" class="Define-Error-Region"/>
		</div>
		
		<BR>
		<!-- modify Button -->
		<div class="modifyButton">
			<input type="submit" value="City Modify">	
		</div>	
			
	</div>

</form:form>

</body>
</html>