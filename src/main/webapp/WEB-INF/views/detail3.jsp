<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD INFO - DETAIL</title>
<link rel="stylesheet" href="resources/css/style.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<script>
	$(function() {
		let m = "${msg}";
		if (m != "") {
			alert(m);
		}
	});
</script>
<style>
body {
	background-color: #FFF6E9;
	color: #000000;
}

h2.form-header {
	color: #006BB9;
}

.detail {
	background-color: #BBE2EC;
	color: #000000;
	margin-bottom: 20px;
	padding: 10px;
}

.detail-title {
	font-weight: bold;
}

.synopsis-title {
	color: #000000;
	font-weight: bold;
}

.btn-area button {
	background-color: #006BB9;
	color: white;
	border: none;
	padding: 10px 20px;
	margin-right: 10px;
	cursor: pointer; 
	border-radius: 10px;
}

.btn-area button:hover {
	background-color: #0D9276;
}
</style> 
</head>
<body>
	<div class="wrap">
		<div class="content">
			<h2 class="form-header">뷰티</h2>
			<div class="detail">
				<div class="detail-sub">
					<div class="detail-title">업체 사진</div>
					<div class="detail-content">
						<c:if test="${empty boardfile}">
							<img class="poster" src="resources/images/no_image.jpg">
						</c:if>
						<c:if test="${!empty board.boardfile}">
							<img class="poster" src="resources/upload/${board.boardfile}">
						</c:if>
					</div>
				</div>
			</div>
			<div class="detail">
				<div class="detail-sub">
					<div class="detail-title">게시글 Id</div>
					<div class="detail-content">${boardId}</div>
				</div>
				<div class="detail-sub">
					<div class="detail-title">모집 시작일</div>
					<div class="detail-content">${periodStart}</div>
				</div>
				<div class="detail-sub">
					<div class="detail-title">모집 마감일</div>
					<div class="detail-content">${periodEnd}</div>
				</div>
				<div class="detail-sub">
					<div class="detail-title">모집 인원</div>
					<div class="detail-content">${personnel}</div>
				</div>
				<div class="detail-sub">
					<div class="detail-title">업체명</div>
					<div class="detail-content">${companyName}</div>
				</div>
				<div class="detail-sub">
					<div class="detail-title">상세 설명</div>
					<div class="detail-content">${detail}</div>
				</div>
			</div>
			<div class="detail">
				<div class="detail-sub">
					<div class="synopsis-title">체크사항</div>
					<div class="synopsis-content">${checkInfo}</div>
				</div>
				<div class="detail-sub">
					<div class="detail-title">가격</div>
					<div class="detail-content">${price}</div>
				</div>
			</div>
		</div>
		<div class="btn-area">
			<button class="btn-write" id="upbtn">수정</button>
			<button class="btn-write" id="delbtn">삭제</button>
			<button class="btn-sub" id="backbtn">뒤로</button>
		</div>
	</div>
</body>
<script>
	$("#backbtn").click(function() {
		location.href = `./?pageNum=${pageNum}`;
	});

	$("#upbtn").click(function() {
		location.href = `./updateFrm?boardId=${boardId}`;
	});

	//게시글 삭제
	$("#delbtn").click(function() {
		let conf = confirm("삭제하시겠습니까?");
		if (conf) {
			location.href = `./delete?boardId=${boardId}`;
		}
	});
</script>
</html>