 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>companyDetail</title>
<link rel="stylesheet" href="resources/css/companyDetail.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
</head>
<body>
	<c:if test="${empty mLogInInfo and empty cLogInInfo}">
			<jsp:include page="header.jsp" />
		</c:if>
		<c:if test="${!empty mLogInInfo}">
			<jsp:include page="mHeader.jsp" />
		</c:if>
		<c:if test="${!empty cLogInInfo}">
			<jsp:include page="cHeader.jsp" />
		</c:if>
	<!--view-->
	
		
		
			<!-- 인포 -->
			<form id="detailForm" method="post" action="rev"
				enctype="multipart/form-data">
                <div id="content">
                <div class="left">
                    <section>
                        <p>
                            <img src="resources/upload/${board.boardFile}" class="boardfile"></p>
                            <input type="hidden" name="boardFile" value="${board.boardFile}">   
                        <p>
                    </section>
                    <section class="checkInfo">
                        <p>
                            <strong><b>체크사항</b></strong><br><span class="checkContent">"${board.checkInfo}"</span>
                        </p>
                    </section> <!--checkInfoEnd-->	
                </div>	<!--leftEnd-->
                    
                     <div class="right">
                <section class="info">
                
                <section class="leftContent">
                <input type="hidden" name="boardId" value="${board.boardId}">

                <p class="name">
                    <strong>업체이름</strong><br><span class="companyName">[${board.companyName}]</span></p>
                <!-- Hidden input fields to hold the data -->
                <input type="hidden" name="companyName"
                    value="${board.companyName}">

                <p class="info5">
                    <strong>모집인원</strong><br>${board.personnel}</p>
                <input type="hidden" name="personnel" value="${board.personnel}">

                <p class="info5">
                    <strong>모집신청일자</strong><br>${board.periodStart}</p>
                <input type="hidden" name="periodStart"
                    value="${board.periodStart}">

                    <p class="info5">
                    <strong>모집마감일자</strong><br>${board.periodEnd}</p>
                <input type="hidden" name="periodEnd" value="${board.periodEnd}">

                <p class="info5">
                    <strong>제공타입</strong><br>${board.provideType}</p>
                <input type="hidden" name="provideType"
                    value="${board.provideType}">

                <p class="info5">
                    <strong>가격</strong><br>${board.price}</p>
                <input type="hidden" name="price" value="${board.price}">

            </section>

            <section class="detail">
                <p>
                    <strong><b>상세정보</b></strong><br> <span class="detailContent">
                        "${board.detail}"</span>
                </p>
                <ul>
                    <li></li>
                    
                </ul>
            </section> <!--detailEnd-->
        
            
            <div class="buttons">
            <c:if test="${!empty mLogInInfo}">
            <!-- 결제버튼-->
            <button type="submit" id="btn-apply" class="btn-common btn-apply">신청하기</button>
            </c:if><!--!empty mLogInInfo -->
            
            <c:if test="${!empty cLogInInfo}">
            <div class="btn-cLogin">
            <button type="button" id="btn-bUpdate" class="btn-common btn-bUpdate" >수정</button>
            <div class="btn-cLogin"></div>
            <button type="button" id="btn-bDelete" class="btn-common btn-bDelete">삭제</button>
            <div class="btn-cLogin"></div>
            <button type="button" id="btn-selectApply" class="btn-common btn-selectApply">신청한 회원 보기</button>
            </div>
            </c:if><!--!empty cLogInInfo -->
           	</div> <!--buttonsEnd-->
            </section>
            

            </div><!--rightEnd-->
            
        </div><!--content-->
        </form>
    
            
<jsp:include page="footer.jsp" />
	

</body>
	<script>
	// 업체 정보 수정 페이지로 이동
	$("#btn-bUpdate").click(function() {
		location.href = `./bUpdate?boardId=${board.boardId}`;
	});
	
	// 업체 삭제
	$("#btn-bDelete").click(function() {
		location.href = `./bDelete?boardId=${board.boardId}`;
	});
	
	// 내 업체를 신청한 회원 정보 페이지로 이동
	$("#btn-selectApply").click(function() {
		location.href = `./selectApply?boardId=${board.boardId}`;
	});
	
</script>

</html>