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
</style>
</head>
<body>
	<div class="wrap">

		<jsp:include page="header.jsp" />
		<nav class="navbar navbar-expand-sm bg-light navbar-light">
			<!-- Links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#">맛집</a></li>
				<li class="nav-item"><a class="nav-link" href="#">숙소</a></li>
				<li class="nav-item"><a class="nav-link" href="#">가전</a></li>
				<li class="nav-item"><a class="nav-link" href="#">뷰티</a></li>
				<li class="nav-item"><a class="nav-link" href="#">기타</a></li>
				<li class="nav-item"><a class="nav-link" href="#">리뷰</a></li>

				<!-- Dropdown -->
				<!--  <li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbardrop"
					data-toggle="dropdown"> Dropdown link </a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Link 1</a> <a
							class="dropdown-item" href="#">Link 2</a> <a
							class="dropdown-item" href="#">Link 3</a>
					</div></li>-->
			</ul>
		</nav>
		<div>
			<hr color="orange">
		</div>
		<div class="hotpick">
			<i class="fa fa-star fa-2x" aria-hidden="true"></i>
			<div class="hotpick-color">HOT PICK</div>
		</div>
		<div class="hotpick">신청 폭발!핫 픽은 뭐가 있을지 둘러보세요!</div>
		<div>
			<hr color="gray">
		</div>
		
			<p>Some example text. Some example text. Some example text. Some
				example text. Some example text.</p>
			<p>Some example text. Some example text. Some example text. Some
				example text. Some example text.</p>
			<p>Some example text. Some example text. Some example text. Some
				example text. Some example text.</p>
			<p>Some example text. Some example text. Some example text. Some
				example text. Some example text.</p>
		
		<div class="coming-soon">
			<i class="fa fa-hourglass-start" aria-hidden="true"></i> COMING SOON
		</div>
		<p>Some example text. Some example text. Some example text. Some
				example text. Some example text.</p>
			<p>Some example text. Some example text. Some example text. Some
				example text. Some example text.</p>
			<p>Some example text. Some example text. Some example text. Some
				example text. Some example text.</p>
			<p>Some example text. Some example text. Some example text. Some
				example text. Some example text.</p>
		<div>
			<hr color="gray">
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
