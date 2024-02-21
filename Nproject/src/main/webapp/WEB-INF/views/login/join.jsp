<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 페이지 선택</title>
</head>
<body>
<h1>회원 페이지 선택</h1>

<form action="select" method="post">
    <input type="radio" name="type" value="personal" checked>개인회원 페이지
    <input type="radio" name="type" value="business">사업자 회원 페이지
    <br><br>
    <!--<a href="login/member-join">개인 회원가입</a>-->
    
    <input type="submit" value="선택">
</form>
</body>
</html>