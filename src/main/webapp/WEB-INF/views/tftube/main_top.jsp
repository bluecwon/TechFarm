<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table colspan="2" border="3">
<tr>
<td>
<a href="tftube_main">오튜브 </a>
</td> 
<td>검색						 <a href="tftube_video_insert">업로드</a>	
<c:choose>
<c:when test="${tube_id==null}">
		<a href="tftube_login">로그인</a>
</c:when>
<c:otherwise>
		
</c:otherwise>
</c:choose>		
</td>                            
</tr>
<tr>
<td>
<a href="tftube_main">홈</a><br>
인기<br>
최근 본 동영상<br>
-----------------------------<br>
음악<br>
스포츠<br>
게임<br>
영화<br>
TV프로그램<br>
뉴스<br>
실시간<br>
</td>
<td>







</body>
</html>