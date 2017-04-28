<%@page import="org.springframework.web.context.annotation.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Member</title>

<link rel="stylesheet" href="/css/RegisterForm.css">

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>

	<h1>Control Member Database : Member Modify</h1>
	
	<form:form action="/Admin/CMD/Mod" method="post" modelAttribute="memberForm">
		<!-- userid -->
		<div>
			<label for="userid" class="Define-Values">userid : </label>
			<form:input path="userid" class="Define-Input-Box" readonly="true"/>
			<form:errors path="userid" class="Define-Error-Region"/>
		</div>
		<!-- email -->
		<div>
			<label for="email" class="Define-Values">email : </label>
			<form:input path="email" class="Define-Input-Box"/>
			<form:errors path="email" class="Define-Error-Region"/>
		</div>
		<!-- username -->
		<div>
			<label for="username" class="Define-Values">username : </label>
			<form:input path="username" class="Define-Input-Box"/>
			<form:errors path="username" class="Define-Error-Region"/>
		</div>
		<!-- password -->
		<div>
			<label for="password" class="Define-Values">password(Required) : </label>
			<form:input path="password" class="Define-Input-Box"/>
			<form:errors path="password" class="Define-Error-Region"/>
		</div>
		<!-- isadmin -->
		<div>
			<label for="isadmin" class="Define-Values">isadmin :</label>
			<form:radiobutton path="isadmin" value="Y" label="True" checked="${ member.isadmin eq 'Y' ? 'checked' : '' }" />
			<form:radiobutton path="isadmin" value="N" label="False" checked="${ member.isadmin eq 'Y' ? '' : 'checked' }"/>
		</div>   
		<!-- isallowed -->
		<div>
			<label for="isallowed" class="Define-Values">isallowed :</label>
			<form:radiobutton path="isallowed" value="Y" label="True" checked="${ member.isallowed eq 'Y' ? 'checked' : '' }"/>
			<form:radiobutton path="isallowed" value="N" label="False" checked="${ member.isallowed eq 'Y' ? '' : 'checked' }"/>
		</div>
		<br>
		<div class="registerButton">
			<input type="submit" value="Modify Member">
		</div> 
	</form:form>

</body>
</html>