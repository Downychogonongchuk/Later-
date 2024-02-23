<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원정보수정 - WRITE</title>
	<link rel="stylesheet" href="resources/css/style.css">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" 
			integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" 
			crossorigin="anonymous"></script>
	<script>
            
          	//파일 업로드 시 선택한 파일명 출력
            $("#file").on("change", function () {
                //파일 입력창(input type=file)에서 파일 목록 가져오기
                let files = $("#file")[0].files;
                console.log(files);

                let fileName = "";

                if(files.length == 1) {
                    fileName = files[0].name;
                }
                else {//파일 선택 창에서 '취소' 버튼을 클릭
                    fileName = "파일선택";
                }

                $(".upload-name").val(fileName);
            });
    </script>
  <style type="text/css">
  	.content {
	padding: 15px 30px;
	margin: 0 auto;
	width: 800px;
	flex: 1;
}
.form-header {
	margin-top: 30px;
	margin-bottom: 30px;
	font-size: 2em;
	text-align: center;
	font-size: 1.8em;
}
  </style>
</head>
<body>

<div class="wrap">
<jsp:include page="header.jsp" />
	<div class="content">
		<form action="mUpdateProc" method="post" enctype="multipart/form-data">
            <h2 class="form-header">회원정보 수정</h2>          
                <!-- 파일 입력 처리 영역 -->
                 <div class="filebox">
                <label for="file">프로필사진</label>
                <input type="file" name="files" id="file">
                <input type="text" class="upload-name" value="파일선택" readonly>
            </div>
            <!-- 개인정보 입력 영역 -->
            <input type="hidden" class="write-input" name="memberId"
            autofocus value="${logInInfo.memberId}">
            <input type="hidden" class="write-input" name="memberName"
            autofocus value="${logInInfo.memberName}">
            <input type="hidden" class="write-input" name="memberEmail"
                   autofocus value="${logInInfo.memberEmail}">
            <h4>비밀번호</h4>
            <input type="password" class="write-input" name="memberPass"
                   autofocus value="${logInInfo.memberPass}">
            <h4>비밀번호 재확인</h4>
            <input type="password" class="write-input" name=""
                   autofocus placeholder="변동사항 없을시 미입력">
            <h4>연락처</h4>
            <input type="text" class="write-input" name="memberPhone"
                   autofocus value="${logInInfo.memberPhone}">
            <h4>사용하는 SNS</h4>
            <select name = "snsKind" class="write-input" required autofocus>
			<option value="없음">==선택해주세요==</option>
			<option value="facebook">페이스북</option>
			<option value="instagram">인스타그램</option>
			<option value="blog">블로그</option>
			<option value="youtube">유튜브</option>
            </select>
            <h4>본인의 SNS또는 BLOG 링크</h4>
            <input type="text" class="write-input" name="snsLink"
                   value="${logInInfo.snsLink}">
            <h4>팔로워 수</h4>       
            <select name="snsFollower" class="write-input" required autofocus>
			<option value="없음">==선택해주세요==</option>
			<option value="1000">1~1,000</option>
			<option value="5000">1,000~5,000</option>
			<option value="10000">5,000~10,000</option>
			<option value="30000">10,000~30,000</option>
			<option value="50000">30,000~50,000</option>
			<option value="50001">50,000 이상</option>
			 </select>

            <div class="btn-area">
                <input type="submit" class="btn-write" value="수정완료">
                <input type="button" class="btn-write" value="뒤로가기" id="backbtn">
            </div>
        </form>
	</div>
	<jsp:include page="footer.jsp" />
</div>
</body>
<script>
    $("#backbtn").click(function () {
    	location.href = `./`;
    });
         
</script>
<script type="text/javascript">

let m = "${msg}";
if(m != ""){
    alert(m);
}

</script>
</html>