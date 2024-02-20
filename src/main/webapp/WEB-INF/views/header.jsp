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
.top-bar {
	background-color: #006BB9;
	color: #fff;
	line-height: 50px;
	display: flex;
	justify-content: center;
	align-items: center; /* 요소를 수직 가운데 정렬 */
}


.logo {
	margin: 4px;
	width: 50px;
	height: 50px;
	border-radius: 10px;
}

.link {
	font-size: 15px;
	color: white;
}

.top-bar a {
	margin-left: 10px;
	text-decoration: none;
}

.login-signin {
	justify-content: flex-end !important
}
</style>

<div class="top-bar"> <img alt="로고"
	src="resources/images/logo1.png" class="logo"
	onclick="location.href='/'">
	<h2>리뷰엔</h2> 
	<div class="lgoin-signin">
	<i class="fa fa-user-circle-o" aria-hidden="true"></i> <a
	class="link" href="loginPage">로그인</a> <a class="link"
	href="registerPage">회원가입</a>
	</div>
</div>

