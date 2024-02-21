<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	vertical-align: middle;
	text-align: left;
}

.logo { /* 로고 스타일 */
	margin: 4px;
	width: 50px;
	height: 50px;
	border-radius: 10px;
}

.site { /* 사이트 이름 위치 조정 */
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
	vertical-align: middle;
	text-align: right;
}
</style>

<div class="top-bar"> 
	<div class="review">
		<a href="/later"><img alt="로고" src="resources/images/logo.png" class="logo"></a>
	</div>
		<h2>리뷰엔</h2>
	<div class="login-signin">
		<i class="fa fa-user-circle-o" aria-hidden="true"></i> 
		<a class="link" href="loginPage">로그인</a> 
		<a class="link" href="mSignIn">회원가입</a>
		<!--  <a class="link" href="writeFrm">업체 등록</a>  -->
	</div>
</div>

