<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>개인 회원가입</title>
    <link rel="stylesheet" href="resources/css/join.css">
</head>
<body>
<div class="container".container {
  						position: relative} >
	<h1>개인 회원가입</h1>
    <form action="join/personal" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="input-group">
            <label for="name">이름</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="input-group">
            <label for="email">이메일</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="input-group">
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="input-group">
            <label for="phone">전화번호</label>
            <input type="tel" id="phone" name="phone" required>
        </div>
       <p>
            <label for="subscribers">구독자 수:</label>
            <select id="subscribers" name="subscribers">
                <option value="1-5000">1~5000</option>
                <option value="5000-10000">5000~10000</option>
                <option value="10000-30000">10000~30000</option>
                <option value="30000-50000">30000~50000</option>
                <option value="50000+">50000 이상</option>
            </select>
        </p>
        <label for="sns">SNS 계정:</label>
            <select id="sns" name="sns">
                <option value="">선택 없음</option>
                <option value="facebook">페이스북</option>
                <option value="instagram">인스타그램</option>
                <option value="cafe">카페</option>
                <option value="blog">블로그</option>
            </select>
        <div class="input-group">
            <label for="profileImage">프로필 사진</label>
            <input type="file" id="profileImage" name="profileImage">
        </div>
        <button type="submit">회원가입</button>
    </form>
</div>
</body>
</html>