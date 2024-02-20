<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인 페이지</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        
        .login-form {
            border: 1px solid #ccc;
            padding: 20px;
            width: 300px;
        }
        
        .input-group {
            margin-bottom: 10px;
        }
        
        .input-group label {
            display: block;
            margin-bottom: 5px;
        }
        
        .input-group input {
            width: 100%;
            padding: 5px;
            border: 1px solid #ddd;
        }
        
        .login-button {
            background-color: #0000FF;
            color: white;
            padding: 5px 10px;
            border: 1px solid #0000FF;
            cursor: pointer;
        }
        
        .other-links {
            margin-top: 10px;
            text-align: center;
        }
        
        .other-links a {
            text-decoration: none;
            color: #0000FF;
        }
    </style>
</head>
<body>
    <h1>로그인</h1>
    <form class="login-form" action="/login" method="post">
        <div class="input-group">
            <label for="username">아이디</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="input-group">
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button class="login-button" type="submit">로그인</button>
        <div class="other-links">
            <a href="/join">회원가입</a> | <a href="/find">아이디/비밀번호 찾기</a>
        </div>
    </form>
</body>
</html>