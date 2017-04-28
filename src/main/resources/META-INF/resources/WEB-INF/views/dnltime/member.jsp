<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>template.jsp</title>

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

<style>
	table{
		margin: 50px 0px 0px 0px;
	}
	td{
		text-align: center;	
	}
</style>
</head>
<body>
	<c:set var="sum" value="0"/>
	<c:set var="a0" value="0"/>
	<c:set var="a1" value="0"/>
	<c:set var="a2" value="0"/>
	<c:set var="a3" value="0"/>
	<c:set var="a4" value="0"/>
	<c:set var="a5" value="0"/>
	<c:set var="a6" value="0"/>
	<c:set var="a7" value="0"/>
<table class="table table-bordered">
	<tr>
<c:forEach var="member" items="${memberlist}">
	
	<c:set var="dnlcode" value="${member.dnlCode}"/>
	<c:choose>
  <c:when test="${dnlcode== '0'}">
  	<c:set var="a0" value="${a0 + 1}"/>
  	<c:set var="sum" value="${sum + 1}"/>
  </c:when>
  	
  <c:when test="${dnlcode=='1'}">
 	 <c:set var="a1" value="${a1 + 1}"/>
 	 <c:set var="sum" value="${sum + 1}"/>
  </c:when>
  <c:when test="${dnlcode=='2'}">
  	 <c:set var="a2" value="${a2 + 1}"/>
  	 <c:set var="sum" value="${sum + 1}"/>
  </c:when>
  <c:when test="${dnlcode=='3'}">
  	<c:set var="a3" value="${a3 + 1}"/>
  	<c:set var="sum" value="${sum + 1}"/>
  </c:when>
  <c:when test="${dnlcode=='4'}">
  	<c:set var="a4" value="${a4 + 1}"/>
  	<c:set var="sum" value="${sum + 1}"/>
  </c:when>
    <c:when test="${dnlcode=='5'}">
  	 <c:set var="a5" value="${a5 + 1}"/>
  	 <c:set var="sum" value="${sum + 1}"/>
  </c:when>
  <c:when test="${dnlcode=='6'}">
  	<c:set var="a6" value="${a6 + 1}"/>
  	<c:set var="sum" value="${sum + 1}"/>
  </c:when>
  <c:when test="${dnlcode=='7'}">
  	<c:set var="a7" value="${a7 + 1}"/>
  	<c:set var="sum" value="${sum + 1}"/>
  </c:when>
 </c:choose>
</c:forEach>

<%-- 	<c:forEach var="member" items="${memberlist}"> --%>
<%-- 			<fmt:formatDate value="${member.attend}" pattern="yyyy-MM-dd"/> --%>
<%-- 			~ <fmt:formatDate  value="${member.leave}" pattern="yyyy-MM-dd"/><br> --%>
<%-- 	</c:forEach> --%>
		
<td colspan="16">총 ${sum} 일 </td>
</tr>
<tr>
<td> 출근</td><td> ${a0}</td>
<td> 지각</td><td> ${a1}</td>
<td> 외출</td><td> ${a2}</td>
<td> 조퇴</td><td> ${a3}</td>
<td> 결근</td><td> ${a4}</td>
<td> 출장</td><td> ${a5}</td>
<td> 휴직</td><td> ${a6}</td>
<td> 휴가</td><td> ${a7}</td>
</tr>
</table>

<%-- ${memberlist} --%>

</body>
</html>