<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="business-join" style="display: none">
  <p>사업자 회원 가입</p>
  <input type="text" name="businessName" placeholder="사업자 이름" required><br>
  <input type="email" name="businessEmail" placeholder="사업자 이메일" required><br>
  <input type="password" name="businessPassword" placeholder="비밀번호" required><br>
  <input type="text" name="businessNumber" placeholder="사업자 번호" required><br>
  <input type="text" name="companyName" placeholder="업체 이름" required><br>
  <input type="text" name="companyAddress" placeholder="업체 주소" required><br>
  <input type="text" name="businessType" placeholder="업종" required><br>
  <input type="file" name="businessProfileImage" accept="image/*" required><br>
  <button type="submit">회원 가입</button>
</div>
</body>
</html>