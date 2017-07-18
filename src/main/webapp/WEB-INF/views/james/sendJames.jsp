<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메일 보내기</title>
</head>
<body>
<div class="container">
  <h4>메일 보내기</h4>
  <form action="sendJames" method="post">
    <div align="center"><!-- 받는 사람 이메일 -->
      <input type="text" name="to" size="120" value="${to }" placeholder="상대의 이메일" >
    </div>     
    <div align="center"><!-- 제목 -->
      <input type="text" name="subject" size="120" placeholder="제목을 입력해주세요" >
    </div>
    <p>
    <div align="center"><!-- 내용 --> 
      <textarea name="text" cols="120" rows="12" resize:none" placeholder="내용#" ></textarea>
    </div>
    <p>
    <div align="center">
      <input type="submit" value="메일 보내기" >
      <input type="reset" value="취소">
    </div>
  </form>
</div>
</body>
</html> 