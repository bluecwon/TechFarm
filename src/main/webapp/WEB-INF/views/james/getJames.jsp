<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">메일내용</h2>
	<table>
	<tr> 
	<td >
		<div align="left">
			<a href="sendJames">메일 쓰기</a>
		</div>
		<br>
		<a href="listJames?folder=INBOX">받은편지함</a><br>
		<a href="listJames?folder=Sent">보낸편지함</a><br>
		<a href="listJames?folder=Trash">휴지통</a><br>
	</td>
		<td>
	<div id="contents">
		${jamesDTO.content }
	</div>
	<td>
</body>
</html>