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
	justify-content: space-between;
	align-items: center; /* 요소를 수직 가운데 정렬 */
}
.top-bar #site{
text-align: center;
}

.review {
	vertical-align: middle;
	text-align: left;
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

.login-signin a {
	margin-left: 10px;
	text-decoration: none;
}

.login-signin {
	vertical-align: middle;
	text-align: right;
}
</style>

<div class="top-bar"> 
	<div class="review">
		<a href="/later"><img alt="로고" src="resources/images/logo.png" class="logo"></a>
	</div>

		<h2 id="site">리뷰엔</h2> 

    
	<div class="login-signin">
		<i class="fa fa-user-circle-o" aria-hidden="true"></i>
		<a class="link" href="login">로그인</a> 
		<a class="link" href="logout">로그아웃</a>
		<a class="link" href="mSignIn">회원가입</a>
		<a class="link" href="mUpdate">회원정보수정</a>
		<a class="link" href="mDelete">회원탈퇴</a>
		<a class="link" href="writeFrm">업체 등록</a>
	</div>
</div>



