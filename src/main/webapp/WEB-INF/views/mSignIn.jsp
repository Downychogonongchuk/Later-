<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script>
            let m = "${msg}";
            if(m != ""){
                alert(m);
            }
            
    </script>
</head>
<body>
	
	<h1>개인 회원 가입</h1>
	<form action="mSignInProc" method="post" enctype="multipart/form-data">
	<label for="file">프로필사진</label>
                <input type="file" name="files" id="file"><br/>
                <input type="text" class="upload-name" value="파일선택" readonly><br/>
		<input type="email" name="memberEmail" placeholder="회원 이메일"><br />
		<input type="password" name="memberPass" placeholder="비밀번호"><br />
		<input type="password" name="" placeholder="비밀번호 확인"><br />
		<input type="text" name="memberName" placeholder="회원 이름"><br />
		<input type="text" name="memberPhone" placeholder="전화번호">
		<h3>사용하는 SNS</h3>
		<select name="snsKind">
			<option value="없음"></option>
			<option value="facebook">페이스북</option>
			<option value="instagram">인스타그램</option>
			<option value="blog">블로그</option>
			<option value="youtube">유튜브</option>
		</select> <br> <input type="text" name="snsLink" placeholder="링크">

		<h3>팔로워 수</h3>
		<select name="snsFollower">
			<option value="없음">없음</option>
			<option value="1000">1~1,000</option>
			<option value="5000">1,000~5,000</option>
			<option value="10000">5,000~10,000</option>
			<option value="30000">10,000~30,000</option>
			<option value="50000">30,000~50,000</option>
			<option value="50001">50,000 이상</option>
		</select>
			<button type="submit">회원가입</button>
	</form>
	<a href="./">로그인 페이지로 이동</a>
</body>
</html>