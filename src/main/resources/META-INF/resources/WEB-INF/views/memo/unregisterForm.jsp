<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>unregisterForm.jsp</title>


<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	 $( function() {
    	$( "#datepicker").datepicker({
    		
    	});
  } );
	
</script>
<style>
	.preButton, .registerButton, .modifyButton , .unregisterButton{
		width: 1000px;
		text-align: right;
	}

</style>
</head>
<body>
<div class="container">
<h1>Remove Memo</h1>
	<div class="preButton">
		<a class="btn btn-sm" href="/memo/page/${param.pageNo}">
		<span class="glyphicon glyphicon-arrow-left"></span> Memo Page</a>
	</div>
	<BR>
<form:form action="/memo/unregister/${mno}?pageNo=${param.pageNo}" method="post" modelAttribute="memoForm">
<table class="table table-bordered">
	<tr>
	<td valign="top"><label for="mno">번호 </label></td>
	<td>
	<form:input path="mno" size="100" readonly="true"/>
	<form:errors path=""/></td>
	</tr>
	<tr>
	<td><label for="mname">Title</label></td>
	<td><form:input path="mname" size="100" readonly="true" autocomplete="off"/>
	<form:errors path="mname"/></td>
	</tr>
	
	<tr>
	<td valign="top"><label for="mdate">등록일 </label></td>
	<td>

	<form:input path="mdate" size="100" id="datepicker" disabled="true"/>
	<form:errors path="mdate"/></td>
	</tr>
	
	<tr>
	<td valign="top"><label for="membersrl">작성자 번호 </label></td>
	<td>

	<form:input path="membersrl" readonly="true" size="100"/>
	<form:errors path=""/></td>
	</tr>
	
	<tr>
	<td valign="top"><label for="mcontent">내용 </label></td>
	<td><form:textarea path="mcontent" readonly="true" cols="101" rows="25"/>
	<form:errors path="mcontent"/></td>
	</tr>
	
		
</table>
<div class="unregisterButton">
	<input type="submit" value="Memo Remove">
</div>


</form:form>
</div>
</body>
</html>