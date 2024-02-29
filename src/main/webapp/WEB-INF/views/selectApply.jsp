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
					<input type="hidden" name="status"
						value="${reserv.status}">

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
				<button type="submit" id="btn-yes" class="btn-yes">확정</button>
				<!-- 결제버튼 완-->
				<button type="submit" id="btn-no"class="btn-no">거절</button>
                </div> <!--buttonsEnd-->
			             </div><!--rightEnd-->
    </c:forEach>

	</c:if>
	</form>
	<jsp:include page="footer.jsp" />
	</div>
</body>
<script>
$(document).ready(function() {
    // 확정 버튼 클릭 시
    $("#btn-yes").click(function(e) {
        e.preventDefault(); // 기본 동작인 form submit을 막음
        var reservationId = $("input[name='reservationId']").val();
        updateReservationStatus(reservationId, "확정");
    });

    // 거절 버튼 클릭 시
    $("#btn-no").click(function(e) {
        e.preventDefault(); // 기본 동작인 form submit을 막음
        var reservationId = $("input[name='reservationId']").val();
        updateReservationStatus(reservationId, "거절");
    });

    function updateReservationStatus(reservationId, reservationTime, status, memberId, boardId) {
        $.ajax({
            type: "POST",
            url: "select", // 실제로 상태를 업데이트하는 서블릿의 경로로 변경해야 합니다.
            data: {
                reservationId: reservationId,
                status: status
            },
            success: function(response) {
                // 서버로부터 성공적인 응답을 받았을 때 처리할 내용
                alert("상태가 업데이트되었습니다.");
                // 여기서 필요한 경우 추가적인 작업 수행
            },
            error: function(xhr, status, error) {
                // 서버 요청에 실패했을 때 처리할 내용
                console.error("상태 업데이트 실패:", error);
                // 오류 메시지를 사용자에게 표시하거나 다른 처리를 수행
            }
        });
    }
});
</script>

</html>