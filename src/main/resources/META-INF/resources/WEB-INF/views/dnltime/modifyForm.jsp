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
<title>DNL Modify</title>
<link rel="stylesheet" href="/css/RegisterForm.css">
<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

<style>
	#d1{
		width:500px;
		margin-top:20px;
	}
	#d1, th{
		text-align: center;
	}
	#img1{
		width:50px;
		height:50px;
		position:absolute; 
		bottom: 10px;
		right: 10px;	
	}
</style>
</head>
<body>
	<h1>Modify Worktime</h1>
	<div class="preButton">
		<a class="btn btn-sm" href="/dnltime/page/${param.pageNo}">
		<span class="glyphicon glyphicon-arrow-left"></span> Worktime Page</a>
	</div>
	<BR>
	
	<form:form action="/dnltime/modifyReason?pageNo=${param.pageNo}" method="post" modelAttribute="dnltime">
	<form:errors></form:errors>
		<!-- Dnlno -->
		<div>
			<label for="dnlno" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>Dnlno : </label>
			<form:input path="dnlno" class="Define-Input-Box"/>
			<form:errors path="dnlno"/>
		</div>
		<!-- Attend -->
		<div>
			<fmt:formatDate value="${dnltime.attend}" var="dateString1" pattern="yyyy/MM/dd" />
			<form:hidden path="attend" value="${dateString1}"/>
			<form:errors path="attend"/>
		</div>
		<!-- Leave -->
		<div>
		<fmt:formatDate value="${dnltime.leave}" var="dateString2" pattern="yyyy/MM/dd" />
			<form:hidden path="leave" value="${dateString2}"/>
			<form:errors path="leave" class="Define-Error-Region"/>
		</div>
		<!-- Reason -->
		<div>
			<label for="reason" class="Define-Values" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>Reason : </label>
			<form:input path="reason" class="Define-Input-Box"/>
			<form:errors path="reason" class="Define-Error-Region"/>
		</div>
		<!-- DnltimeCode -->
		<div>
			<label for="dnlCode" class="Define-Values" class="Define-Values"><span class="glyphicon glyphicon-pencil"></span>DnltimeCode : </label>
			<form:input path="dnlCode" class="Define-Input-Box"/>
			<form:errors path="dnlCode" class="Define-Error-Region"/>
		</div>
		<!-- Membersrl -->
		<div>
			<form:hidden path="membersrl"/>
		</div>
		<BR>
		<div class="modifyButton">
			<input type="submit" value="Worktime Modify">
		</div>
	</form:form>
	
	<div id="d1">
	<table class="table table-bordered table-striped">
		<tr class="danger"><th>DnltimeCode</th><th>Code 설명</th></tr>	
		<tr>	<td>0</td><td>출근</td>	</tr>
		<tr>	<td>1</td><td>지각</td>	</tr>
		<tr>	<td>2</td><td>외출</td>	</tr>
		<tr>	<td>3</td><td>조퇴</td>	</tr>
		<tr>	<td>4</td><td>결근</td>	</tr>
		<tr>	<td>5</td><td>출장</td>	</tr>
		<tr>	<td>6</td><td>휴직</td>	</tr>
		<tr>	<td>7</td><td>휴가</td>	</tr>		
	</table>
	</div>
	
<!-- 	<img id="img1" src="http://gkgkgk0064.dothome.co.kr/Plus.png"> -->

</body>
</html>