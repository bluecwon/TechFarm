<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메일 보내기</title>
</head>
<body>
	<header>
		<h1 align="center">메일 보내기</h1>
	</header>
	<nav></nav>
	<section>
		<form action="sendJames" method="post" enctype="multipart/form-data">
      		<input type="email" name="to" size="80" value="${to }" placeholder="상대의 이메일" ><br>
      		<input type="text" name="subject" size="80" placeholder="제목을 입력해주세요" >
    		<p>
      		<textarea name="text" cols="100" rows="12" placeholder="내용을 입력해주세요" ></textarea>
    		</p>
    		<input type="file" name="file" multiple><br>
      		<input type="submit" value="메일 보내기" >
      		<input type="reset" value="취소">
  </form>
	</section>
	<footer></footer>
</body>
</html> 