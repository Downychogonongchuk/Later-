<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>리뷰작성</title>
	<link rel="stylesheet" href="resources/css/writeFrm.css">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" 
			integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" 
			crossorigin="anonymous"></script>
	<script>
        $(function () {
            let m = "${msg}";
            if(m != ""){
                alert(m);
            }
            
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
        });
    </script>
</head>
<body>
<div class="wrap">
<jsp:include page="mHeader.jsp" />
	<div class="content">
		<form action="rWriteProc" method="post" enctype="multipart/form-data">
            <h2 class="form-header">리뷰 작성</h2>
            <div class="filebox">
                <!-- 파일 입력 처리 영역 -->
                <label for="file">이미지</label>
                <input type="file" name="files" id="file">
                <input type="text" class="upload-name" value="파일명" readonly>
            </div>
            <input type="hidden" class="write-input ta" name="memberId"
            	value="${member.memberId}">
            <input type="text" class="write-input ta" name="reviewTitle" placeholder="ex)[업체명]제목">
            <input type="datetime-local" class="write-input ta" name="time">
            <input type="text" class="write-input ta" name="reviewLink" placeholder="리뷰 작성를 작성하신 SNS링크">
            <textarea rows="20" class="write-input ta" name="contents"
                      placeholder="내용"></textarea>
            <div class="btn-area">
                <input type="submit" class="btn-write" value="작성완료">
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
</html>