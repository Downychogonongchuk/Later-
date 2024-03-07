<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신청한 체험단 선택</title>
<link rel="stylesheet" href="resources/css/selectApply.css" />
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





		<div class="right">
			<c:if test="${empty rList}">
				<div class="shop-item">
					<span class="none-content">신청한 체험단이 없습니다.</span>
				</div>
			</c:if>
			<c:if test="${!empty rList}">
				<c:forEach var="reserv" items="${rList}">
					<c:forEach var="member" items="${mList}">
						<c:if test="${reserv.memberId == member.memberId}">
							<section class="info">
								<c:if test="${!empty member.memberProfile}">
									<img src="resources/upload/${member.memberProfile}"
										class="poster-pre">
								</c:if>
								<c:if test="${empty member.memberProfile}">
									<img src="resources/images/no_image.jpg" class="poster-pre">
								</c:if>
								<p>
									<strong>회원이름</strong><br>${member.memberName}</p>
								<p>
									<strong>sns팔로워 수</strong><br>${member.snsFollower}</p>
								<p>
									<strong>sns링크</strong><br>${member.snsLink}</p>
								<p>
									<strong>신청시간</strong><br>${reserv.reservationTime}</p>
								<p>
									<strong>신청 상태</strong><br>${reserv.status}</p>
								
								


								<form id="detailForm" method="post" action="select"
									enctype="multipart/form-data">
									<input type="hidden" name="reservationId"
										value="${reserv.reservationId}"> <input type="hidden"
										name="reservationTime" value="${reserv.reservationTime}">
									<input type="hidden" name="status" value="${reserv.status}">
									<input type="hidden" name="memberId" value="${reserv.memberId}">
									<input type="hidden" name="boardId" value="${reserv.boardId}">

									<div class="buttons">
										<!-- 결제버튼-->
										<button type="submit" id="btn-yes" class="btn-yes">확정</button>
										<!-- 결제버튼 완-->
										<button type="submit" id="btn-no" class="btn-no">거절</button>
									</div>
									<!--buttonsEnd-->
								</form>
								<!-- formEnd -->
							</section>
						</c:if>
					</c:forEach>
					<!-- mList End -->
				</c:forEach>
				<!-- rList End -->
				</c:if>
		</div>
		<!--rightEnd-->



		

		<jsp:include page="footer.jsp" />
	</div>
</body>
<script>
	$(document).ready(function() {
		$(".btn-yes").click(function() {
			// 확정 버튼을 눌렀을 때
			$(this).closest("form").find("input[name='status']").val("확정"); // status 값을 확정으로 변경
			$(this).closest("form").submit(); // 폼 서브밋
		});

		$(".btn-no").click(function() {
			// 거절 버튼을 눌렀을 때
			$(this).closest("form").find("input[name='status']").val("거절"); // status 값을 거절으로 변경
			$(this).closest("form").submit(); // 폼 서브밋
		});
	});
</script>
<script>
	let m = "${msg}";
	if (m != "") {
		alert(m);
	}
</script>
</html>