<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="right">
		<a href="editContact?no=${dto.no }">수정</a>|<a href="deleteContact?no=${dto.no }">삭제</a>
	</div>
	<div align="center">
		<table>
				<tr>
					<td>${dto.photo }</td>
					<td><h2>${dto.name }</h2>
				</tr>
				<tr>
					<td><h3>Contact details</h3></td>
				</tr>
				<tr>
					<td>email</td>
					<td>${dto.email }</td>
				</tr>
				<tr>
					<td>phone</td>
					<td>${dto.phone }</td>
				</tr>
				<tr>
					<td>notes</td>
					<td>${dto.notes }</td>
				</tr>
		</table>
	</div>
	
</body>
</html>