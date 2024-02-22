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

<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
.top-bar { /* 헤더 바 */
	background-color: #006BB9;
	color: #fff;
	line-height: 50px;
	display: flex;
	justify-content: space-between;
	align-items: center; /* 요소를 수직 가운데 정렬 */
}

.review { /* 로고위치 조정 */
	flex: 1;
	vertical-align: middle;
	text-align: left;
	padding-left: 5px;
}

.logo { /* 로고 스타일 */
	margin: 4px;
	width: 50px;
	height: 50px;
	border-radius: 10px;
}

.site { /* 사이트 이름 위치 조정 */
	flex: 1;
	text-align: center;
}

.link { /* 링크 스타일 */
	font-size: 15px;
	color: white;
}

.login-signin a { /* 로그인, 회원가입*/
	margin-left: 10px;
	text-decoration: none;
}

.login-signin { /* 로그인, 회원가입*/
	flex: 1;
	vertical-align: middle;
	text-align: right;
	padding-right: 5px;
}
</style>

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
			boolean cLogin = true;
			//일반회원 로그인 X, 업체회원 로그인 X
			if(mLogin == false && cLogin == false) {
		%>
		<!-- 아무도 로그인하지 않았을 때 보여주는 태그 -->
		<i class="fa fa-user-circle-o" aria-hidden="true"></i>
		<a class="link" href="loginPage">로그인</a> 
		<a class="link" href="mSignIn">회원가입</a>
		<%
			}
			// 일반회원 로그인 X, 업체회원 로그인 O
			else if(cLogin == true) {
		%>
		<!-- 업체회원이 로그인 했을 때 보여주는 태그 -->
		<a class="link" href="#">마이페이지</a>
		<a class="link" href="writeFrm">업체 등록</a> 
		<a class="link" href="mSignIn">로그아웃</a>
		<%
			}
			// 일반회원 로그인 O, 업체회원 로그인 X
			else if(mLogin == true) {
		%>
		<!-- 일반회원이 로그인 했을 때 보여주는 태그 -->
		<a class="link" href="#">마이페이지</a>
		<a class="link" href="mSignIn">로그아웃</a>
		<%
			}
		%>
	</div>
</div>


