<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>BOARD INFO - Home</title>
<link rel="stylesheet" href="resources/css/style.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>

<script>
	// 성공시 home에서 msg 출력, 실패시 writeFrm.jsp에서
	$(function() {
		let msg = "${msg}";
		if (msg != "") {
			alert(msg);
		}
	});
</script>

</head>
<body>
	<div class="wrap">

		<div class="content">
			<div class="list-title">
				<h2 class="form-header">카테고리 목록</h2>
				<button class="wr-btn" onclick="location.href='./writeFrm'">
					게시글 작성</button>
			</div>
			<div class="data-area">
				<!-- 게시글 목록 출력 -->
				<c:if test="${empty boardList}">
					<div class="board-item">
						<span class="none-content">저런 등록된 게시글이 없습니다.</span>
					</div>
				</c:if>
				<c:if test="${!empty boardList}">
					<c:forEach var="board" items="${boardList}">
						<div class="board-item">
							<!-- 게시글 정보 표시 -->
							<div class="board-info">
								<div>
									<strong>게시글 ID:</strong> ${board.boardId}
								</div>
								<div>
									<strong>모집 시작:</strong> ${board.periodStart}
								</div>
								<div>
									<strong>모집 마감:</strong> ${board.periodEnd}
								</div>
								<div>
									<strong>모집 인원:</strong> ${board.personnel}
								</div>
								<div>
									<strong>업체명:</strong> ${board.companyName}
								</div>
								<div>
									<strong>상세 설명:</strong> ${board.detail}
								</div>
								<div>
									<strong>체크사항:</strong> ${board.checkInfo}
								</div>
								<div>
									<strong>제공 타입:</strong> ${board.provideType}
								</div>
								<div>
									<strong>가격:</strong> ${board.price}
								</div>
								<div>
									<strong>게시글 업체 사진:</strong> <img
										src="resources/upload/${board.boardfile}" class="board-img">
								</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>

			<div class="paging-area">
				<div class="paging">${paging}</div>
			</div>
		</div>


	</div>
</body>
</html>






