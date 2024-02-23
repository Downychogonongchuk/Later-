<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
<link rel="stylesheet"
	href="resources/css/header.css"/>


<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<div class="top-bar"> 
	<div class="review">
		<a href="/later"><img alt="로고" src="resources/images/logo.png" class="logo"></a>
	</div>
		<h2>리뷰엔</h2>
	<div class="login-signin">
		<!-- mLogin: 일반회원 로그인 여부
			 cLogin: 업체회원 로그인 여부 -->
		<% 
		 	//mLogin: 일반회원 로그인 여부
		 	//cLogin: 업체회원 로그인 여부
			boolean mLogin = false; 
			boolean cLogin = false;
			//일반회원 로그인 X, 업체회원 로그인 X
			if(mLogin == false && cLogin == false) {
		%>
		<!-- 아무도 로그인하지 않았을 때 보여주는 태그 -->
		<i class="fa fa-user-circle-o" aria-hidden="true"></i>
		<a class="link" href="login">로그인</a> 
		<a class="link" href="signSelect">회원가입</a>
		<a class="link" href="bUpdate">업체정보수정</a>
		<a class="link" href="mUpdate">회원정보수정</a>
		<%
			}
			// 일반회원 로그인 X, 업체회원 로그인 O
			else if(cLogin == true) {
		%>
		<!-- 업체회원이 로그인 했을 때 보여주는 태그 -->
		<a class="link" href="#">마이페이지</a>
		<a class="link" href="writeFrm">업체 등록</a> 
		<a class="link" href="logout">로그아웃</a>
		<%
			}
			// 일반회원 로그인 O, 업체회원 로그인 X
			else if(mLogin == true) {
		%>
		<!-- 일반회원이 로그인 했을 때 보여주는 태그 -->
		<a class="link" href="#">마이페이지</a>
		<a class="link" href="logout">로그아웃</a>
		<%
			}
		%>
	</div>
</div>

