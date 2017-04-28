<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>firstpage.jsp</title>

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

<style type="text/css">
	
	.main > .container {
		width: 850px;
		height: 100px;
		padding-top: 50px;
		margin: 0 auto;
		color:white;

	}
	.ball {
		border-radius:10px;
		text-align:center;
		float: left;
		width: 100px;
		height: 130px;
		margin: 10px auto;
		vertical-align:medium;

	}
	p {
		font-size:7em;
		font-weight:900;
	}

	.ball:nth-child(1) {
		background: #0085C7;
		animation: right 1s infinite ease-in-out;
	}

	.ball:nth-child(2) {
		background: #F4C300;
	
		animation: left 1s infinite ease-in-out;
	}

	.ball:nth-child(3) {
		background: #000000;
	
		animation: right 1s infinite ease-in-out;
	}

	.ball:nth-child(4) {
		background: #009F3D;
		animation: left 1s infinite ease-in-out;
	}

	.ball:nth-child(5) {
		background: #DF0024;
		animation: right 1s infinite ease-in-out;
	}

	.ball:nth-child(6) {
		background: #0085C7;
		animation: left 1s infinite ease-in-out;
	}

	.ball:nth-child(7) {
		background: #F4C300;
		animation: right 1s infinite ease-in-out;
	}

	.ball:nth-child(8) {
		background: #000000;
		animation: left 1s infinite ease-in-out;
	}

	@keyframes right {
		0% {
			transform: translate(0,-20px);
		}
		50% {
			transform: translate(0,20px);
		}
		100% {
			transform: translate(0,-20px);
		}
	}
	
	@keyframes left {
		0% {
			transform: translate(0,20px);
		}
		50% {
			transform: translate(0,-20px);
		}
		100% {
			transform: translate(0,20px);
		}
	}
	/* s */
	body {
		background-image: url("../../../img/w_str.png");
	/* 	padding : 270px 600px 0 600px; */
	}
	.bg {
	/* 	width: 700px; */
	/* 	border: 1px solid red; */
		padding: 50px 100px 0 100px;
	
		margin :auto;
		float: left;
		
	}
	
	.img {
		width : 300px;
		height: 280px;
		border : 1px solid rgba(0,0,0,0.2);
		margin : 10px;
		
	
	}
	
	.img:hover {
		box-shadow: 0 3px 5px 0 rgba(0, 0, 0, 0.2), 0 4px 10px 0 rgba(0, 0, 0, 0.19);
		opacity : 0.8;
		
	}
	
	.overlay {
	  position: absolute;
	  top: 0;
	  bottom: 0;
	  left: 0;
	  right: 0;
	  height: 100%;
	  width: 100%;
	  opacity: 0;
	  transition: .5s ease;
	  background-color: #008CBA;
	}
	
	.container:hover .overlay {
	  opacity: 1;
	}
	
	.text {
	  color: white;
	  font-size: 20px;
	  position: absolute;
	  top: 50%;
	  left: 50%;
	  transform: translate(-50%, -50%);
	}
</style>
</head>
<body>
	<div class="main">
	  <div class="container">
	  	  <div class="ball"><P>H</p></div>
		  <div class="ball"><P>P</p></div>
		  <div class="ball"><P>R</p></div>
		  <div class="ball"><P>O</p></div>
		  <div class="ball"><P>J</p></div>
		  <div class="ball"><P>E</p></div>
		  <div class="ball"><P>C</p></div>
		  <div class="ball"><P>T</p></div>
		</div>
	</div>
	<div class="container">
		<div style="text-align:center;" class="bg">
			<a href="/dnltime/page/1" data-toggle="tooltip" title="신한나"><img class="img" src="/img/WorkList.png"></a>
			<a href="/sal/page/1" data-toggle="tooltip" title="최혜진"><img class="img" src="/img/SalList.png"></a>		
			<a href="/memo/page/1" data-toggle="tooltip" title="최혜진&신한나"><img class="img" src="/img/MemoList.png"></a>
			<a href="/Admin/CMD" data-toggle="tooltip" title="권혁준"><img class="img" src="/img/MemberList.png"></a>
		</div>
	</div>
		
</body>

<script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
</script>
</html>