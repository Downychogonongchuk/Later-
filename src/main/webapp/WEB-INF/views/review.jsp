<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>카테고리 - 리뷰</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link rel="stylesheet"
	href="resources/css/style.css"/>
<link rel="stylesheet"
	href="resources/css/review.css"/>

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
			<li class="nav-item"><a class="nav-link"
				href="category?cateNum=1">맛집</a></li>
			<li class="nav-item"><a class="nav-link"
				href="category?cateNum=2">숙소</a></li>
			<li class="nav-item"><a class="nav-link"
				href="category?cateNum=3">가전</a></li>
			<li class="nav-item"><a class="nav-link"
				href="category?cateNum=4">뷰티</a></li>
			<li class="nav-item"><a class="nav-link"
				href="category?cateNum=5">기타</a></li>
			<li class="nav-item"><a class="nav-link" href="review">리뷰</a></li>
		</ul>
		</nav>
		<div>
			<hr color="orange">
		</div>
		<!-- 업체 리스트 (2024-02-26) -->
		<div class="review" >
		 <c:if test="${empty rList}">
				등록된 리뷰가 없습니다.
			</c:if>
			<c:if test="${!empty rList}">
				<c:forEach var="ritem" items="${rList}">
					<div class="review-item">
					<!-- 업체 이미지 (2024-02-26) -->
					<div class="review-image">
						<a href="reviewDetail?reviewId=${ritem.reviewId}&memberId=${ritem.memberId}">
							<c:if test="${empty ritem.reviewFile}">
								<img src="resources/images/no_image.jpg"
									class="review-poster">
							</c:if>
							<c:if test="${!empty ritem.reviewFile}">
								<img src="resources/upload/${ritem.reviewFile}"
									class="review-poster">
							</c:if>
						</a>
						</div>
						<!-- 제목 (2024-03-04) -->
						<div class="review-title">
						<a href="reviewDetail?reviewId=${ritem.reviewId}">
								${ritem.reviewTitle}
						</a>
						</div>
						<!-- 업체 이름 (2024-02-26) -->
						<div class="review-contents">
						<a href="reviewDetail?reviewId=${ritem.reviewId}">
								${ritem.contents}
						</a>
						</div>
					</div>
				</c:forEach>
			</c:if> 
			</div>
			<div class="paging-area">
				<div class="paging">${paging}</div>
			</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>