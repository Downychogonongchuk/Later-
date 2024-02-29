<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정 - WRITE</title>
<link rel="stylesheet" href="resources/css/login.css">
<link rel="stylesheet" href="resources/css/header.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
</head>
<body>

	<div class="wrap">
		<jsp:include page="header.jsp" />
		<div class="content">
			<form action="loginCheck" method="post"
				enctype="multipart/form-data">
				<h2 class="form-header">로그인</h2>
				<!-- 개인정보 입력 영역 -->
				<div class="loginBox">
					<h4>이메일</h4>
					<input type="email" class="write-input" name="memberEmail"
						autofocus placeholder="이메일을 입력해주세요." required="required">
					<h4>비밀번호</h4>
					<input type="password" class="write-input" name="memberPass"
						autofocus placeholder="비밀번호를 입력해주세요." required="required">
				</div>
				<div class="btn-area">
					<input type="submit" class="btn-write" value="로그인" id="loginbtn"><br>
					<br>
					<br>
					<h5>이메일, 비밀번호를 잊으셨나요?</h5>
					<a href="" class="link1">아이디 /</a><a href="" class="link1"> 비밀번호 찾기</a><br>
					<a href="mSignIn" class="link1">회원가입</a>
					<br> <input type="button" class="btn-write" value="홈으로 돌아가기"
						id="backbtn">

				</div>
			</form>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
<script>
	$("#backbtn").click(function() {
		location.href = `./`;
	});
</script>
<script type="text/javascript">
	let m = "${msg}";
	if (m != "") {
		alert(m);
	}
</script>
</html>