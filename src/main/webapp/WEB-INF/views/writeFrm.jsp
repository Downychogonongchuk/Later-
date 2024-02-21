<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MOVIE INFO - WRITE</title>
	<link rel="stylesheet" href="resources/css/style1.css">
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
<jsp:include page="header.jsp" />
	<div class="content">
		<form action="writeProc" method="post" enctype="multipart/form-data">
            <h2 class="form-header">모집 등록</h2>
            <div class="filebox">
                <!-- 파일 입력 처리 영역 -->
                <label for="file">이미지</label>
                <input type="file" name="files" id="file">
                <input type="text" class="upload-name" value="파일명" readonly>
            </div>
            <input type="text" class="write-input" name="companyName"
                   autofocus placeholder="가게명" required>
            <input type="text" class="write-input" name="perioStart"
                   placeholder="모집시작일 ex)2024-02-00" required>
            <input type="text" class="write-input" name="perioEnd"
                   placeholder="모집종료일 ex)2024-02-00" required>
            <input type="text" class="write-input" name="personnel"
                   placeholder="모집인원" required>
            <textarea rows="10" class="write-input ta" name="detail"
                      placeholder="모집내용"></textarea>
            <textarea rows="10" class="write-input ta" name="checkInfo"
                      placeholder="체크사항 및 요청사항"></textarea>
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
    	location.href = `./?pageNum=${pageNum}`;
    });
</script>
</html>