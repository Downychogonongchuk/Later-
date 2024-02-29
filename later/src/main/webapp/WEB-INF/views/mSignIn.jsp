<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<script>
            let m = "${msg}";
            if(m != ""){
                alert(m);
            }
    </script>
</head>
<body>
	<h1>개인 회원 가입</h1>
	<form action="mSignInProc" method="post" enctype="multipart/form-data" onsubmit="return echeck()">
	<label for="file">포스터</label>
                <input type="file" name="files" id="file"><br/>
                <input type="text" class="upload-name" value="파일선택" readonly><br/>
		<input type="email" name="memberEmail" placeholder="회원 이메일" id="memberEamil" required>
		<button type="button" id="emailCheck">중복체크</button><br />
		<div id="emailError" style="color: red;"></div>
		<input type="password" name="memberPass" placeholder="비밀번호" required><br />
		<input type="password" name="passwordConfirm" placeholder="비밀번호 확인" required><br />
		<input type="text" name="memberName" placeholder="회원 이름" required><br />
		<input type="text" name="memberPhone" placeholder="전화번호" required>
		<h3>사용하는 SNS</h3>
		<select name="snsKind">
			<option value="없음"></option>
			<option value="facebook">Facebook</option>
			<option value="instagram">Instagram</option>
			<option value="blog">blog</option>
			<option value="cafe">티스토리</option>
		</select> <br> <input type="text" name="snsLink" placeholder="링크">

		<h3>팔로워 수</h3>
		<select name="snsFollower">
			<option value="없음">없음</option>
			<option value="1000">1~1,000</option>
			<option value="5000">1,000~5,000</option>
			<option value="10000">5,000~10,000</option>
			<option value="30000">10,000~30,000</option>
			<option value="50000">30,000~50,000</option>
			<option value="50000+">50,000 이상</option>
		</select>
			<button type="submit">회원가입</button>
	</form>
	<a href="loginPage">로그인 페이지로 이동</a>
</body>
<script>
	let ckEmail = false;
	
	$("#emailCheck").click(function () {
		let email = $("#memberEamil").val();
		if(email == ""){
			alert("이메일을 입력하세요.");
			return;
		}
		
		let sendObj = {"email": email};
		
		$.ajax({
            type: "GET",
            url: "emailcheck",
            data: sendObj,
            success: function (response) {
                if (response === 'true') {
                    $('#emailError').text('사용 가능한 이메일입니다.');
                    ckEmail = true;
                } else {
                    $('#emailError').text('중복된 이메일입니다.');
                    $("#memberEamil").val("");
                    $("#memberEamil").focus();
                    ckEmail = false;
                }
            },
            error: function () {
                $('#emailError').text('이메일 중복 체크에 실패했습니다.');
                ckEmail = false;
            }
        });
	})
	
	function echeck(){
		if(ckEmail == false){
			alert("중복확인을 해주세요.");
			return false;
		}
		return true;
	}
</script>
</html>