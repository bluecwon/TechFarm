<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="resources/myaccount/style.css" rel="stylesheet" />
<title>내 계정</title>
</head>
<body>
<div id="header">
<b>내 계정</b>
</div>
<div id="main"><br><br>
				<b>${sessionScope.memberDTO.name}</b>님 환영합니다.<br>
				<b>한 곳</b>에서 <b>TechFarm</b>에 관한 계정을 관리할 수 있습니다.<br>
				<br>
				<div id="menu1">TechFarm 정보</div>
				<div id="menu2">tftube 정보</div>
				<div id="menu3">tblog 정보</div>
				<div id="menu4">tplus 정보</div>
</div>
</body>
</html>