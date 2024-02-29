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
	href="resources/css/companyDetail.css"/>
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
		<c:if test="${empty rList}">
			<div class="shop-item">
                 <span class="none-content">신청한 체험단이 없습니다.</span>
            </div>
		</c:if>
		<c:if test="${!empty rList}">
			<c:forEach var="reservation" items="${rList}">
			<div class="right">
				    <section class="info">
					
					
					<input type="hidden" name="reservationId" value="${reservation.reservationId}">

					<p class="name">
						<strong>업체이름</strong><br>${board.companyName}</p>
					<!-- Hidden input fields to hold the data -->
					<input type="hidden" name="companyName"
						value="${board.companyName}">

					<p>
						<strong>모집인원</strong><br>${board.personnel}</p>
					<input type="hidden" name="personnel" value="${board.personnel}">

					<p>
						<strong>모집신청일자</strong><br>${board.periodStart}</p>
					<input type="hidden" name="periodStart"
						value="${board.periodStart}">

					<p>
						<strong>모집마감일자</strong><br>${board.periodEnd}</p>
					<input type="hidden" name="periodEnd" value="${board.periodEnd}">

					<p>
						<strong>제공타입</strong><br>${board.provideType}</p>
					<input type="hidden" name="provideType"
						value="${board.provideType}">

					<p>
						<strong>가격</strong><br>${board.price}</p>
					<input type="hidden" name="price" value="${board.price}">

				</section>

				<section class="detail">
					<p>
						<strong><b>상세정보</b></strong> <span class="detailContent">
							"${detail}"</span>
					</p>
					<ul>
						<li></li>
						
					</ul>
				</section> <!--detailEnd-->
			
                
                <div class="buttons">
                <!-- 결제버튼-->
				<button type="submit" id="btn-apply" class="btn-apply">신청하기</button>
				<!-- 결제버튼 완-->
				<button id="btn-interest" class="btn-interest">찜</button>
                </div> <!--buttonsEnd-->
			             </div><!--rightEnd-->
    </c:forEach>
		
	</c:if>
	<jsp:include page="footer.jsp" />
	</div>

 
</body>
</html>