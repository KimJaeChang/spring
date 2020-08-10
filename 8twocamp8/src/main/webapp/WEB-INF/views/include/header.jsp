<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>	
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Agency - Start Bootstrap Theme</title>

<!-- Core theme CSS (includes Bootstrap)-->
<link href="../resources/css/styles.css" rel="stylesheet" />
<link href="../resources/mycss/menu.css" rel="stylesheet" />
</head>
<body id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="#page-top"><img
				src="../resources/assets/img/navbar-logo.svg" alt="" /></a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars ml-1"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ml-auto">
                        <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 캠프 go</a>
                        	<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
         						<a class="dropdown-item" href="../twocamp/camp/camplist">캠핑장 검색</a>
         						<a class="dropdown-item" href="#">지도로 검색</a>
       						</div>
       						<li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 예약</a>
                        	<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
         						<a class="dropdown-item" href="#">예약</a>
       						</div>
       						<li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 쇼핑몰</a>
                        	<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
         						<a class="dropdown-item" href="#">상품 목록 조회</a>
         						<a class="dropdown-item" href="#">장바구니</a>
       						</div>
       						<li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 커뮤니티</a>
                        	<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
         						<a class="dropdown-item" href="#">공지사항</a>
         						<a class="dropdown-item" href="../twocamp/board/list">건의사항 및 Q&A</a>
         						<a class="dropdown-item" href="#">후기</a>
       						</div>
                    </ul>
                </div>
		</div>
		<div class="frame">
		<div class="side">
			<ul>
				<li><a href="${contextPath}/adminSign" class="manLink">회원가입</a></li>
				<li>|</li>
				<li><c:if test="${id==null&&userId==null }">
						<a href="${contextPath }/adminLogin" class="manLink">로그인</a>
					</c:if> <c:if test="${id!=null||userId!=null }">
         	${id.id } ${userId.nickname }님 환영합니다.
         	<a href="${contextPath }/adminLogout" class="manLink">로그아웃</a>
					</c:if></li>
			</ul>
		</div>
	</div>
	</nav>
	<!-- Masthead-->
	<header class="masthead">
		<div class="container">
			<div class="masthead-subheading">Welcome To Our TwoCamp!</div>
			<div class="masthead-heading text-uppercase">On a windy day, Go camping</div>
			
		</div>
	</header>
	<!-- Services-->
	
	<!-- Portfolio Grid-->
	
	<!-- About-->
	
	<!-- Team-->
	
	<!-- Clients-->
	
	<!-- Contact-->
	
	<!-- Footer-->
	
	<!-- Portfolio Modals-->
	
	<!-- Modal 2-->
	
	<!-- Modal 3-->
	
	<!-- Modal 4-->
	
	<!-- Modal 5-->
	
	<!-- Modal 6-->
	
	<!-- Bootstrap core JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>
	<!-- Third party plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
	<!-- Contact form JS-->
	<script src="../resources/assets/mail/jqBootstrapValidation.js"></script>
	<script src="../resources/assets/mail/contact_me.js"></script>
	<!-- Core theme JS-->
	<script src="../resources/js/scripts.js"></script>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>
	<!-- Third party plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
	<!-- Contact form JS-->
	<script src="../resources/assets/mail/jqBootstrapValidation.js"></script>
	<script src="../resources/assets/mail/contact_me.js"></script>
	<!-- Core theme JS-->
	<script src="../resources/js/scripts.js"></script>
</body>
</html>
