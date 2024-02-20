<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>회원가입</h1>
    <form action="joinAction.jsp" method="post">
        <label for="id">아이디</label>
        <input type="text" id="id" name="id" required>
        <br>
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password" required>
        <br>
        <label for="name">이름</label>
        <input type="text" id="name" name="name" required>
        <br>
        <label for="email">이메일</label>
        <input type="email" id="email" name="email" required>
        <br>
        <button type="submit">회원가입</button>
    </form>
</div>
</body>
</html>