<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>로그인</title>
</head>
<script>
            let m = "${msg}";
            if(m != ""){
                alert(m);
            }
            
    </script>
<body>
    <h1>로그인</h1>
    <form action="loginCheck" method="post">
        <input type="text" name="memberEmail" placeholder="아이디">
        <input type="password" name="memberPass" placeholder="비밀번호">
        <button type="submit">로그인</button>
    </form>
    <a href="mSignIn">회원가입</a>
    <a href="#">아이디/비밀번호 찾기</a>
</body>
</html>