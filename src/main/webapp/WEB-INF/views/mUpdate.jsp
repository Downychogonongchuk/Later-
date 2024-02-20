<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원정보수정 - WRITE</title>
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
            <h2 class="form-header">정보 수정</h2>
            <div class="filebox">
                <!-- 파일 입력 처리 영역 -->
                <label for="file">프로필사진</label>
                <input type="file" name="files" id="file">
                <input type="text" class="upload-name" value="파일선택" readonly>
            </div>
            <h3>연락처</h3>
            <input type="text" class="write-input" name="m_name"
                   autofocus placeholder="010-xxxx-xxxx">
            <h3>사용하는 SNS</h3>
            <select name="" class="write-input" name="" >
			 	<option value="">선택해주세요</option>
			 	<option value="">인스타그램</option>
			 	<option value="">페이스북</option>
			 	<option value="">네이버블로그</option>
			 	<option value="">티스토리 블로그</option>
            </select>
            <h3>본인의 SNS또는 BLOG 링크</h3>
            <input type="text" class="write-input" name="m_nation"
                   placeholder="예)http://instagram.com/example">
            <h3>팔로워 수</h3>       
            <select name="" class="write-input" name="" >
			 	<option value="">선택해주세요</option>
			 	<option value="">~5000</option>
			 	<option value="">5000~10000</option>
			 	<option value="">10000~15000</option>
			 	<option value="">15000~20000</option>
			 	<option value="">20000~25000</option>
			 	<option value="">25000~30000</option>
			 	<option value="">35000~40000</option>
			 	<option value="">45000~50000</option>
			 	<option value="">50000만 이상</option>
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
    	location.href = `./?pageNum=${pageNum}`;
    });
</script>
</html>