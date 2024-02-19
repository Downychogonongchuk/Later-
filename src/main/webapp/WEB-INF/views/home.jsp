<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="resources/css/style.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<style type="text/css">
.wrap {
	display: flex;
	flex-direction: column;
	height: 100%;
}
hr {
	color: orange;
}
.hotpick {
	display: flex;
	justify-content: center;
	align-items: center;
}
.hotpick-color {
	color: red;
	font-size: 2em;
}
</style>
</head>
<body>
	<div class="wrap">
		<jsp:include page="header.jsp" />
		<nav class="nav">
			<a class="nav-link active" aria-current="page" href="#">Active</a> <a
				class="nav-link" href="#">Link</a> <a class="nav-link" href="#">Link</a>
			<a class="nav-link disabled" aria-disabled="true">Disabled</a>
		</nav>
		<div><hr color="orange"></div>
		<div class="hotpick">
			<!--  <img src="resources/images/">-->
			<div class="hotpick-color">
				HOT PICK
			</div>
		</div>
		<div class="hotpick">신청 폭발!핫 픽은 뭐가 있을지 둘러보세요!</div>
		<div><hr color="gray"></div>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
