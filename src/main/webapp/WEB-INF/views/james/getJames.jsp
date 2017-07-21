<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1 align="center">메일내용</h1>
	</header>
	<nav>
		<div align="left">
			<a href="sendJames">메일 쓰기</a>
		</div>
		<br>
		<a href="listJames?folder=INBOX">받은편지함</a><br>
		<a href="listJames?folder=Sent">보낸편지함</a><br>
		<a href="listJames?folder=Trash">휴지통</a><br>
	</nav>
	<section>
		<div id="contents">
		${jamesDTO.content }
	</div>
	</section>
	<footer>
	</footer>
</body>
</html>