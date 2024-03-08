<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>리뷰엔</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

<link rel="stylesheet"
	href="resources/css/applyCompany.css"/>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>


<script>
            let m = "${msg}";
            if(m != ""){
                alert(m);
            }
            
    </script>
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
				<li class="nav-item"><a class="nav-link" href="category?cateNum=1">맛집</a></li>
				<li class="nav-item"><a class="nav-link" href="category?cateNum=2">숙소</a></li>
				<li class="nav-item"><a class="nav-link" href="category?cateNum=3">가전</a></li>
				<li class="nav-item"><a class="nav-link" href="category?cateNum=4">뷰티</a></li>
				<li class="nav-item"><a class="nav-link" href="category?cateNum=5">기타</a></li>
				<li class="nav-item"><a class="nav-link" href="review">리뷰</a></li>
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
		
		<!-- 업체 리스트 (2024-02-26) -->
<div id="content">
        <section id="applyCompany">
            <div class="item-area">
                <!-- 신청 목록 출력 -->
                    <c:if test="${empty bList}">
                        <div class="shop-item">
                            <span class="none-content">신청한 체험단 모집글이 없습니다.</span>
                        </div>
                    </c:if><!--if boardList is Empty-->

                    <c:if test="${!empty bList}">
                        <c:forEach var="board" items="${bList}" begin="0" end="7" step="1">
                            <div class="shop-item">
                                <a href="companyDetail?boardId=${board.boardId}">
                                    <c:if test="${empty board.boardFile}">
                                        <img src="resources/images/no_image.jpg"
                                            class="poster-pre">
                                    </c:if> <!--!empty boardList End-->

                                    <c:if test="${!empty board.boardFile}">
                                        <img src="resources/upload/${board.boardFile}"
                                            class="poster-pre">
                                    </c:if>
                                </a>
                                <section class="info-pre">
                              
                                    <div class="title-pre">
                                        <a class="title" href="companyDetail?boardId=${board.boardId}">
                                            ${board.companyName}
                                        </a>  
                                    </div> <!--title-pre-End-->
                                    
                                    
                                    <div class="content-provide">${board.provideType}</div>
                                    <div class="content-price">${board.price}</div>
                                     <div class="priceline"></div>
                                     <div class="div3">모집인원</div>
                                    <div class="content-personnel">${board.hits} / ${board.personnel}</div>
                                    <div class="content-period1">신청 시작:${board.periodStart}</div>
                                    <div class="content-period2">신청 마감:${board.periodEnd}</div>
                                   
                               
                                </section>
                            </div>
                        </c:forEach>
                    </c:if>
                </div> <!-- data-area End -->
        </section> <!--applyCompany End-->
    </div> <!--content End-->
		<div class="coming-soon">
			<i class="fa fa-hourglass-start" aria-hidden="true"></i> COMING SOON
		</div>
		<!-- 업체 리스트 (2024-02-26) -->
	<div id="content">
        <section id="applyCompany">
            <div class="item-area">
                <!-- 신청 목록 출력 -->
                    <c:if test="${empty cbList}">
                        <div class="shop-item">
                            <span class="none-content">신청한 체험단 모집글이 없습니다.</span>
                        </div>
                    </c:if><!--if boardList is Empty-->

                    <c:if test="${!empty cbList}">
                        <c:forEach var="cbList" items="${cbList}" begin="0" end="7" step="1">
                            <div class="shop-item">
                                <a href="companyDetail?boardId=${cbList.boardId}">
                                    <c:if test="${empty cbList.boardFile}">
                                        <img src="resources/images/no_image.jpg"
                                            class="poster-pre">
                                    </c:if> <!--!empty boardList End-->

                                    <c:if test="${!empty cbList.boardFile}">
                                        <img src="resources/upload/${cbList.boardFile}"
                                            class="poster-pre">
                                    </c:if>
                                </a>
                                <section class="info-pre">
                              
                                    <div class="title-pre">
                                        <a class="title" href="companyDetail?boardId=${cbList.boardId}">
                                            ${cbList.companyName}
                                        </a>  
                                    </div> <!--title-pre-End-->
                                    
                                  
                                    <div class="content-provide">${cbList.provideType}</div>
                                    <div class="content-price">${cbList.price}</div>
                                     <div class="priceline"></div>
                                     <div class="div3">모집인원</div>
                                    <div class="content-personnel">${cbList.hits} / ${cbList.personnel}</div>
                                    <div class="content-period1">신청 시작:${cbList.periodStart}</div>
                                    <div class="content-period2">신청 마감:${cbList.periodEnd}</div>
                                   
                               
                                </section>
                            </div>
                        </c:forEach>
                    </c:if>
                </div> <!-- data-area End -->
        </section> <!--applyCompany End-->
    </div> <!--content End-->
		<div>
			<hr color="gray">
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>