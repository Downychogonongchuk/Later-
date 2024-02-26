<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link rel="stylesheet" href="resources/css/myPage.css" />

<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>


<style type="text/css">
.wrap {
	display: flex;
	flex-direction: column;
	height: 100%;
}

.hotpick {
	display: flex;
	justify-content: center;
	align-items: center;
}

.hotpick-color {
	color: red;
	font-size: 35px;
}

.coming-soon {
	background-color: #000000;
	color: #fff;
	font-size: 20px;
	line-height: 50px;
	display: flex;
	justify-content: center;
	align-items: center;
}

.fa-star {
	color: red;
}

.nav-link {
	font-size: 20px;
}

/* 사이드바 스타일 */
.sidebar {
	height: 100%;
	width: 400px;
	/*             position: fixed; */
	top: 0;
	left: 0;
	background-color: #f8f9fa;
	padding: 20px;
	border-right: 2px solid #006BB9;
}

.sidebar a {
	padding: 10px 15px;
	text-decoration: none;
	font-size: 20px;
	color: #495057;
	display: block;
}

.sidebar a:hover {
	background-color: #e9ecef;
}

.img-box {
	margin: 0 auto; width : 200px; /* 이미지의 너비 */
	height: 200px; /* 이미지의 높이 */
	border-radius: 50%; /* 모서리를 둥글게 만듭니다. 값은 반지름을 나타냅니다. */
	overflow: hidden;
	width: 200px; /* 모서리를 둥글게 만든 부분을 이미지가 넘치지 않도록 숨깁니다. */
}

.img-box img {
	width: 100%; /* 이미지가 부모 요소인 div에 꽉 차게 설정합니다. */
	height: auto; /* 이미지의 높이를 자동으로 조정하여 비율을 유지합니다. */
	display: block; /* 인라인 요소를 블록 요소로 변환합니다. */
}

.box-line {
	padding-bottom: 50px;
	padding-top: 30px;
	border-bottom: 2px solid #006BB9;
}
#h4{
text-align: center;
}
</style>
<script>
	let m = "${msg}";
	if (m != "") {
		alert(m);
	}
</script>
</head>
<body>
	<div class="wrap">
		<div>
			<c:if test="${empty logInInfo && empty logInInfo1}">
				<jsp:include page="header.jsp" />
			</c:if>
			<c:if test="${!empty logInInfo}">
				<jsp:include page="mheader.jsp" />
			</c:if>
			<c:if test="${!empty logInInfo1}">
				<jsp:include page="cheader.jsp" />
			</c:if>
		</div>

		<div class="sidebar">
			<div class="box-line">
				<div class="img-box">
					<img alt="" src="resources/images/no_image.jpg">
				</div>
				<h4 id="h4">
					<strong>${logInInfo.memberName}</strong>
				</h4>
			</div>

			<div class="div-box">
				<div>
					<a href="mUpdate">회원정보수정</a>
				</div>
				<div>
					<a href="#">내가 신청한 모집글</a>
				</div>
				<div>
					<a href="#">내가 모집한글</a>
				</div>
				<div>
					<a href="mDelete">회원탈퇴</a>
				</div>
			</div>

		</div>
	</div>
	<div>
		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>
