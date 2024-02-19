<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 개인 회원 가입</h1>
<form action="...">
		<input type="text" name="name" placeholder="회원 이름"><br/>
		<input type="email" name="email" placeholder="회원 이메일"><br/>
        <input type="password" name="password" placeholder="비밀번호"><br/>
        <input type="password" name="passwordConfirm" placeholder="비밀번호 확인"><br/>
        <input type="text" name="contact" placeholder="전화번호">
<h3>사용하는 SNS</h3>
        <select name="sns">
            <option value="없음"></option>
            <option value="facebook">Facebook</option>
            <option value="instagram">Instagram</option>
            <option value="blog">blog</option>
            <option value="cafe">cafe</option>
            </select>
            <input type="text" name="link" placeholder="링크">
<h3>팔로워 수</h3>
        <select name="followerCount">
            <option value="없음">없음</option>
            <option value="1000">1~1,000</option>
            <option value="5000">1,000~5,000</option>
            <option value="10000">5,000~10,000</option>
            <option value="30000">10,000~30,000</option>
            <option value="50000">30,000~50,000</option>
            <option value="50000+">50,000 이상</option>
            
			<button type="submit">회원가입</button>
			
</form>
<a href="./">로그인 페이지로 이동</a>
</body>
</html>