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
	href="resources/css/selectApply.css"/>
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
		<form id="detailForm" method="post" action="select"
      enctype="multipart/form-data">
		<c:if test="${empty rList}">
			<div class="shop-item">
                 <span class="none-content">신청한 체험단이 없습니다.</span>
            </div>
		</c:if>
		<c:if test="${!empty rList}">
			<c:forEach var="reserv" items="${rList}">
			<div class="right">
				    <section class="info">
					
					
					<input type="hidden" name="reservationId" value="${reserv.reservationId}">

					<!-- <p class="name">
						<strong>업체이름</strong><br>${board.companyName}</p>
					 Hidden input fields to hold the data 
					<input type="hidden" name="companyName"
						value="${board.companyName}">  -->

					<p>
						<strong>신청시간</strong><br>${reserv.reservationTime}</p>
					<input type="hidden" name="reservationTime" value="${reserv.reservationTime}">

					<p>
						<strong>신청 상태</strong><br>${reserv.status}</p>
					<!--  <input type="hidden" name="status"
						value="${reserv.status}"> -->

					<p>
						<strong>모집마감일자</strong><br>${board.periodEnd}</p>
					<input type="hidden" name="memberId" value="${reserv.memberId}">

					<p>
						<strong>제공타입</strong><br>${board.provideType}</p>
					<input type="hidden" name="boardId"
						value="${reserv.boardId}">

					<p>
						<!--  <strong>가격</strong><br>${board.price}</p>
					<input type="hidden" name="price" value="${board.price}">
                    -->
				</section>

				<!--  <section class="detail">
					<p>
						<strong><b>상세정보</b></strong> <span class="detailContent">
							"${detail}"</span>
					</p>
					<ul>
						<li></li>
						
					</ul>
				</section> detailEnd
			-->
                
                <div class="buttons">
                <!-- 결제버튼-->
				<button type="submit" id="btn-yes" class="btn-yes" name="status" value="확정">확정</button>
				<!-- 결제버튼 완-->
				<button type="submit" id="btn-no"class="btn-no" name="status" value="거절">거절</button>
                </div> <!--buttonsEnd-->
			             </div><!--rightEnd-->
    </c:forEach>

	</c:if>
	</form>
	<jsp:include page="footer.jsp" />
	</div>
</body>
<script>
$("#btn-yes").click(function() {
	location.href = `./selectApply`;
});
$("#btn-no").click(function() {
	location.href = `./selectApply`;
});
</script>

</html>