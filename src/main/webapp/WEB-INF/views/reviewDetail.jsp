<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="resources/css/style.css"/>
<link rel="stylesheet"
	href="resources/css/reviewDetail.css"/>
</head>
<style>
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
<body>
<div class="wrap">
		<c:if test="${empty mLogInInfo and empty cLogInInfo}">
			<jsp:include page="header.jsp" />
		</c:if>
		<c:if test="${!empty mLogInInfo}">
			<jsp:include page="mHeader.jsp" />
		</c:if>
		<c:if test="${!empty cLogInInfo}">
			<jsp:include page="cHeader.jsp" />
		</c:if>
		<nav class="navbar navbar-expand-sm bg-light navbar-light">
			<!-- Links -->
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#">맛집</a></li>
				<li class="nav-item"><a class="nav-link" href="#">숙소</a></li>
				<li class="nav-item"><a class="nav-link" href="#">가전</a></li>
				<li class="nav-item"><a class="nav-link" href="#">뷰티</a></li>
				<li class="nav-item"><a class="nav-link" href="#">기타</a></li>
				<li class="nav-item"><a class="nav-link" href="review">리뷰</a></li>
			</ul>
		</nav>
		<div>
			<hr color="orange">
		</div>
<div class="detail-all">
	<div class="image">
		<c:if test="${empty review.reviewFile}">
			<img src="resources/images/no_image.jpg"
				class="detail-poster">
		</c:if>
		<c:if test="${!empty review.reviewFile}">
			<img src="resources/upload/${review.reviewFile}"
				class="detail-poster">
		</c:if>
	</div>
	<div class="content">
		<h2 class="form-header">상세 보기</h2>
		<!-- 게시글 상세 내용 출력(div) -->
		<div class="detail">
			<div class="detail-sub">
				<div class="detail-title">내용</div>
				<div class="detail-content">${review.contents}</div>
			</div>
			<div class="detail-sub">
				<div class="detail-title">작성 시간</div>
				<div class="detail-content">${review.time}</div>
			</div>
		</div>
	</div>
</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>